package zad3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class AccountLimitator implements VetoableChangeListener {

    double limit;


    public AccountLimitator(double limit){
        this.limit=limit;
    }

    public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
        double newVal = (double) e.getNewValue();
        if (newVal < limit)
            throw new PropertyVetoException("Unacceptable value change: "+newVal,e);
    }

}
