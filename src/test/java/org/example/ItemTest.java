package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    // Constructor
    @Test
    @DisplayName("Item ID is correctly set on creation")
    public void testConstructorWithValidValue() {
        assertEquals("testid", new MockHelperItem("testid").getId());
    }

    @Test
    @DisplayName("Constructor handles empty string ID")
    public void testConstructorWithEmptyString() {
        assertEquals("", new MockHelperItem("").getId());
    }

    @Test
    @DisplayName("Constructor normalizes mixed case ID to lower case")
    public void testConstructorWithMixedCaseId() {
        assertEquals("this is a test", new MockHelperItem("This Is A Test").getId());
    }

    @Test
    @DisplayName("Constructor handles number ID")
    public void testConstructorWithNumericId() {
        assertEquals("12345", new MockHelperItem("12345").getId());
    }

    @Test
    @DisplayName("Constructor throws NullPointerException for null ID")
    public void testConstructorNullPointerExceptionWithNullId() {
        assertThrows(NullPointerException.class, () -> new MockHelperItem(null));
    }

    // setId
    @Test
    @DisplayName("SetId correctly updates the ID")
    public void testSetIdWithNewValue() {
        MockHelperItem item = new MockHelperItem("Before");
        item.setId("After");
        assertEquals("after", item.getId());
    }

    @Test
    @DisplayName("SetId handles empty string ID")
    public void testSetIdWithEmptyString() {
        MockHelperItem item = new MockHelperItem("testid");
        item.setId("");
        assertEquals("", item.getId());
    }

    @Test
    @DisplayName("SetId normalizes mixed case ID to lower case")
    public void testSetIdWithMixedCase() {
        MockHelperItem item = new MockHelperItem("testid");
        item.setId("This Is A Test");
        assertEquals("this is a test", item.getId());
    }

    @Test
    @DisplayName("SetId handles number ID")
    public void testSetIdWithNumber() {
        MockHelperItem item = new MockHelperItem("testid");
        item.setId("12345");
        assertEquals("12345", item.getId());
    }

    @Test
    @DisplayName("SetId throws NullPointerException for null ID")
    public void testSetIdNullPointerExceptionWithNull() {
        MockHelperItem item = new MockHelperItem("testid");
        assertThrows(NullPointerException.class, () -> item.setId(null));
    }

    // toString
    @Test
    @DisplayName("ToString returns correct lowercase ID")
    public void testToStringWithValidValue() {
        assertEquals("testid", new MockHelperItem("testid").toString());
    }

    @Test
    @DisplayName("ToString handles mixed case IDs")
    public void testToStringWithMixedCaseId() {
        MockHelperItem item = new MockHelperItem("TestId");
        item.setId("TesTId");
        assertEquals("testid", item.toString());
    }

    @Test
    @DisplayName("ToString handles empty string IDs")
    public void testToStringWithEmptyId() {
        MockHelperItem item = new MockHelperItem("testId");
        item.setId("");
        assertEquals("", item.toString());
    }

    @Test
    @DisplayName("ToString handles number IDs")
    public void testToStringWithNumericId() {
        MockHelperItem item = new MockHelperItem("12345");
        assertEquals("12345", item.toString());
    }

    @Test
    @DisplayName("ToString correctly handles long IDs")
    public void testToStringWithLongId() {
        String longId = "test".repeat(1000);
        MockHelperItem item = new MockHelperItem("testId");
        item.setId(longId);
        assertEquals(longId, item.toString());
    }
}
