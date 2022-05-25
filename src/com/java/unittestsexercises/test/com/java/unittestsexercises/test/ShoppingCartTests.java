package com.java.unittestsexercises.test;

import com.java.unittestsexercises.main.shop.Product;
import com.java.unittestsexercises.main.shop.ProductNotFoundException;
import com.java.unittestsexercises.main.shop.ShoppingCart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShoppingCartTests {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void beforeEach() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void whenCartCreatedThenReturnZeroProducts() {
        //when
        int cartItemsCount = shoppingCart.getItemCount();

        //then
        assertEquals(0, cartItemsCount);
    }

    @Test
    public void whenCartEmptyThenReturnZeroProducts() {
        //when
        shoppingCart.empty();

        //then
        assertEquals(0, shoppingCart.getItemCount());
    }

    @Test
    public void whenProductAddedThenItemsNumberIncremented() {
        //given
        Product p1 = new Product("p1",21.22);
        Product p2 = new Product("p2",44.11);
        Product p3 = new Product("p3",60.11);
        shoppingCart.addItem(p1);
        shoppingCart.addItem(p2);
        shoppingCart.addItem(p3);

        //when
        int cartItemsCount = shoppingCart.getItemCount();

        //then
        assertEquals(3, cartItemsCount);
    }

    @Test
    public void whenProductAddedThenCheckBalance() {
        //given
        Product p1 = new Product("p1",44.12);
        Product p2 = new Product("p2",53.02);
        Product p3 = new Product("p3",90.11);
        shoppingCart.addItem(p1);
        shoppingCart.addItem(p2);
        shoppingCart.addItem(p3);

        //when
        double balanceValue = shoppingCart.getBalance();
        double productsPriceSum = p1.getPrice() + p2.getPrice() + p3.getPrice();

        //then
        assertEquals(productsPriceSum, balanceValue);
    }

    @Test
    public void whenProductIsRemovedThenItemsNumberDecreased() throws ProductNotFoundException {
        //given
        Product p1 = new Product("p1",44.12);
        shoppingCart.addItem(p1);

        //when
        shoppingCart.removeItem(p1);

        //then
        assertEquals(0,shoppingCart.getItemCount());
    }

    @Test
    public void whenProductToRemoveNotExistThenThrowNotFoundException() {
        //given
        Product p1 = new Product("p1",44.12);

        //when
        try {
            shoppingCart.removeItem(p1);

            //then
            fail();
        }
        catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void afterEach() {
        shoppingCart = null;
    }
}