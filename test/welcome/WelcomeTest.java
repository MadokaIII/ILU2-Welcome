package welcome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void answerName(){
        assertEquals("Hello, Joe", Welcome.welcome("joe"));
        assertEquals("Hello, Kate", Welcome.welcome("Kate"));
    }

}