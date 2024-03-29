package cas2xb3_A2_zhang_CZ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;


public class Read {
	
	
	protected String cityInfo[][] = new String[32][3];
	protected String lines[] = new String[52];
	protected String connections[][] = new String[52][2];
	public float mcdonalds[][] = new float[13912][2];
	protected float burgerking[][] = new float[7085][2];
	protected float wendys[][] = new float[5879][2];
	protected String menuComplete[][] = new String[41][4];
	protected String menuMcdonalds[][] = new String[18][3];
	protected String menuBurgerking[][] = new String[12][3];
	protected String menuWendys[][] = new String[10][3];

	
	public Read() throws FileNotFoundException{
		//read data from data files and sort restaurant longitude
		readConnections();
		readUSCities();
		readRest();
		sortRestLong();
		readMenu();
	}
	
	//read data from connectedCities.txt
	//parse data into a 2d array connections with arrays of [city from, city to]
	public void readConnections() throws FileNotFoundException {
		Scanner input = new Scanner(new File("data/connectedCities.txt")).useDelimiter("\\s*\n\\s*");
		int counter = 0;
		while (input.hasNext()) {
			String[] tokens = input.nextLine().split(", ");
			connections[counter] = tokens;
			counter++;
		}
		input.close();
	}
	
	//read data from USCities.csv
	//save data to a 2d array with each entry being [city name, lat, long]
	public void readUSCities() throws FileNotFoundException {
		Scanner USCities = new Scanner(new File("data/USCities.csv")).useDelimiter("\\s*\n\\s*");
		int counter = 0;		
		USCities.nextLine();
		while (USCities.hasNext()) {
			String[] tokens = USCities.nextLine().split(",");
			//System.out.println(tokens[3]);
			cityInfo[counter][0] = tokens[3];
			cityInfo[counter][1] = tokens[4];
			cityInfo[counter][2] = tokens[5];
			counter++;
		}
		USCities.close();
	}
	
	//read data from mcdonalds.csv, burgerking.csv, wendys.csv
	//save long and lat in their respective 2d arrays
	public void readRest() throws FileNotFoundException {
		Scanner mcdonaldsIn = new Scanner(new File("data/mcdonalds.csv")).useDelimiter("\\s*\n\\s*");
		int counter = 0;
		mcdonaldsIn.nextLine();
		while (mcdonaldsIn.hasNext()) {
			String[] tokens = mcdonaldsIn.nextLine().split(",");
			mcdonalds[counter][0] = Float.valueOf(tokens[0]);
			mcdonalds[counter][1] = Float.valueOf(tokens[1]);
			counter++;

		}
		
		Scanner burgerkingIn = new Scanner(new File("data/burgerking.csv")).useDelimiter("\\s*\n\\s*");
		counter = 0;
		burgerkingIn.nextLine();
		while (burgerkingIn.hasNext()) {
			String[] tokens = burgerkingIn.nextLine().split(",");
			burgerking[counter][0] = Float.valueOf(tokens[0]);
			burgerking[counter][1] = Float.valueOf(tokens[1]);
			counter++;
		}
		
		Scanner wendysIn = new Scanner(new File("data/wendys.csv")).useDelimiter("\\s*\n\\s*");
		counter = 0;
		wendysIn.nextLine();
		while (wendysIn.hasNext()) {
			String[] tokens = wendysIn.nextLine().split(",");
			wendys[counter][0] = Float.valueOf(tokens[0]);
			wendys[counter][1] = Float.valueOf(tokens[1]);
			counter++;
		}
		wendysIn.close();
		burgerkingIn.close();
		mcdonaldsIn.close();
	}
	
	//read data from menu.csv
	//parse data into each restaurant's respective 2d arrays with entry format being [price, meal, restaurant]
	public void readMenu() throws FileNotFoundException {
		Scanner menuIn = new Scanner(new File("data/menu.csv")).useDelimiter("\\s*\n\\s*");
		menuIn.nextLine();
		for (int i = 0; i < 40; i++) {
			String[] tokens = menuIn.nextLine().split(",");
			menuComplete[i] = tokens;
		}
		
		for (int i = 0; i < 18; i++) {
			menuMcdonalds[i][0] = menuComplete[i][2].replace("$", "");
			menuMcdonalds[i][1] = menuComplete[i][1];
			menuMcdonalds[i][2] = "McDonalds";
		}
		
		int counter = 0;
		for (int i = 18; i < 30; i++) {
			menuBurgerking[counter][0] = menuComplete[i][2].replace("$", "");
			menuBurgerking[counter][1] = menuComplete[i][1];
			menuBurgerking[counter][2] = "BurgerKing";
			counter++;
		}
		
		counter = 0;
		for (int i = 30; i < 40; i++) {
			menuWendys[counter][0] = menuComplete[i][2].replace("$", "");
			menuWendys[counter][1] = menuComplete[i][1];
			menuWendys[counter][2] = "Wendys";
			counter++;
		}
		
	}
	
	//sorts location arrays of restaurants based on ascending longitudes
	public void sortRestLong() {
		Arrays.sort(mcdonalds, (a, b) -> Double.compare(a[0], b[0]));
		Arrays.sort(burgerking, (a, b) -> Double.compare(a[0], b[0]));
		Arrays.sort(wendys, (a, b) -> Double.compare(a[0], b[0]));
	}
	
	//helper function that prints out all the connected cities. Only used in testing
	public void printCitiestxt() {
		for (int i = 0; i < lines.length; i++) {
			System.out.println(connections[i][0] + " -> " + connections[i][1]);
		}
	}
	
	//helper function that prints out all the cities. Only used in testing
	public void printAllCities() {
		for (int i = 0; i < cityInfo.length; i++) {
			System.out.print(i);
			System.out.print(": ");
			System.out.println(cityInfo[i][0]);	
		}
	}
	
	//given a city, it will return the number associated with it
	public int cityToNum(String city) {
		city = city.toUpperCase();
		for (int i = 0; i < cityInfo.length; i++) {
			if (city.equals(cityInfo[i][0])) {
				return i;
			}
		}
		return 0;
	}
	
	//given a number, it will return the city associated with it
	public String numToCity(int num) {
		return cityInfo[num][0];
	}

}
