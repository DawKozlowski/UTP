package zad1;

import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {
    T file;


    public InputConverter(T file) {
        this.file = file;
    }



    public <S> S convertBy(Function ... f) {
        Object result = null;
        for (Function fun : f) {
            result = fun.apply(file);
        }
        return (S)result;
    }



/*
    public List<String> convertBy(Function<String, List<String>> f1) {
        return f1.apply((String)file);
    }

    public String convertBy(Function<String, List<String>> f1, Function<List<String>, String> f2) {
        return f2.apply(f1.apply((String) file));
    }

    public List<Integer> convertBy(Function<String, List<String>> f1, Function<List<String>, String> f2, Function<String, List<Integer>> f3) {
        return f3.apply(f2.apply(f1.apply((String) file)));
    }

    public Integer convertBy(Function<String, List<String>> f1, Function<List<String>, String> f2, Function<String, List<Integer>> f3, Function<List<Integer>, Integer> f4) {
        return f4.apply(f3.apply(f2.apply(f1.apply((String) file))));
    }


    public Integer convertBy(Function<List<String>, String> f1, Function<String, List<Integer>> f2, Function<List<Integer>, Integer> f3) {
        return f3.apply(f2.apply(f1.apply((List<String>) file)));
    }

*/



}