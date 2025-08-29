package oopproject;
public class Admin extends user {
    private boolean loggedIn = false;
    public Admin(String userID, String name, String contact, String email, String password, String role) {
        super(userID, name, contact, email, password, "Admin");
    }
   public void adminLogin(String email, String password) {
       if (login(email, password)) {
            loggedIn = true;
            System.out.println("ADMIN ACCESS GRANTED");
        } else {
            loggedIn = false;
            System.out.println("Invalid Credentials");
        }
    }
  
   public boolean isLoggedIn() {
        return loggedIn;
    }

}
   