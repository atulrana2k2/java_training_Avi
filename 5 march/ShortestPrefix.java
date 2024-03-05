import java.util.*;

class TrieNode
{
    Map<Character,TrieNode> children;
    int frequency;

    TrieNode()
    {
        children=new HashMap<>();
        frequency=0;
    }
}


public class ShortestPrefix {

    static TrieNode root;


    //inserting the word into Trie Data Structure
    public static void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
            current.frequency++;
        }
    }


    //finding shortest prefix using Trie
    public static String findShortestUniquePrefix(String word) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            prefix.append(c);
            current = current.children.get(c);
            if (current.frequency == 1) {
                break;
            }
        }
        return prefix.toString();
    }



    // calling insert and findshortesuniqueprefix for each word
    public static String[] shortestUniquePrefix(List<String> words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        String[] prefixes = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            prefixes[i] = findShortestUniquePrefix(words.get(i));
        }
        return prefixes;
    }





    public static void main(String[] args) {


        //taking a list of word as Input
        Scanner sc=new Scanner(System.in);
        List<String> wordList=new ArrayList<>();
        System.out.println("Enter the  No of Strings : ");
        int stringCount= sc.nextInt();
        System.out.println("Enter the Strings : ");
        for(int string=0;string<stringCount;string++)
        {
            System.out.println("Enter "+(string+1)+" word");
            wordList.add(sc.next());
         }



        //storing the result in a StringArray of Prefixes
        String[] Prefixes=shortestUniquePrefix(wordList);
        for(int word=0;word<wordList.size();word++)
        {
            System.out.println(wordList.get(word)+"="+Prefixes[word]);
        }

    }
}

