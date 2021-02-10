package com.bowlingChallenge;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bowlingChallenge.model.Frame;
import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.service.ScoreCalculations;
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

}
