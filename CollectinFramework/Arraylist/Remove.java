package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Remove {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> color=new ArrayList<>();
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("White");

        System.out.print("Colors");
        for(String colors:color)
            System.out.println(colors+" ");

        System.out.println("Enter the Index of color you want to remove  (up to 3) : ");
        int indexOfColor=scanner.nextInt();

        //using remove function to remove the element
        color.remove(indexOfColor);

        System.out.println("Colours after Removal : ");
        for(String colors: color)
            System.out.print(colors+" ");
    }
}
