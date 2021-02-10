package com.bowlingChallenge;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.bowlingChallenge.constant.ReadFileConstant;
import com.bowlingChallenge.model.Frame;
import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.service.ProcessData;
import com.bowlingChallenge.service.ScoreCalculations;
import com.bowlingChallenge.service.impl.ProcessDataImpl;
import com.bowlingChallenge.service.impl.ScoreCalculationsImpl;

public class BowlingNonThrivialTest {

	@Test
	public void test() {
		ScoreCalculations sci = new ScoreCalculationsImpl();
		ArrayList<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0,0,'S'));
		frames.add(new Frame(8,2,0,'P'));
		frames.add(new Frame(5,5,0,'P'));
		frames.add(new Frame(6,2,0,'N'));
		Player player = new Player ("Juan",frames,null);
		ArrayList<Integer>scores = sci.scoreCalculation(player.getFrames());
		ArrayList<Integer> compare= new ArrayList<Integer>();
		compare.add(20);
		compare.add(35);
		compare.add(51);
		compare.add(59);
	   
	    Assert.assertEquals(compare, scores);
	}
	
	@Test
	public void test2() {
		
		ProcessData pd = new ProcessDataImpl();
		ArrayList<HashMap<String, String>> input = new ArrayList<HashMap<String,String>>();
		ArrayList<Player> result= new ArrayList<Player>();
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put(ReadFileConstant.KEY_NAME, "Juan");
		temp.put(ReadFileConstant.KEY_SCORE, "10");
		input.add(temp);
		temp = new HashMap<String, String>();
		temp.put(ReadFileConstant.KEY_NAME, "Oscar");
		temp.put(ReadFileConstant.KEY_SCORE, "7");
		input.add(temp);
		temp = new HashMap<String, String>();
		temp.put(ReadFileConstant.KEY_NAME, "Oscar");
		temp.put(ReadFileConstant.KEY_SCORE, "1");
		input.add(temp);
		temp = new HashMap<String, String>();
		temp.put(ReadFileConstant.KEY_NAME, "Juan");
		temp.put(ReadFileConstant.KEY_SCORE, "2");
		input.add(temp);
		temp = new HashMap<String, String>();
		temp.put(ReadFileConstant.KEY_NAME, "Juan");
		temp.put(ReadFileConstant.KEY_SCORE, "3");
		input.add(temp);
		temp = new HashMap<String, String>();
		result = pd.information(input);
		
		ArrayList<Player> expected= new ArrayList<Player>();
		ArrayList<Frame> frame = new ArrayList<Frame>();
		frame.add(new Frame(10,0,0,'S'));
		frame.add(new Frame(2,3,0,'N'));
		ArrayList<Integer> scores = new ArrayList<Integer>();
		scores.add(15);
		scores.add(20);
		expected.add(new Player ("Juan",frame,scores));
		frame = new ArrayList<Frame>();
		scores = new ArrayList<Integer>();
		frame.add(new Frame(7,1,0,'N'));
		scores.add(8);
		expected.add(new Player ("Oscar",frame,scores));
		
		
	    Assert.assertEquals(expected.get(0).getScores(), result.get(0).getScores());
	}

}
