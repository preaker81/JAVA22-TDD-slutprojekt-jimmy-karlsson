package org.example;

public class MockConsumer implements Consumer {
    private final MockHelperBuffer buffer;

    public MockConsumer(MockHelperBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    }

    @Override
    public void stopRunning() {
    }

    public Item removeItem()  {
        return buffer.remove();
    }
}
