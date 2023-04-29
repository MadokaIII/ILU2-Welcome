package welcome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void answerName(){
        assertEquals("Hello, Joe", Welcome.welcome("joe"));
        assertEquals("Hello, Kate", Welcome.welcome("Kate"));
        assertEquals("Hello, Joe", Welcome.welcome(" joe "));
        assertEquals("Hello, Kate", Welcome.welcome(" Kate "));
    }

    @Test
    void answerNone(){
        assertEquals("Hello, my friend", Welcome.welcome(""));
        assertEquals("Hello, my friend", Welcome.welcome("    "));
        assertEquals("Hello, my friend", Welcome.welcome(null));
    }

    @Test
    void answerYell(){
        assertEquals("HELLO, JOE !", Welcome.welcome("JOE"));
        assertEquals("HELLO, KATE !", Welcome.welcome("KATE"));
        assertEquals("HELLO, JOE !", Welcome.welcome(" JOE "));
        assertEquals("HELLO, KATE !", Welcome.welcome(" KATE "));
    }

    @Test
    void answerNames(){
        assertEquals("Hello, Joe, Kate", Welcome.welcome("joe,kate"));
        assertEquals("Hello, Kate, Joe", Welcome.welcome("kate,joe"));
        assertEquals("Hello, Joe, Kate", Welcome.welcome(" joe,kate "));
        assertEquals("Hello, Kate, Joe", Welcome.welcome(" kate,joe "));
    }

}