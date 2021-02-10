package com.bowlingChallenge.service;
import java.util.ArrayList;
import java.util.HashMap;

import com.bowlingChallenge.model.Player;

/**
 *
 * @author NathaliaUrdinola
 */
public interface ProcessData {
    
    ArrayList<Player> information(ArrayList<HashMap<String,String>> rawData);
    
}
