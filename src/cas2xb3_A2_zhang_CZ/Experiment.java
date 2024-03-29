package cas2xb3_A2_zhang_CZ;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Graphing.BreadthFirstDirectedPaths;
import Graphing.DepthFirstDirectedPaths;
import Graphing.Digraph;
/**
 *  @author Charles Zhang
 */

//******************************************************
//THIS IS JUST FOR EXPERIMENTING. NOT PART OF ASSIGNMENT
//******************************************************

/*
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
			
			
			read.printCitiestxt();
			System.out.println(read.cityToNum("DENVER"));
			System.out.println(read.numToCity(12));
			
			
			read.printCitiestxt();
			read.printAllCities();
			Digraph digraph = new Digraph(32);
					
			for (int i = 0; i < read.connections.length; i++) {			
				digraph.addEdge(read.cityToNum(read.connections[i][0]), 
						read.cityToNum(read.connections[i][1]));		
			}
					
			System.out.println(digraph.toString());

			DepthFirstDirectedPaths depthFirst = 
					new DepthFirstDirectedPaths(digraph, 0);

			System.out.println(depthFirst.hasPathTo(21));
			System.out.println(depthFirst.pathTo(21));
			
			BreadthFirstDirectedPaths breadthFirst = 
					new BreadthFirstDirectedPaths(digraph, 0);
			System.out.println(breadthFirst.hasPathTo(21));
			System.out.println(breadthFirst.pathTo(21));
			Iterable<Integer> path = (breadthFirst.pathTo(21));
			System.out.println(path.toString());
			String pathstring[] = path.toString().split(" ");
			for (int i = 0; i < pathstring.length; i++) {
				System.out.println(pathstring[i]);
			}
			//ArrayList<Integer> path = (ArrayList<Integer>) (breadthFirst.pathTo(21));
			//for (int i = 0; i < pat)
//			CityRestaurants cityrest = new CityRestaurants();
//			cityrest.restInCity(read.cityInfo[0]);
//			String cityarr[] = read.cityInfo[0];
//			System.out.println(cityarr[0]);
//			float ls[][] = {{1,1}, {3,1}, {5,1}, {7, 1}, {10,1}};
//			
//			System.out.println(CustomBinarySearch.start((float) -94.061849, ls));
//			System.out.println(DumbSeqSearch.find(8, ls));

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/
