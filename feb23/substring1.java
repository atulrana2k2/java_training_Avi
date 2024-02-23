package org.example;

import java.util.LinkedList;
import java.util.Scanner;

public class substring1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String string = sc.nextLine();
        System.out.println("Enter the Initial index : ");
        int initialIndex = sc.nextInt();
        System.out.println("Enter the Ending index :");
        int endingIndex = sc.nextInt();
        StringBuilder ans =(substring(string, initialIndex, endingIndex));
        System.out.println(ans);


    }

    public static StringBuilder substring(String string, int initialIndex, int endingIndex) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            linkedList.add(string.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = initialIndex; i < endingIndex && i < string.length(); i++) {
            ans.append(linkedList.get(i));
        }
        return ans;

    }
}
