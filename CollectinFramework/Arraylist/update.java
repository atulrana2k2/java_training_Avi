package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class update {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> color = new ArrayList<>();
        color.add("Red");
        color.add("blue");
        color.add("green");
        color.add("White");

        System.out.println("Colors");
        for(String colors:color)
            System.out.print(colors +" ");

        System.out.println("\nEnter the color you want to update : ");
        String updateColor=scanner.nextLine();

        //using add function to update the list
        color.add(2,updateColor);


        System.out.println("Colours after a update");
        for(String  colors:color)
            System.out.print(colors+" ");

    }
}
