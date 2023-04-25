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
                String line =reader.nextLine();

                if (line.isEmpty()) {
                    while (reader.hasNextLine()) {

                        line=reader.nextLine();

                        if(line.isEmpty()) {


                            while(reader.hasNext()) {
                                line=reader.nextLine();

                                if(dj.getRepresentative(""+line.charAt(0))==dj.getRepresentative(""+line.charAt(2))) {
                                    System.out.println("connected");
                                }else {
                                    System.out.println("not connected");
                                }
                            }
                        }else {
                            dj.union(""+line.charAt(0), ""+line.charAt(2));
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