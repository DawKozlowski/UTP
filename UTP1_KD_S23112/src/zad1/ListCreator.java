/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {
    public List<T> lista = new ArrayList<>();

    public ListCreator(List<T> list){
        this.lista =list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> listaNowa) {
        return new ListCreator<T>(listaNowa);
    }

    public ListCreator<T> when(Selector<T> sel){
        List<T> filteredList = new ArrayList<>();
        for(T elem : this.lista){
            if(sel.select(elem)){
                filteredList.add(elem);
            }
        }
        return new ListCreator<T>(filteredList);
    }

    public <S> List<S> mapEvery(Mapper<T, S> map){
        List<S> mappedList = new ArrayList<>();
        for(T elem : this.lista){
            mappedList.add(map.map(elem));
        }
        return mappedList;
    }
    // Uwaga: klasa musi być sparametrtyzowana
}  
