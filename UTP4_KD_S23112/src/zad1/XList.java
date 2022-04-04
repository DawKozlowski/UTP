package zad1;

import java.util.*;
import java.util.function.Function;

public class XList<T> extends AbstractList<T> {

    private T[] array;

   // XList(T[] array) {
   //     this.array = array;
   // }

    XList(Collection<T> ... c){
        List<T> collection = new ArrayList();
        for(Collection<T> d : c) {
            for(T a : d) {
                collection.add(a);
            }
        }
        array=(T[])collection.toArray();
    }

    XList(T ... a){
        List<T> list = new ArrayList<>();
        for(T c : a){
            list.add(c);
        }
        array=(T[])list.toArray();
    }

    public static <T> XList<T> of(T ... x){
        List<T> list = new ArrayList<>();
        for(T c : x){
            list.add(c);
        }
        return new XList(list);
    }

    public static <T> XList<T> of(Collection<T> c){
        return new XList(c);
    }

    public static <T> XList<T> charsOf(String s){
        List<Character> chars = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            chars.add(ch);
        }
        return new XList(chars);
    }

    public static <T> XList<T> tokensOf(String s){
        //List<String> chars = new ArrayList<>();
        String[] split = s.split(" ");
        return new XList(split);
    }

    public static <T> XList<T> tokensOf(String s, String ch){
        String[] split = s.split(ch);
        return new XList(split);
    }

    public T get(int index) {
        return array[index];
    }

    public XList<T> union(Collection<T> c){
        List<T> list = Arrays.asList(array);
        return new XList<T>(list, c);
    }

    public XList<T> union(T[] arr){
        List<T> list1 = Arrays.asList(array);
        List<T> list2 = Arrays.asList(arr);
        return new XList<T>(list1, list2);
    }

    public XList<T> diff(T[] array){
        boolean occur;
        List<T> list = new ArrayList<>();
        for(T a : this.array){
            occur=false;
            for(T c : array){
                if(a==c){
                    occur=true;
                }
            }
            if(!occur) {
                list.add(a);
            }
        }
        return new XList<>(list);
    }


    public XList<T> diff(Collection<T> c){
        boolean occur;
        List<T> list = new ArrayList<>();
        for(T a : this.array){
            occur=false;
            for(T t : c){
                if(a==t){
                    occur=true;
                }
            }
            if(!occur) {
                list.add(a);
            }
        }
        return new XList<>(list);
    }



    public XList<T> unique(){
        Set<T> set = new HashSet<>();
        List<T> list = new ArrayList<>();
        list=Arrays.asList(array);
        set=(Set<T>)Set.of(list);
        return new XList<>(set);
    }

    public XList<T> combine(){
        List<T> list = asList(array);
         XList xList=new XList(XList.permute(list,0));
         return xList;
    }

      public static <T> List<T> permute(List<T> arr, int k){
        List<T> list = new ArrayList<>();
            for(int i = k; i < arr.size(); i++){
                Collections.swap(arr, i, k);
                permute(arr, k+1);
                Collections.swap(arr, k, i);
            }
            if (k == arr.size() -1){
                list.add((T)arr);
            }
            return list;
        }


      public XList<T> collect(Function<T, T> fun){
        List<T> list = new ArrayList<>();
        for(T elem : this.array){
            list.add(fun.apply(elem));
        }
        return new XList<>(list);
      }


    public String join(){
        StringBuilder sb = new StringBuilder();
        for(T elem : this.array){
            sb.append(elem);
        }
       return sb.toString();
    }

    public String join(String sep){
        StringBuilder sb = new StringBuilder();
        for(T elem : this.array){
            sb.append(elem);
            sb.append(sep);
        }
     return sb.toString();
    }



    public T set(int index, T element) {
        T oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean add(T t) {
       return  true;
    }

    @Override
    public void add(int index, T element) {
        List<T> list = Arrays.asList(array);
        list.add(element);
        array=(T[])list.toArray();
    }

    public static <T> List<T> asList(T[] a) {
        return new XList<T>(a);
    }


}
