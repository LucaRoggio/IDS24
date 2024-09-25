package com.example.insw.order_refactorizacion;

public class DiscountCalculator {

    public double calculateDiscount(double totalAmount, CustomerType customerType) {
        double discount = 0;

        if (customerType == CustomerType.REGULAR) {
            if (totalAmount > 100) {
                discount = totalAmount * 0.05;
            }
            if (totalAmount > 500) {
                discount = totalAmount * 0.1;
            }
        } else if (customerType == CustomerType.VIP) {
            if (totalAmount > 100) {
                discount = totalAmount * 0.1;
            }
            if (totalAmount > 500) {
                discount = totalAmount * 0.15;
            }
        }

        if (totalAmount > 1000) {
            discount = totalAmount * 0.2;
        }

        return discount;
    }
}
