package cas2xb3_A2_zhang_CZ;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import ADTs.DirectedEdge;
import Graphing.DijkstraSP;
import Graphing.EdgeWeightedDigraph;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Read read = new Read();
		read.printAllCities();
		CityRestaurants rest = new CityRestaurants();
		
		//WRITE BFS
		

		
		
		//DIJKSTRA SETUP
		EdgeWeightedDigraph weightedDg = new EdgeWeightedDigraph(32);
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
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("data/a2_out.txt", true));
			writer.write("Hello World !!");
		}
		catch (IOException e) {
			
		}

	}
}
