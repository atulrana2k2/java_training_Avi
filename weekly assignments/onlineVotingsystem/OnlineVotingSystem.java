package onlineVotingsystem;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static onlineVotingsystem.MainClass.employees;


public class OnlineVotingSystem {

    static List<User> RegisteredUser = new CopyOnWriteArrayList<>();
    static HashMap<User, Boolean> Voter = new HashMap<>();

    static HashMap<Candidate, Integer> Party = new HashMap<>();
    static List<Candidate> candidates = new ArrayList<>();

        //function to add Candidates
    public static void addCandidate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Candidate ID: ");
        String candidateID = sc.nextLine();
        System.out.println("Enter the Candidate Name: ");
        String name = sc.nextLine();
        System.out.println("Enter the Party Affiliation: ");
        String partyAffiliation = sc.nextLine();
        System.out.println("Enter the Voting Symbol: ");
        String votingSymbol = sc.nextLine();

        Candidate candidate = new Candidate(candidateID, name, partyAffiliation, votingSymbol);
        candidates.add(candidate);
        System.out.println("---Candidate Added Successfully---\n");
    }


    //function to remove Candidates
    public static void removeCandidate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Candidate ID to remove: ");
        String candidateID = sc.next();
        boolean removed = false;
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateID().equals(candidateID)) {
                candidates.remove(candidate);
                removed = true;
                System.out.println("---Candidate Removed Successfully---\n");
                break;
            }
        }
        if (!removed) {
            System.out.println("---No Candidate with such ID found---\n");
        }
    }


    public static void Registration(List<User> employees, Scanner sc) {

        System.out.println("Enter the userId you want to Register : ");
        String userID = sc.next();
        sc.nextLine();
        boolean flag = false;
        for (User registeredUser : RegisteredUser) {
            if (registeredUser.getUserID().equals(userID)) {
                System.out.println("---User Already Registered---\n");
                return;
            }
        }
        for (User employee : employees) {
            if (employee.getUserID().equals(userID)) {
                flag = true;
                int chances = 3;
                while (chances > 0) {
                    System.out.println("Enter the Password : (dd-mm-yyyy) ");
                    String password = sc.nextLine();


                    if (Objects.equals(employee.getUserPassword(), password)) {

                        LocalDate currentDate = LocalDate.now();

                        LocalDate birthDate = employee.getDateOFBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int age = Period.between(birthDate, currentDate).getYears();

                        if (age > 18) {
                            System.out.println("---You are Registered for Voting---\n");
                            RegisteredUser.add(employee);
                            Voter.put(employee, false);

                            return;


                        } else {
                            System.out.println("---You are not Eligible for Voting---\n");
                            return;

                        }
                    } else {

                        System.out.println("You Entered a wrong password Chances Remaining : " + (chances - 1));
                        chances--;
                    }


                }
                System.out.println("---No More Attempts---\n");
            }

        }

        if (!flag) {
            System.out.println("----UserId does not exist----\n");

        }


    }


    //function to update the user information in the csv File
    public static void updateUserInCSV(User user) {
        String userDataFile = "G:\\java\\weeklyasignment\\onlineVotingsystem\\New Microsoft Excel Worksheet.csv";

        String updatedUserInfo = user.getUserID() + "," + user.getUserPassword() + "," + user.getUserName();
        updateVotersList(user);
        updateEmployeeList(user);


        List<String> lines = new ArrayList<>();

        // Read the contents of the CSV file and update the information of the specified user
        try (BufferedReader csvReader = new BufferedReader(new FileReader(userDataFile))) {
            String currentLine;
            while ((currentLine = csvReader.readLine()) != null) {
                String[] userDetails = currentLine.split(",");
                if (Objects.equals(user.getUserID(), userDetails[0])) {
                    lines.add(updatedUserInfo);
                } else {
                    lines.add(currentLine);
                }
            }
            System.out.println("---File Updated Successfully---\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Write the updated list back to the CSV file
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(userDataFile))) {
            for (String line : lines) {
                csvWriter.write(line);
                csvWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //function to update the information of User
    private static void updateVotersList(User user) {


        for (User u : RegisteredUser) {
            if (u.getUserID().equals(user.getUserID())) {
                RegisteredUser.remove(u); // Remove the existing user with the same ID
                RegisteredUser.add(user); // Add the updated user to the voters list
                break; // Break the loop to avoid ConcurrentModificationException
            }
        }


    }

    private static void updateEmployeeList(User user) {
        for (User employee : employees) {
            if (employee.getUserID().equals(user.getUserID())) {
                employees.remove(employee);
                employees.add(user);
            }
        }
    }


    //function to display the Registered user
    public static void displayRegisteredUsers() {
        if (!RegisteredUser.isEmpty()) {
            System.out.println("Registered Users:");
            for (User user : RegisteredUser) {
                System.out.println(user);
            }
        } else {
            System.out.println("----No Registered Users to Display----\n");
        }
    }


    //function for Voting

    public static void Voting(String userId) {
        Scanner scanner = new Scanner(System.in);

        // Check if the user is registered
        boolean isRegistered = false;
        User currentUser = null;
        for (User user : RegisteredUser) {
            if (user.getUserID().equals(userId)) {
                isRegistered = true;
                System.out.println("Enter the Password : ");
                String password = scanner.nextLine();
                if (!user.getUserPassword().equals(password)) {
                    System.out.println("---Wrong Password---\n");
                    return;
                }
                currentUser = user;
                break;
            }
        }

        if (!isRegistered) {
            System.out.println("---User not registered---");
            System.out.println("-----Do Registration before Voting----\n");
            return;
        }

        // Check if the user has already voted
        if (Voter.get(currentUser)) {
            System.out.println("---You already voted---\n");
            return;
        }

        // Display candidate information for voting
        if (!candidates.isEmpty()) {
            System.out.println("Candidates List:");
            for (Candidate candidate : candidates) {
                System.out.println("Name : "+candidate.getName()+"Party : "+candidate.getPartyAffiliation()+"Voting Symbol : "+candidate.getVotingSymbol());
            }
        } else {
            System.out.println("----No Candidates to Vote----\n");
            return;
        }

        System.out.println("Enter voting symbol of the candidate to vote: ");
        String votingSymbol = scanner.nextLine();

        // Find the candidate corresponding to the entered voting symbol
        Candidate selectedCandidate = null;
        for (Candidate candidate : candidates) {
            if (candidate.getVotingSymbol().equals(votingSymbol)) {
                selectedCandidate = candidate;
                break;
            }
        }

        if (selectedCandidate != null) {
            Party.put(selectedCandidate, Party.getOrDefault(selectedCandidate, 0) + 1);
            System.out.println("----Vote casted successfully----\n");
            Voter.put(currentUser, true); // Record that the user has voted
        } else {
            System.out.println("---Invalid voting symbol---\n");
        }
    }


    //function to display the available parties

    public static void displayCandidates() {
        if (!candidates.isEmpty()) {
            System.out.println("\t\tCandidates List:\n");
            for (Candidate candidate : candidates) {
                System.out.println("Name: " + candidate.getName());
                System.out.println("Party Affiliation: " + candidate.getPartyAffiliation());
                System.out.println("Voting Symbol: " + candidate.getVotingSymbol());
                System.out.println();
            }
        } else {
            System.out.println("No Candidates to Display\n");
        }
    }


    //function to display the election result
    public static void showElectionResults() {

        List<Map.Entry<Candidate, Integer>> sortedEntries = new ArrayList<>(Party.entrySet());

        // Sort the list based on the values (votes) in descending order
        Collections.sort(sortedEntries, new Comparator<Map.Entry<Candidate, Integer>>() {
            @Override
            public int compare(Map.Entry<Candidate, Integer> o1, Map.Entry<Candidate, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); // Descending order
            }
        });

        // Print the sorted list
        for (Map.Entry<Candidate, Integer> entry : sortedEntries) {
            System.out.println("Candidate: " + entry.getKey().getName() + ", Votes: " + entry.getValue());
        }


        // Determine the winner(s) (candidate(s) with the most votes)
        if (!sortedEntries.isEmpty()) {
            // Find the highest number of votes
            int maxVotes = sortedEntries.get(0).getValue();

            // Print all candidates with the highest number of votes
            System.out.println("\n\n-------Winners-------");
            for (Map.Entry<Candidate, Integer> entry : sortedEntries) {
                if (entry.getValue() == maxVotes) {
                    System.out.println(entry.getKey().getName() + " (Votes: " + entry.getValue() + ")\n");
                } else {
                    // Since the list is sorted, once we reach an entry with fewer votes, we can break the loop
                    break;
                }
            }
        } else {
            System.out.println("---No winner yet---\n");
        }
    }


    //function to remove Registered user
    public static void removeRegisteredUser(String userId) {
        Iterator<User> iterator = RegisteredUser.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUserID().equals(userId)) {
                iterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
                System.out.println("---Registered user removed successfully---\n");
                return;  // Return after removing the user
            }
        }
        System.out.println("----User Not Registered---\n");
    }


    // New function to display voting status of registered users
    public static void displayVotingStatus() {
        boolean anyUserLeftForVoting = false;
        boolean anyoneVoted = false;

        for (User user : RegisteredUser) {
            if (!Voter.getOrDefault(user, false)) {
                anyUserLeftForVoting = true;
                break;
            }
        }

        if (anyUserLeftForVoting) {
            System.out.println("Registered users who have not voted yet:");
            for (User user : RegisteredUser) {
                if (!Voter.getOrDefault(user, false)) {
                    System.out.println(user.getUserName() + " (" + user.getUserID() + ")");
                }
            }
        } else {
            System.out.println("No users left for voting.");
        }

        System.out.println("\nRegistered users who have already voted:");
        for (User user : RegisteredUser) {
            if (Voter.getOrDefault(user, false)) {
                anyoneVoted = true;
                System.out.println("Name : " + user.getUserName() + "\nUserID : " + user.getUserID());
            }
        }

        if (!anyoneVoted) {
            System.out.println("No one has voted yet.");
        }
    }



}
