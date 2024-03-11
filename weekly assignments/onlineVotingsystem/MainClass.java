package onlineVotingsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;




public class MainClass {
    static List<User> employees = new CopyOnWriteArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //Reading the information of User from Csv File

        try (BufferedReader bf = new BufferedReader(new FileReader("G:\\java\\weeklyasignment\\onlineVotingsystem\\New Microsoft Excel Worksheet.csv"))) {
            String line;

            //reading the header first
            bf.readLine();
            // Read each line from the CSV file
            while ((line = bf.readLine()) != null) {
                String[] data = line.split(","); // Split the line by comma (CSV format)
                // Assuming the CSV structure is: userId, userPassword, Name
                String userId = (data[0]);

                String Name = (data[2]);

                String dateFormat = "dd-MM-yyyy";
                String userPassword = data[1];
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

                try {
                    // Parse the string into a Date object
                    Date dateObject = sdf.parse(data[1]);
                    employees.add(new User(userId, dateObject, Name, userPassword));

                } catch (ParseException e) {
                    // Handle parsing errors
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println(employees);

        try{

        while (true) {
            System.out.println("\t\t-----ONLINE VOTING SYSTEM----");
            System.out.println("\t\t\t  ---OPTIONS--- ");
            System.out.println("1:  User ");
            System.out.println("2:  Admin");
            System.out.println("3:  Exit the System\n");
            System.out.println("Enter your Choice : ");
            try {
                int Choice = sc.nextInt();
                sc.nextLine();
                if (Choice > 3) {
                    throw new InputMismatchException();
                }


                switch (Choice) {
                    case 1:
                        boolean validInput1=false;
                        while (true) {
                            System.out.println("\t\t\t ----Options(USER)---- ");
                            System.out.println("1: Registration");
                            System.out.println("2: Update User");
                            System.out.println("3: To Cast A Vote");
                            System.out.println("4: Exit the user Module");
                            System.out.println("5: Exit the System\n");
                            System.out.println("Enter Your Choice : ");
                            try {
                                int choice = sc.nextInt();
                                sc.nextLine();
                                if (choice > 5) {
                                    throw new InputMismatchException();
                                }
                                switch (choice) {
                                    case 1:
                                        OnlineVotingSystem.Registration(employees, sc);

                                        break;

                                    case 2:
                                        boolean validInput = false;
                                        boolean IDflag = false;
                                        try {
                                            while (!validInput) {
                                                System.out.println("Enter the user Id You want to Update : ");
                                                String userId = sc.nextLine();
                                                for (User employee : employees)
                                                    if (employee.getUserID().equals(userId)) {
                                                        IDflag = true;
                                                        System.out.println("Enter user Password : ");
                                                        String userPassword = sc.nextLine();
                                                        if (employee.getUserPassword().equals(userPassword)) {
                                                            System.out.println("Enter What you want to update : ");
                                                            System.out.println("1: Name");
                                                            System.out.println("2: Password/Date of Birth");
                                                            System.out.println("3: Full Information \n");
                                                            System.out.println("Enter your choice : ");
                                                            try {
                                                                int updateChoice = sc.nextInt();
                                                                sc.nextLine();
                                                                if (updateChoice > 3) {
                                                                    throw new InputMismatchException();
                                                                }
                                                                switch (updateChoice) {
                                                                    case 1:
                                                                        System.out.println("Enter the Updated Name : ");
                                                                        String UpdatedName = sc.next();
                                                                        OnlineVotingSystem.updateUserInCSV(new User(employee.getUserID(), new Date(), UpdatedName, employee.getUserPassword()));
                                                                        System.out.println("------Record Updated Successfully------\n\n");
                                                                        break;

                                                                    case 2:
                                                                        System.out.println("Enter the Updated Password/Date of Birth (dd-MM-yyyy");
                                                                        String UpdatedPassword = sc.nextLine();
                                                                        OnlineVotingSystem.updateUserInCSV(new User(employee.getUserID(), new Date(), employee.getUserName(), UpdatedPassword));
                                                                        System.out.println("------Record Updated Successfully------\n");
                                                                        break;

                                                                    case 3:
                                                                        System.out.println("Enter Updated Name :");
                                                                        String UpdateName = sc.nextLine();
                                                                        System.out.println("Enter the Updated Password/Date of Birth (dd-MM-yyyy");
                                                                        String UpdatePassword = sc.next();
                                                                        OnlineVotingSystem.updateUserInCSV(new User(employee.getUserID(), new Date(), UpdateName, UpdatePassword));
                                                                        System.out.println("------Record Updated Successfully------\n");
                                                                        break;


                                                                }
                                                                validInput = true;
                                                            } catch (InputMismatchException e) {
                                                                System.out.println("----Enter choice between 1-3----");
                                                            }


                                                        } else
                                                            System.out.println("----Invalid Password----\n");

                                                    }
                                                if (!IDflag)
                                                    System.out.println("----Invalid Id----\n");


                                            }


                                        } catch (InputMismatchException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;


                                    case 3:
                                        System.out.println("---------Welcome For Voting--------\n");
                                        System.out.println("First Login to the System");
                                        System.out.println("Enter the User Id : ");
                                        String UserID = sc.next();
                                        OnlineVotingSystem.Voting(UserID);
                                        break;


                                    case 4:
                                        System.out.println("----Exiting the User module----\n");
                                        validInput1 = true;
                                        break;

                                    case 5:
                                        System.out.println("\n\n-----Exiting System----");
                                        System.exit(0);



                                }

                            } catch (InputMismatchException e) {
                                System.out.println("----Enter Choice Between 1-4-----");
                            }
                            if (validInput1) {
                                break;
                            }
                        }
                       break;

                    case 2:
                        boolean inValid2=false;
                        Admin admin = new Admin();
                        System.out.println("Enter the Admin Id :");
                        String AdminId = sc.next();
                        if (admin.getAdminID().equals(AdminId)) {
                            System.out.println("Enter Password : ");
                            String Password = sc.next();
                            if (admin.getPassword().equals(Password)) {
                                while (!inValid2) {
                                    System.out.println("\n\t\t\t ----Options(ADMIN)----");
                                    System.out.println("1:  Add Candidates/Party ");
                                    System.out.println("2:  Remove Candidates/Party");
                                    System.out.println("3:  Show Voting Status");
                                    System.out.println("4:  Show Election Results ");
                                    System.out.println("5:  Display User");
                                    System.out.println("6:  Display Registered user");
                                    System.out.println("7:  Display Party/Candidates");
                                    System.out.println("8:  Remove Register User");
                                    System.out.println("9:  Exit Admin Panel");
                                    System.out.println("10: Exit the System\n");
                                    System.out.println("Enter Your Choice : ");
                                    try {
                                        int choice = sc.nextInt();
                                        sc.nextLine();
                                        if (choice > 10) {
                                            throw new InputMismatchException();
                                        }


                                        switch (choice) {
                                            case 1:
                                                OnlineVotingSystem.addCandidate();
                                                break;

                                            case 2:
                                                OnlineVotingSystem.removeCandidate();
                                                break;

                                            case 3:
                                                OnlineVotingSystem.displayVotingStatus();
                                                break;


                                            case 4:
                                                OnlineVotingSystem.showElectionResults();
                                                break;

                                            case 5:
                                                System.out.println(employees);
                                                break;

                                            case 6:
                                                OnlineVotingSystem.displayRegisteredUsers();
                                                break;


                                            case 7:
                                                OnlineVotingSystem.displayCandidates();
                                                break;

                                            case 8:
                                                System.out.println("Enter the User Id : ");
                                                String userId= sc.nextLine();
                                                OnlineVotingSystem.removeRegisteredUser(userId);
                                                break;


                                            case 9:
                                                System.out.println("---Exiting Admin Panel---\n");
                                                inValid2=true;
                                                break;

                                            case 10:
                                                System.out.println("----Exiting The System----");
                                                System.exit(0);
                                        }
                                        if(inValid2)
                                        {
                                            break;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("--Please Enter Choice between 1-5--\n");
                                    }
                                }
                            } else {
                                System.out.println("--Admin Password is Incorrect--\n");
                                break;
                            }
                        } else {
                            System.out.println("--Admin Id not Matched--\n");
                            break;
                        }
                        break;

                    case 3:
                        System.out.println("----Exiting System----");
                        System.exit(0);


                }
            } catch (InputMismatchException e) {
                System.out.println("--Please Enter Choice Between 1-2--\n");
            }


        }

        }catch (InputMismatchException e)
        {
            System.out.println("---Invalid Input---\n");
        }






    }
}
