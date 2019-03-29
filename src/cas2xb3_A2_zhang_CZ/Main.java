package cas2xb3_A2_zhang_CZ;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		EdgeWeightedDigraph weightedDg = new EdgeWeightedDigraph(32);
		Read read = new Read();
		read.printAllCities();
		CityRestaurants rest = new CityRestaurants();
		for (int i = 0; i < read.connections.length; i++) {			

			int toCity = read.cityToNum(read.connections[i][1]);
			String dollarMenu[][] = rest.availableMenu(toCity);
			
			for (int j = 0; j < 6; j++) {
				if (dollarMenu[j][0] != null) {
					double price = Double.valueOf(dollarMenu[j][0]);
					DirectedEdge edge = new DirectedEdge(read.cityToNum(read.connections[i][0]),
					read.cityToNum(read.connections[i][1]), price);
					weightedDg.addEdge(edge);
				}
			}
		}
		System.out.println(weightedDg.toString());
		
		DijkstraSP sPath = new DijkstraSP(weightedDg, 0);
		System.out.print("Path: ");
		System.out.println(sPath.pathTo(21));
		System.out.print("Path Cost: $");
		System.out.println(sPath.distTo(21));
	}

}
