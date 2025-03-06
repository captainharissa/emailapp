package emailapp;


import java.util.Scanner;
import javax.swing.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private String email;
    private int defaultPasswordlength = 10;
    private String company = "outlook.fr";

    //Constructor to receive first name and last
    public Email(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.department="";
        this.password = randomPassword(defaultPasswordlength);
        email = firstName.toLowerCase()+ "."+ lastName.toLowerCase()+"@"+ department + "." + company;
    }

    //Ask for department
    public String setDepartment(String depChoice){
        return switch (depChoice) {
            case "enseignant" -> "enseignant-unice";
            case "élève" -> "etu-unice";
            case "admin" -> "admin-unice";
            default -> "";
        };
    }

    public String getCompany(){
        return company;
    }

    public String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789&@*/-";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

}
