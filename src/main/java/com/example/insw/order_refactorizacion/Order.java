package com.example.insw.order_refactorizacion;

import java.util.List;

/**
 *La classe {@code Order} rappresenta un ordine con il nome del cliente, 
 *il tipo di cliente, una lista di articoli, l'importo totale, lo sconto e la tassa
 */
public class Order {
    private String customerName;
    private CustomerType customerType;
    private List<String> items;
    private double totalAmount;
    private double discount;
    private double tax;

    /**
     *Crea un nuovo ordine con il nome del cliente, il tipo di cliente
     *una lista di articoli e l'importo totale
     *@param customerName il nome del cliente
     *@param customerType il tipo di cliente
     *@param items la lista degli articoli
     *@param totalAmount l'importo totale dell'ordine
     */
    public Order(String customerName, CustomerType customerType, List<String> items, double totalAmount) {
        this.customerName = customerName;
        this.customerType = customerType;
        this.items = items;
        this.totalAmount = totalAmount;
        this.discount = 0;
        this.tax = 0;
    }

    /**
     *Applica lo sconto all'ordine usando un calcolatore di sconti
     *@param discountCalculator il calcolatore di sconti
     */
    public void applyDiscount(DiscountCalculator discountCalculator) {
        this.discount = discountCalculator.calculateDiscount(this.totalAmount, this.customerType);
    }

    /**
     *Calcola le tasse sull'ordine usando un calcolatore di tasse
     *@param taxCalculator il calcolatore di tasse
     */
    public void calculateTax(TaxCalculator taxCalculator) {
        this.tax = taxCalculator.calculateTax(this.totalAmount);
    }

    public double getDiscount() { //serve a rendere pubblico il double
        return this.discount;
    }

    public double getTax() {  //serve a rendere pubblico il double
        return this.tax;
    }

    /**
     *Stampa i dettagli dell'ordine, inclusi il nome del cliente, il tipo, 
     *gli articoli, l'importo totale, lo sconto, le tasse e l'importo finale
     */
    public void printOrderDetails() {
        double finalAmount = this.totalAmount - this.discount + this.tax;
        System.out.println("Customer: " + this.customerName);
        System.out.println("Customer Type: " + this.customerType);
        System.out.println("Items: " + String.join(", ", this.items));
        System.out.println("Total Amount: " + this.totalAmount);
        System.out.println("Discount: " + this.discount);
        System.out.println("Tax: " + this.tax);
        System.out.println("Final Amount: " + finalAmount);
    }
}
