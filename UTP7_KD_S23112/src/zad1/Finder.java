/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad1;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Finder {

    String fname;


    public Finder(String fname){
        this.fname=fname;
    }

    public int getIfCount() throws IOException {
        int count=0;
        for(String line : Files.readAllLines(Paths.get(fname))){
            if(line.contains("if")){
                count++;
            }
        }
        return count;
    }


    public int getStringCount(String word) throws IOException{
        int count=0;

        Scanner sc = new Scanner(new File((fname)));
        while(sc.hasNext()){
            if(sc.next().contains(word)){
                count++;
            }
        }
        return count;
    }


}    
