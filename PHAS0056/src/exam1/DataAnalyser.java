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
	
	public ArrayList<NFLData> dataFromURL(BufferedReader b) throws IOException {
		// initialise Array object
		ArrayList<NFLData> data = new ArrayList<NFLData>();
		// skip through 3 first lines that don't contain info
		// about the players
		String line = b.readLine();
		line = b.readLine();
		line = b.readLine();
		
		// read each line one by one and add EarthquakeData objects to ArrayList
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
		int apYds;               // initialise running All Purpose Yards
		
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
	
	// creates an ArrayList of all team names
	public ArrayList<String> getTeams(ArrayList<NFLData> data) {
		// initialise ArrayList
		ArrayList<String> teams = new ArrayList<String>();

		// run through all the players
		for (int i = 0; i < playerTot; i++) {
			// check if this team name is in the least already
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
	
	public analyseTeam(ArrayList<NFLData> data, ArrayList<String> teams) {
				
	}
	
	// getter for the total number of players
	public int getTot() {
		return playerTot;
	}

}
