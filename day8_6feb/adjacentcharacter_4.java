import java.util.Scanner;

public class adjacentcharacter_4 {
    static String ans = "";

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :");
        String s = sc.next();
        int l = s.length()-1;
        int i = 0;
        String answer = adjacentC(s, l, i);
        answer=answer+s.charAt(s.length()-1);               //appending the last character
        System.out.println(answer);

    }

    public static String adjacentC(String s, int l, int i) {
        if (l == 0)
            return ans;
        else if (s.charAt(i) == s.charAt(i + 1))            //checking for adjacent character

            ans = ans + s.charAt(i) + '*';              //adding * to the ans string
        else
            ans = ans + s.charAt(i);            //adding the character to answer if no adjacent find

        return adjacentC(s, l-=1, i+=1);
    }
}