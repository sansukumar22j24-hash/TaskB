package TaskCli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[4];
        User currentUser = null;
        String option="0";

        while (true) {
            System.out.println("====== Welcome To Task Manager =====");
            System.out.print("Enter Your name: ");
            String name = sc.nextLine();


            boolean isUserExist=false;
            int pos=0;
            for (int i = 0; i <users.length ; i++) {
                if(users[i]==null){
                    continue;
                }
                if (users[i].getName().equals(name)){
                    isUserExist=true;
                    pos=i;
                    break;
                }
            }
            if(isUserExist == false) {
                currentUser = new User(name);
                for (int i = 0; i < users.length; i++) {
                    if(users[i]==null){
                        users[i]=currentUser;
                        break;
                    }

                }
            }
            if(isUserExist == true){
                currentUser=users[pos];
                System.out.println("User is already Exist! ");
            }

            while (option !="5") {
                System.out.println("Enter the Options");
                System.out.println("1.(+) Add Task");
                System.out.println("2.Show All Task");
                System.out.println("3.Update Task");
                System.out.println("4.Delete Task");
                System.out.println("5.(X) Exit");
                System.out.print("=> ");
                option = sc.nextLine();

                if (option.equals("1") || option.equals("+")) {
                    System.out.println("Enter the Title:");
                    String title=sc.nextLine();
                    Task task = new Task(title);
                    System.out.println("If you Want to Add Description : Yes || No ");
                    String descriptionOption=sc.nextLine();
                    if(descriptionOption.equals("Yes")) {
                        System.out.println("Add the Description");
                        String description = sc.nextLine();
                        task.setDescription(description);
                    }

                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i] == null) {
                            currentUser.getTaskArray()[i] = task;// address task to user
                            System.out.println(currentUser.getTaskArray()[i].getTitle());
                            if(descriptionOption.equals("Yes")) {
                                System.out.println(currentUser.getTaskArray()[i].getDescription());
                            }
                            break;
                        }
                    }
                    System.out.println("Task is created ");
                }


                if(option.equals("2")){
                    System.out.println("List of Available Tasks");
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] != null) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(currentUser.getTaskArray()[i].getTitle());
                            }
                        }

                }



                if(option.equals("3")){
                    System.out.println("Update the Task");
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i] != null) {
                            System.out.print(i + 1 + ". ");
                            System.out.println(currentUser.getTaskArray()[i].getTitle());
                        }
                    }
                    System.out.println("Enter the Option want to Update");
                    String updateOption=sc.nextLine();

                    System.out.println("What You want to Update Title || Description ");
                    String titleOrDescription= sc.nextLine();
                    Integer numberUpdateOption=new Integer(updateOption);

                    if(titleOrDescription.equals("Title")) {
                        System.out.print("Enter the Title: ");
                        String updateTitle = sc.nextLine();
                        currentUser.getTaskArray()[numberUpdateOption-1].setTitle(updateTitle);
                        System.out.println("Title is Updated");
                    }
                    if(titleOrDescription.equals("Description")) {
                        System.out.print("Enter the Description: ");
                        String updateDescription = sc.nextLine();
                        currentUser.getTaskArray()[numberUpdateOption-1].setDescription(updateDescription);
                        System.out.println("Description is Updated");
                    }
                    System.out.println("=====================");



                }



                if(option.equals("4")){
                    System.out.println("Delete the Task");
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i]!= null){
                            System.out.print(i + 1 + ". ");
                            System.out.println(currentUser.getTaskArray()[i].getTitle());
                        }
                    }
                    System.out.println("Pick any one to delete");
                    String deleteOption=sc.nextLine();
                    Integer deleteNumOption=new Integer(deleteOption);
                    currentUser.getTaskArray()[deleteNumOption-1]=null;
                    Task[] temporaryArray= currentUser.getTaskArray();

                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i] ==null){
                            currentUser.getTaskArray()[i]=temporaryArray[deleteNumOption-1];
                        }
                    }
                    int n=0;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i]!= null){
                            System.out.print(n + 1 + ". ");
                            System.out.println(currentUser.getTaskArray()[i].getTitle());
                        }
                        n++;
                    }

                System.out.println();


                }

                if (option.equals("5") || option.equals("X")) {
                    System.out.println("You Exit ");
                   break;
                }

            }


        }
    }
}
