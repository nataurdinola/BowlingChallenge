package com.bowlingChallenge.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.bowlingChallenge.constant.ReadFileConstant;
import com.bowlingChallenge.model.Frame;
import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.service.ProcessData;
import com.bowlingChallenge.service.ScoreCalculations;

/**
 *
 * @author NathaliaUrdinola
 */
public class ProcessDataImpl implements ProcessData {

	@Override
	public ArrayList<Player> information(ArrayList<HashMap<String, String>> rawData) {
		ArrayList<Player> newData = new ArrayList<>();
		ScoreCalculations sci = new ScoreCalculationsImpl();
		String lastName = " "; // Last name on the list (i-1)
		String prevName = " "; // Name before the last (i-2)
		String befName =" "; //Name to control only one player (perfect score or zero)
		int numBall = 0;
		int cont=0; //Counter for one player and last frame
		for (HashMap<String, String> eachData : rawData) {
			boolean isPlayer = false;
			String name = eachData.get(ReadFileConstant.KEY_NAME);
			int score = Integer.parseInt(eachData.get(ReadFileConstant.KEY_SCORE));
			if (name.equalsIgnoreCase(lastName) && name.equalsIgnoreCase(prevName)) { // 3 Throws in a row, last frame
				numBall = 2;
			} else {
				if (name.equalsIgnoreCase(lastName)) {
					numBall = 1;
				}else {
					cont=0;
				}
			}

			if (newData.isEmpty()) {
				ArrayList<Frame> frames = new ArrayList<Frame>();
				Player player = new Player(name, frames,null);
				newData.add(player);
				numBall = assignScoretoFrame(numBall, player, score,0);

			} else {
				for (Player player : newData) {
					if (player.getName().equals(name)) {
						isPlayer = true;
						if(name.equalsIgnoreCase(lastName) && name.equalsIgnoreCase(prevName)&& name.equalsIgnoreCase(befName)) { //Only one player
							if(player.getFrames().size()==10) {
								cont++;
							}
						}
						numBall = assignScoretoFrame(numBall, player, score,cont);
						break;
					}
				}
				if (!isPlayer) {
					ArrayList<Frame> frames = new ArrayList<Frame>();
					Player player = new Player(name, frames,null);
					newData.add(player);
					numBall = assignScoretoFrame(numBall, player, score,0);
				}
			}
			befName = prevName;
			prevName = lastName;
			lastName = name;
		}
		
		for (Player player : newData) {
			int[] scores = sci.scoreCalculation(player.getFrames());
			player.setScores(scores);
		}
		
		return newData;

	}

	private int assignScoretoFrame(int numBall, Player player, int score, int turn) {
		if(score <0 || score>10) {
			System.out.print("Data not valid, "+score+", will be asigned 0");
			score=0;
		}else {
		if (score == 10) {
			if (player.getFrames().size() == 10) {//Last frame
				if (numBall==1 || turn==1) {
					player.getFrames().get(player.getFrames().size() - 1).setBall2(score);
				} else {
					if(numBall==2 || turn==2) {
					player.getFrames().get(player.getFrames().size() - 1).setBall3(score);
					}
				}
			} else {
					if(validateFrames(player)) {
					player.getFrames().add(new Frame(score, 0, 0, 'S'));
					}else {
						System.out.print("You have gone over 10 frames");
					}
				
			}
			numBall = 0;
		} else {
			if (numBall == 0) {
				if(validateFrames(player)) {
				player.getFrames().add(new Frame(score, 0, 0, 'N'));
				numBall = 1;
				}else {
					System.out.print("You have gone over 10 frames");
				}
				
			} else {
				if (numBall == 1) {
					player.getFrames().get(player.getFrames().size() - 1).setBall2(score);
					if (player.getFrames().get(player.getFrames().size() - 1).getBall1()
							+ player.getFrames().get(player.getFrames().size() - 1).getBall2() == 10) {
						player.getFrames().get(player.getFrames().size() - 1).setType('P');
					}
					numBall = 0;
				} else { // If numBall==2, Last frame 3rd throw
					player.getFrames().get(player.getFrames().size() - 1).setBall3(score);
					numBall = 0;
					}
				}
			}
		}
		return numBall;

	}
	
	private boolean validateFrames(Player player) {
		boolean next = false;
		if(player.getFrames().size()==10) {
			next=false;
		}else {
			next=true;
		}
		return next; 
	}
}