package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Class to allow the disjoint set to run using a file fed from 
 * the command line.
 * @author Scott and Nate
 *
 */
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        DisjointForest<String> dj = new DisjointForest<String>();
        File file = new File(args[0]);
        try {
            try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
				    String nextLine = scanner.nextLine();

				    if (nextLine.isEmpty()) break;

				    dj.makeSet(nextLine);
				}
				while (scanner.hasNextLine()) {
				    String nextLine = scanner.nextLine();

				    if (nextLine.isEmpty()) break;

				    String[] line = nextLine.split("\\s+");
				    dj.union(line[1], line[0]);
				}
				while (scanner.hasNextLine()) {
				    String nextLine = scanner.nextLine();

				    String[] elements = nextLine.split("\\s+");

				    if (nextLine.isEmpty()) break;
				    if (!dj.getRepresentative(elements[0]).equals(dj.getRepresentative(elements[1]))) {
				        System.out.println("not connected");
				    } else {
				        System.out.println("connected");
				    }
				}
			}
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }
}