package com.example.insw.order_refactorizacion;

import java.util.ArrayList;
import java.util.List;

/**
 *Classe principale che gestisce l'ordine, applica sconto e tasse e stampa i dettagli
 */
public class Main {

    /**
     *Metodo principale che crea un ordine, calcola sconto e tasse e stampa i dettagli
     *@param args gli argomenti della riga di comando
     */
    public static void main(String[] args) {
        // Creazione di una lista di articoli
        List<String> items = new ArrayList<>();
        items.add("Oggetto_1");
        items.add("Oggetto_2");

        //Creazione dell'ordine per il cliente Luca di tipo vip
        Order order = new Order("Luca", CustomerType.VIP, items, 1500);

        //Creazione dei calcolatori di sconto e tasse
        DiscountCalculator discountCalculator = new DiscountCalculator();
        TaxCalculator taxCalculator = new TaxCalculator();

        //Applicazione dello sconto e delle tasse
        order.applyDiscount(discountCalculator);
        order.calculateTax(taxCalculator);

        //Stampa
        order.printOrderDetails();
    }
}
