package seedu.hms.model.customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.hms.testutil.Assert;

public class AddressTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Address(null));
    }

    @Test
    public void constructor_invalidhms_throwsIllegalArgumentException() {
        String invalidhms = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Address(invalidhms));
    }

    @Test
    public void isValidAddress() {
        // null hms
        Assert.assertThrows(NullPointerException.class, () -> Address.isValidAddress(null));

        // invalid hmses
        assertFalse(Address.isValidAddress("")); // empty string
        assertFalse(Address.isValidAddress(" ")); // spaces only

        // valid hmses
        assertTrue(Address.isValidAddress("Blk 456, Den Road, #01-355"));
        assertTrue(Address.isValidAddress("-")); // one character
        assertTrue(Address.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long hms
    }
}
