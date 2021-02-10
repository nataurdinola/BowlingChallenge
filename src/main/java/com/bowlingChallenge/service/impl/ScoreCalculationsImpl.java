package com.bowlingChallenge.service.impl;

import java.util.ArrayList;

import com.bowlingChallenge.model.Frame;
import com.bowlingChallenge.service.ScoreCalculations;

/**
 *
 * @author NathaliaUrdinola
 */
public class ScoreCalculationsImpl implements ScoreCalculations {

	@Override
	public int[] scoreCalculation(ArrayList<Frame> frames) {
		int scores[] = new int[10];
		int score = 0;
		System.out.print(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			if (frames.get(i).getType() == 'S') { // If hits a Strike on the frame
				if (i < frames.size() - 1 && frames.get(i + 1).getType() == 'S') { // If hits another Strike
					if (i < frames.size() - 2) {
						score += frames.get(i).getBall1() + frames.get(i + 1).getBall1() + frames.get(i + 2).getBall1();
					} else {
						score += frames.get(i).getBall1() + frames.get(i + 1).getBall1()+frames.get(i+1).getBall2();
					}
				} else {
					if (i < frames.size() - 1) {
						score += frames.get(i).getBall1() + frames.get(i + 1).getBall1() + frames.get(i + 1).getBall2();
					} else {
						score += frames.get(i).getBall1()+frames.get(i).getBall2()+frames.get(i).getBall3(); //If hits a Strike on the first of the last frame
					}
				}
			} else {
				if (frames.get(i).getType() == 'P') { // If hits a Spare on the frame
					if (i < frames.size() - 1) {
						score += frames.get(i).getBall1() + frames.get(i).getBall2() + frames.get(i + 1).getBall1();
					} else {
						score += frames.get(i).getBall1() + frames.get(i).getBall2()+frames.get(i).getBall3();
					}
				} else { // Nor a strike or a spare
					score += frames.get(i).getBall1() + frames.get(i).getBall2();
				}
			}
			scores[i] = score;
		}

		return scores;
	}

}
