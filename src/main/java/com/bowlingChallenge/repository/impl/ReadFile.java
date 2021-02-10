package com.bowlingChallenge.repository.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	public ArrayList<HashMap<String, String>> readAndPrint(String filePath) throws Exception {
		
		ArrayList<HashMap<String, String>> fullData = new ArrayList<HashMap<String, String>>();
		
		InputStream stream = ReadFile.class.getResourceAsStream(filePath);
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
	        while (reader.ready()) {
	            String actualLine = reader.readLine();
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
	    }catch (FileNotFoundException e) {
	    	throw new Exception("File not found.");
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
	
		
		return fullData;
	}
}
