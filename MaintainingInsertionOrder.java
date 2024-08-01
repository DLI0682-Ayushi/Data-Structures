package collections_and_sets;
import java.util.*;
public class MaintainingInsertionOrder {
    public static List<String> removeDuplicatesAndMaintainOrder(List<String> inputList) {
        Set<String> linkedHashSet = new LinkedHashSet<>(inputList);
        return new ArrayList<>(linkedHashSet);
    }

    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("apple", "banana", "apple", "orange");
        List<String> outputList = removeDuplicatesAndMaintainOrder(inputStrings);
        System.out.println(outputList);
    }
}

