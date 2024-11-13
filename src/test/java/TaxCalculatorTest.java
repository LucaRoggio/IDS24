import com.example.insw.order_refactorizacion.TaxCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void testCalculateTax() {
        TaxCalculator taxCalculator = new TaxCalculator();
        
        // Testa il calcolo della tassa
        assertEquals(0, taxCalculator.calculateTax(0), 0.001);
        assertEquals(15, taxCalculator.calculateTax(100), 0.001);
        assertEquals(30, taxCalculator.calculateTax(200), 0.001);
        assertEquals(150, taxCalculator.calculateTax(1000), 0.001);
    }
}
