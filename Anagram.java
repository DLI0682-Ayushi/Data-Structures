package Assignment2;
import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] strings = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strings) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            anagramGroups.get(sortedStr).add(str);
        }

        System.out.println("Anagram groups:");
        for (Map.Entry<String, List<String>> entry : anagramGroups.entrySet()) {
            System.out.println(entry.getValue());
        }

        scanner.close();
    }
}
