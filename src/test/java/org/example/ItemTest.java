package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemTest {

    @Test
    @DisplayName("Test")
    public void testGetId() {
        MockHelperItem item = new MockHelperItem("TestID");
        assertEquals("testid", item.getId());
    }

    @Test
    @DisplayName("Test")
    public void testSetId(){
        MockHelperItem item = new MockHelperItem("Before");
        assertTrue(Objects.equals(item.getId(), "before"));
        item.setId("AFTER");
        assertTrue(Objects.equals(item.getId(), "after"));
    }
}
