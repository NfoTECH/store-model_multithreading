package dev.nfotech.thread;

import dev.nfotech.model.Cashier;
import dev.nfotech.model.Customer;
import dev.nfotech.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreThreadTest {

    @Test
    @DisplayName("Should make a sale when the cashier is available")
    void runWhenCashierIsAvailableThenMakeSale() {
        Cashier cashier = new Cashier();
        Customer customer = new Customer("A", 1000);
        HashMap<String, Product> stock = new HashMap<>();
        stock.put("Carrot", new Product("Carrot", "Bars", 4187, 1.77));
        stock.put("Banana", new Product("Banana", "Bars", 79, 2.27));
        stock.put("Arrowroot", new Product("Arrowroot", "Cookies", 2445, 2.18));
        stock.put("Pretzels", new Product("Pretzels", "Snacks", 186, 3.15));


        customer.addToCart(new Product("Arrowroot", 19));
        customer.addToCart(new Product("Banana", 11));

        StoreThread storeThread = new StoreThread(cashier, customer, stock);
        storeThread.run();

        assertEquals(66.39, cashier.totalPrice);
    }
}