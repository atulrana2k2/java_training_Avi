import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Abstract class representing an item in the library
abstract class Item {
    private int id;
    private String title;
    private String author;

    public Item(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    //  method to display item details abstract function defined in child classes

    public abstract void displayDetails();
}

// class representing a book inherited from Item class
class Book extends Item {
    private String isbn;

    public Book(int id, String title, String author, String isbn) {
        super(id, title, author);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getIsbn());
    }
}

//  class representing a magazine inherited by Item class
class Magazine extends Item {
    private int issueNumber;

    public Magazine(int id, String title, String author, int issueNumber) {
        super(id, title, author);               //calling the constructor of parent class to add the values
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine Name: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Issue Number: " + getIssueNumber());
    }
}

// Interface for items that can be checked out
interface CheckOutable {
    void checkOut();
    void returnItem();
}

// Class representing a library member
class LibraryMember {
    private int memberId;
    private String name;

    public LibraryMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void checkOutItem(CheckOutable item) {
        item.checkOut();
    }

    public void returnItem(CheckOutable item) {
        item.returnItem();
    }
}

// Class representing the library
class Library {
    private Map<Integer, Item> inventory;
    private Map<Integer, LibraryMember> members;

    public Library() {
        inventory = new HashMap<>();
        members = new HashMap<>();
    }

    public void addItem(Item item) {
        inventory.put(item.getId(), item);
    }

    public void registerMember(LibraryMember member) {
        members.put(member.getMemberId(), member);
    }

    public void checkOutItem(int memberId, int itemId) {
        LibraryMember member = members.get(memberId);
        Item item = inventory.get(itemId);
        if (member != null && item != null && item instanceof CheckOutable) {
            member.checkOutItem((CheckOutable) item);
        }
    }

    public void returnItem(int memberId, int itemId) {
        LibraryMember member = members.get(memberId);
        Item item = inventory.get(itemId);
        if (member != null && item != null && item instanceof CheckOutable) {
            member.returnItem((CheckOutable) item);
        }
    }

    public void displayItemDetails(int itemId) {
        Item item = inventory.get(itemId);
        if (item != null) {
            item.displayDetails();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); /* consume newline  character becaus scanner does
                                    not read enter or newline char from input stream*/

            switch (choice) {
                case 1:
                    addNewItem(library, scanner);
                    break;
                case 2:
                    registerMember(library, scanner);
                    break;
                case 3:
                    checkOutItem(library, scanner);
                    break;
                case 4:
                    returnItem(library, scanner);
                    break;
                case 5:
                    displayItemDetails(library, scanner);
                    break;
                case 6:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number from 1 to 6.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add new item to the library");
        System.out.println("2. Register a new library member");
        System.out.println("3. Check out an item");
        System.out.println("4. Return an item");
        System.out.println("5. Display item details");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addNewItem(Library library, Scanner scanner) {
        System.out.println("\nAdding new item to the library");
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character because scanner does not read enter or newline character

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter item type (1 for Book, 2 for Magazine): ");
        int itemType = scanner.nextInt();
        scanner.nextLine();

        switch (itemType) {             //to take type of book as A book or magazine
            case 1:
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                library.addItem(new Book(id, title, author, isbn));         //add information for book new instance
                System.out.println("Book added successfully.");
                break;
            case 2:
                System.out.print("Enter issue number: ");
                int issueNumber = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                library.addItem(new Magazine(id, title, author, issueNumber)); //add information of magzine instance
                System.out.println("Magazine added successfully.");
                break;
            default:
                System.out.println("Invalid item type.");
        }
    }

    private static void registerMember(Library library, Scanner scanner) {
        System.out.println("\nRegistering a new library member");
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        library.registerMember(new LibraryMember(memberId, name));          //add the informatin of library mem
        System.out.println("Member registered successfully.");
    }

    private static void checkOutItem(Library library, Scanner scanner) {
        System.out.println("\nChecking out an item");
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        library.checkOutItem(memberId, itemId);
        System.out.println("Item checked out successfully.");
    }

    private static void returnItem(Library library, Scanner scanner) {
        System.out.println("\nReturning an item");
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        library.returnItem(memberId, itemId);
        System.out.println("Item returned successfully.");
    }

    private static void displayItemDetails(Library library, Scanner scanner) {
        System.out.println("\nDisplaying item details");
        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        library.displayItemDetails(itemId);
    }
}

