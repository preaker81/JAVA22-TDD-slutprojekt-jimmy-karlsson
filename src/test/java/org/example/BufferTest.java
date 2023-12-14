package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BufferTest {
    private MockHelperBuffer buffer;
    private MockProducer producer;
    private MockConsumer consumer;

    @BeforeEach
    public void setUp() {
        buffer = new MockHelperBuffer();
        producer = new MockProducer(buffer);
        consumer = new MockConsumer(buffer);
    }

    @Test
    @DisplayName("Add valid item using producer")
    public void testAddValidItemUsingProducer() {
        MockHelperItem item = new MockHelperItem("test");
        assertTrue(producer.addItem(item));
    }

    @Test
    @DisplayName("Buffer not empty after adding item")
    public void testBufferNotEmptyAfterAddingItem() {
        producer.addItem(new MockHelperItem("test"));
        assertFalse(buffer.getBufferQueue().isEmpty());
    }

    @Test
    @DisplayName("Add multiple items to buffer")
    public void testAddMultipleItemsToBuffer() {
        for (int i = 1; i <= 5; i++) {
            producer.addItem(new MockHelperItem("test" + i));
        }
        assertEquals(5, buffer.getBufferQueue().size());
    }

    @Test
    @DisplayName("Specific items added to buffer")
    public void testSpecificItemsAddedToBuffer() {
        MockHelperItem item1 = new MockHelperItem("test1");
        MockHelperItem item2 = new MockHelperItem("test2");
        producer.addItem(item1);
        producer.addItem(item2);
        assertTrue(buffer.getBufferQueue().containsAll(Arrays.asList(item1, item2)));
    }

    @Test
    @DisplayName("Remove item from buffer")
    public void testRemoveItemFromBuffer() {
        MockHelperItem item = new MockHelperItem("test");
        producer.addItem(item);
        assertEquals(item, consumer.removeItem());
        assertTrue(buffer.getBufferQueue().isEmpty());
    }

    @Test
    @DisplayName("Handle null item addition")
    public void testAddNullItem() {
        assertThrows(NullPointerException.class, () -> producer.addItem(null));
    }

    @Test
    @DisplayName("Add item with empty string value")
    public void testAddItemWithEmptyStringValue() {
        MockHelperItem mockItem = new MockHelperItem("");
        assertTrue(producer.addItem(mockItem));
    }

    @Test
    @DisplayName("Buffer not empty after adding item with empty string")
    public void testBufferNotEmptyWithEmptyStringItem() {
        producer.addItem(new MockHelperItem(""));
        assertFalse(buffer.getBufferQueue().isEmpty());
    }

    @Test
    @DisplayName("Handle null value item addition directly to buffer")
    public void testAddNullValueItemDirectlyToBuffer() {
        assertThrows(NullPointerException.class, () -> buffer.add(new MockHelperItem(null)));
    }

    @Test
    @DisplayName("Handle thread interruption during item removal")
    public void testThreadInterruptionDuringRemove() {
        Thread thread = new Thread(() -> {
            assertThrows(InterruptedException.class, consumer::removeItem);
            assertTrue(Thread.currentThread().isInterrupted());
        });

        thread.start();
        thread.interrupt();
    }

    @Test
    @DisplayName("Consumer waits and resumes on producer notification")
    public void testConsumerWaitingAndProducerNotification() throws InterruptedException {
        final int numberOfItems = 5;
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < numberOfItems; i++) {
                MockHelperItem consumedItem = (MockHelperItem) consumer.removeItem();
                assertNotNull(consumedItem);
            }
        });

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < numberOfItems; i++) {
                try {
                    Thread.sleep(100);
                    producer.addItem(new MockHelperItem("item" + i));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();
    }
}
