package com.bowlingChallenge;

import java.util.ArrayList;
import java.util.HashMap;

import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.repository.BowlingDataRepository;
import com.bowlingChallenge.repository.impl.ReadFile;
import com.bowlingChallenge.service.ProcessData;
import com.bowlingChallenge.service.PrintScore;
import com.bowlingChallenge.service.impl.ProcessDataImpl;
import com.bowlingChallenge.service.impl.ConsolePrint;

/**
 *
 * @author NathaliaUrdinola
 */
public class BowlingChallengeService {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception{
		BowlingDataRepository rf = new ReadFile();
		ArrayList<Player> players = new ArrayList<Player>();
		ProcessData processDataImpl = new ProcessDataImpl();
		PrintScore ps = new ConsolePrint();
		
		ArrayList<HashMap<String, String>> proData = rf.readAndPrint();
		players = processDataImpl.information(proData);
		ps.printFinalData(players);
		

	}

}