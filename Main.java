package TaskCli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserManagerInterface userManager=new UserManager();
        while (true) {
            UserInterface currentUser = userManager.login();
            String option="0";

            while (option !="5") {
                System.out.println("Enter the Options");
                System.out.println("1.(+) Add Task");
                System.out.println("2.Show All Task");
                System.out.println("3.Update Task");
                System.out.println("4.Delete Task");
                System.out.println("5.(X) Exit");
                System.out.print("=> ");
                option = sc.nextLine();
                try {
                    if (option.isEmpty()) {
                        System.out.println("Option should not be Empty ");
                        System.out.print("Pick any One Option");
                        System.out.println(" ");
                        continue;
                    }
                    if (option.equals("exit")) {
                        throw new Exception();
                    }
                    try {
                        Integer options=new Integer(option);
                        if(options<1 || options>5){
                            throw new Exception();
                        }

                    }
                    catch (Exception e) {
                        System.out.println("=== Enter the Valid Option (1 to 5) ===");
                        continue;
                    }

                    TaskManagerInterface taskManager=new TaskManager();
                    if (option.equals("1") || option.equals("+"))
                    {
                        taskManager.addTask(currentUser);
                    }
                    else if (option.equals("2")) {
                        taskManager.showTask(currentUser);
                    }
                    else if (option.equals("3")) {
                        taskManager.updateTask(currentUser);
                    }
                   else  if (option.equals("4")) {
                        taskManager.deleteTask(currentUser);
                    }
                    else if (option.equals("5") || option.equals("X")) {
                        System.out.println("You Exit ");
                        break;
                    }
                    else {
                        System.out.println("Invalid Option");
                    }

                } catch (Exception e) {
                    System.out.println("===-- Exit --===");
                    System.out.println("Come Again next Time");
                    break;
                }
            }



        }
    }
}
