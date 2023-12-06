package org.example;

public class MockConsumer implements Consumer {

    private Buffer buffer;
    private boolean isRunning;

    public MockConsumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            // Simulera konsumtion av ett objekt
            if (!buffer.buffer.isEmpty()) {
                Item item = buffer.remove();
                // Hantera 'item' om nödvändigt
            }
            // Lägg till logik för att pausa eller avsluta loopen om nödvändigt
        }
    }

    @Override
    public void stopRunning() {
        isRunning = false;
    }
}
