import java.util.Scanner;

public class removeadjacentduplicates_12 {

    public static String removeAdjacentDuplicates(String str) {
        int len = str.length();

        // If the string has less than 2 characters, it cannot have adjacent duplicates
        if (len < 2) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        // Traverse the string to remove adjacent duplicates
        while (i < len) {
            char currentChar = str.charAt(i);
            int j = i + 1;

            // Find the position of the next different character
            while (j < len && str.charAt(j) == currentChar) {
                j++;
            }

            // If adjacent duplicates are found, skip them
            if (j - i > 1) {
                i = j;
            } else {
                // Otherwise, append the current character and move to the next character
                sb.append(currentChar);
                i++;
            }
        }

        String result = sb.toString();


        if (result.equals(str)) {     // If the result is the same as the input, no further removal is possible
            return result;
        } else {
            return removeAdjacentDuplicates(result);  // Recursively remove adjacent duplicates from the result
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = removeAdjacentDuplicates(input);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
