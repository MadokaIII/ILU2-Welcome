package welcome;

import javafx.util.Pair;

import java.util.*;

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
        if (input.equals(FRIEND)) {
            str.append(FRIEND);
        } else {
            if (yell) {
                str.append(capitalize(input).toUpperCase().replaceAll("\\s*\\(X", " (x"));
            } else {
                str.append(capitalize(input));
            }
        }
    }

    private static String getHello(boolean yell) {
        return yell ? HELLO.toUpperCase() : HELLO;
    }

    private static String getSeparatorString(int namesLength, boolean yell) {
        if (namesLength == 1)
            return ", ";
        return yell ? ", AND " : ", and ";
    }

    private static String getEnd(boolean yell) {
        return yell ? " !" : ".";
    }

    private static List<String> trimNames(String[] input) {
        return Arrays.stream(input).map(String::trim).toList();
    }

    public static Pair<List<String>, List<String>> getUniqueNames(List<String> names) {
        List<String> normalNames = new ArrayList<>();
        List<String> yelledNames = new ArrayList<>();
        Pair<List<String>, List<String>> pair = new Pair<>(normalNames, yelledNames);
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            String uniqueName = yell(name) ? name : name.toLowerCase();
            if (uniqueNames.add(uniqueName)) {
                int count = Collections.frequency(names.stream()
                        .map(str -> yell(str) ? str : str.toLowerCase()).toList(), uniqueName);
                String newName = count == 1 ? name : name + " (x" + count + ")";
                (yell(name) ? yelledNames : normalNames).add(newName);
            }
        }
        return pair;
    }

    private static String makeString(List<String> names, boolean yell) {
        StringBuilder str = new StringBuilder();
        String hello = getHello(yell);
        String separatorString = getSeparatorString(names.size(), yell);
        String end = getEnd(yell);
        boolean yoda = names.stream().map(name -> name.toLowerCase()
                .replaceAll("\\s*\\(x\\d+\\)", "")).toList().contains("yoda");
        if (yoda)
            Collections.reverse(names);
        for (int i = 0; i < names.size(); i++) {
            if (i != 0) {
                str.append(i == names.size() - 1 ? separatorString : ", ");
            }
            addName(str, names.get(i), yell);
        }
        if(!yoda)
            str.insert(0, hello + ", ");
        else
            str.append(", " + hello);
        str.append(end);
        return str.toString();
    }


    public static String welcome(String input) {
        List<String> names = trimNames(friend(input).split(","));
        Pair<List<String>, List<String>> pair = getUniqueNames(names);
        StringBuilder str = new StringBuilder();
        if (!pair.getKey().isEmpty()) {
            str.append(makeString(pair.getKey(), false));
        }
        if (!pair.getValue().isEmpty()) {
            if (!str.isEmpty()) {
                str.append(" AND ");
            }
            str.append(makeString(pair.getValue(), true));
        }
        return str.toString();
    }

}
