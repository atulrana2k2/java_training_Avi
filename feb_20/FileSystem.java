

import java.io.*;
import java.util.*;

public class FileSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1: Create A new File");
                System.out.println("2: Display the content of the File");
                System.out.println("3: Operation (sort Employee according to Salary)");
                System.out.println("Enter Your Choice");
                int choice = sc.nextInt();
                if (choice > 4)
                    throw new InputMismatchException();
                switch (choice) {
                    case 1:
                        CreateFile(sc);
                        break;
                    case 2:
                        Readfile(sc);
                        break;
                    case 3:
                        System.out.println("Enter File Name");
                        String Name = sc.next();
                        operation(Name);
                        break;
                    case 4:
                        System.out.println("Exiting the System");
                        System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid INput");
            }

        }
    }




    static void CreateFile( Scanner sc) {                                       //function to create a file
        HashMap<String, Integer> Employee = new HashMap<>();
        System.out.println("Enter The File Name (with Extension)  : ");
        String FName = sc.next();
            System.out.println("Enter total no of Employee  : ");
            int no = sc.nextInt();
            System.out.println("Enter Employee Details : ");
            for (int i = 0; i < no; i++) {
                System.out.println("Enter the Name of " + (i + 1) + " Employee : ");
                String Name = sc.next();
                System.out.println("Enter Salary " + (i + 1) + " Employee : ");
                int id = sc.nextInt();
                Employee.put(Name, id);
            }
            serializeHashMapToFile(Employee,FName);                 //serialization of data for adding it into file


    }

    static void Readfile(Scanner sc) {                                                      //fxn to read file from existing file
        System.out.println("Enter The File Name");
        String FName = sc.next();
        File file = new File(FName);
        if (file.exists()) {
            if(file.length()==0) {
                System.out.println("File is Empty");
                return;
            }
            HashMap<String, Integer> deserializedHashMap = deserializeHashMapFromFile(FName);   //desarialization of data
            System.out.println(deserializedHashMap);
    }else System.out.println("File Does not exist");
    }
    static void operation(String Name)
    {
        File file = new File(Name);
        HashMap<String,Integer>student=new HashMap<>();
        if (file.exists()) {
            HashMap<String, Integer> deserializedHashMap = deserializeHashMapFromFile(Name);
            Map<String, Integer> sortedHashMap = sortHashMapByValueDescending(deserializedHashMap);
            System.out.println(sortedHashMap);
        }
        else System.out.println("File does not exist");

    }
    public static void serializeHashMapToFile(HashMap<String, Integer> hashMap, String filePath) {      //function to serialize the data
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(hashMap);
            System.out.println("HashMap serialized to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error serializing HashMap: " + e.getMessage());
        }
    }

    public static HashMap<String, Integer> deserializeHashMapFromFile(String filePath) {    //function to deserialize the data from file
        HashMap<String, Integer> hashMap = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            hashMap = (HashMap<String, Integer>) ois.readObject();
            System.out.println("HashMap deserialized from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing HashMap: " + e.getMessage());
        }
        return hashMap;
    }

    public static HashMap<String, Integer> sortHashMapByValueDescending(HashMap<String, Integer> hashMap) { //fxn to perform sort operation on Hash Map
        List<HashMap.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entryList, (entry1, entry2) -> {
            // Sort by value in reverse order (decreasing order)
            return entry2.getValue().compareTo(entry1.getValue());
        });

        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
