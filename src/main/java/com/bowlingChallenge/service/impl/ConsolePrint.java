package com.bowlingChallenge.service.impl;

import java.util.ArrayList;

import com.bowlingChallenge.model.Frame;
import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.service.PrintScore;

public class ConsolePrint implements PrintScore {

	@Override
	public void printFinalData(ArrayList<Player> players) throws Exception {

		String format = "%-20s %5d\n";
		String concat = "Frame " + "\t" + "\t" + "1" + "\t" + "2" + "\t" + "3" + "\t" + "4" + "\t" + "5" + "\t" + "6"
				+ "\t" + "7" + "\t" + "8" + "\t" + "9" + "\t" + "10";
		String concatPlayer = "";
		System.out.println(concat);
		for (Player player : players) {
			System.out.println(player.getName());
			concatPlayer += "Pinfalls" + "\t";
			for (Frame frame : player.getFrames()) {
				if (!frame.equals(player.getFrames().get(player.getFrames().size()-1))) {
					if (frame.getType() == 'S') {
						concatPlayer += "X" + "\t";
					} else {
						if (frame.getType() == 'P') {
							concatPlayer += frame.getBall1() + " /" + "\t";
						} else {
							concatPlayer += frame.getBall1() + " " + frame.getBall2() + "\t";
						}
					}
				}else {
					if (frame.getBall1() == 10) {
						concatPlayer += "X" + " ";
						concatPlayer+=frame.getBall2()+ " ";
					} else {
						if(frame.getBall1()+frame.getBall2()==10) {
							concatPlayer += frame.getBall1() + " "+"/" + " ";	
						}else {
							concatPlayer += frame.getBall1() + " "+frame.getBall2() + " ";
						}
					}
					concatPlayer+=frame.getBall3()+ " ";
				}
			}
			System.out.println(concatPlayer);
			
			concatPlayer = "Score" + "\t"+"\t";
			for (int score: player.getScores()) {
				concatPlayer+=score+" "+"\t";
			}
			System.out.println(concatPlayer);
			concatPlayer="";
		}

	}

}
