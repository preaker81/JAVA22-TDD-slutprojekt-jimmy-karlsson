package org.example;

public class MockConsumer implements Consumer {

    private MockHelperBuffer buffer;
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

    public boolean isRunning() {
        return running;
    }
}