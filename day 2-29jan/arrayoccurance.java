import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class arrayoccurance {
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int s= sc.nextInt();
        System.out.println("Enter the elements of the array :");
        int[] array=new int[s];
        Map<Integer, Integer> map =new HashMap<Integer, Integer>();
        for(int i=0;i<s;i++)
        {
            array[i]=sc.nextInt();
        }
        for(int i=0;i<s;i++)
        {
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
    map.forEach((k,v)->{
        if(map.get(k)==1)
            System.out.println(k);

    });
        }
    }

