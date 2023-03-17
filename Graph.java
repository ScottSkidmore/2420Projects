package assign07;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Represents a sparse, unweighted, directed graph (a set of vertices and a set
 * of edges). The graph is not generic and assumes that a string name is stored
 * at each vertex.
 *
 * @author Erin Parker Nate Zuro, Scott Skidmore
 * @version March 3, 2022
 */
public class Graph<T> {

	private HashMap<String, Vertex<T>> vertices;

	private int vertNum;

	/**
	 * Constructs an empty graph.
	 */
	public Graph() {
		vertices = (HashMap<String, Vertex<T>>) new HashMap<String, Vertex<T>>();
	}

	/**
	 * getter for a vertices in the graph
	 * 
	 * @param key string key for map
	 * @return the vertex that matches the key
	 */
	public Vertex<T> getVertice(String key) {
		return vertices.get(key);
	}

	/**
	 * Adds to the graph a directed edge from the vertex with name "name1" to the
	 * vertex with name "name2". (If either vertex does not already exist in the
	 * graph, it is added.)
	 *
	 * @param name1 - string name for source vertex
	 * @param name2 - string name for destination vertex
	 */
	public void addEdge(T name1, T name2) {
		Vertex<T> vertex1;
	
		if (vertices.containsKey(name1.toString()))
			vertex1 = vertices.get(name1.toString());
		
		else {
			vertex1 = new Vertex<T>(name1);
			vertices.put(vertex1.getName(), vertex1);
		}

		Vertex<T> vertex2;
		if (vertices.containsKey(name2.toString()))
			vertex2 = vertices.get(name2.toString());
		else {
			vertex2 = new Vertex<T>(name2);
			vertices.put(vertex2.getName(), vertex2);
		}

	
		vertex1.addEdge(vertex2);
		this.vertNum = this.vertNum + 1;
	}

	/**
	 * Generates the DOT encoding of this graph as string, which can be pasted into
	 * http://www.webgraphviz.com to produce a visualization.
	 */
	public String generateDot() {
		StringBuilder dot = new StringBuilder("digraph d {\n");

		for (Vertex<T> v : vertices.values()) {
			
			Iterator<Edge<T>> edges = v.edges();
			while (edges.hasNext())
				dot.append("\t\"" + v.getName() + "\" -> \"" + edges.next() + "\"\n");

		}

		return dot.toString() + "}";
	}

	/**
	 * Generates a simple textual representation of this graph.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Vertex<T> v : vertices.values())
			result.append(v + "\n");

		return result.toString();
	}

	/**
	 * getter for the map of vertices
	 * 
	 * @return the map of vertices
	 */
	public HashMap<String, Vertex<T>> getMap() {
		return vertices;
	}

	/**
	 * gets the number of vertices in the graph
	 * 
	 * @return number of vertices in the graph
	 */
	public int getVertNum() {
		return this.vertNum;
	}

}