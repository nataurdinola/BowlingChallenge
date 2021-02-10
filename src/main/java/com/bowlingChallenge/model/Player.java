package com.bowlingChallenge.model;

import java.util.ArrayList;

/**
 *
 * @author NathaliaUrdinola
 */
public class Player {
    
    private String name;
    private ArrayList<Frame> frames;
    private int[] scores;

    public Player(String name, ArrayList<Frame> frames, int [] scores) {
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

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

}
