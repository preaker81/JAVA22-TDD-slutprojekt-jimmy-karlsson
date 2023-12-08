package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class BufferTest {

    private MockHelperBuffer buffer;

    @Before
    public void setUp() {
        buffer = new MockHelperBuffer();
    }

    @Test
    @DisplayName("Tests that the buffer variable is empty")
    public void testBufferIsEmpty() {
        Assert.assertTrue(buffer.buffer.isEmpty());

        buffer.add(new MockHelperItem("Item1"));
        Assert.assertFalse(buffer.buffer.isEmpty());
    }

    @Test
    @DisplayName("Tests that the buffer variable is not empty when item is added")
    public void testBufferIsNotEmpty() {
        buffer.add(new MockHelperItem("Item1"));
        Assert.assertFalse(buffer.buffer.isEmpty());
    }

    @Test
    @DisplayName("Tests that removing an item should return the same item that was added")
    public void testRemoveItem() {
        MockHelperItem item = new MockHelperItem("test");
        buffer.add(item);
        assertEquals(item, buffer.remove());
    }

    @Test
    @DisplayName("Tests that remove()-metod throws InterruptedException when interrupted")
    public void testRemoveWithInterrupt() throws InterruptedException {
        // Skapar en ny tråd som kommer att köra remove()-metoden.
        Thread testThread = new Thread(() -> {
            buffer.remove();
            Assert.fail("Ett InterruptedException borde ha kastats");
        });

        testThread.start(); // Startar tråden.
        Thread.sleep(100); // Ger tid för tråden att starta och nå wait()-anropet i remove()-metoden.

        testThread.interrupt(); // Skickar ett avbrott till tråden.
        testThread.join(); // Väntar tills tråden har avslutat sin exekvering.
    }

}
