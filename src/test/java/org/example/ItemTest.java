package org.example;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    @DisplayName("Tests Item constructor that it sets correct value in lowercase")
    public void testItemConstructor() {
        String testValue = "TestIdValue";
        MockHelperItem item = new MockHelperItem(testValue);
        assertEquals(testValue.toLowerCase(), item.toString());
    }

    @Test
    @DisplayName("Tests that setId works by creating item with BEFORE value and then use setId with value AFTER")
    public void testSetId() {
        String initValue = "Before";
        String changedValue = "AFTER";
        String exptectedValue = "after";
        MockHelperItem item = new MockHelperItem(initValue);
        item.setId(changedValue);
        assertEquals(item.getId(), exptectedValue);
    }

    @Test
    @DisplayName("Tests the toString for correct lowerCase return")
    public void testToString() {
        String testValue = "TestIdValue";
        MockHelperItem item = new MockHelperItem(testValue);
        assertEquals(testValue.toLowerCase(), item.toString());
    }
}
