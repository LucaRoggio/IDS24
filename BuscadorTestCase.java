import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.insw.Buscador;
import java.util.Arrays;
import java.util.List;

class BuscadorTestCase {

    Buscador buscador;
    String[] nombres = {"Luca", "Jose", "David"};
    List<String> listaNombres;

    @BeforeEach
    void setUp() {
        buscador = new Buscador();
        listaNombres = Arrays.asList(nombres);
    }

    @Test
    @DisplayName("name searching")
    void testBuscarPalabra() {
        assertTrue(buscador.buscarPalabra("Luca", listaNombres), "word found");
    }

    @Test
    @DisplayName("return name at position given")
    void testDevolverPalabra() {
        assertEquals("Luca", buscador.devolverPalabra(listaNombres, 0), "word given");
    }

    @Test
    @DisplayName("return first element")
    void testDevolverPrimerElemento() {
        assertEquals("Luca", buscador.devolverPrimerElemento(listaNombres), "first Word given");
    }

    @Test
    @DisplayName("return last element")
    void testDevolverUltimoElemento() {
        assertEquals("David", buscador.devolverUltimoElemento(listaNombres), "last Word given");
    }
}
