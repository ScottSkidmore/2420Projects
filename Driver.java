package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		File read = new File(args[0]);
		DisjointForest<String>dj=new DisjointForest<String>();
		try {
			Scanner reader = new Scanner(read);
			while (reader.hasNextLine()) {
				String line =reader.next();
				//System.out.println(line);
				if (line=="") {
					while (reader.hasNextLine()) {
						line=reader.next();
						if(line=="") {
					
						
							while(reader.hasNext()) {
								line=reader.next();
								if(dj.getRepresentative(""+line.charAt(0))==dj.getRepresentative(""+line.charAt(3))) {
									System.out.println("connected");
								}else {
									System.out.println("not connected");
								}
							}
						}else {
							dj.union(""+line.charAt(0), ""+line.charAt(3));
						}
					}
					
				}else {
					dj.makeSet(line);
				}
				
			}
			reader.close();
		} catch (Exception e) {
			e= new FileNotFoundException();
			System.out.println(e);
		}

	}
}
