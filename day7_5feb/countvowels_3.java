import java.util.Scanner;

public class countvowels_3 {
    public static void  main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = sc.next();
        int l = s.length();
        int fcount = 0, Ecount = 0;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A'
                    || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
                fcount++;
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u' || s.charAt(j) == 'A'
                    || s.charAt(j) == 'E' || s.charAt(j) == 'I' || s.charAt(j) == 'O' || s.charAt(j) == 'U')
                Ecount++;
        }
        if (fcount == Ecount)
            System.out.println("True");
        else
            System.out.println("False");
    }}