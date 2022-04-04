/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*<--
 *  niezbędne importy
 */
public class Main {
  public static void main(String[] args) {

    Function<String, List<String>> flines = (n) -> {
     return Arrays.asList(n.split("\n"));
    };

    Function<List<String>, String> join = (n) -> {
      String text ="";
      for(String s : n){
        text +=s;
      }
      return text;
    };

    Function<String, List<Integer>> collectInts = (n) -> {
      n=n.replaceAll("/\\D/g", " ");
      String[] strings = n.split(" ");
      List<Integer> numbers = new ArrayList<>();
      for(String s : strings){
        numbers.add(Integer.parseInt(s));
      }
      return numbers;
    };

    Function<List<Integer>, Integer> sum = (n) -> {
      Integer suma=0;
      for(Integer i : n){
        suma +=i;
      }
      return suma;
    };


    /*<--
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
