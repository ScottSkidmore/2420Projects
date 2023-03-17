package assign07;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * This class represents a vertex (AKA node) in a directed graph. The vertex is
 * not generic, assumes that a string name is stored there.
 *
 * @author Erin Parker Nate Zuro, and Scott Skidmore
 * @version March 3, 2022
 */
public class Vertex<T> {

	
	private T name;
	private boolean visited = false;
	private Vertex<T> cameFrom;

	private int inCount = 0;


	private LinkedList<Edge<T>> adj;

	/**
	 * Creates a new Vertex object, using the given name.
	 *
	 * @param name - string used to identify this Vertex
	 */
	public Vertex(T name) {
		this.name = name;
		this.adj = new LinkedList<Edge<T>>();
		this.cameFrom = null;

	}

	/**
	 * setter for the came from variable
	 * 
	 * @param n the vertex that we are setting as came from.
	 */
	public void cameFrom(Vertex<T> n) {
		this.cameFrom = n;
	}

	/**
	 * getter for came from
	 * 
	 * @return the came from vertex or null
	 */
	public Vertex<T> getCameFrom() {
		return this.cameFrom;
	}

	/**
	 * @return the string used to identify this Vertex
	 */
	public String getName() {
		return name.toString();
	}

	/**
	 * Adds a directed edge from this Vertex to another.
	 *
	 * @param otherVertex - the Vertex object that is the destination of the edge
	 */
	public void addEdge(Vertex<T> otherVertex) {
		adj.add(new Edge<T>(otherVertex));
	}

	/**
	 * @return a iterator for accessing the edges for which this Vertex is the
	 *         source
	 */
	public Iterator<Edge<T>> edges() {
		return adj.iterator();
	}

	/**
	 * Generates and returns a textual representation of this Vertex.
	 */
	public String toString() {
		String s = "Vertex " + name + " adjacent to vertices ";
		Iterator<Edge<T>> itr = adj.iterator();
		while (itr.hasNext())
			s += itr.next() + "  ";
		return s;
	}

	/**
	 * setter for the is visited field
	 * 
	 * @param T the boolean value we are setting
	 */
	public void isVisited(boolean T) {
		this.visited = T;
	}

	/**
	 * getter for visited field
	 * 
	 * @return the visited field
	 */
	public boolean getVisited() {
		return visited;
	}

	/**
	 * getter for data field
	 * 
	 * @return the field with data
	 */
	public T getData() {
		return name;
	}

	/**
	 * gets the adjacency list for a vertex
	 * 
	 * @return the adjacency list for a vertex
	 */
	public LinkedList<Edge<T>> getEdges() {
		return this.adj;
	}

	/**
	 * removes and edge between two vertices
	 * 
	 * @param e the edge we want to remove
	 */
	public void removeEdge(Edge<T> e) {
		for (int i = 0; i < adj.size(); i++) {
			if (e.equals(adj.get(i))) {
				adj.remove(e);
			}
		}
	}

	/**
	 * gets the size of the adjacency list
	 * 
	 * @return the size of the adjacency list
	 */
	public int edgeSize() {
		return adj.size();
	}

	/**
	 * changes the count for the in count of a vertex
	 * 
	 * @param i the amount we want to change by
	 */
	public void changeInCount(int i) {
		this.inCount = this.inCount + i;
	}

	/**
	 * getter for the in count
	 * 
	 * @return the in count of vertex
	 */
	public int getInCount() {
		return this.inCount;
	}
}