import java.util.*;

public class uc13 git checkout -b uc11-palindrome{

    static boolean stackMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    static boolean twoPointerMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    static boolean recursiveMethod(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return recursiveMethod(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean stackResult = stackMethod(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean twoPointerResult = twoPointerMethod(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean recursiveResult = recursiveMethod(normalized, 0, normalized.length() - 1);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        System.out.println("\nResults:");
        System.out.println("Stack Method: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Two Pointer Method: " + twoPointerResult + " | Time: " + twoPointerTime + " ns");
        System.out.println("Recursive Method: " + recursiveResult + " | Time: " + recursiveTime + " ns");

        sc.close();
    }
}