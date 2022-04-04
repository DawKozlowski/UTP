package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

    T object;

    public Maybe(T object){
        this.object =object;
    }

    public Maybe(){
        this.object =null;
    }


    public static <T> Maybe<T> of(T x){
      return new Maybe(x);
    }

    void ifPresent(Consumer cons){
        if(object !=null){
            cons.accept(object);
        }
    }

    public <S> Maybe<S> map(Function<T, S> func){
       if(object !=null){
           if(func.apply(this.object)==null){
               return new Maybe();
           }else{
               return new Maybe(func.apply(this.object));
           }
       }else{
           return new Maybe();
       }
    }

    public T get(){
        if(this.object ==null){
            throw new NoSuchElementException("maybe is empty");
        }else{
            return object;
        }
    }

    public boolean isPresent(){
        if(object ==null){
            return false;
        }else{
            return true;
        }
    }

    public T orElse(T defVal){
        if(this.object ==null){
            return  defVal;
        }else{
            return object;
        }
    }

    public Maybe<T> filter(Predicate pred){
        if(pred.test(this.object) || this.object ==null){
            return this;
        }else{
            return new Maybe();
        }
    }



    @Override
    public String toString() {
        if(object ==null){
            return "Maybe is empty";
        }else {
            return "Maybe has a value " + object;
        }
    }



}
