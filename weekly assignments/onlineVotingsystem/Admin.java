package onlineVotingsystem;

import java.util.Scanner;


    public class Admin {

     private final String Name;
     private final String AdminID;

     private final String Password;

       public Admin() {
            Name = "Admin";
            AdminID = "AS100";
            Password = "Admin*123";
        }

        public String getName() {
            return Name;
        }

        public String getAdminID() {
            return AdminID;
        }

        public String getPassword() {
            return Password;
        }



    }

