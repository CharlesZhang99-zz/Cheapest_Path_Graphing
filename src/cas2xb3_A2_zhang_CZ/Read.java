package cas2xb3_A2_zhang_CZ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Read {
	
	public String allCities[][] = new String[32][3];
	//public String cityInfo[][] = new String[32];
	public String lines[] = new String[52];
	public String connections[][] = new String[52][2];


	
	public Read() throws FileNotFoundException{
		Scanner input = new Scanner(new File("data/connectedCities.txt")).useDelimiter("\\s*\n\\s*");
		Scanner USCities = new Scanner(new File("data/USCities.csv")).useDelimiter("\\s*\n\\s*");

		int counter = 0;
		while (input.hasNext()) {
			String[] tokens = input.nextLine().split(", ");
			connections[counter] = tokens;
			counter++;
		}
		
		counter = 0;
		USCities.nextLine();
		while (USCities.hasNext()) {
			String[] tokens = USCities.nextLine().split(",");
			//System.out.println(tokens[3]);
			allCities[counter][0] = tokens[3];
			allCities[counter][1] = tokens[4];
			allCities[counter][2] = tokens[5];
			counter++;
		}
	}
	
	public void printCitiestxt() {
		for (int i = 0; i < lines.length; i++) {
			System.out.println(connections[i][0] + " -> " + connections[i][1]);
		}
	}
	
	//puts all cities exactly once in a an array allCities
	//this will eliminate hashing for graphing
	/*
	public void filterAllCities() {
		int counter = 0;

		for (int i = 0; i < connections.length; i++) {
			boolean containsCity = false;
			containsCity = Arrays.asList(allCities).contains(connections[i][0]);
			if (!containsCity) {
				allCities[counter] = connections[i][0];
				counter++;
			}
		}
		for (int i = 0; i < connections.length; i++) {

			boolean containsCity = false;
			containsCity = Arrays.asList(allCities).contains(connections[i][1]);
			if (!containsCity) {
				allCities[counter] = connections[i][1];
				counter++;
			}
		}
	}
	*/
	
	public void printAllCities() {
		for (int i = 0; i < allCities.length; i++) {
			System.out.print(i);
			System.out.print(": ");
			System.out.println(allCities[i][0]);	
		}
	}
	
	//given a city, it will return the number associated with it
	public int cityToNum(String city) {
		city = city.toUpperCase();
		for (int i = 0; i < allCities.length; i++) {
			if (city.equals(allCities[i][0])) {
				return i;
			}
		}
		return 0;
	}
	
	//given a city, it will return the number associated with it
	public String numToCity(int num) {
		return allCities[num][0];
	}

	public static void main(String[] args) {

	}

}
