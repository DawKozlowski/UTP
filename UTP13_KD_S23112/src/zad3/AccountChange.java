package zad3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AccountChange implements PropertyChangeListener {

    public AccountChange(){}


    public void propertyChange(PropertyChangeEvent e)  {
        double oldVal =  (double) e.getOldValue();
        double newVal = (double) e.getNewValue();
        if(newVal<0){
            System.out.println("Value changed from " + oldVal + " to " + newVal+" balance < 0!");
        }else{
            System.out.println("Value changed from " + oldVal + " to " + newVal);
        }
    }


}
