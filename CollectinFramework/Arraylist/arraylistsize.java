package ArrayList;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arraylistsize {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> color=new ArrayList<>();
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("White");

        //size of arraylist
        System.out.println("Current Size : "+color.size());


        //displaying existing list of color
        System.out.println("Colors");
        for(String colors:color)
            System.out.print(colors +" ");


        //size will be updated dynamically at run time by add function
        System.out.println("\nEnter the colour you want to add : ");
        String addColor=scanner.nextLine();
        color.add(addColor);

        //displaying the new size of the arraylist
        System.out.println("New size : "+color.size());
        System.out.println("Colours after a update");
        for(String  colors:color)
            System.out.print(colors+" ");

    }
}
