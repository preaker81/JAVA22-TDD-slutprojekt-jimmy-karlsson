package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    @DisplayName("Item ID is correctly set on creation")
    public void whenCreated_thenIdIsCorrect() {
        assertEquals("testid", new MockHelperItem("testid").getId());
    }

    @Test
    @DisplayName("Constructor handles empty string ID")
    public void whenCreatedWithEmptyId_thenIdIsEmptyString() {
        assertEquals("", new MockHelperItem("").getId());
    }

    @Test
    @DisplayName("Constructor normalizes mixed case ID to lower case")
    public void whenCreatedWithMixedCaseId_thenIdIsLowerCased() {
        assertEquals("this is a test", new MockHelperItem("This Is A Test").getId());
    }

    @Test
    @DisplayName("SetId correctly updates the ID")
    public void whenIdIsSet_thenIdIsUpdatedCorrectly() {
        MockHelperItem item = new MockHelperItem("Before");
        item.setId("After");
        assertEquals("after", item.getId());
    }

    @Test
    @DisplayName("SetId handles empty string ID")
    public void whenIdSetToEmpty_thenIdIsEmptyString() {
        MockHelperItem item = new MockHelperItem("testid");
        item.setId("");
        assertEquals("", item.getId());
    }

    @Test
    @DisplayName("SetId normalizes mixed case ID to lower case")
    public void whenIdSetToMixedCase_thenIdIsLowerCased() {
        MockHelperItem item = new MockHelperItem("testid");
        item.setId("This Is A Test");
        assertEquals("this is a test", item.getId());
    }

    @Test
    @DisplayName("Constructor throws NullPointerException for null ID")
    public void whenCreatedWithNullId_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MockHelperItem(null));
    }

    @Test
    @DisplayName("SetId throws NullPointerException for null ID")
    public void whenIdSetToNull_thenThrowsNullPointerException() {
        MockHelperItem item = new MockHelperItem("testid");
        assertThrows(NullPointerException.class, () -> item.setId(null));
    }

    @Test
    @DisplayName("ToString returns correct lowercase ID")
    public void whenToString_thenReturnsLowerCaseId() {
        assertEquals("testid", new MockHelperItem("testid").toString());
    }

    @Test
    @DisplayName("ToString handles mixed case IDs")
    public void whenToStringWithMixedCaseId_thenReturnsLowerCaseId() {
        MockHelperItem item = new MockHelperItem("TestId");
        item.setId("TesTId");
        assertEquals("testid", item.toString());
    }

    @Test
    @DisplayName("ToString handles empty string IDs")
    public void whenToStringWithEmptyId_thenReturnsEmptyString() {
        MockHelperItem item = new MockHelperItem("testId");
        item.setId("");
        assertEquals("", item.toString());
    }

    @Test
    @DisplayName("ToString correctly handles long IDs")
    public void whenToStringWithLongId_thenReturnsCorrectId() {
        String longId = "test".repeat(1000);
        MockHelperItem item = new MockHelperItem("testId");
        item.setId(longId);
        assertEquals(longId, item.toString());
    }
}
