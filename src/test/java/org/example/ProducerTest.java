package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProducerTest {

    private MockProducer producer;
    private MockHelperBuffer buffer;

    @BeforeEach
    public void setUp() {
        buffer = new MockHelperBuffer();
        producer = new MockProducer(buffer);
    }

    @Test
    @DisplayName("Tests that the Producer is running from start")
    public void testIsRunningInitiallyTrue() {
        assertTrue(producer.isRunning());
    }

    @Test
    @DisplayName("Tests that the Producer is stopped when stopRunning is called")
    public void testIsRunningAfterStopRunning() {
        producer.stopRunning();
        assertFalse(producer.isRunning());
    }

    @Test
    @DisplayName("Tests that Producer is adding item to buffer")
    public void testRunAddsItemToBuffer() {
        producer.run();
        Item item = buffer.remove();
        assertNotNull(item, "Buffer should have an item after run");
    }

}
