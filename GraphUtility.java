package assign07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Contains several methods for solving problems on generic, directed,
 * unweighted, sparse graphs.
 *
 * @author Erin Parker & ??
 * @version March 3, 2022
 */
public class GraphUtility<Type> {

    public static <Type> boolean areConnected(List<Type> sources, List<Type> destinations, Type srcData, Type dstData) {
        if (sources.size() != destinations.size()) {
            throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
        }

        if (sources.contains(srcData)== false||destinations.contains(dstData) == false || srcData == null || dstData == null) {
            if (sources.contains(dstData)&&destinations.contains(srcData)) {
                return false;
            }
            throw new IllegalArgumentException("Either srcData or dstData is not present in the sources or destinations lists, or they are null.");
        }

        Graph<Type> graph = new Graph<Type>();

        for (int i = 0; i < sources.size(); i++) {
            graph.addEdge(sources.get(i), destinations.get(i));
        }

        if (srcData == dstData) {
            graph.getVertice(srcData.toString()).isVisited(true);
            return true;
        }
        if (sources.contains(srcData)== false||destinations.contains(dstData) == false || srcData == null || dstData == null) {
            throw new IllegalArgumentException("Either srcData or dstData is not present in the sources or destinations lists, or they are null.");
        }
        return recursiveConnected(graph, srcData, dstData);
    }

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
    // FILL IN + ADD METHOD COMMENT
    //

    public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData,
                                                 Type dstData) throws IllegalArgumentException {
        if (sources.size() != destinations.size()) {
            throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
        }
        if (sources.contains(srcData)== false||destinations.contains(dstData) == false || srcData == null || dstData == null) {

            throw new IllegalArgumentException("Either srcData or dstData is not present in the sources or destinations lists, or they are null.");
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
                return reconstructPath(graph,n,srcData,dstData);
            }

            Iterator<Edge<Type>> it1 = graph.getVertice(n.getName().toString()).edges();
            while (it1.hasNext()) {
                Edge<Type> next = it1.next();
                if (next.getOtherVertex().getVisited() == false) {
                    if(next.getOtherVertex().getCameFrom()==(null)) {
                        next.getOtherVertex().cameFrom(n);
                    }
                    nodesToVisit.add(next.getOtherVertex());
                    if (next.getOtherVertex().getData() == dstData) {
                        return reconstructPath(graph,next.getOtherVertex(),srcData,dstData);
                    }
                }
            }
        }
        throw new IllegalArgumentException();

    }

    public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations) throws IllegalArgumentException {
        if (sources.size() != destinations.size()) {
            throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
        }

        int vertNum = 0;
        Graph<Type> graph = new Graph<Type>();

        // Add vertices and edges to the graph
        for (int i = 0; i < sources.size(); i++) {
            graph.addEdge(sources.get(i), destinations.get(i));
            graph.getVertice(destinations.get(i).toString()).changeInCount(1);
        }

        System.out.println(graph);
        // Perform topological sort
        ArrayList<Vertex<Type>> vertexesWithNoIncomingEdges = new ArrayList<>();
        for (Vertex<Type> v : graph.getMap().values()) {
            vertNum = vertNum+1;
            System.out.println(v.getInCount());
            if(v.getInCount() == 0) {
                vertexesWithNoIncomingEdges.add(v);
            }
        }

        List<Type> result = new ArrayList<>();
        while (!vertexesWithNoIncomingEdges.isEmpty()) {
            Vertex<Type> node = vertexesWithNoIncomingEdges.iterator().next();
            vertexesWithNoIncomingEdges.remove(node);
            result.add(node.getData());
            for (Edge<Type> e : node.getEdges()) {
                Vertex<Type> dest = e.getOtherVertex();
                dest.removeEdge(e);
                e.getOtherVertex().changeInCount(-1);
                if (dest.edgeSize() == 0) {
                    vertexesWithNoIncomingEdges.add(dest);
                }
            }
        }

        if (result.size() != vertNum) {
            System.out.println((result));
            System.out.println(result.size());
            System.out.println(vertNum);
            throw new IllegalArgumentException("The graph contains a cycle.");
        }

        return result;
    }

    public static <Type>List<Type>reconstructPath(Graph<Type> g,Vertex<Type> node,Type srcData,Type dstData){
        List<Type> path = new ArrayList<>();

        for(Vertex<Type>vertex = g.getVertice(dstData.toString()); vertex.getData() != srcData; vertex = vertex.getCameFrom()){
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

        // Determine if graph is directed (i.e., look for "digraph id {").
        String line = "", edgeOp = "";
        while (scan.hasNext()) {
            line = scan.next();

            // Skip //-style comments.
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

        // Look for edge operator -> and determine the source and destination
        // vertices for each edge.
        while (scan.hasNext()) {
            String[] substring = line.split(edgeOp);

            for (int i = 0; i < substring.length - 1; i += 2) {
                // remove " and trim whitespace from node string on the left
                String vertex1 = substring[0].replace("\"", "").trim();
                // if string is empty, try again
                if (vertex1.equals(""))
                    continue;

                // do the same for the node string on the right
                String vertex2 = substring[1].replace("\"", "").trim();
                if (vertex2.equals(""))
                    continue;

                // indicate edge between vertex1 and vertex2
                sources.add(vertex1);
                destinations.add(vertex2);
            }

            // do until the "}" has been read
            if (substring[substring.length - 1].indexOf("}") >= 0)
                break;

            line = scan.next();

            // Skip //-style comments.
            line = line.replaceFirst("//.*", "");
        }

        scan.close();
    }
}