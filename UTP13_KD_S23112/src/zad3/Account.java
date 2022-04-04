package zad3;

import java.beans.*;

public class Account {

    public double balance;

    private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
    private VetoableChangeSupport vetos = new VetoableChangeSupport(this);

    public Account() throws PropertyVetoException {
        this(0);
    }

    public Account(double balance) throws PropertyVetoException{
            setBalance(balance);
    }


    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChange.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChange.removePropertyChangeListener(l);
    }

    public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
        vetos.addVetoableChangeListener(l);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
        vetos.removeVetoableChangeListener(l);
    }


    public void deposit(double value) throws PropertyVetoException{
            setBalance(getBalance()+value);
    }

    public void withdraw(double value) throws PropertyVetoException{
            setBalance(getBalance()-value);

    }

    public void transfer(Account account, double value) throws PropertyVetoException{
            setBalance(getBalance()-value);
            account.setBalance(account.getBalance()+value);
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) throws PropertyVetoException {
        double oldBalance=this.balance;

        vetos.fireVetoableChange("balance", oldBalance, balance);

        this.balance=balance;

        propertyChange.firePropertyChange("balance", oldBalance, balance);
    }


    @Override
    public String toString() {
        return "Account: "+balance;
    }
}
