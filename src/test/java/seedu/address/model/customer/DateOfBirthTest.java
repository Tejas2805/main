package seedu.address.model.customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class DateOfBirthTest {

    @Test
    public void constructorNullThrowsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new DateOfBirth(null));
    }

    @Test
    public void constructorInvalidIdThrowsIllegalArgumentException() {
        String invalidDateOfBirth = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new DateOfBirth(invalidDateOfBirth));
    }

    @Test
    public void isValidDob() {
        // null identification number
        Assert.assertThrows(NullPointerException.class, () -> DateOfBirth.isValidDob(null));

        // invalid identification numbers
        assertFalse(DateOfBirth.isValidDob("")); // empty string
        assertFalse(DateOfBirth.isValidDob(" ")); // spaces only
        assertFalse(DateOfBirth.isValidDob("1/12/1999")); // date is not in correct format
        assertFalse(DateOfBirth.isValidDob("dob")); // non-numeric
        assertFalse(DateOfBirth.isValidDob("01/13/1999")); // month out of bounds
        assertFalse(DateOfBirth.isValidDob("01/11/2020")); // year can't be equal or greater than current year

        // valid identification numbers
        assertTrue(DateOfBirth.isValidDob("28/05/1999")); // exact order
        assertTrue(DateOfBirth.isValidDob("01/12/1999"));
        assertTrue(DateOfBirth.isValidDob("12/10/1999")); // long identification numbers
    }
}
