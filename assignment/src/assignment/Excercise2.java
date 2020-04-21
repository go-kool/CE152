package assignment;

public class Excercise2 {
	public static void main(String args[]) throws Exception {
		Earth earth = new Earth();
		earth.readDataMap("/File Path /earth.xyz");
		System.out.println("Please enter an a longitude (0-360) and latitude (-90-90):");
		double longitude = 0;
		double latitude = 0;
		try {
			longitude = Double.parseDouble(earth.readInput());
			latitude = Double.parseDouble(earth.readInput());
			System.out.println("The altitude at longitude" + longitude + " and latitude" + latitude + " is "
					+ earth.getAltitude(longitude, latitude) + " meters.");
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
