package com.bowlingChallenge.service;
import java.util.ArrayList;

import com.bowlingChallenge.model.Frame;

/**
 *
 * @author NathaliaUrdinola
 */
public interface ScoreCalculations {
    
    int[] scoreCalculation(ArrayList<Frame> scores);
    
    
}
