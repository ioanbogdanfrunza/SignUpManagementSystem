package signupmanagementsystem;

public class Guest {
    String lastName;
    String firstName;
    String email;
    String phoneNumber;
    
    public Guest(String lastName, String firstName, String email, String phoneNumber) { // constructor pentru clasa Guest
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
