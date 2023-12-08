package org.example;

public class MockHelperBuffer extends Buffer {
    private boolean throwInterrupt = false;

    public void setThrowInterrupt(boolean throwInterrupt) {
        this.throwInterrupt = throwInterrupt;
    }

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
