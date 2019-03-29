package cas2xb3_A2_zhang_CZ;

import java.io.FileNotFoundException;

public class CityRestaurants extends Read{

	public CityRestaurants() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		
		System.out.println(cityInfo[0][0]);
	}
	
	public void RestInCity(String[] cInfo){
		float cityLong = Float.valueOf(cInfo[3]);
		float cityLat = Float.valueOf(cInfo[2]);
		boolean inRadius = true;
		while (inRadius) {
			
		}
	}
	

}
