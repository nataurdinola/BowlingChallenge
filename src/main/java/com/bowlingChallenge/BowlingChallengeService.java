package com.bowlingChallenge;


import com.bowlingChallenge.service.ManageService;
import com.bowlingChallenge.service.impl.ManageServiceImpl;

/**
 *
 * @author NathaliaUrdinola
 */
public class BowlingChallengeService {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception{
		ManageService ms = new ManageServiceImpl();
		ms.startApp();
		
	}

}