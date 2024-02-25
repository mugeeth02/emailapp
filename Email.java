package emailapp;
import java.util.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "abccompany.com";

    //Constructor to receive the firstName and lastName
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " +  this.firstName +" "+ this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

//         Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " +firstName + ".DEPARTMENT CODES\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for none\n Enter Department Code  : ");
        Scanner obj = new Scanner(System.in);
        int deptChoice = obj.nextInt();
        if (deptChoice == 1) {
            return "sales";
        } else if (deptChoice == 2) {
            return "dev";
        } else if (deptChoice == 3) {
            return "acc";
        } else {
            return " ";
        }
    }

//        Generate a random password
        private String randomPassword(int length){
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
            char[] password = new char[length];
            for(int i=0; i<length; i++){
                int rand = (int)(Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);
            }
            return new String(password);
        }

        //Set the mailboxCapacity
        public void setMailboxCapacity(int capacity){
            this.mailboxCapacity = capacity;
        }

        //Set the alternateMail
        public void setAlternateEmail(String altEmail){
            this.alternateEmail = altEmail;
        }

        //Change the password
        public void changePassword(String Password){
            this.password = Password;
        }

        public int getMailboxCapacity(){ return mailboxCapacity; }
        public String getAlternateEmail(){ return alternateEmail; }
        public String getpassword(){ return password; }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: " + mailboxCapacity;
    }

}
