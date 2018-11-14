package exam1;

import java.util.Scanner;

// stores all the data about NFL players
// no getter methods, because it is easier to access data
// directly through the public variables
public class NFLData {
	public String name, team, pos;
	public int games, att, ruYds, ruTD, tgt, rec, reYds, reTD, fmb;
	
	// input a String line of raw data
	public NFLData (String line) {
		try (
			Scanner s = new Scanner(line).useDelimiter("\t");
		){
			// assign values to corresponding variables
			name = s.next();
			team = s.next();
			pos = s.next();
			games = s.nextInt();
			att = s.nextInt();
			ruYds = s.nextInt();
			ruTD = s.nextInt();
			tgt = s.nextInt();
			rec = s.nextInt();
			reYds = s.nextInt();
			reTD = s.nextInt();
			fmb = s.nextInt();
		}
		catch (Exception e) {
			System.out.println("NFLData constructor: " + e);
		}
	}
	
	// outputs data as a String
	public String toString() {
		return name+", Team: "+team+", Position: "+pos+", Games: "+games+"\nRushing Attempts: "+att+
				", Rushing Yards: "+ruYds+", Rushing TD: "+ruTD+", Was a Target: "+tgt+
				"\nReceptions: "+rec+", Receiving Yards: "+reYds+", Receiving TD: "+reTD+", Fumbles: "+fmb;
	}

}
