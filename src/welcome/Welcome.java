package welcome;

public class Welcome {

    private static final String HELLO = "Hello, ";
    private static final String FRIEND = "my friend";

    private static String capitalize(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private static String friend(String input){
        if (input == null || "".equals(input.trim())){
            return FRIEND;
        }
        else return capitalize(input.trim());
    }

    public static String welcome(String input){
        if (input != null && !"".equals(input.trim()) && input.toUpperCase().equals(input)) return HELLO.toUpperCase() + friend(input).toUpperCase() + " !";
        return HELLO + friend(input);
    }

}
