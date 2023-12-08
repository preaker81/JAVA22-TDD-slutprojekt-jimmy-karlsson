package org.example;


public class MockProducer implements Producer {

    private MockHelperBuffer buffer;
    private volatile boolean running = true;

    public MockProducer(MockHelperBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        MockHelperItem item = new MockHelperItem("item");
        buffer.add(item);
    }

    @Override
    public void stopRunning() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

}