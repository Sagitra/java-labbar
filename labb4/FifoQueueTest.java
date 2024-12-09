import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FifoQueueTest{
    @Test
    @DisplayName("Tom lista som faktiskt är tom")
    void TomLista(){
        FifoQueue<String> temp = new FifoQueue<>();
        assertEquals(0, temp.size());
    }

    @Test
    @DisplayName("Tom lista som inte är tom")
    void Offer() {
        FifoQueue<String> temp = new FifoQueue<>();
        assertTrue(temp.offer("test"));
    }
    
}