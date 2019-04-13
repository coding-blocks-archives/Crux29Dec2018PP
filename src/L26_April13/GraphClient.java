package L26_April13;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Apr-2019
 *
 */

public class GraphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 2);
		graph.addEdge("B", "C", 6);
		graph.addEdge("C", "D", 8);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 90);
		graph.addEdge("F", "G", 78);
		graph.addEdge("E", "G", 45);

		// graph.display();
		System.out.println(graph);

		// graph.removeEdge("D", "E");
		// graph.removeVertex("A");
		graph.display();
		System.out.println(graph.numEdges());

		// System.out.println(graph.hasPath("A", "F", new HashMap<>() , "A"));

		// graph.printAllPaths("A", "F", new HashMap<>(), "A");

		System.out.println(graph.bfs("A", "F"));
		System.out.println(graph.dfs("A", "F"));

		graph.bft();
		graph.dft();

	}
}
