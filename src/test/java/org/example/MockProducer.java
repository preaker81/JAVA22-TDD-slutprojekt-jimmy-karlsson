package org.example;

import org.mockito.Mockito;

public class MockProducer implements Producer {

    private Buffer buffer;
    private boolean isRunning;

    public MockProducer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            // Simulera produktion av ett objekt
            Item item = Mockito.mock(Item.class);
            buffer.add(item);
            // Lägg till logik för att pausa eller avsluta loopen om nödvändigt
        }
    }

    @Override
    public void stopRunning() {
        isRunning = false;
    }
}
