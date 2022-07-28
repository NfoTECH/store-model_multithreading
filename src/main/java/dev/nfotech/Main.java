package dev.nfotech;


import dev.nfotech.model.*;
import dev.nfotech.thread.StoreThread;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Store.readFile();


        ArrayList<Product> cart1 = new ArrayList<>();
        ArrayList<Product> cart2 = new ArrayList<>();
        ArrayList<Product> cart3 = new ArrayList<>();
        ArrayList<Product> cart4 = new ArrayList<>();
        ArrayList<Product> cart5 = new ArrayList<>();

        Customer jackson = new Customer("Jackson", 1000);
        Customer richard= new Customer("Richard", 1200);
        Customer aliyah = new Customer("Aliyah", 2150);
        Customer fortune = new Customer("Fortune", 2150);
        Customer clinton = new Customer("Clinton", 2150);


        Cashier cashier= new Cashier();
        cart1.add(new Product("Carrot", 10));
        jackson.setMyCart(cart1);

        cart2.add(new Product("Carrot", 10));
        richard.setMyCart(cart2);

        cart3.add(new Product("Carrot", 10));
        aliyah.setMyCart(cart3);

        cart4.add(new Product("Carrot", 10));
        fortune.setMyCart(cart4);

        cart5.add(new Product("Carrot", 10));
        clinton.setMyCart(cart5);

        System.out.println("\nCarrot balance quantity before sales is " + Product.stock.get("Carrot").getQuantity()+ "\n");

        StoreThread thread1 = new StoreThread(cashier, aliyah, Product.stock);
        StoreThread thread2 = new StoreThread(cashier, richard, Product.stock);
        StoreThread thread3 = new StoreThread(cashier, jackson, Product.stock);
        StoreThread thread4 = new StoreThread(cashier, fortune, Product.stock);
        StoreThread thread5 = new StoreThread(cashier, clinton, Product.stock);

        List<StoreThread> threadList =  new ArrayList<>();
        Collections.addAll(threadList, thread1, thread2, thread3, thread4, thread5);

        for (StoreThread thread: threadList) {
            thread.start();
            try {
                thread.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\nCarrot balance quantity after sales is " + Product.stock.get("Carrot").getQuantity());
    }
}
