package facturePRO;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class FactureTest {

  Facture facture;

  @Test
  public void testGetSumNotEmpty() {

    facture = new Facture();
    facture.addProduct("jeden", 2, 10);
    facture.addProduct("dwa", 100, 0.5);
    assertEquals(70, facture.getSum(), 0);
  }

  @Test
  public void testGetSumEmpty() {

    facture = new Facture();
    assertEquals(0, facture.getSum(), 0);
  }
}
