package com.bowlingChallenge.model;

import java.util.ArrayList;

/**
 *
 * @author NathaliaUrdinola
 */
public class Player {
    
    private String name;
    private ArrayList<Frame> frames;
    private ArrayList<Integer> scores;

    public Player(String name, ArrayList<Frame> frames, ArrayList<Integer> scores) {
        this.name = name;
        this.frames = frames;
        this.setScores(scores);
        
    }
    
    public Player() {
        this.name = " ";
        this.frames = null;
        this.scores = null;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

	public ArrayList<Integer> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Integer> scores2) {
		this.scores = scores2;
	}

}
