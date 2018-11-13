package exam1_15;

public class MidTermExam {

	public static void main(String[] args) throws Exception {
		DataParser dp = new DataParser("http://www.hep.ucl.ac.uk/"
				+ "undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
		
		System.out.println("Total number of earthquakes: "+ (int) dp.getTot());
		
		for (int i = 1; i < 13; i++) {
			dp.analyseMonth(i);
			System.out.println("\nTotal number of earthquakes in month "+i+": "+(int) dp.getMonthTot());
			
			System.out.println("\nFull details of the deepest earthquake in month "+i+": ");
			dp.stringFromID((int) dp.getDepthID());
			
			System.out.println("\nFull details of the earthquake whose depth is most accurately known in month "+i+": ");
			dp.stringFromID((int) dp.getDepthAccID());
		}
	}

}
