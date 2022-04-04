/**
 *
 *  @author Kozłowski Dawid S23112
 *
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CustomersPurchaseSortFind {

    List<Purchase> list;
    public void readFile(String fname){
        Scanner s = null;
        try {
            s = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        list = new ArrayList<Purchase>();
        while (s.hasNextLine()){
            String[] parts = s.nextLine().split(";");
            list.add(new Purchase(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
        }
        s.close();
    }


    public void showSortedBy(String s){
        Comparator<Purchase> comp;
        switch (s){
            case "Nazwiska":
                comp=Comparator.naturalOrder();
                Collections.sort(list, comp);
                System.out.println("Nazwiska");
                for(Purchase pur : list){
                    System.out.println(pur.getID()+";"+pur.getName()+";"+pur.getFood()+";"+pur.getPrice()+";"+pur.getQuantity());
                }
                System.out.println();
                break;
            case "Koszty":
                comp=(p1,p2) -> (int)p1.getCost()-(int)p2.getCost();
                Collections.sort(list, comp.reversed());
                System.out.println("Koszty");
                for(Purchase pur : list){
                    System.out.println(pur.getID()+";"+pur.getName()+";"+pur.getFood()+";"+pur.getPrice()+";"+pur.getQuantity()+"(koszt: "+ pur.getCost()+')');
                }
               System.out.println();
                break;
            default:
                System.out.println("Error");
        }
    }

    public void showPurchaseFor(String s){
        List<Purchase> target = list.stream()
                                    .filter(n->n.getID().equals(s))
                                    .collect(toList());

        System.out.println("Klient "+s);
        for(Purchase pur : target){
            System.out.println(pur.getID()+";"+pur.getName()+";"+pur.getFood()+";"+pur.getPrice()+";"+pur.getQuantity());
        }
        System.out.println();
    }





}
