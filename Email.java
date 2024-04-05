package EmailApplication;

import java.util.Scanner;

public class Email {
    private String FirstName;
    private String LastName;
    private String password;
    private int Defaultpasswordlength = 10;
    private String Department;
    private String email;
    private int MailboxCapacity = 500;
    private String alternateEmail;
    private String CompanySuffix = "aeycompany.com";

    // constructor for recive the first name and lastname
    public Email(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;

        // Call Methode asking for the deapartment - return the department
        this.Department = Setdepartment();

        // Call a Methode that return a random password
        this.password = randomPassword(Defaultpasswordlength);
        System.out.println("Your password is : " + this.password);

        // Combine elements to genrate email
        email = FirstName.toLowerCase() + "." + LastName.toLowerCase() + "@" + Department + "." + CompanySuffix;


    }

    // ask for the Department
    private String Setdepartment() {
        System.out.println("New Worker : "+FirstName+". Department Codes:\n1.For sales\n2.For Devlopement\n3.For Accounting");
        System.out.print("Enter the Department Code:");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        sc.close();
        switch (depChoice) {
            case 1:
                return "sales";
            case 2:
                return "Devlopement";
            case 3:
                return "Accouting";
            default:
                return "none";
        }
        
    }


    // Genrate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXWXYZ123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void SetMailBoxCapacity(int capacity) {
        this.MailboxCapacity = capacity;
    }

    // set the alternate eamil
    public void SetAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change the password
    public void ChangePassword(String password) {
        this.password = password;
    }

    public int GetMailBoxCapacity() {
        return MailboxCapacity;
    }

    public String GetAlternateEmail() {
        return alternateEmail;
    }

    public String GetPassword() {
        return password;
    }

    public String ShowInfo() {
        return "\nDisplay Name : " + FirstName + " " + LastName + "\nCompany Email : " + email + "\nMailBox Capacity : "
                + MailboxCapacity + "mb";
    }
}
