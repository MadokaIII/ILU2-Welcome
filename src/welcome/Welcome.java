package welcome;

public class Welcome {

    private static final String HELLO = "Hello, ";

    private static String capitalize(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static String welcome(String input){
        return HELLO + capitalize(input);
    }

}
