import javax.swing.*;
import java.util.*;

public class GroupAnagrams_1{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        List<List<String>> answer=new ArrayList<>();
        System.out.println("Enter the number of string :");
        int n= sc.nextInt();

        String[] string=new String[n];
        System.out.println("Enter the strings");
        for(int i=0;i<n;i++)
            string[i]=sc.next();
            answer = groupanagrams(string);
            System.out.println(answer);
        }


    public static List<List<String>> groupanagrams(String[] string)
    {
        List<List<String>> ans=new ArrayList<>();
        HashMap< String ,List<String>> map=new HashMap<>();
        for(String word :string) {
            char[] s = word.toCharArray();                      //convert string to array for sorting
            Arrays.sort(s);
            String sortedstring = String.valueOf(s);            //convert array back to string
            if (!map.containsKey(sortedstring))             //check weather the sorted string exit in map if not
                map.put(sortedstring, new ArrayList<>());  // add the sortedstring to map and make a correponding list
            map.get(sortedstring).add(word);                       // to store the word in map */
        }
        map.forEach((k,v)->{
            ans.add(v);                             //return the list containg each list of string having anagrams

        });
                return ans;
    }

}
