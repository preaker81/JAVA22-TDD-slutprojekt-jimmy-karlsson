package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BufferTest {

    private MockHelperBuffer buffer;

    @Before
    public void setUp() {
        buffer = new MockHelperBuffer();
    }

    @Test
    @DisplayName("Tests that the buffer que variable is empty")
    public void testBufferIsEmpty() {
        Assert.assertTrue(buffer.buffer.isEmpty());

        buffer.add(new MockHelperItem("test"));
        Assert.assertFalse(buffer.buffer.isEmpty());
    }

    @Test
    @DisplayName("Tests that the buffer variable is not empty when item is added")
    public void testBufferIsNotEmpty() {
        buffer.add(new MockHelperItem("test"));
        Assert.assertFalse(buffer.buffer.isEmpty());
    }

    @Test
    @DisplayName("Tests that removing an item should return the same item that was added")
    public void testRemoveItem() {
        MockHelperItem item = new MockHelperItem("test");
        buffer.add(item);
        assertSame(item, buffer.remove());
    }

    @Test
    @DisplayName("Test add() with null value Id")
    public void testAddWithNullValueItem() {
        assertThrows(NullPointerException.class, () -> buffer.add(new MockHelperItem(null)));
    }

}
