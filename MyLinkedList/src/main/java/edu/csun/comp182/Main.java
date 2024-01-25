package edu.csun.comp182;
import java.io.*;
public class Main {

    public static void main(String[] args){
        MyLinkedList<Object> mylist = new MyLinkedList<>();


        mylist.add("Reyna");
        mylist.add("Jett");
        mylist.add("Raze");
        mylist.add("Jett");
        mylist.add(new Object());
        mylist.add(new Object());
        mylist.add(new Object());
        mylist.add(new Object());
        mylist.add(new Object());
        mylist.add(new Object());
        try {
            Object something = mylist.get(8);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I get an index out of bounds exception");
            e.printStackTrace(System.out);
        }

        System.out.println("List size " + mylist.size());
        mylist.remove("Raze");
        mylist.remove(1);
        System.out.println("List size " + mylist.size() + "Two objects removed");


    }
}