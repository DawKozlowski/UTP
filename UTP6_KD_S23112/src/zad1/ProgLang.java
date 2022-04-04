package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;

public class ProgLang {

    public String fname;


    public ProgLang(String fname) {
        this.fname = fname;
    }

    public Map<String, Set<String>> getLangsMap() {
        Map<String, Set<String>> map = new HashMap<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] parts = s.nextLine().split("\\t");
            String key = parts[0];
            String[] partsWithoutKey = Arrays.copyOfRange(parts, 1, parts.length);
            Set<String> set = new HashSet<>(Arrays.asList(partsWithoutKey));
            map.put(key, set);
        }
        return map;
    }

    public Map<String, Set<String>> getProgsMap() {
        Map<String, Set<String>> map = new HashMap<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        map = new HashMap<>();
        while (s.hasNextLine()) {
            String[] parts = s.nextLine().split("\\t");
            String key = parts[0];
            String[] partsWithoutKey = Arrays.copyOfRange(parts, 1, parts.length );
            Set<String> set = new HashSet<>();
            set.add(key);
            for (String str : partsWithoutKey) {
                if (map.containsKey(str)) {
                    Set<String> values = map.get(str);
                    set.addAll(values);
                    map.put(str, set);
                } else {
                    map.put(str, set);
                }
            }
        }
        return map;
    }

    public static <K, V> Map<K, Set<V>> sorted(Map<K, Set<V>> srcMap, Comparator<Map.Entry<K, Set<V>>> comp) {
        List<Map.Entry<K, Set<V>>> entries = new ArrayList<>(srcMap.entrySet());
        entries.sort(comp);
        LinkedHashMap<K, Set<V>> resMap = new LinkedHashMap<>();
        entries.forEach(e -> resMap.put(e.getKey(), e.getValue()));
        return resMap;
    }


    public static <K, V> Map<K, Set<V>> filtered(Map<K, Set<V>> srcMap, Predicate<Set<V>> pred){
        List<Map.Entry<K, Set<V>>> entries = new ArrayList<>(srcMap.entrySet());
        List<K> keys = new ArrayList<>(srcMap.keySet());
        LinkedHashMap<K, Set<V>> resMap = new LinkedHashMap<>();
        keys.forEach(e -> {
            if(pred.test(srcMap.get(e))){
                resMap.put(e, srcMap.get(e));
            }
        });
        return resMap;
    }


    public Map<String, Set<String>> getLangsMapSortedByNumOfProgs() {
        Map<String, Set<String>> map = this.getLangsMap();


        Map<String, Set<String>> sortedMap = sorted(map, (e1, e2) -> {
            int size1 = e1.getValue().size();
            int size2 = e2.getValue().size();
            if (size1 == size2) {
              return  e1.getKey().compareTo(e2.getKey());
            } else {
                return size2 - size1;
            }
        });

        return sortedMap;
    }




    public Map<String, Set<String>> getProgsMapSortedByNumOfLangs() {

        Map<String, Set<String>> map = this.getProgsMap();


        Map<String, Set<String>> sortedMap = sorted(map, (e1, e2) -> {
            int size1 = e1.getValue().size();
            int size2 = e2.getValue().size();
            if (size1 == size2) {
                return  e1.getKey().compareTo(e2.getKey());
            } else {
                return size2 - size1;
            }
        });

        return sortedMap;
    }


    public Map<String, Set<String>> getProgsMapForNumOfLangsGreaterThan(int n){
        Map<String, Set<String>> map = this.getProgsMap();
        Map<String, Set<String>> finalMap = new HashMap<>();

        map.forEach( (e1, e2) ->{
            if(e2.size()>n){
                finalMap.put(e1, e2);
            }
        });

        return finalMap;
    }




    }








