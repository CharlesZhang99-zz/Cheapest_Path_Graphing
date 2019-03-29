package cas2xb3_A2_zhang_CZ;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class CityRestaurants extends Read{
	
	public boolean[][] cityRests = new boolean[32][3];
	

	public CityRestaurants() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		
		allCities();
		printCityRests();
		sortRestPrice();
	}
	
	public boolean[] restInCity(String[] cInfo){
		float cityLong = Float.valueOf(cInfo[2]);
		float cityLat = Float.valueOf(cInfo[1]);
		//int startlong = CustomBinarySearch.start(cityLong, mcdonalds);
		
		boolean hasMcdonalds = false;
		boolean hasBurgerking = false;
		boolean hasWendys = false;
		
		int index = DumbSeqSearch.find((float) (cityLong-0.5), mcdonalds);
		while (mcdonalds[index][0] < cityLong + 0.5) {
			if ((mcdonalds[index][1] > cityLat - 0.5) &&  (mcdonalds[index][1] < cityLat + 0.5)) {
				hasMcdonalds = true;
			}
			index++;
		}
		
		index = DumbSeqSearch.find((float) (cityLong-0.5), burgerking);
		while (burgerking[index][0] < cityLong + 0.5) {
			if ((burgerking[index][1] > cityLat - 0.5) &&  (burgerking[index][1] < cityLat + 0.5)) {
				hasBurgerking = true;
			}
			index++;
		}
		
		index = DumbSeqSearch.find((float) (cityLong-0.5), wendys);
		while (wendys[index][0] < cityLong + 0.5) {
			if ((wendys[index][1] > cityLat - 0.5) &&  (wendys[index][1] < cityLat + 0.5)) {
				hasWendys = true;
			}
			index++;
		}
		boolean[] ret = {hasMcdonalds, hasBurgerking, hasWendys};
		return ret;
	}
	
	public void allCities() {
		for (int i = 0; i < 32; i++) {
			cityRests[i] = restInCity(cityInfo[i]);
		}
	}
	
	
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
	public void sortRestPrice() {
		Arrays.sort(menuMcdonalds, (a, b) -> Double.compare(Float.valueOf(a[0]), Float.valueOf(b[0])));
		Arrays.sort(menuBurgerking, (a, b) -> Double.compare(Float.valueOf(a[0]), Float.valueOf(b[0])));
		Arrays.sort(menuWendys, (a, b) -> Double.compare(Float.valueOf(a[0]), Float.valueOf(b[0])));
	}
	
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
