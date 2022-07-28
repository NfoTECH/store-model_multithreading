package dev.nfotech.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashierTest {


    Cashier cashier;
    Customer customer;
    HashMap<String, Product> stock = new HashMap<>();
    Product product;
    double totalPriceAfterSale;
    double totalPriceBeforeSale;


    @BeforeEach
    void setUp() {
        cashier = new Cashier();
        Store.readFile();
        stock = Product.stock;
        product =  new Product("Carrot","Bars",15,20.0);

        totalPriceBeforeSale = cashier.totalPrice;
        totalPriceAfterSale  = product.getQuantity() * stock.get(product.getName()).getPrice();
        customer = new Customer("Chioma",1000);
        customer.getMyCart().add(product);
    }


    @Test
    @DisplayName("Make sale and issue receipt when product is available and in stock")
    void makeSaleWhenProductIsAvailable() {
        assertEquals(cashier.totalPrice,totalPriceBeforeSale);
        cashier.makeSale(customer,stock);
        assertEquals(cashier.totalPrice,totalPriceAfterSale);

    }


    @Test
    @DisplayName("Should remove the product from the cart when the product is out of stock")
    void makeSaleWhenProductIsOutOfStockThenRemoveProductFromCart() {
        //Cashier cashier = new Cashier();
        Customer customer = new Customer("John", 1000);
        Product product = new Product("Bread", "Food", 0, 100);
        customer.addToCart(product);
        HashMap<String, Product> stock = new HashMap<>();
        stock.put("Bread", product);

        cashier.makeSale(customer, stock);

        assertEquals(0, customer.getMyCart().size());
    }

    @Test
    @DisplayName("Should remove the product from the cart when the product is not available")
    void makeSaleWhenProductIsNotAvailableThenRemoveProductFromCart() {
        Cashier cashier = new Cashier();
        Customer customer = new Customer("James", 1000);
        Product product = new Product("Phone", "Electronics", 0, 1000);
        customer.addToCart(product);

        cashier.makeSale(customer, Product.stock);

        assertEquals(0, customer.getMyCart().size());
    }
}