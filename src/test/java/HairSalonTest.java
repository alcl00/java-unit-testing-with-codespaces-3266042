import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {
      HairSalon.Day[] expected = new HairSalon.Day[]{HairSalon.Day.MONDAY, HairSalon.Day.TUESDAY};
      HairSalon.Day[] actual = hairSalon.getOpeningDays();

      assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(value = HairSalon.Day.class, names = {"MONDAY", "TUESDAY"})
    public void testSalonIsOpenOn(HairSalon.Day day) {
      boolean actual = hairSalon.isOpen(day);
      assertTrue(actual);
    }

    @ParameterizedTest
    @EnumSource(value = HairSalon.Day.class, names = {"WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"})
    public void testSalonIsClosed(HairSalon.Day day) {
      boolean actual = hairSalon.isOpen(day);
      assertFalse(actual);
    }

    @Test
    public void testNull() {
      assertFalse(hairSalon.isOpen(null));
    }

    @Test
    public void testApplyDiscount() {
      Calculator calculator = new Calculator();
      //Only run this unit test if calculator.divide works
      assumeTrue(calculator.divide(hairSalon.getHaircutPrice(), 2) == 15);

      int expected = 20;
      int actual = hairSalon.applyDiscount();

      assertEquals(expected, actual);
    }

}