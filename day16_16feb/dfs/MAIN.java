package dfs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Server server1 = new Server(1001);
        Server server2 = new Server(1002);
        DFS_System d = new DFS_System();
        d.addServer(server1);
        d.addServer(server2);
        while (true) {

            System.out.println("        OPTIONS          ");
            System.out.println("1: For Adding a Server");
            System.out.println("2: For Uploading a File");
            System.out.println("3. For Download a File");
            System.out.println("4. For Replicate a File");
            System.out.println("5. Exit The system");
            System.out.println("Enter Your Choice");
            try {                                                                           //using try catch for and Exception
                int choice = sc.nextByte();
                if (choice > 5)
                    throw new InputMismatchException();
                switch (choice) {
                    case 1:                                                                     //case for adding a server

                        System.out.println("Enter Server Details");
                        System.out.println("Enter Server Id");
                        int id = sc.nextInt();
                        Server s = new Server(id);
                        d.addServer(s);
                        break;
                    case 2:                                                                    //case for adding a file in a server
                        try {
                            System.out.println("Enter File Details:");
                            System.out.println("Enter File Name : ");
                            String Name = sc.next();
                            sc.nextLine();
                            System.out.println("Enter File Size :");
                            double size = sc.nextDouble();
                            sc.nextLine();
                            File f = new File(Name, size);
                            System.out.println("\n Enter server Id where you want to add the File : ");
                            int sid = sc.nextInt();
                            d.uploadFile(f, sid);
                            break;
                        } catch (InputMismatchException e) {
                            sc.nextLine();
                            System.out.println("Invalid Input");
                            break;
                        }
                    case 3:                                                                 //case for Downloading a file from the server
                        try {
                            System.out.println("Enter File Name you want to Download : ");
                            String fName = sc.next();
                            System.out.println("Enter Server Id form where you want to Download the file");
                            int sid = sc.nextInt();
                            d.downloadFile(fName, sid);
                            break;
                        } catch (InputMismatchException e) {
                            sc.nextLine();
                            System.out.println("Invalid Input");
                            break;
                        }
                    case 4:                                                                 //case for replicating a file from one server to another server
                        try {
                            System.out.println("Enter File Name you want to replicate : ");
                            String fName = sc.next();
                            sc.nextLine();
                            System.out.println("Enter the Server Id in which file exist");
                            int Sid= sc.nextInt();
                            sc.nextLine();
                            File f = new File(fName);
                            System.out.println("Enter Server Id where You want to replicate the file : ");
                            int idS = sc.nextInt();
                            d.replicateFile(f, Sid  ,idS);
                            break;
                        } catch (InputMismatchException e) {
                            sc.nextLine();
                            System.out.println("Invalid Input");
                            break;
                        }
                    case 5:                                                                                     //case for exiting a system
                        System.out.println("Exiting System");
                        System.exit(0);



                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid Input");
            }
        }
    }
}

