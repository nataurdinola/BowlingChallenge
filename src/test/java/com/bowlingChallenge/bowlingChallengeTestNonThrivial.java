package com.bowlingChallenge;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bowlingChallenge.model.Frame;
import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.service.ScoreCalculations;
import com.bowlingChallenge.service.impl.ScoreCalculationsImpl;



public class bowlingChallengeTestNonThrivial {

	@Test
	public void test() {
		ScoreCalculations sci = new ScoreCalculationsImpl();
		ArrayList<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0,0,'S'));
		frames.add(new Frame(8,2,0,'P'));
		frames.add(new Frame(5,5,0,'P'));
		frames.add(new Frame(6,2,0,'N'));
		Player player = new Player ("Juan",frames,null);
		System.out.print("hola");
	    int[] scores = sci.scoreCalculation(player.getFrames());
	    int [] compare= {20,35,51,59,0,0,0,0,0,0};
	   
	    Assert.assertArrayEquals(compare, scores);
		
	}

}
