package assign07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static jdk.nashorn.internal.ir.RuntimeNode.Request.reverse;

/**
 * Contains several methods for solving problems on generic, directed, unweighted, sparse graphs.
 *
 * @author Erin Parker & ??
 * @version March 3, 2022
 */
public class GraphUtility<Type> {


    public static <Type> boolean areConnected(List<Type> sources, List<Type> destinations, Type srcData, Type dstData) {
        if (sources.size() != destinations.size()) {
            throw new IllegalArgumentException("Sources and destinations lengths are not equal.");
        }

        Graph<Type> graph = new Graph<Type>();

        for (int i = 0; i < sources.size(); i++) {
            graph.addEdge(sources.get(i), destinations.get(i));
        }
        System.out.println(graph);

        graph.getVertice(srcData).isVisited(true);

        if (srcData == dstData) {
            return true;
        }
        return recursiveConnected(graph, srcData, dstData);
    }

    public static <Type> boolean recursiveConnected(Graph<Type> graph, Type currentData, Type dstData) {
        if (currentData == dstData) {
            graph.getVertice(currentData).isVisited(true);
            return true;
        }
        Iterator it = graph.getVertice(currentData).edges();
        while (it.hasNext()) {

            Edge next = (Edge) it.next();
            if (next.getOtherVertex().getData().equals(dstData)) return true;

            if (next.getOtherVertex().getVisited() == false) {
                next.getOtherVertex().isVisited(true);
                if(recursiveConnected(graph, (Type) next.getOtherVertex().getData(), dstData))
                    return true;
            }
        }
        return false;
    }
    // FILL IN + ADD METHOD COMMENT
    //


    public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData, Type dstData)
            throws IllegalArgumentException {
        //make queue
        //mark src data as visited
        //put first node in queue

        //while queue isn't empty{
        //pop the queue and loop through the edges in the vertex you popped marking the vertexes at the other end as visited
        //
    //  }
        // FILL IN + ADD METHOD COMMENT
        return null;
    }



    public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations) throws IllegalArgumentException {
        // FILL IN + ADD METHOD COMMENT
        List<Vertex> path = new ArrayList<>();

        Graph<Type> graph = new Graph<Type>();

        Vertex <Type>startVertex = null;

        for (int i = 0; i < sources.size(); i++) {
            graph.addEdge(sources.get(i), destinations.get(i));
        }

        for (int v = 0; v < sources.size(); v++){
            if(!graph.getVertice(sources.get(v)).edges().hasNext()){
                startVertex = graph.getVertice(sources.get(v));
                Iterator it = startVertex.edges();
                path.add(startVertex);
                sources.remove(startVertex);
            }

            Iterator it = startVertex.edges();
            Edge graphIterator = (Edge) it.next();
            graphIterator = edge.getOtherVertex();
        }






        return null;
    }

    /**
     * Builds "sources" and "destinations" lists according to the edges
     * specified in the given DOT file (e.g., "a -> b"). Assumes that the vertex
     * data type is String.
     * <p>
     * Accepts many valid "digraph" DOT files (see examples posted on Canvas).
     * --accepts \\-style comments
     * --accepts one edge per line or edges terminated with ;
     * --does not accept attributes in [] (e.g., [label = "a label"])
     *
     * @param filename     - name of the DOT file
     * @param sources      - empty ArrayList, when method returns it is a valid
     *                     "sources" list that can be passed to the public methods in this
     *                     class
     * @param destinations - empty ArrayList, when method returns it is a valid
     *                     "destinations" list that can be passed to the public methods in
     *                     this class
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
