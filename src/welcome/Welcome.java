package welcome;

public class Welcome {

    private static final String HELLO = "Hello, ";
    private static final String FRIEND = "my friend";

    private static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    private static String friend(String input) {
        if (input == null || "".equals(input.trim())) {
            return FRIEND;
        } else return capitalize(input.trim());
    }

    private static boolean yell(String input) {
        return input.toUpperCase().equals(input);
    }

    public static String welcome(String input) {
        StringBuilder str = new StringBuilder(HELLO);
        if (yell(friend(input))){
            str.append(friend(input) + " !");
            return str.toString().toUpperCase();
        }
        str.append(friend(input));
        return str.toString();
    }

}
