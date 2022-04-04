/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad2;


import zad1.Purchase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagrams {
    String fname;

    public Anagrams(String fname) {
        this.fname = fname;
    }


    public List<List<String>> getSortedByAnQty() {
        List<String> listOfWords = new ArrayList<String>();
        Scanner s = null;
        try {
            s = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            listOfWords.add(s.next());
        }
        s.close();


        List<String> extraList = new ArrayList<>();
        List<String> extraList2;

        List<String> forbidenWords = new ArrayList<>();

        List<List<String>> finalList = new ArrayList<>();

        for (String word : listOfWords) {
            extraList.clear();
            if (!forbidenWords.contains(word)) {
                extraList.add(word);
                forbidenWords.add(word);
            }
            for (String word2 : listOfWords) {
                if (isAnagram(word, word2)) {
                    if (!forbidenWords.contains(word2)) {
                        extraList.add(word2);
                        forbidenWords.add(word2);
                    }
                }
            }
            if(!extraList.isEmpty()) {
                extraList2 = new ArrayList<>(extraList);
                finalList.add(extraList2);
            }
        }
        Collections.sort(finalList, (e1, e2)-> e2.size()-e1.size());
        return finalList;
    }

    static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toCharArray();
            char[] ArrayS2 = s2.toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        return status;
    }


    public String getAnagramsFor(String word){
        List<String> words = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        Scanner s = null;
        try {
            s = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()){
            words.add(s.next());
        }
        s.close();

        for(String string : words){
            if(isAnagram(word, string)){
                    list.add(string);
            }
        }

        if(!list.contains(word)){
            return word+": "+"null";
        }

        list.remove(word);

        if(list.size()==0){
            return word+": "+"[]";
        }else{
            return word+": "+list.toString();
        }
    }
}  
