package dev.nfotech.thread;

import dev.nfotech.model.Cashier;
import dev.nfotech.model.Customer;
import dev.nfotech.model.Product;

import java.util.HashMap;

import static dev.nfotech.model.Product.stock;

public class StoreThread extends Thread{
    final Cashier cashier;
    Customer customer;
    HashMap<String, Product> stock;

    public StoreThread(Cashier cashier, Customer customer, HashMap<String, Product>stock) {
        this.cashier = cashier;
        this.customer = customer;
        this.stock = stock;
    }
    @Override
    public void run() {
        synchronized (cashier) {
            cashier.makeSale(customer, stock);
        }
    }
}
