package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T> {
    public List<T> lista = new ArrayList<>();

    public ListCreator(List<T> list){
        this.lista =list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> listaNowa) {
        return new ListCreator<T>(listaNowa);
    }

    public ListCreator<T> when(Predicate<T> sel){
        List<T> filteredList = new ArrayList<>();
        for(T elem : this.lista){
            if(sel.test(elem)){
                filteredList.add(elem);
            }
        }
        return new ListCreator<T>(filteredList);
    }

    public <S> List<S> mapEvery(Function<T, S> map){
        List<S> mappedList = new ArrayList<>();
        for(T elem : this.lista){
            mappedList.add(map.apply(elem));
        }
        return mappedList;
    }

}
