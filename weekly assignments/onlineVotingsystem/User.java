package onlineVotingsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private String userID;
    private Date DateOFBirth;

    private String userName;

    private String userPassword;

    public User(String userID, Date dateOFBirth, String userName,String userPassword) {
        this.userID = userID;
        this.DateOFBirth=dateOFBirth;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDateOFBirth() {
        return DateOFBirth;
    }

    public void setDateOFBirth(Date dateOFBirth) {
        DateOFBirth = dateOFBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(" MMM dd yyyy");
        return "User{" +
                "userID=" + userID +
                ", DateOFBirth=" + sdf.format(DateOFBirth) +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                "}\n";
    }
}