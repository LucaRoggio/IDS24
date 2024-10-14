import com.example.insw.order_refactorizacion.DiscountCalculator;
import com.example.insw.order_refactorizacion.CustomerType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {

    @Test
    public void testCalculateDiscountRegular() {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        
        // Test con cliente REGULAR
        assertEquals(0, discountCalculator.calculateDiscount(50, CustomerType.REGULAR));
        assertEquals(2.5, discountCalculator.calculateDiscount(50, CustomerType.REGULAR), 0.001);
        assertEquals(50, discountCalculator.calculateDiscount(500, CustomerType.REGULAR), 0.001);
        assertEquals(100, discountCalculator.calculateDiscount(1000, CustomerType.REGULAR), 0.001);
    }

    @Test
    public void testCalculateDiscountVIP() {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        
        // Test con cliente VIP
        assertEquals(0, discountCalculator.calculateDiscount(50, CustomerType.VIP));
        assertEquals(10, discountCalculator.calculateDiscount(100, CustomerType.VIP), 0.001);
        assertEquals(75, discountCalculator.calculateDiscount(500, CustomerType.VIP), 0.001);
        assertEquals(200, discountCalculator.calculateDiscount(1000, CustomerType.VIP), 0.001);
    }

    @Test
    public void testCalculateDiscountThresholds() {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        
        // Test soglia di 1000
        assertEquals(400, discountCalculator.calculateDiscount(2000, CustomerType.REGULAR), 0.001);
        assertEquals(400, discountCalculator.calculateDiscount(2000, CustomerType.VIP), 0.001);
    }
}
