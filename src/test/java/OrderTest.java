import com.example.insw.order_refactorizacion.Order;
import com.example.insw.order_refactorizacion.CustomerType;
import com.example.insw.order_refactorizacion.DiscountCalculator;
import com.example.insw.order_refactorizacion.TaxCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    public void testApplyDiscount() {
        List<String> items = new ArrayList<>();
        items.add("Oggetto_1");
        items.add("Oggetto_2");

        Order order = new Order("Luca", CustomerType.REGULAR, items, 150);
        DiscountCalculator discountCalculator = new DiscountCalculator();
        order.applyDiscount(discountCalculator);

        // Testa il calcolo dello sconto per cliente REGULAR
        assertEquals(7.5, order.getDiscount(), 0.001); // Usa il getter per accedere a discount
    }

    @Test
    public void testCalculateTax() {
        List<String> items = new ArrayList<>();
        items.add("Oggetto_1");
        items.add("Oggetto_2");

        Order order = new Order("Luca", CustomerType.REGULAR, items, 200);
        TaxCalculator taxCalculator = new TaxCalculator();
        order.calculateTax(taxCalculator);

        // Testa il calcolo della tassa
        assertEquals(30, order.getTax(), 0.001); // Usa il getter per accedere a tax
    }

    @Test
    public void testPrintOrderDetails() {
        List<String> items = new ArrayList<>();
        items.add("Oggetto_1");
        items.add("Oggetto_2");

        Order order = new Order("Luca", CustomerType.REGULAR, items, 200);
        DiscountCalculator discountCalculator = new DiscountCalculator();
        TaxCalculator taxCalculator = new TaxCalculator();
        
        order.applyDiscount(discountCalculator);
        order.calculateTax(taxCalculator);
        
        // Qui puoi testare l'output stampato, se necessario, usando System.out o un logger
        // Potresti voler usare un approccio diverso per verificare l'output (come il redirect dello stream di output)
    }
}
