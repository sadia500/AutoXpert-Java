package oopproject;

public class user {
    protected String userID;
    protected String password;
    protected String name;
    protected String contact;
    protected String email;
    protected String role;
    protected String address;

    public user(String userID, String name, String contact, String email, String password, String role) {
        this.userID = userID;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }
     public String getContact() {
        return contact;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }
    public String setName(String text) {
        return name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String inputEmail, String inputPassword) {
        return email.equals(inputEmail) && password.equals(inputPassword);
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    public void updateProfile(String newContact, String newEmail, String newPassword) {
        this.contact = newContact;
        this.email = newEmail;
        this.password = newPassword;
        System.out.println("Profile updated for: " + name);
    }

    public void viewProfile() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }
}