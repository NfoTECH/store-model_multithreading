package dev.nfotech.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Customer implements Comparator<Customer> {
    private String name;
    private double wallet;
    private int noOfItemCart = 0;

    private ArrayList<Product> myCart=new ArrayList<>();

    public Customer() {

    }

    public Customer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public int getNoOfItemCart() {
        return noOfItemCart;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getMyCart() {
        return myCart;
    }

    public void setMyCart(ArrayList<Product> myCart) {
        this.myCart = myCart;
    }

    public void addToCart(Product product) {
        this.myCart.add(product);
        this.noOfItemCart += product.getQuantity();
    }

    public double getWallet() {
        return wallet;
    }

    @Override
    public int compare(Customer A, Customer B) {
        return Integer.compare(B.getNoOfItemCart(), A.getNoOfItemCart());
    }
}