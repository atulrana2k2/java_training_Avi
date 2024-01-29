import java.util.Scanner;

public class stirngcasechange {
    public static void main(String[] args) {
        int i;
        String  sentence,newsn = "";
        System.out.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        sentence = sc.nextLine();
        int l = sentence.length();
        for (i = 0; i < l; i++) {
            if ((int) sentence.charAt(i) > 90 && (int) sentence.charAt(i) < 122) {
                newsn = newsn + (char) (sentence.charAt(i) - 32);
            } else if ((int) sentence.charAt(i) > 64 && (int) sentence.charAt(i) < 90) {
                newsn = newsn + (char) (sentence.charAt(i) + 32);
            } else
                newsn = newsn + (char) (sentence.charAt(i));
        }
        System.out.println(newsn);
    }
}


