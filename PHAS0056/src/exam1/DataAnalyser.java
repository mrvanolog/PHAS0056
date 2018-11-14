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
		int ruYdsID, apYdsID;    // initialise index storing variables
		int apYds;               // initialise running All Purpose Yards
		
		for (int i = 0; i < playerTot; i++) {
			if (data.get(i).ruYds > ruYdsMax) {
				ruYdsMax = data.get(i).ruYds;
				ruYdsID = i;
			}
			
			apYds = data.get(i).ruYds + data.get(i).reYds;
			if (apYds > apYdsMax) {
				apYdsMax = apYds;
				apYdsID = i;
			}
		}
	}
	
	// getter for the total number of players
	public int getTot() {
		return playerTot;
	}

}
