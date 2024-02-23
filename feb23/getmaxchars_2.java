package org.example;

import java.util.Scanner;

public class getmaxchars_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String string;
        System.out.println("Enter the string :");
        string = sc.next();
        maxchar(string);
    }
    public static void maxchar(String string)
    {
        int[] check=new int[126];
        for(char s:string.toCharArray())
        {
            if(Character.isLetter(s))
            check[s]++;
        }

        int max=0;
        int ans=0;
        for(int i=0;i<126;i++)
        {
            if(check[i]>max)
            {
                ans=i;
                max=check[i];
            }
        }
        if(max==0)
            System.out.println("No letter avaliable");
        else
            System.out.println("Largest ocuring charcter is :"+(char)ans);
    }
}
