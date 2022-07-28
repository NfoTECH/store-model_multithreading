package dev.nfotech.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    @DisplayName(
            "Should return 1 when the number of items in cart of customer A is less than customer B")
    void compareWhenNoOfItemCartOfCustomerAIsLessThanCustomerBThenReturn1() {
        Customer customerA = new Customer("A", 100);
        Customer customerB = new Customer("B", 100);

        customerA.addToCart(new Product("Arrowroot", 9));
        customerA.addToCart(new Product("Arrowroot", 11));
        customerB.addToCart(new Product("Arrowroot", 10));
        customerB.addToCart(new Product("Pretzels", 15));

        assertEquals(1, customerA.compare(customerA, customerB));
    }

    @Test
    @DisplayName(
            "Should return -1 when the number of items in cart of customer A is greater than customer B")
    void compareWhenNoOfItemCartOfCustomerAIsGreaterThanCustomerBThenReturnMinus1() {
        Customer customerA = new Customer("A", 100);
        Customer customerB = new Customer("B", 100);

        customerA.addToCart(new Product("Arrowroot", 19));
        customerA.addToCart(new Product("Arrowroot", 11));
        customerB.addToCart(new Product("Arrowroot", 10));
        customerB.addToCart(new Product("Pretzels", 12));

        assertEquals(-1, customerA.compare(customerA, customerB));
    }

    @Test
    @DisplayName("Should add the product to the cart")
    void addToCartShouldAddProductToCart() {
        Customer customer = new Customer("Aliyah", 100);
        Product product = new Product("Carrot", "Bars", 5, 1.77);

        customer.addToCart(product);

        assertEquals(1, customer.getMyCart().size());
    }

    @Test
    @DisplayName("Should increase the number of items in the cart")
    void addToCartShouldIncreaseNoOfItemInTheCart() {
        Customer customer = new Customer("Aliyah", 100);
        Product product = new Product("Carrot", "Bars", 5, 1.77);
        customer.addToCart(product);
        assertEquals(5, customer.getNoOfItemCart());
    }
}