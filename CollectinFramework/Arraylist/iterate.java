package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iterate {
    public static void main(String[] args) {
        List<String>color=new ArrayList<>();
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("White");


        //using  to iterate over arraylist
        Iterator<String> colorIterator =color.iterator();
        while(colorIterator.hasNext())
        {
            System.out.println(colorIterator.next());
        }


        //using forEach function
        color.forEach((String val)-> System.out.println(val));

        //using enhanced for loop to iterate over arraylist
        for(String colors:color)
            System.out.println(colors);
    }
}
