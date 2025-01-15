package com.example.insw.LO;

public class Main{
    public static void main(String[] args) {
        // Obtener la instancia del logger y registrar mensajes
        Logger logger = Logger.getInstance();
        logger.log("Primer mensaje desde el método principal.");

        // Registrar mensajes desde otro método
        logDesdeOtroMetodo();

        // Cerrar el logger al final
    }
    public static void logDesdeOtroMetodo() {
        Logger logger = Logger.getInstance();
        logger.log("Mensaje desde otro método.");
    }
}