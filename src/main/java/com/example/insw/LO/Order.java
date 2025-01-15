package com.example.insw.LO;

import com.example.insw.LO.Logger;

import java.util.List;

public class Order {
    private String customerName;
    private CustomerType customerType;
    private List<String> items;
    private double totalAmount;
    private double discount;
    private double tax;

    public Order(String customerName, CustomerType customerType, List<String> items, double totalAmount) {
        this.customerName = customerName;
        this.customerType = customerType;
        this.items = items;
        this.totalAmount = totalAmount;
        this.discount = 0;
        this.tax = 0;

        Logger logger = Logger.getInstance();
        logger.log("INFO", "Order creado para el cliente: " + customerName + " con importe total: " + totalAmount);
    }

    public void applyDiscount() {
        Logger logger = Logger.getInstance();
        logger.log("INFO", "Aplicando descuento para el cliente: " + this.customerName);
        this.discount = DiscountCalculator.calculateDiscount(this.customerType, this.totalAmount);
        logger.log("INFO", "Descuento aplicado: " + this.discount);
    }

    public void calculateTax() {
        Logger logger = Logger.getInstance();
        logger.log("INFO", "Calculando impuesto para el cliente: " + this.customerName);
        this.tax = TaxCalculator.calculateTax(this.totalAmount);
        logger.log("INFO", "Impuesto calculado: " + this.tax);
    }

    public void printOrderDetails() {
        Logger logger = Logger.getInstance();
        double finalAmount = this.totalAmount - this.discount + this.tax;
        logger.log("INFO", "Imprimiendo detalles del pedido para el cliente: " + this.customerName);
        System.out.println("Customer: " + this.customerName);
        System.out.println("Customer Type: " + this.customerType);
        System.out.println("Items: " + String.join(", ", this.items));
        System.out.println("Total Amount: " + this.totalAmount);
        System.out.println("Discount: " + this.discount);
        System.out.println("Tax: " + this.tax);
        System.out.println("Final Amount: " + finalAmount);
    }

    public String returnOrderDetails() {
        double finalAmount = totalAmount - this.discount + this.tax;
        return "Customer: " + this.customerName +
                " Customer Type: " + this.customerType +
                " Items: " + String.join(", ", this.items) +
                " Total Amount: " + this.totalAmount +
                " Discount: " + this.discount +
                " Tax: " + this.tax +
                " Final Amount: " + finalAmount;
    }
}
