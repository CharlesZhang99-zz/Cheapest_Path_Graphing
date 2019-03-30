package cas2xb3_A2_zhang_CZ;

//author Charles Zhang
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import ADTs.DirectedEdge;
import Graphing.BreadthFirstDirectedPaths;
import Graphing.DepthFirstDirectedPaths;
import Graphing.Digraph;
import Graphing.DijkstraSP;
import Graphing.EdgeWeightedDigraph;

//RUN THIS TO WRITE TO a2_out.txt file!
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Read read = new Read();
		CityRestaurants rest = new CityRestaurants();
		//make a new digraph with 32 vertices
		Digraph digraph = new Digraph(32);
		
		//adding edges to graph based
		for (int i = 0; i < read.connections.length; i++) {			
			digraph.addEdge(read.cityToNum(read.connections[i][0]), 
					read.cityToNum(read.connections[i][1]));		
		}
		
		
		
		//BFS SETUP
		BreadthFirstDirectedPaths bfs = 
				new BreadthFirstDirectedPaths(digraph, 0);
		//String list of cities(vertices) in the path
		String bfsPath[] = bfs.pathTo(21).toString().split(" ");
		
		
		
		//DFS SETUP
		DepthFirstDirectedPaths dfs = 
				new DepthFirstDirectedPaths(digraph, 0);
		//String list of cities(vertices) in the path
		String dfsPath[] = dfs.pathTo(21).toString().split(" ");
		
		
		
		//DIJKSTRA SETUP
		//make a new weighted digraph with 32 vertices
		EdgeWeightedDigraph weightedDg = new EdgeWeightedDigraph(32);
		
		//iterate through number of connections from connectedCities.txt
		for (int i = 0; i < read.connections.length; i++) {			
			//convert going to city to a number
			int toCity = read.cityToNum(read.connections[i][1]);
			//get the available cheapest menu from that city
			String dollarMenu[][] = rest.availableMenu(toCity);
			
			//iterate through the number of menu items from dollarMenu
			for (int j = 0; j < 6; j++) {
				if (dollarMenu[j][0] != null) {
					//added price of meal as weight for an edge
					double price = Double.valueOf(dollarMenu[j][0]);
					DirectedEdge edge = new DirectedEdge(read.cityToNum(read.connections[i][0]),
					read.cityToNum(read.connections[i][1]), price);
					weightedDg.addEdge(edge);
				}
			}
		}
		//making a new instance of DijkstraSP with 0 as source vertice
		DijkstraSP sPath = new DijkstraSP(weightedDg, 0);

		
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("data/a2_out.txt"));
			//WRITE BFS
			w.write("BFS: ");
			for (int i = 0; i < bfsPath.length - 1; i++) {
				w.write(read.numToCity(Integer.valueOf(bfsPath[i])));
				w.write(", ");
			}
			w.write(read.numToCity(Integer.valueOf(bfsPath[bfsPath.length - 1])));
			w.write("\n");
			
			//WRITE DFS
			w.write("DFS: ");
			for (int i = 0; i < dfsPath.length - 1; i++) {
				w.write(read.numToCity(Integer.valueOf(dfsPath[i])));
				w.write(", ");
			}
			w.write(read.numToCity(Integer.valueOf(dfsPath[dfsPath.length - 1])));
			w.write("\n");
			w.write("\n");
			
			//WRITE WEIGHTED
			int cityLength = 20;
			int mealLength = 30;
			
			w.write("City");
			//fancy loop to make spacing perfect. This appears multiple times later on.
			for (int i = 0; i < cityLength - "city".length(); i++) {
				w.write(" ");
			}
			
			w.write("Meal Choice");
			for (int i = 0; i < mealLength - "Meal Choice".length(); i++) {
				w.write(" ");
			}
			w.write("Cost of Meal");
			w.write("\n");
			
			//write city to, meal name, and meal price to file.
			for (DirectedEdge e : sPath.pathTo(21)) {
				String cityTo = read.numToCity(e.to());
				double weight = e.weight();
				String[][] availibleMenu = rest.availableMenu(e.to());
				String meal = null;
				
				for (int i = 0; i < availibleMenu.length; i++) {
					if (weight == Double.valueOf(availibleMenu[i][0])) {
						meal = availibleMenu[i][1];
					}
				}
				
				w.write(cityTo);
				for (int i = 0; i < cityLength - cityTo.length(); i++) {
					w.write(" ");
				}
				
				w.write(meal);
				for (int i = 0; i < mealLength - meal.length(); i++) {
					w.write(" ");
				}
				
				w.write(String.valueOf(weight));
				for (int i = 0; i < mealLength - String.valueOf(weight).length(); i++) {
					w.write(" ");
				}
				
				w.write("\n");
				
				//System.out.println(e.weight());
			}
			
			
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
