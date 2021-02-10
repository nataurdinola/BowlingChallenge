package com.bowlingChallenge.repository.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bowlingChallenge.constant.ReadFileConstant;
import com.bowlingChallenge.repository.BowlingDataRepository;

/**
 *
 * @author NathaliaUrdinola
 */
public class ReadFile implements BowlingDataRepository {

	@Override
	public ArrayList<HashMap<String, String>> readAndPrint() throws Exception {
		
		ArrayList<HashMap<String, String>> fullData = new ArrayList<HashMap<String, String>>();
		try (BufferedReader br = new BufferedReader(new FileReader(ReadFileConstant.FILE_PATH))) 
        {
            String actualLine;
            while ((actualLine = br.readLine()) != null) 
            {
				String[] game = actualLine.split(" ");
				HashMap<String, String> temp = new HashMap<String, String>();
				temp.put(ReadFileConstant.KEY_NAME, game[0]);
				try {
				temp.put(ReadFileConstant.KEY_SCORE, game[1].equalsIgnoreCase("F") ? "0" : game[1]);
				Integer.parseInt(temp.get(ReadFileConstant.KEY_SCORE));
				}catch (Exception e) {
					throw new Exception("The score data forma is incorrect.");
				}
				fullData.add(temp);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return fullData;
	}
}
