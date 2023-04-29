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

    private static String getHello(boolean yell) {
        if (yell) {
            return HELLO.toUpperCase();
        } else {
            return HELLO;
        }
    }

    private static String getSeparatorString(int namesLength, boolean yell) {
        if (namesLength == 1) {
            return ", ";
        } else if (yell) {
            return ", AND ";
        } else {
            return ", and ";
        }
    }

    private static String getEnd(boolean yell) {
        if (yell) {
            return " !";
        } else {
            return "";
        }
    }

    public static String[] trimNames(String[] input){
        if (input.length == 1) {
            return input;
        }
        String[] names = new String[input.length];
        for (int i = 0; i < input.length; i++)
            names[i] = input[i].trim();
        return names;
    }

    public static String welcome(String input) {
        boolean yell = yell(friend(input));
        String[] names = friend(input).split(",");
        names = trimNames(names);
        StringBuilder str = new StringBuilder(getHello(yell));
        for (int i = 0; i < names.length - 1; i++) {
            str.append(", ");
            addName(str, names[i], yell);
        }
        str.append(getSeparatorString(names.length, yell));
        addName(str, names[names.length - 1], yell);
        str.append(getEnd(yell));
        return str.toString();
    }

}
