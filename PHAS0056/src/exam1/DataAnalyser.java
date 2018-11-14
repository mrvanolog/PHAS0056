package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

// creates an array of NFLData objects and analyses that data
public class DataAnalyser {
	
	private int playerTot = 0;
	
	// creates BufferedReader object from a URL
	public BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}
	
	// creates an array of NFLData objects and calculates 
	// the number of players recorded in the file
	public ArrayList<NFLData> dataFromURL(BufferedReader b) throws IOException {
		// initialise Array object
		ArrayList<NFLData> data = new ArrayList<NFLData>();
		// skip through 3 first lines that don't contain info
		// about the players
		String line = b.readLine();
		line = b.readLine();
		line = b.readLine();
		
		// read each line one by one and add NFLData objects to ArrayList
		while ((line = b.readLine()) != null) {
			NFLData player = new NFLData(line);
			data.add(player);
		
			playerTot++;
		}
		return data;
	}
	
	// finds and prints the details of the player who gained 
	// the most Rushing Yards and the most All Purpose Yards
	public void analyse(ArrayList<NFLData> data) {
		// initialise running maximum variables
		int ruYdsMax = -Integer.MAX_VALUE, apYdsMax = -Integer.MAX_VALUE;
		int ruYdsID = 0, apYdsID = 0;    // initialise index storing variables
		int apYds;                       // initialise running All Purpose Yards
		
		// run through all the players
		for (int i = 0; i < playerTot; i++) {
			// look for the most Rushing Yards 
			if (data.get(i).ruYds > ruYdsMax) {
				ruYdsMax = data.get(i).ruYds;
				ruYdsID = i;
			}
			
			// look for the most All Purpose Yards
			apYds = data.get(i).ruYds + data.get(i).reYds;
			if (apYds > apYdsMax) {
				apYdsMax = apYds;
				apYdsID = i;
			}
		}
		// print the results
		System.out.println("\nPlayer with the most Rushing Yards:\n"+data.get(ruYdsID));
		System.out.println("\nPlayer with the most All Purpose Yards:\n"+data.get(apYdsID));
	}
	
	// creates an ArrayList<String> of all team names
	public ArrayList<String> getTeams(ArrayList<NFLData> data) {
		// initialise ArrayList
		ArrayList<String> teams = new ArrayList<String>();

		// run through all the players
		for (int i = 0; i < playerTot; i++) {
			// check if this team name is in the list already
			boolean check = true;
			for (String name : teams) {
				if (name.equals(data.get(i).team)) {
					check = false;
				}
			}

			// if there is no such team name already - add it to the list
			if (check) {
				teams.add(data.get(i).team);
			}
		}
		return teams;
	}
	
	// receives the name of the team as an input and only checks
	// the players who belong to the given team, then prints the results 
	public void analyseTeam(ArrayList<NFLData> data, String team) {
		ArrayList<Integer> touchID = new ArrayList<Integer>();
		int touch, touchNum = 0, liabilityID = 0, buttFinID = 0;
		double fewest = Double.MAX_VALUE, liability;
		double buttFinMax = -Double.MAX_VALUE, buttFin;
		
		// run through all the players
		for (int i = 0; i < data.size(); i++) {
			// check if that's the correct team
			if (team.equals(data.get(i).team)) {
				// check for the number of the players who touched
				// the ball at least 10 times
				touch = data.get(i).att + data.get(i).tgt; 
				if (touch >= 10) {
					touchNum++;
					// update the list of players who touched
					// the ball at least 10 times
					touchID.add(i);
				}
				
				// check for the player who was the greatest liability to his team
				liability = (data.get(i).ruYds + data.get(i).reYds) / touch;
				if (liability < fewest) {
					fewest = liability;
					liabilityID = i;
				}
			}
		}
		// go through all the players who touched the ball more than 10 times
		// and find the one with the Butter Fingers
		for (int id : touchID) {
			buttFin = (data.get(id).tgt - data.get(id).rec + data.get(id).fmb) / (data.get(id).tgt + data.get(id).att);
			if (buttFin > buttFinMax) {
				buttFinMax = buttFin;
				buttFinID = id;
			}
		}
		// print the results
		System.out.println("\n-----------------------------Team "+team+"-------------------------------");
		System.out.println("The number of players who touched the ball at least 10 times: "+touchNum);
		System.out.println("\nThe player who was the greatest liability to his team:");
		System.out.println(data.get(liabilityID));
		System.out.println("\nThe player with the worst Butter Fingers:");
		System.out.println(data.get(buttFinID));
		System.out.println("--------------------------------------------------------------------");
	}
	
	// getter for the total number of players
	public int getTot() {
		return playerTot;
	}
}
