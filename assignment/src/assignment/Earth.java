package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Earth {

	private double[][] arrayOfEarth = new double[2336041][3];
	private Map<Coordinates, Double> mapOfEarth = new HashMap<>();

	public void readDataArray(String fileName) throws Exception {
		File dataFile = new File(fileName);

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(dataFile));
		String st;
		int i = 0;
		while ((st = br.readLine()) != null) {
			String[] stringArray = st.split("\\s+");
			for (int j = 0; j < stringArray.length; j++) {
				double data = Double.parseDouble(stringArray[j]);
				arrayOfEarth[i][j] = data;
			}
			i++;
		}
	}

	public List<double[]> coordintesAbove(double altitude) {
		ArrayList<double[]> arrayList = new ArrayList<double[]>();
		for (int i = 0; i < arrayOfEarth.length; i++) {
			if (arrayOfEarth[i][2] > altitude) {
				double[] coordinates = { arrayOfEarth[i][0], arrayOfEarth[i][1] };
				arrayList.add(coordinates);
			}
		}
		return arrayList;
	}

	public List<double[]> coordintesBelow(double altitude) {
		ArrayList<double[]> arrayList = new ArrayList<double[]>();
		for (int i = 0; i < arrayOfEarth.length; i++) {
			if (arrayOfEarth[i][2] < altitude) {
				double[] coordinates = { arrayOfEarth[i][0], arrayOfEarth[i][1] };
				arrayList.add(coordinates);
			}
		}
		return arrayList;
	}

	public void percentageAbove(double altitude) {
		System.out.println("Proportion of coordinates above " + altitude + " meters: "
				+ (100 * coordintesAbove(altitude).size()) / 2336041 + "%");
	}

	public void percentageBelow(double altitude) {
		System.out.println("Proportion of coordinates above " + altitude + " meters: "
				+ (100 * coordintesAbove(altitude).size()) / 2336041 + "%");
	}

	public double calculatePercentage(List<Double> arrayList) {
		return (100 * arrayList.size()) / 2336041;
	}

	public String readInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public void readDataMap(String fileName) throws Exception {
		File dataFile = new File(fileName);

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(dataFile));
		String st;
		while ((st = br.readLine()) != null) {
			String[] stringArray = st.split("\\s+");
			int j = 0;
			this.mapOfEarth.put(
					new Coordinates(Double.parseDouble(stringArray[j]), Double.parseDouble(stringArray[j + 1])),
					Double.parseDouble(stringArray[j + 2]));
		}
	}
	
	public double getAltitude(double longitude, double latitude){
		return this.mapOfEarth.get(new Coordinates(longitude, latitude));
	}
}
