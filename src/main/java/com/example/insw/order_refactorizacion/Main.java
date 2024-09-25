package com.example.insw.order_refactorizacion;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Oggetto_1");
        items.add("Oggetto_2");

        Order order = new Order("Luca", CustomerType.VIP, items, 1500);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        TaxCalculator taxCalculator = new TaxCalculator();

        order.applyDiscount(discountCalculator);
        order.calculateTax(taxCalculator);
        order.printOrderDetails();
    }
}
