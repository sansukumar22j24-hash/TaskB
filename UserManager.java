package TaskCli;

import java.util.Scanner;

public class UserManager implements UserManagerInterface {
    Scanner sc = new Scanner(System.in);
    UserInterface[] users = new User[4];


    public UserInterface login(){
        System.out.println("====== Welcome To Task Manager =====");
        UserInterface currentUser = null;
        boolean nameChecking=false;
        while(!nameChecking) {
            String name = null;
            try {
                System.out.print("Enter Your name: ");
                name = sc.nextLine();
                if (name.isEmpty()) {
                    throw new Exception();
                }


                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        continue;
                    }
                    if (users[i].getName().equals(name)) {
                        currentUser = users[i];
                        System.out.println("User is already Exist! ");
                        System.out.println("Welcome Back -_- ");
                        break;
                    }
                }
                if (currentUser == null) {
                    currentUser = new User(name);
                    for (int i = 0; i < users.length; i++) {
                        if (users[i] == null) {
                            users[i] = currentUser;
                            break;
                        }
                    }
                }
                nameChecking=true;

            } catch (Exception e) {
                if (name.isEmpty()) {
                    System.out.println("Name should not be Empty! ");
                }

            }
        }
        return currentUser;
    }
}
