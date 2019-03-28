package cas2xb3_A2_zhang_CZ;

import java.io.FileNotFoundException;

public class Experiment {
	//given a city, it will return the number associated with it
	public static int cityToNum(String city, String allCities[]) {
		for (int i = 0; i < allCities.length; i++) {
			if (city.equals(allCities[i])) {
				return i;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		try {
			Read read = new Read();
			/*
			read.printCitiestxt();
			read.filterAllCities();
			read.printAllCities();
			System.out.println(read.cityToNum("Denver"));
			System.out.println(read.numToCity(19));
			*/
	
			Digraph digraph = new Digraph(32);
					
			for (int i = 0; i < read.connections.length; i++) {			
				digraph.addEdge(read.cityToNum(read.connections[i][0]), 
						read.cityToNum(read.connections[i][1]));		
			}
			
			read.printAllCities();
		
			System.out.println(digraph.toString());
		
		


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
