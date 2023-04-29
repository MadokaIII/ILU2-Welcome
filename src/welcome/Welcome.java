package welcome;

public class Welcome {

    private static final String HELLO = "Hello";
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

    private static void addName(StringBuilder str, String input, boolean yell) {
        switch (input) {
            case FRIEND -> {
                str.append(FRIEND);
            }
            default -> {
                if (yell){
                    str.append(capitalize(input).toUpperCase());
                } else {
                    str.append(capitalize(input));
                }
            }
        }

    }

    public static String welcome(String input){
        StringBuilder str = new StringBuilder();
        boolean yell = yell(friend(input));
        String[] names = friend(input).split(",");
        if (yell) {
            str.append(HELLO.toUpperCase());
            for(String name : names){
                str.append(", ");
                addName(str, name, yell);
            }
            str.append(" !");
        } else {
            str.append(HELLO);
            for(String name : names){
                str.append(", ");
                addName(str, name, yell);
            }
        }
        return str.toString();
    }

}
