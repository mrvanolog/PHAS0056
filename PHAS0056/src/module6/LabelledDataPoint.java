package module6;

// allows to store and retrieve data x, y and error of y (ey)
// also allows to label the data 
public class LabelledDataPoint extends DataPoint {
	private String label;
	// input values of x, y and ey
	// input string containing the data label
	public LabelledDataPoint(double x, double y, double ey, String label) throws Exception {
		super(x, y, ey);
		
		this.label = label;
	}
	
	public String toString() {
		return label+": "+"x = "+x+", y = "+y+" +/- "+ey;
	}
}
