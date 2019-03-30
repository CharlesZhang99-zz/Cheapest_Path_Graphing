package cas2xb3_A2_zhang_CZ;

import java.io.FileNotFoundException;
import java.util.Arrays;
//this inherits from Read class
//deals with restaurant side of things such as finding restaurants within city radius and sorting restaurant prices
public class CityRestaurants extends Read{
	
	//this variable stores where or not a restaurant cities in a certain city.
	//first index is fro cities, second index if for mcd, burgerking, wendy exist boolean
	public boolean[][] cityRests = new boolean[32][3];
	

	public CityRestaurants() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		
		allCities();
		//printCityRests();
		sortRestPrice();
	}
	
	//locate which restaurants are in each city
	public boolean[] restInCity(String[] cInfo){
		float cityLong = Float.valueOf(cInfo[2]);
		float cityLat = Float.valueOf(cInfo[1]);
		//int startlong = CustomBinarySearch.start(cityLong, mcdonalds);
		
		boolean hasMcdonalds = false;
		boolean hasBurgerking = false;
		boolean hasWendys = false;
	
		//find where in the first index of mcdonalds is based on the city longitude - 0.5
		//we can do this because mcdonalds is sorted by increasing longitude
		int index = DumbSeqSearch.find((float) (cityLong-0.5), mcdonalds);
		//iterate from city longitude - 0.5 to city longitude + 0.5 of longitude in mcdonalds location list.
		while (mcdonalds[index][0] < cityLong + 0.5) {
			//checks if the latitude if within city lat - 0.5 to city lat + 0.5 range
			if ((mcdonalds[index][1] > cityLat - 0.5) &&  (mcdonalds[index][1] < cityLat + 0.5)) {
				//if a mcdonalds is found set hasMcdonalds to true
				hasMcdonalds = true;
			}
			index++;
		}
		
		//similar to mcdonalds
		index = DumbSeqSearch.find((float) (cityLong-0.5), burgerking);
		while (burgerking[index][0] < cityLong + 0.5) {
			if ((burgerking[index][1] > cityLat - 0.5) &&  (burgerking[index][1] < cityLat + 0.5)) {
				hasBurgerking = true;
			}
			index++;
		}
		
		//similar to mcdonalds
		index = DumbSeqSearch.find((float) (cityLong-0.5), wendys);
		while (wendys[index][0] < cityLong + 0.5) {
			if ((wendys[index][1] > cityLat - 0.5) &&  (wendys[index][1] < cityLat + 0.5)) {
				hasWendys = true;
			}
			index++;
		}
		
		//put whether or not a certain restaurant exits in an array.
		boolean[] ret = {hasMcdonalds, hasBurgerking, hasWendys};
		return ret;
	}
	
	//puts the availability of restaurants for each city into an array
	public void allCities() {
		for (int i = 0; i < 32; i++) {
			cityRests[i] = restInCity(cityInfo[i]);
		}
	}
	
	//helper function to print out the availability of restaurants in each city. Only used for testing.
	public void printCityRests() {
		for (int i = 0; i < 32; i++) {
			System.out.print(i);
			System.out.print(". ");
			System.out.print(cityInfo[i][0]);
			System.out.print(": (McDonalds: ");
			System.out.print(cityRests[i][0]);
			System.out.print(", BurgerKing: ");
			System.out.print(cityRests[i][1]);
			System.out.print(", Wendys: ");
			System.out.print(cityRests[i][2]);
			System.out.println(")");
		}
	}
	
	//sorts the menu items of each restaurant by price
	public void sortRestPrice() {
		Arrays.sort(menuMcdonalds, (a, b) -> Double.compare(Float.valueOf(a[0]), Float.valueOf(b[0])));
		Arrays.sort(menuBurgerking, (a, b) -> Double.compare(Float.valueOf(a[0]), Float.valueOf(b[0])));
		Arrays.sort(menuWendys, (a, b) -> Double.compare(Float.valueOf(a[0]), Float.valueOf(b[0])));
	}
	
	//outputs an array of menu items based on restaurant availability if the certain city
	//pricing is in an ascending order in this array
	public String[][] availableMenu(int cityNum) {
		String[][] dollarMenu = new String[6][3];
		int index = 0;
		if (cityRests[cityNum][0] == true) {
			dollarMenu[index] = menuMcdonalds[0];
			index++;
			dollarMenu[index] = menuMcdonalds[1];
			index++;
		}
		if (cityRests[cityNum][1] == true) {
			dollarMenu[index] = menuBurgerking[0];
			index++;
			dollarMenu[index] = menuBurgerking[1];
			index++;
		}
		if (cityRests[cityNum][2] == true) {
			dollarMenu[index] = menuWendys[0];
			index++;
			dollarMenu[index] = menuWendys[1];
		}
		
		return dollarMenu;
	}
}
