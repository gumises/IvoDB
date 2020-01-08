package facturePRO;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductTest {

  Product product;
  
  @Test
  public void testProduct() {
    product = new Product("jeden", 100, 0.99);
    assertEquals(99, product.getSumPrice(), 0.01);
  }

}
