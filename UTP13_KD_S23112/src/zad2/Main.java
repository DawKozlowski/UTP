package zad2;

import zad1.ProgLang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args){


        Class<zad1.ProgLang> C = zad1.ProgLang.class;

        System.out.println("Nadklasy");
        while (C != null) {
            System.out.println(C.getName());
            C = (Class<ProgLang>) C.getSuperclass();
            System.out.println(C);
        }
        System.out.println("Konstruktory");
        Class<zad1.ProgLang> C2 = zad1.ProgLang.class;

        Constructor[] constructors = C2.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("constuctor: " + constructors[i]);
        }
        System.out.println("Metody");
        Method mets[] = null;
        mets=C2.getDeclaredMethods();
        for(Method m : mets){
            System.out.println(m);
        }
        System.out.println("Pola");
        Field[] field = C2.getDeclaredFields();
        for(Field f : field){
            System.out.println(f);
        }
        System.out.println("Pola w nadklasie");
        C2 = (Class<ProgLang>) C2.getSuperclass();
        Field[] fields =  C2.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("Utworzenie obiektu i wywołanie metody");
        try {
            ProgLang C3 = ProgLang.class.getConstructor(String.class).newInstance();
            mets[1].invoke(C3, String.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
