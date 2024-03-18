package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Replace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> color = new ArrayList<>();
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("White");

        //displaying existing list of color
        System.out.println("Colors");
        for(String colors:color)
            System.out.print(colors +" ");

        System.out.println("\nEnter the color you want to Replace  at 2 index: ");
        String replaceColor=scanner.nextLine();

        //using set to replace the elements in the arraylist
        color.set(2,replaceColor);

        //list after replacing the elements
        System.out.println("Colours after a replace");
        for(String  colors:color)
            System.out.print(colors+" ");


    }
}
