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
                        System.out.println("Pick any One Option ");
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

//add task
                    if (option.equals("1") || option.equals("+"))
                    {
                        boolean exit=false;
                        while(!exit){
                        boolean taskIsNotFull = false;
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] == null) {
                                taskIsNotFull = true;
                                break;
                            }
                        }
                        System.out.println("Available Tasks ");
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] != null) {
                                System.out.print(i + 1 + ".");
                                System.out.println(currentUser.getTaskArray()[i].getTitle());
                            }
                        }

                        if (taskIsNotFull == true)
                        {
                            try {
                                System.out.println("Enter the Title:");
                                String title = sc.nextLine();
                                if (title.isEmpty()) {
                                    System.out.println("Title Should not be Empty");
                                    continue;
                                }
                                if (title.equals("exit")) {
                                    throw new Exception();
                                }
                                Task task = new Task(title);

                                for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                    if (currentUser.getTaskArray()[i] == null) {
                                        currentUser.getTaskArray()[i] = task;// address task to user
                                        break;
                                    }
                                }
                                System.out.println("Task is created ");

                                String descriptionOption = null;
                                boolean descriptionFg = false;
                                while (!descriptionFg) {
                                        System.out.println("If you Want to Add Description : Yes || No ");
                                        descriptionOption = sc.nextLine();
                                        if (descriptionOption.isEmpty()) {
                                        System.out.println("Description Should not be empty! ");
                                        continue;
                                        }
                                        else if (descriptionOption.equals("No")) {
                                            descriptionFg = true;
                                        }
                                        else if (descriptionOption.equals("exit")) {
                                            throw new Exception();
                                        }
                                        else if (descriptionOption.equals("Yes")) {
                                            System.out.println("Add the Description");
                                            String description = sc.nextLine();
                                            if(description.isEmpty()){
                                                continue;
                                            }
                                            if(description.equals("exit")){
                                                throw new Exception();
                                            }

                                            task.setDescription(description);
                                            descriptionFg=true;
                                        }
                                        else{
                                            System.out.println("Enter Only Yes or No ");
                                        }
                                }
                                int n = 1;
                                for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                    if (currentUser.getTaskArray()[i] != null) {
                                        System.out.print(n + ".");
                                        System.out.println(currentUser.getTaskArray()[i].getTitle());
                                        if (descriptionOption.equals("Yes")) {
                                            System.out.println(currentUser.getTaskArray()[i].getDescription());
                                        }
                                        n++;
                                    }
                                }


                            } catch (Exception e)
                            {
                                exit=true;
                                System.out.println("Exit");
                            }
                        }
                        else {
                            System.out.println("Maximum Task is full ");
                            break;
                        }
                        }
                    }

// Show All Tasks
                    if (option.equals("2")) {
                        boolean showTasks = false;
                        System.out.println("===  All task List === ");
                        while (!showTasks) {

                            String showTasksOption = null;
                            try {
                                System.out.println("List of Available Tasks");
                                for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                    if (currentUser.getTaskArray()[i] != null) {
                                        System.out.print(i + 1 + ". ");
                                        System.out.println(currentUser.getTaskArray()[i].getTitle());
                                    }
                                }
                                if (currentUser.getTaskArray() != null) {

                                    System.out.println("Pick any number to Show");
                                    System.out.println("1.Show all Task ");
                                    System.out.println("2.Show all Todo");
                                    System.out.println("3.Show all In-progress");
                                    System.out.println("4.Show all Done");


                                    boolean corretOption = false;
                                    while (!corretOption) {
                                        try {

                                            showTasksOption = sc.nextLine();
                                            if (showTasksOption.isEmpty()) {
                                                System.out.println("Option Should Not empty ");
                                                System.out.println("Pick the correct Option ( 1 to 4 )");
                                                continue;
                                            }
                                            if (showTasksOption.equals("exit")) {
                                                throw new Exception();
                                            }

                                        } catch (Exception e) {
                                            if (showTasksOption.isEmpty()) {
                                                System.out.println("=== Enter the valid option first ===");

                                            }
                                            if (showTasksOption.equals("exit")) {
                                                showTasks = true;
                                                System.out.println("Exit");
                                                break;
                                            }
                                        }

                                        if (showTasksOption.equals("1")) {
                                            System.out.println("All Tasks ");
                                            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                                if (currentUser.getTaskArray()[i] != null) {
                                                    System.out.print(i + 1 + ". ");
                                                    System.out.print(currentUser.getTaskArray()[i].getTitle());
                                                    System.out.print(" <");
                                                    System.out.print(currentUser.getTaskArray()[i].getStatus());
                                                    System.out.println(">");
                                                }
                                            }
                                            corretOption = true;

                                        } else if (showTasksOption.equals("2")) {
                                            System.out.println("All Task Todo ");
                                            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                                if (currentUser.getTaskArray()[i] != null) {
                                                    if (currentUser.getTaskArray()[i].getStatus().equals("Todo")) {
                                                        System.out.print(i + 1 + ". ");
                                                        System.out.println(currentUser.getTaskArray()[i].getStatus());
                                                    }
                                                }
                                            }
                                            corretOption = true;

                                        } else if (showTasksOption.equals("3")) {
                                            System.out.println("All Tasks In-Progress");
                                            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                                if (currentUser.getTaskArray()[i] != null) {
                                                    if (currentUser.getTaskArray()[i].getStatus().equals("In-Progress")) {
                                                        System.out.print(i + 1 + ". ");
                                                        System.out.println(currentUser.getTaskArray()[i].getStatus());
                                                    }
                                                }
                                            }
                                            corretOption = true;

                                        } else if (showTasksOption.equals("4")) {
                                            System.out.println("All Tasks Done");
                                            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                                                if (currentUser.getTaskArray()[i] != null) {
                                                    if (currentUser.getTaskArray()[i].getStatus().equals("Done")) {
                                                        System.out.print(i + 1 + ". ");
                                                        System.out.println(currentUser.getTaskArray()[i].getStatus());
                                                    }
                                                }
                                            }
                                            corretOption = true;

                                        } else {
                                            System.out.println("=== Enter the valid Option First ( 1 to 4 ) ===");
                                        }

                                    }
                                }else{
                                    System.out.println("Task is not here To Show");
                                    showTasks=true;
                                }

                            } catch (Exception e) {
                                if (showTasksOption.equals("exit")) {
                                    System.out.println("Exit");
                                    showTasks = true;

                                }
                            }
                        }
                    }








                    if (option.equals("3")) {
                        System.out.println("Update the Task");
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] != null) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(currentUser.getTaskArray()[i].getTitle());
                            }
                        }
                        System.out.println("Enter the Option want to Update");
                        String updateOption = sc.nextLine();

                        System.out.println("What You want to Update Title || Description ");
                        String titleOrDescription = sc.nextLine();
                        Integer numberUpdateOption = new Integer(updateOption);

                        if (titleOrDescription.equals("Title")) {
                            System.out.print("Enter the Title: ");
                            String updateTitle = sc.nextLine();
                            currentUser.getTaskArray()[numberUpdateOption - 1].setTitle(updateTitle);
                            System.out.println("Title is Updated");
                        }
                        if (titleOrDescription.equals("Description")) {
                            System.out.print("Enter the Description: ");
                            String updateDescription = sc.nextLine();
                            currentUser.getTaskArray()[numberUpdateOption - 1].setDescription(updateDescription);
                            System.out.println("Description is Updated");
                        }
                        System.out.println("=====================");


                    }


                    if (option.equals("4")) {
                        System.out.println("Delete the Task");
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] != null) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(currentUser.getTaskArray()[i].getTitle());
                            }
                        }
                        System.out.println("Pick any one to delete");
                        String deleteOption = sc.nextLine();
                        Integer deleteNumOption = new Integer(deleteOption);
                        currentUser.getTaskArray()[deleteNumOption - 1] = null;

                        Task[] temporaryArray = currentUser.getTaskArray();
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] == null) {
                                currentUser.getTaskArray()[i] = temporaryArray[deleteNumOption - 1];
                            }
                        }

                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i] != null) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(currentUser.getTaskArray()[i].getTitle());
                            }
                        }

                        System.out.println();


                    }

                    if (option.equals("5") || option.equals("X")) {
                        System.out.println("You Exit ");
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("===XXX Exit XXX===");
                    System.out.println("Come Again next Time");
                    break;
                }
            }



        }
    }
}
