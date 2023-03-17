package assign07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Contains several methods for solving problems on generic, directed,
 * unweighted, sparse graphs.
 *
 * @author Erin Parker & Nate Zuro and Scott SKidmore
 * @version March 3, 2022
 */
public class GraphUtility<Type> {
	/**
	 * Method that returns true if two elements are connected in a graph and false
	 * if they are not
	 * 
	 * @param <Type>
	 * @param sources      list of sources to be turned into vertices
	 * @param destinations list of destinations to be turned to vertices
	 * @param srcData      the source we are starting with
	 * @param dstData      the destination we are testing for connection
	 * @return true or false if graph is connected
	 */
	public static <Type> boolean areConnected(List<Type> sources, List<Type> destinations, Type srcData, Type dstData) {
		if (sources.size() != destinations.size()) {
			throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
		}

		if (sources.contains(srcData) == false || destinations.contains(dstData) == false || srcData == null
				|| dstData == null) {
			if (sources.contains(dstData) && destinations.contains(srcData)) {
				return false;
			}
			throw new IllegalArgumentException(
					"Either srcData or dstData is not present in the sources or destinations lists, or they are null.");
		}

		Graph<Type> graph = new Graph<Type>();

		for (int i = 0; i < sources.size(); i++) {
			graph.addEdge(sources.get(i), destinations.get(i));
		}

		if (srcData == dstData) {
			graph.getVertice(srcData.toString()).isVisited(true);
			return true;
		}
		if (sources.contains(srcData) == false || destinations.contains(dstData) == false || srcData == null
				|| dstData == null) {
			throw new IllegalArgumentException(
					"Either srcData or dstData is not present in the sources or destinations lists, or they are null.");
		}
		return recursiveConnected(graph, srcData, dstData);
	}

	/**
	 * The recursive method that is called in the connected driver method
	 * 
	 * @param <T>
	 * @param graph       the graph we are looking at
	 * @param currentData the current data of the vertex we are at
	 * @param dstData     the destination we are looking for
	 * @return true or false if the vertices are connected
	 */
	public static <T> boolean recursiveConnected(Graph<T> graph, T currentData, T dstData) {
		if (currentData == dstData) {
			graph.getVertice(currentData.toString()).isVisited(true);
			return true;
		}
		Iterator<Edge<T>> it = graph.getVertice(currentData.toString()).edges();
		while (it.hasNext()) {

			Edge<T> next = it.next();
			if (next.getOtherVertex().getData().equals(dstData)) {
				return true;
			}
			if (next.getOtherVertex().getVisited() == false) {
				next.getOtherVertex().isVisited(true);
				if (recursiveConnected(graph, next.getOtherVertex().getData(), dstData)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method that returns a list of the shortest path between two vertices if it is
	 * found
	 * 
	 * @param <Type>
	 * @param sources      list of source data for vertices
	 * @param destinations list of destination data for vertices
	 * @param srcData      the data for the start vertex
	 * @param dstData      the vertex we are trying to find the shortest path to
	 * @return a list of the data for the shortest path of vertices
	 * @throws IllegalArgumentException
	 */
	public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData,
			Type dstData) throws IllegalArgumentException {
		if (sources.size() != destinations.size()) {
			throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
		}
		if (sources.contains(srcData) == false || destinations.contains(dstData) == false || srcData == null
				|| dstData == null) {

			throw new IllegalArgumentException(
					"Either srcData or dstData is not present in the sources or destinations lists, or they are null.");
		}

		Graph<Type> graph = new Graph<Type>();

		for (int i = 0; i < sources.size(); i++) {
			graph.addEdge(sources.get(i), destinations.get(i));
		}
		Queue<Vertex<Type>> nodesToVisit = new LinkedList<Vertex<Type>>();
		Iterator<Edge<Type>> it = graph.getVertice(srcData.toString()).edges();
		while (it.hasNext()) {

			Edge<Type> next = it.next();
			nodesToVisit.add(next.getOtherVertex());
			next.getOtherVertex().cameFrom(graph.getVertice(srcData.toString()));
		}
		while (!nodesToVisit.isEmpty()) {
			Vertex<Type> n = nodesToVisit.remove();
			n.isVisited(true);
			if (n.getData() == dstData) {
				return reconstructPath(graph, srcData, dstData);
			}

			Iterator<Edge<Type>> it1 = graph.getVertice(n.getName().toString()).edges();
			while (it1.hasNext()) {
				Edge<Type> next = it1.next();
				if (next.getOtherVertex().getVisited() == false) {
					if (next.getOtherVertex().getCameFrom() == (null)) {
						next.getOtherVertex().cameFrom(n);
					}
					next.getOtherVertex().isVisited(true);
					nodesToVisit.add(next.getOtherVertex());
					if (next.getOtherVertex().getData().equals(dstData)) {
						return reconstructPath(graph, srcData, dstData);
					}
				}
			}
		}
		throw new IllegalArgumentException("g");

	}

	/**
	 * Performs a topological sort on a graph
	 * 
	 * @param <Type>
	 * @param sources      list of source data for vertices
	 * @param destinations list of source data for vertices
	 * @return a list of the data sorted in order using topological sort
	 * @throws IllegalArgumentException
	 */
	public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations) throws IllegalArgumentException {
		if (sources.size() != destinations.size()) {
			throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
		}

		int vertNum = 0;
		Graph<Type> graph = new Graph<Type>();

		for (int i = 0; i < sources.size(); i++) {
			graph.addEdge(sources.get(i), destinations.get(i));
			graph.getVertice(destinations.get(i).toString()).changeInCount(1);
		}

		ArrayList<Vertex<Type>> path = new ArrayList<>();
		for (Vertex<Type> v : graph.getMap().values()) {
			vertNum = vertNum + 1;
			if (v.getInCount() == 0) {
				path.add(v);
			}
		}

		List<Type> result = new ArrayList<>();
		for (int i = 0; i < path.size(); i++) {
			Vertex<Type> vertex = path.get(i);
			result.add(vertex.getData());
			for (Edge<Type> e : vertex.getEdges()) {
				Vertex<Type> dest = e.getOtherVertex();
				vertex.removeEdge(e);
				e.getOtherVertex().changeInCount(-1);
				if (dest.getInCount() == 0) {
					path.add(dest);
				}
			}
		}
		if (result.size() != vertNum)
			throw new IllegalArgumentException("Graph is cyclical.");

		return result;
	}

	/**
	 * reconstructs a the shortest path from one vertex to another
	 * 
	 * @param <Type>
	 * @param g       the graph we are looking at
	 * @param srcData the data for the first vertex in the path
	 * @param dstData the data for the last vertex in the path
	 * @return a list of the data of the vertices in order that form the shortest
	 *         path
	 */
	public static <Type> List<Type> reconstructPath(Graph<Type> g, Type srcData, Type dstData) {
		List<Type> path = new ArrayList<>();

		for (Vertex<Type> vertex = g.getVertice(dstData.toString()); !vertex.getData().equals(srcData); vertex = vertex.getCameFrom()) {
			path.add(vertex.getData());
		}
		path.add(g.getVertice(srcData.toString()).getData());
		Collections.reverse(path);
		return path;
	}

	/**
	 * Builds "sources" and "destinations" lists according to the edges specified in
	 * the given DOT file (e.g., "a -> b"). Assumes that the vertex data type is
	 * String.
	 * <p>
	 * Accepts many valid "digraph" DOT files (see examples posted on Canvas).
	 * --accepts \\-style comments --accepts one edge per line or edges terminated
	 * with ; --does not accept attributes in [] (e.g., [label = "a label"])
	 *
	 * @param filename     - name of the DOT file
	 * @param sources      - empty ArrayList, when method returns it is a valid
	 *                     "sources" list that can be passed to the public methods
	 *                     in this class
	 * @param destinations - empty ArrayList, when method returns it is a valid
	 *                     "destinations" list that can be passed to the public
	 *                     methods in this class
	 */
	public static void buildListsFromDot(String filename, ArrayList<String> sources, ArrayList<String> destinations) {

		Scanner scan = null;
		try {
			scan = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		scan.useDelimiter(";|\n");

		
		String line = "", edgeOp = "";
		while (scan.hasNext()) {
			line = scan.next();

		
			line = line.replaceFirst("//.*", "");

			if (line.indexOf("digraph") >= 0) {
				edgeOp = "->";
				line = line.replaceFirst(".*\\{", "");
				break;
			}
		}
		if (edgeOp.equals("")) {
			System.out.println("DOT graph must be directed (i.e., digraph).");
			scan.close();
			System.exit(0);

		}

		while (scan.hasNext()) {
			String[] substring = line.split(edgeOp);

			for (int i = 0; i < substring.length - 1; i += 2) {
		
				String vertex1 = substring[0].replace("\"", "").trim();
			
				if (vertex1.equals(""))
					continue;

			
				String vertex2 = substring[1].replace("\"", "").trim();
				if (vertex2.equals(""))
					continue;
				sources.add(vertex1);
				destinations.add(vertex2);
			}

		
			if (substring[substring.length - 1].indexOf("}") >= 0)
				break;

			line = scan.next();

	
			line = line.replaceFirst("//.*", "");
		}

		scan.close();
	}
}