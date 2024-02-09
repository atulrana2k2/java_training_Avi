import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Product class
abstract class Product {
    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {               //constructor for initalizing the value of objects

        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculateFinalPrice();                       //abstract function define d in other class
}

// Electronics class inheriting Product
class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(int productId, String productName, double price, int warrantyPeriod) {       //constructor adding values to variable for child and base class
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public double calculateFinalPrice() {

        return getPrice(); //  returning the original price
    }
}

// Clothing class inheriting Product
class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(int productId, String productName, double price, String size, String color) {
        super(productId, productName, price);                   //initalizing all the varibale of child and base class
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public double calculateFinalPrice() {

        return getPrice(); //  returning the original price
    }
}

// User interface
interface User {
    void browseProducts();
    void addToCart(Product product);
    void placeOrder();
}

// RegisteredUser class implementing User
class RegisteredUser implements User {
    String username;
    private List<Product> cart;
    private List<Order> orderHistory;

    public RegisteredUser(String username) {
        this.username = username;
        this.cart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public void browseProducts() {
        // Logic to browse products
        System.out.println("Browsing products...");
    }

    @Override
    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " added to cart.");
    }

    @Override
    public void placeOrder() {
        Order order = new Order(this.cart);
        orderHistory.add(order);
        System.out.println("Order placed successfully.");
        cart.clear();
    }
}

// Order class
class Order {
    private List<Product> products;
    private double totalAmount;

    public Order(List<Product> products) {
        this.products = products;
        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.calculateFinalPrice();
        }
    }
}

public class Onlinesystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Product> products = new HashMap<>();
        List<User> users = new ArrayList<>();

//        boolean running = true;
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1. Add Product");
            System.out.println("2. Register User");
            System.out.println("3. Browse Products");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.println("Enter product details:");
                    System.out.println("Product ID:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Product Name:");
                    String productName = scanner.nextLine();
                    System.out.println("Price:");
                    double price = scanner.nextDouble();
                    System.out.println("CATEGORY OF PRODUCT:"+'\n'+"Enter 1 for Electronics "+'\n'+"Enter 2 for Clothing :");
                    int category = scanner.nextInt();

                    if (category == 1) {
                        System.out.println("Warranty Period In years:");
                        int warrantyPeriod = scanner.nextInt();
                        products.put(productId, new Electronics(productId, productName, price, warrantyPeriod));
                    } else if (category == 2) {
                        System.out.println("Size:");
                        String size = scanner.next();
                        System.out.println("Color:");
                        String color = scanner.next();
                        products.put(productId, new Clothing(productId, productName, price, size, color));
                    }
                    System.out.println("Product is added successfully");
                    break;
                case 2:
                    // Register User
                    System.out.println("Enter username:");
                    String username = scanner.next();
                    users.add(new RegisteredUser(username));
                    System.out.println("User added sucessfully \n");
                    break;
                case 3:
                    // Browse Products
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("Products available:");
                        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                            System.out.println("Product Id : " + entry.getKey() + "\nProduct Name : " + entry.getValue().getProductName() +
                                    "\nPrice:" + entry.getValue().getPrice() + "$");
                        }
                    }
                    break;
                case 4:
                    // Add Product to Cart
                    System.out.println("Enter user's username:");
                    String user = scanner.next();
                    boolean userFound = false;
                    for (User u : users) {
                        if (u instanceof RegisteredUser && ((RegisteredUser) u).username.equals(user)) {
                            userFound = true;
                            break;
                        }
                    }
                    if (!userFound) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.println("Enter product ID to add to cart:");
                    int productID = scanner.nextInt();
                    Product productToAdd = products.get(productID);
                    if (productToAdd != null) {
                        for (User u : users) {
                            if (u instanceof RegisteredUser && ((RegisteredUser) u).username.equals(user)) {
                                u.addToCart(productToAdd);
                            }
                        }
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    // Place Order
                    System.out.println("Enter user's username to place order:");
                    String usernameForOrder = scanner.next();
                    boolean userFoundForOrder = false;
                    for (User u : users) {
                        if (u instanceof RegisteredUser && ((RegisteredUser) u).username.equals(usernameForOrder)) {
                            userFoundForOrder = true;
                            break;
                        }
                    }
                    if (!userFoundForOrder) {
                        System.out.println("User not found.");
                        break;
                    }

                    // Ask for product ID
                    System.out.println("Enter product ID to place order:");
                    int productIDToOrder = scanner.nextInt();
                    Product productToOrder = products.get(productIDToOrder);
                    if (productToOrder == null) {
                        System.out.println("Product not found.");
                        break;
                    }

                    for (User u : users) {
                        if (u instanceof RegisteredUser && ((RegisteredUser) u).username.equals(usernameForOrder)) {
                            u.placeOrder();
                        }
                    }
                    // Display the price of the ordered product
                    System.out.println("ordered product:"+productToOrder.getProductName() +"\nPrice " + productToOrder.getPrice()+" $");
                    break;
                case 6:
                    System.out.println("Exit of Program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }


    }
}
