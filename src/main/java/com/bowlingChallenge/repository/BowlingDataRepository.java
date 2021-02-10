package com.bowlingChallenge.repository;

import java.util.ArrayList;
import java.util.HashMap;

public interface BowlingDataRepository {
	
	ArrayList<HashMap<String, String>> readAndPrint(String filePath) throws Exception ;

}
