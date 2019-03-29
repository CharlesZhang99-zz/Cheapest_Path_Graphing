package cas2xb3_A2_zhang_CZ;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Graphing.BreadthFirstDirectedPaths;
import Graphing.DepthFirstDirectedPaths;
import Graphing.Digraph;

public class BFSDFSTest {
	

	Digraph g = new Digraph(32);
	BreadthFirstDirectedPaths bfs;
	DepthFirstDirectedPaths dfs;
	

			

	@Before
	public void setUp() throws Exception {
		Read read = new Read();
		CityRestaurants rest = new CityRestaurants();
		for (int i = 0; i < read.connections.length; i++) {			
			g.addEdge(read.cityToNum(read.connections[i][0]), 
					read.cityToNum(read.connections[i][1]));		
		}
		bfs = new BreadthFirstDirectedPaths(g, 0);
		dfs = new DepthFirstDirectedPaths(g, 0);
				
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testBFS() {
		System.out.println(g.toString());
		//iterate through all cities to see if theres a path from Boston to all other cities
		for (int i = 1; i < 32; i++) {
			
			String path[] = bfs.pathTo(i).toString().split(" ");
			//this boolean indicates if the whole route is valid
			boolean isRoute = true;
			//iterate through all the vertices starting from the second one to the last
			for (int j = 1; j < path.length; j++) {
				boolean aTob = false;
				//check if the previous city in path array is connected to the current city
				for (int w : g.getAdj()[Integer.valueOf(path[j - 1])]) {
					if (w == Integer.valueOf(path[j])) {
						aTob = true;
					}
				}
				isRoute = isRoute && aTob;
			}
			//check if every path is correct
			assert(isRoute == bfs.hasPathTo(i));
//			System.out.print("isRoute: ");
//			System.out.println(isRoute);
//			System.out.print("hashPathTo: ");
//			System.out.println(bfs.hasPathTo(i));
//			System.out.println(bfs.pathTo(i));
		}
	}
	
	@Test
	public void testDFS() {
		System.out.println(g.toString());
		//iterate through all cities to see if theres a path from Boston to all other cities
		for (int i = 1; i < 32; i++) {
			
			String path[] = dfs.pathTo(i).toString().split(" ");
			//this boolean indicates if the whole route is valid
			boolean isRoute = true;
			//iterate through all the vertices starting from the second one to the last
			for (int j = 1; j < path.length; j++) {
				boolean aTob = false;
				//check if the previous city in path array is connected to the current city
				for (int w : g.getAdj()[Integer.valueOf(path[j - 1])]) {
					if (w == Integer.valueOf(path[j])) {
						aTob = true;
					}
				}
				isRoute = isRoute && aTob;
			}
			//check if every path is correct
			assert(isRoute == dfs.hasPathTo(i));
//			System.out.print("isRoute: ");
//			System.out.println(isRoute);
//			System.out.print("hashPathTo: ");
//			System.out.println(bfs.hasPathTo(i));
//			System.out.println(bfs.pathTo(i));
		}
	}

}
