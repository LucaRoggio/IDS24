package com.example.insw.order_refactorizacion;

/**
 *la classe {@code TaxCalculator} calcola le tasse su un importo totale
 */
public class TaxCalculator {

    /**
     *Calcola le tasse su un importo totale
     *@param totalAmount l'importo totale su cui calcolare le tasse
     *@return le tasse calcolate, pari al 15% dell'importo totale
     */
    public double calculateTax(double totalAmount) {
        return totalAmount * 0.15;
    }
}
