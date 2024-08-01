package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize the graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and compute in-degrees of nodes
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Initialize the queue with nodes having zero in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        // Process nodes with zero in-degree
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If count equals numCourses, all courses can be finished
        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 1}, {3, 2} };

        if (canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("Not all courses can be finished.");
        }
    }
}
