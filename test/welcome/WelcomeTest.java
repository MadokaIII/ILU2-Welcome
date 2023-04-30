package welcome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void answerName(){
        assertEquals("Hello, Joe.", Welcome.welcome("joe"));
        assertEquals("Hello, Kate.", Welcome.welcome("Kate"));
        assertEquals("Hello, Joe.", Welcome.welcome(" joe "));
        assertEquals("Hello, Kate.", Welcome.welcome(" Kate "));
    }

    @Test
    void answerNone(){
        assertEquals("Hello, my friend.", Welcome.welcome(""));
        assertEquals("Hello, my friend.", Welcome.welcome("    "));
        assertEquals("Hello, my friend.", Welcome.welcome(null));
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
        assertEquals("Hello, Joe, and Kate.", Welcome.welcome("joe  ,  kate"));
        assertEquals("Hello, Kate, and Joe.", Welcome.welcome("Kate  ,  joe"));
        assertEquals("Hello, Joe, and Kate.", Welcome.welcome(" joe  , kate "));
        assertEquals("Hello, Kate, and Joe.", Welcome.welcome(" kate  ,  joe "));
        assertEquals("Hello, Joe, Kate, and Love.", Welcome.welcome("joe  ,kate,  Love"));
        assertEquals("Hello, Kate, Joe, and Love.", Welcome.welcome("kate,joe, Love"));
        assertEquals("Hello, Kate, Joe, and Love.", Welcome.welcome(" Kate ,Joe ,Love "));
        assertEquals("Hello, Joe, Kate, and Love.", Welcome.welcome(" joe, kate, Love "));
    }

    @Test
    void answerYells(){
        assertEquals("HELLO, JOE, KATE, AND LOVE !", Welcome.welcome("JOE, KATE, LOVE"));
        assertEquals("HELLO, LOVE, KATE, AND JOE !", Welcome.welcome("LOVE ,KATE,  JOE"));
        assertEquals("HELLO, KATE, JOE, AND LOVE !", Welcome.welcome(" KATE,  JOE  ,LOVE "));
        assertEquals("HELLO, JOE, KATE, AND LOVE !", Welcome.welcome(" JOE, KATE,  LOVE "));
    }

    @Test
    void answerRepetitions(){
        assertEquals("Hello, Joe (x3).", Welcome.welcome("joe,joe,joe"));
        assertEquals("HELLO, JOE (x2), AND KATE !", Welcome.welcome("JOE,JOE,KATE"));
        assertEquals("Hello, Kate, and Joe (x2).", Welcome.welcome("kate,joe,joe"));
        assertEquals("HELLO, KATE (x2), AND JOE !", Welcome.welcome("KATE,JOE,KATE"));
        assertEquals("Hello, Joe (x2), and Kate. AND HELLO, LOVE (x3) !",
                Welcome.welcome("lOVE, joe, Joe,Kate, LOVE, LOVE"));
        assertEquals("Hello, Joe (x2), Love, and Kate. AND HELLO, LOVE (x3) !",
                Welcome.welcome("lOVE, joe, Joe, love ,Kate, LOVE, LOVE"));
    }

    @Test
    void answerYoda(){
        assertEquals("Yoda, Hello.", Welcome.welcome("yoda"));
        assertEquals("Yoda (x3), Hello.", Welcome.welcome("yoda,yoda,yoda"));
        assertEquals("Yoda (x3), Joe, Kate (x2), Hello. AND HELLO, LOVE (x3) !",
                Welcome.welcome("lOVE, kate, Joe,Kate, Yoda, LOVE, LOVE, Yoda , yoda"));
        assertEquals("Yoda, Joe, Kate (x2), Hello. AND YODA (x2), LOVE (x3), HELLO !",
                Welcome.welcome("lOVE, kate, Joe,Kate, Yoda, LOVE, LOVE, YODA , YODA"));
    }

}