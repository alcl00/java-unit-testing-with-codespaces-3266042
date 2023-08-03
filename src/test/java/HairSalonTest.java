import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {
      String[] expected = new String[]{"Monday", "Tuesday"};
      String[] actual = hairSalon.getOpeningDays();

      assertArrayEquals(expected, actual);
    }

    @Test
    public void testSalonIsOpenOnMonday() {
      boolean actual = hairSalon.isOpen("Monday");
      assertTrue(actual);
    }

    @Test
    public void testSalonIsClosedOnWednesday() {
      boolean actual = hairSalon.isOpen("Wednesday");
      assertFalse(actual);
    }

    @Test
    public void testExceptionIsThrownIfWeekdayDoesNotEndInDay() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpen("January"));

      String expected = "Weekday must end with 'day'";
      String actual = exception.getMessage();

      assertEquals(expected, actual);
    }

}