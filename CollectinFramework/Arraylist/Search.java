package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> color=new ArrayList<>();
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("White");

        System.out.println("Enter the color you want to search : ");
        String searchedColor=scanner.nextLine();

        //using contains function to check the element exist in the list or not
        if(color.contains(searchedColor))
            System.out.println("Found the Element");
        else
            System.out.println("Element not Found");


    }
}
