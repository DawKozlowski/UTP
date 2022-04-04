/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad2;


import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {

    List<String> listOfWords = new ArrayList<>();
    URL url = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
    Scanner sc = new Scanner(url.openStream());
    while(sc.hasNextLine()) {
      listOfWords.add(sc.nextLine());
    }

    Map<String, List<String>> map = listOfWords.stream()
                    .distinct()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.groupingBy(p-> isAnagram(p), Collectors.toList()));


    Comparator<List<String>> comparator = new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {
        return o1.size()-o2.size();
      }
    };

     int max = map.values().stream().max(comparator).get().size();

    List<List<String>> list2 = map.values().stream().filter(list3->list3.size()==max).collect(Collectors.toList());

    list2.forEach(System.out::println);

  }


  private static String isAnagram(String s) {
    return Stream.of(s.split("")).sorted().collect(Collectors.joining());
  }


}
