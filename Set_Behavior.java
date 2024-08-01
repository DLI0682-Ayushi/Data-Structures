package collections_and_sets;
import java.util.*;
public class Set_Behavior {
    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(5, 3, 5, 1, 2);
        Set<Integer> hashSet = new HashSet<>(inputList);
        Set<Integer> linkedHashSet = new LinkedHashSet<>(inputList);
        Set<Integer> treeSet = new TreeSet<>(inputList);
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);
    }
}
