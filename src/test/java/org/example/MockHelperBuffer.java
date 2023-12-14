package org.example;

import java.util.Queue;

public class MockHelperBuffer extends Buffer {

    public Queue<Item> getBufferQueue() {
        return super.buffer;
    }
}
