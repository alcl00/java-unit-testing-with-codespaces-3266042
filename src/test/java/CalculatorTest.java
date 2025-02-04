import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

  @ParameterizedTest
  @ValueSource(ints = {2, -2, -100000, 200000})
  public void testIsEven(int number) {
    boolean actual = calculator.isEven(number);

    assertTrue(actual);
  }

  @Test
  public void testIsOdd() {
    boolean actual = calculator.isEven(3);

    assertFalse(actual);
  }

  @Test
  public void testIncrementArray() {
    int[] expected = new int[]{2, 3, 4};

    int[] actual = calculator.incrementArray(new int[]{1, 2, 3});

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testByZero() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));

    String expected = "Ints cannot be divided by zero";

    String actual = exception.getMessage();

    assertEquals(expected, actual);
  }

}
