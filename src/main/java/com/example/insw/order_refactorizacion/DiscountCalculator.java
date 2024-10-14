package com.example.insw.order_refactorizacion;

/**
 * La classe {@code DiscountCalculator} calcola lo sconto basato sull'importo totale e il tipo di cliente
 */
public class DiscountCalculator {

    /**
     * Calcola lo sconto in base all'importo totale e al tipo di cliente
     * @param totalAmount l'importo totale dell'ordine
     * @param customerType il tipo di cliente
     * @return lo sconto calcolato in base alle regole specificate
     */
    public double calculateDiscount(double totalAmount, CustomerType customerType) {
        double discount = 0;

        //Calcolo sconto per clienti REGULAR
        if (customerType == CustomerType.REGULAR) {
            if (totalAmount > 100) {
                discount = totalAmount * 0.05;
            }
            if (totalAmount > 500) {
                discount = totalAmount * 0.1;
            }
        //Calcolo sconto per clienti VIP
        } else if (customerType == CustomerType.VIP) {
            if (totalAmount > 100) {
                discount = totalAmount * 0.1;
            }
            if (totalAmount > 500) {
                discount = totalAmount * 0.15;
            }
        }

        //Ulteriore sconto se l'importo totale supera i 1000
        if (totalAmount > 1000) {
            discount = totalAmount * 0.2;
        }

        return discount;
    }
}
