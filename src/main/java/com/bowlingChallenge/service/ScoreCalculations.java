package com.bowlingChallenge.service;
import java.util.ArrayList;

import com.bowlingChallenge.model.Frame;

/**
 *
 * @author NathaliaUrdinola
 */
public interface ScoreCalculations {
    
	ArrayList<Integer> scoreCalculation(ArrayList<Frame> scores);
    
    
}
