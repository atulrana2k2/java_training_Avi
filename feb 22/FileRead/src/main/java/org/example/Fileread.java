package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Fileread {

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter Type of file : ");
                System.out.println("1: csv File : ");
                System.out.println("2: json File : ");
                System.out.println("3: xml file : ");
                System.out.println("Enter Your Choice :");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the Path of the Csv File :");
                        String PathCsv = sc.next();
                        if (PathCsv.substring((PathCsv.length() - 3)).equals("csv")) {
                            System.out.println("File is Validated");
                            List<Employee> employees;
                            employees = FileReadcsv(PathCsv);
                            System.out.println("File Read SuccessFully");
                            if (employees != null) {
                                for (Employee employee : employees) {
                                    System.out.println(employee);
                                }
                            }
                            try (BufferedWriter bf = new BufferedWriter(new FileWriter("abc.json"))) {
                                bf.write("First Name,Last Name,Salary");
                                bf.newLine();
                                for (Employee employee : employees) {
                                    bf.write(String.valueOf(employee));

                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        } else {
                            System.out.println("Invalid File Type");
                        }
                        break;

                    case 2:
                        System.out.println("Enter the Path of Json File : ");
                        String PathJson = sc.next();
                        if (PathJson.substring((PathJson.length() - 4)).equals("json")) {
                            System.out.println("File Is Validated");
                            Readjsonfile(PathJson);
                        } else
                            System.out.println("Invalid File Type");
                        break;

                    case 3:
                        System.out.println("Enter the Path of Xml File : ");
                        String PathXml = sc.next();
                        if (PathXml.substring((PathXml.length() - 3)).equals("xml")) {
                            System.out.println("File Is Validated");
                            ReadXmlFile(PathXml);
                        } else
                            System.out.println("Invalid File Type");
                        break;
                }
            }
        }
    static List<Employee> FileReadcsv(String FName) {
        File file = new File(FName);
        if (file.exists()) {
            List<Employee> employees = new ArrayList<>();
            try (BufferedReader bf = new BufferedReader(new FileReader(FName))) {
                String line;
                bf.readLine();
                // Read each line from the CSV file
                while ((line = bf.readLine()) != null) {
                    String[] data = line.split(","); // Split the line by comma (CSV format)
                    // Assuming the CSV structure is: name, age, salary;
                    String Name = (data[0]);
                    String lName = (data[1]);
                    String salary = (data[2]);
                    employees.add(new Employee(Name, lName, salary));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return employees;
        } else
            System.out.println("File Does Not Exist");
        return null;
    }

    public static void Readjsonfile(String PathJson) throws IOException {// Read the content of the JSON file into a string
                String content = new String(Files.readAllBytes(Paths.get(PathJson)));


                JSONArray jsonArray = new JSONArray(content);


                HashMap<String, Integer> map = new HashMap<>();
                int avg = 0;
        // Iterate through the JSON array and process each JSON object
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    // Now you can access the data using methods like getString(), getInt(), etc.
                    // For example:
                    String name = json.getString("name");
                    int mathsMarks = json.getInt("maths");
                    int phyMarks = json.getInt("physics");
                    int englishMarks = json.getInt("english");

                    int sum = mathsMarks + phyMarks + englishMarks / 3;
                    avg += sum;
                    map.put(name, sum);

                    System.out.println("Name:" + name + " Maths-Marks:" + mathsMarks + " Physics-Marks:" + phyMarks + " English-marks:" + englishMarks);

                    System.out.println();
                }

                avg /= jsonArray.length();


                System.out.println("Avg is: " + avg);
                JSONArray resultArray = new JSONArray();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    String name = entry.getKey();
                    int sum = entry.getValue();

                    if (sum > avg) {
                        // Create a JSON object for each student
                        JSONObject studentObject = new JSONObject();
                        studentObject.put("name", name);
                        studentObject.put("sum_of_marks", sum);

                        // Add the student object to the result array
                        resultArray.put(studentObject);
                    }
                }

                // Write the JSON array to a file
                FileWriter fileWriter = new FileWriter("result.json");
                fileWriter.write(resultArray.toString());
                fileWriter.close();

                System.out.println("Data written to result.json successfully to file : result.json ");

            }

                public static void ReadXmlFile(String PathXml)
                {
                    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
                    try{
                        DocumentBuilder builder=factory.newDocumentBuilder();
                        //get document
                        Document document  =builder.parse(new File(PathXml));
                        //normalize the xml file
                        document.getDocumentElement().normalize();
                        //get all the element by tag name
                        NodeList studentList = document.getElementsByTagName("student");
                        for (int i = 0; i < studentList.getLength(); i++) {
                            Node student = studentList.item(i);
                            if (student.getNodeType() == Node.ELEMENT_NODE) {
                                Element studentElement = (Element) student;
                                // Get student name
                                NodeList nameList = studentElement.getElementsByTagName("name");
                                Element nameElement = (Element) nameList.item(0);
                                String studentName = nameElement.getTextContent();
                                System.out.println("Student Name : " + studentName);

                                // Get student id
                                NodeList idList = studentElement.getElementsByTagName("id");
                                Element idElement = (Element) idList.item(0);
                                String studentId = idElement.getTextContent();
                                System.out.println("    ID : " + studentId);

                                // Get student marks
                                NodeList marksList = studentElement.getElementsByTagName("marks");
                                Element marksElement = (Element) marksList.item(0);
                                String studentMarks = marksElement.getTextContent();
                                System.out.println("    Marks : " + studentMarks);
                            }
                        }

                    } catch (ParserConfigurationException | SAXException | IOException e) {
                        throw new RuntimeException(e);
                    }

                }

        }

