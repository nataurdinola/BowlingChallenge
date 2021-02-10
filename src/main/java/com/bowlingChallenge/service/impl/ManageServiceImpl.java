package com.bowlingChallenge.service.impl;
import java.util.ArrayList;
import java.util.HashMap;

import com.bowlingChallenge.constant.ReadFileConstant;
import com.bowlingChallenge.model.Player;
import com.bowlingChallenge.repository.BowlingDataRepository;
import com.bowlingChallenge.repository.impl.ReadFile;
import com.bowlingChallenge.service.ManageService;
import com.bowlingChallenge.service.PrintScore;
import com.bowlingChallenge.service.ProcessData;


public class ManageServiceImpl implements ManageService{

	@Override
	public void startApp() throws Exception {
		BowlingDataRepository rf = new ReadFile();
		ArrayList<Player> players = new ArrayList<Player>();
		ProcessData processDataImpl = new ProcessDataImpl();
		PrintScore ps = new ConsolePrint();
		
		
		System.out.println("Integration tests");

		ArrayList<HashMap<String, String>> proData2 = rf.readAndPrint(ReadFileConstant.PERFECT_SCORE);
		players = processDataImpl.information(proData2);
		System.out.println("PERFECT SCORE"+'\n');
		ps.printFinalData(players);
		
		ArrayList<HashMap<String, String>> proData3 = rf.readAndPrint(ReadFileConstant.TWO_PLAYERS);
		players = processDataImpl.information(proData3);
		System.out.println("TWO PLAYERS"+'\n');
		ps.printFinalData(players);

		
	}

}
