import java.util.Scanner;

public class counvowels {
    public static void main(String[] args) {
        int vcount=0,ccount=0,scount=0;
        String sentence="";
        Scanner sc = new Scanner(System.in);
        sentence=sc.nextLine();
        int l=sentence.length();
        for(int i=0;i<l;i++)
        {
            if(sentence.charAt(i)=='i' || sentence.charAt(i)=='e' || sentence.charAt(i)=='a' ||sentence.charAt(i)=='o' || sentence.charAt(i)=='u')
                vcount++;
            else if((int)sentence.charAt(i)>90 && (int)sentence.charAt(i)<122)
                ccount++;
            else
                scount++;
        }
        System.out.println("Number of vowels in sentence :" + vcount);
        System.out.println("Number of constants in sentence: " + ccount);
        System.out.println("Number of special character in sentence " + scount);

    }
}