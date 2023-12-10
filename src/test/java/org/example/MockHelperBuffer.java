package org.example;

public class MockHelperBuffer extends Buffer {
    private boolean throwInterrupt = false;

    @Override
    public synchronized Item remove() {
        if (throwInterrupt) {
            throw new RuntimeException(new InterruptedException("Interrupted for test"));
        }
        return super.remove();
    }

    public synchronized int size() {
        return buffer.size();
    }
}
