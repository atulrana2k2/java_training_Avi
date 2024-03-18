package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Retrive {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> color=new ArrayList<>();
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("White");
        System.out.println("Enter the Index  (up to 3): ");
        int index=scanner.nextInt();

        //using get function to retrieve element from index
        System.out.println(color.get(index));

    }
}
