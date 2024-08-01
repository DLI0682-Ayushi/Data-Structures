package collections_and_sets;
import java.util.*;
public class PerformanceComparison {
    public static void main(String[] args) {
        int numElements = 1_000_000;
        long startTime = System.nanoTime();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < numElements; i++) {
            hashSet.add(i);
        }
        long endTime = System.nanoTime();
        long hashSetAddTime = endTime - startTime;

        startTime = System.nanoTime();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < numElements; i++) {
            linkedHashSet.add(i);
        }
        long linkedHashSetAddTime = endTime - startTime;

        startTime = System.nanoTime();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < numElements; i++) {
            treeSet.add(i);
        }
        long treeSetAddTime = endTime - startTime;

        // Measure time for contains operation
        startTime = System.nanoTime();
        boolean containsHashSet = hashSet.contains(numElements / 2);
        endTime = System.nanoTime();
        long hashSetContainsTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean containsLinkedHashSet = linkedHashSet.contains(numElements / 2);
        endTime = System.nanoTime();
        long linkedHashSetContainsTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean containsTreeSet = treeSet.contains(numElements / 2);
        endTime = System.nanoTime();
        long treeSetContainsTime = endTime - startTime;

        System.out.println("HashSet add time: " + hashSetAddTime + " ns");
        System.out.println("LinkedHashSet add time: " + linkedHashSetAddTime + " ns");
        System.out.println("TreeSet add time: " + treeSetAddTime + " ns");
        System.out.println("HashSet contains time: " + hashSetContainsTime + " ns");
        System.out.println("LinkedHashSet contains time: " + linkedHashSetContainsTime + " ns");
        System.out.println("TreeSet contains time: " + treeSetContainsTime + " ns");
    }
}

