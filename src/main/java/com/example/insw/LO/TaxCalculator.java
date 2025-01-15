package com.example.insw.LO;

import com.example.insw.LO.Logger;

public class TaxCalculator {
    public static double calculateTax(double totalAmount) {
        Logger logger = Logger.getInstance();
        logger.log("INFO", "Iniciando cálculo de impuestos para un monto total de: " + totalAmount);
        double tax = totalAmount * 0.15;
        logger.log("INFO", "Impuesto calculado: " + tax);
        return tax;
    }
}