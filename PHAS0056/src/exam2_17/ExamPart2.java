package exam2_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExamPart2 {
	
	// creates BufferedReader object from a URL
	public static BufferedReader brFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, String> index = new HashMap<String, String>();
		BufferedReader b = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		String line;
		// create a HashMap of filenames and instruments
		while((line = b.readLine()) != null) {
			Scanner s = new Scanner(line);
			
			index.put(s.next(), s.next());
			
			s.close();
		}
		
		// create an empty array for recordings
		ArrayList<Recording> records = new ArrayList<Recording>();
		
		// fill array with data
		try {
			records.add(new Recording("recording01.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt")));
			records.add(new Recording("recording02.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt")));
			records.add(new Recording("recording03.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt")));
			records.add(new Recording("recording04.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt")));
			records.add(new Recording("genA.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt")));
			records.add(new Recording("genB.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt")));
			records.add(new Recording("genC.txt",
				brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt")));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		SoundDuration sd = new SoundDuration();
		SoundLevel sl = new SoundLevel();
		
		for(Recording record : records) {
			System.out.println(record.name+" sound duration is: "+sd.classification(record));
			System.out.println(record.name+" sound level is: "+sl.classification(record));
			System.out.println();
		}

	}

}
