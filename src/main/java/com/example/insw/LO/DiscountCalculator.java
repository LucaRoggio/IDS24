package com.example.insw.LO;

import com.example.insw.LO.Logger;

public class DiscountCalculator {
    public static double calculateDiscount(CustomerType customerType, double totalAmount) {
        Logger logger = Logger.getInstance();
        logger.log("INFO", "Iniciando cálculo de descuento para tipo de cliente: " + customerType + " y monto total: " + totalAmount);

        double discount = 0;
        switch (customerType) {
            case REGULAR:
                if (totalAmount > 1000) {
                    discount = totalAmount * 0.2;
                } else if (totalAmount > 500) {
                    discount = totalAmount * 0.1;
                } else if (totalAmount > 100) {
                    discount = totalAmount * 0.05;
                }
                break;

            case VIP:
                if (totalAmount > 1000) {
                    discount = totalAmount * 0.2;
                } else if (totalAmount > 500) {
                    discount = totalAmount * 0.15;
                } else if (totalAmount > 100) {
                    discount = totalAmount * 0.1;
                }
                break;
        }

        logger.log("INFO", "Descuento calculado: " + discount);
        return discount;
    }
}