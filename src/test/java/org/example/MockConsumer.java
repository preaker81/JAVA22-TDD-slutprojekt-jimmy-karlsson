package org.example;

public class MockConsumer implements Consumer {
    private final MockHelperBuffer buffer;
    private volatile boolean running = true;

    public MockConsumer(MockHelperBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        running = true;
        buffer.remove();
    }

    @Override
    public void stopRunning() {
        running = false;
    }

    public Item removeItem()  {
        return buffer.remove();
    }
}
