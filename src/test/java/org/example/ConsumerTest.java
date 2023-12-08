package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsumerTest {
    private MockConsumer consumer;
    private MockHelperBuffer buffer;

    @BeforeEach
    public void setUp() {
        buffer = new MockHelperBuffer();
        consumer = new MockConsumer(buffer);
    }

    @Test
    @DisplayName("Tests that the Consumer is running from start")
    public void testIsRunningInitiallyTrue() {
      assertTrue(consumer.isRunning());
    }

    @Test
    @DisplayName("Tests that the Consumer is stopped when stopRunning is called")
    public void testIsRunningAfterStopRunning() {
        consumer.stopRunning();
        assertFalse(consumer.isRunning());
    }

    @Test
    @DisplayName("Tests that Consumer run method remove an item from the buffer")
    public void testRunRemovesItemFromBuffer() {
        MockHelperItem addItem = new MockHelperItem("item");
        buffer.add(addItem);

        int sizeBefore = buffer.size();
        consumer.run();
        int sizeAfter = buffer.size();

        assertTrue(sizeBefore > sizeAfter, "Buffer size should decrease after consumer runs");
    }

    @Test
    @DisplayName("Remove should wait when buffer is empty")
    public void testRemoveWaitsWhenBufferIsEmpty() throws InterruptedException {
        Thread removeThread = new Thread(() -> {
            buffer.remove();
        });
        removeThread.start();
        // Ge lite tid för tråden att starta och nå wait()-anropet
        Thread.sleep(100);
        // Kontrollera att tråden fortfarande är igång, vilket indikerar att den väntar
        assertTrue(removeThread.isAlive(), "Thread should be waiting as buffer is empty");
        // Stoppa tråden för att undvika att den fortsätter att köra efter testet
        removeThread.interrupt();
    }


}
