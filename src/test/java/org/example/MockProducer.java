package org.example;


public class MockProducer implements Producer {

    private final MockHelperBuffer buffer;


    public MockProducer(MockHelperBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    }

    @Override
    public void stopRunning() {
    }

    public boolean addItem(MockHelperItem item) {
        return buffer.add(item);
    }
}