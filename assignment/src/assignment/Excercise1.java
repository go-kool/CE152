package assignment;

public class Excercise1 {
	
	public static void main(String args[]) throws Exception {
		Earth earth = new Earth();
		earth.readDataArray("/filePath/earth.xyz");
		System.out.println("Please enter an altitude:");
		double altitude = 0;
		try {
			altitude = Double.parseDouble(earth.readInput());
			earth.percentageAbove(altitude);
		} catch (Exception e) {
			System.out.println("Invalid altitude. Please enter \"quit\" to end program.");
			String newInput = earth.readInput();
			if (newInput.equals("quit")) {
				System.out.println("Bye!");
				System.exit(0);
			}
		}
	}
}
