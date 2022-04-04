/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad1;


import java.text.Collator;
import java.util.Locale;

public class Purchase implements Comparable<Purchase> {
    String ID;
    String name;
    String food;
    double price;
    double quantity;

    public Purchase(String ID, String name,String food, double price, double quantity) {
        this.ID = ID;
        this.name = name;
        this.food = food;
        this.price = price;
        this.quantity=quantity;
    }

    @Override
    public int compareTo(Purchase other) {
        Collator collator = Collator.getInstance(new Locale("pl"));
        if( collator.compare(this.getName(), other.getName())==0){
            return ID.compareTo(other.ID);
        }
        return  collator.compare(this.getName(), other.getName());
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost(){
        return quantity*price;
    }

    @Override
    public String toString() {
        return
                 ID +
                  name +
                  food +
                price +
                quantity +'\n'
                ;
    }
}
