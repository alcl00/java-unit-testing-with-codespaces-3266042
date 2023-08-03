import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
  Calculator calculator = new Calculator();

  @Test
  public void testAdd() {
      int expected = 3;
      
      int actual = calculator.sum(1, 2);

      assertEquals(expected, actual);
  }

  @Test
  public void testSubtract() {
    int expected = 1;
    int actual = calculator.subtract(3, 2);

    assertEquals(expected, actual);
  }

  @Test
  public void testMultiply() {
    int expected = 6;
    int actual = calculator.multiply(2, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void testDivide() {
    int expected = 3;
    int actual = calculator.divide(6, 2);

    assertEquals(expected, actual);
  }


}
