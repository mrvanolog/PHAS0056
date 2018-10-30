package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DataAnalysis {
	
	public static ArrayList<Double> dataFromURL(String url) throws IOException {
		// create BufferedReader object from a URL
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		String line = "";
		
		line = b.readLine();
		try{
			DataPoint dpt = new DataPoint(line);
		}
		catch (Exception e) {
			System.out.println("DataAnalysis.dataFromURL(): " + e);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
