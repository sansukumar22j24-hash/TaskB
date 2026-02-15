package TaskCli;

import java.util.Scanner;

public class TaskManager extends TaskManagerUtil implements TaskManagerInterface{
    Scanner sc=new Scanner(System.in);

    public void addTask(UserInterface currentUser){
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
            TaskManagerUtil.displayTitle(currentUser);

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
                } catch (Exception e)
                {
                    exit=true;
                    System.out.println("=== Exit ===");
                }
            }
            else {
                System.out.println("Maximum Task is full ");
                break;
            }
        }
    }



    //Show All Task

    public void showTask(UserInterface currentUser){
        boolean showTasks = false;
        System.out.println("===  All task List === ");
        while (!showTasks) {

            String showTasksOption = null;
            try {
                System.out.println("List of Available Tasks");
               TaskManagerUtil.displayTitle(currentUser);
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
                                System.out.println("=== Exit ===");
                                break;
                            }
                        }

                        if (showTasksOption.equals("1")) {
                            System.out.println("All Tasks ");
                            TaskManagerUtil.displayTitle(currentUser);
                            corretOption = true;


                        } else if (showTasksOption.equals("2")) {
                            System.out.println("All Task Todo ");
                            TaskManagerUtil.displayStatus(currentUser,"Todo");
                            corretOption = true;

                        } else if (showTasksOption.equals("3")) {
                            System.out.println("All Tasks In-Progress");
                            TaskManagerUtil.displayStatus(currentUser,"In-Progress");
                            corretOption = true;

                        } else if (showTasksOption.equals("4")) {
                            System.out.println("All Tasks Done");
                            TaskManagerUtil.displayStatus(currentUser,"Done");
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
                    System.out.println("=== Exit ===");
                    showTasks = true;

                }
            }
        }

    }


    // Update Task
    public void updateTask(UserInterface currentUser){
        System.out.println("Update the Task");
        boolean update = false;
        String updateOption = null;
        while (!update) {
            if (TaskManagerUtil.isEmptyTask(currentUser)) {
                TaskManagerUtil.displayTitle(currentUser);
                try {

                    boolean optionFg = false;
                    while (!optionFg) {
                        System.out.println("Enter the Option want to Update");
                        System.out.println("1. Update Task Title ");
                        System.out.println("2. Update Task Description ");
                        System.out.println("3. Update Task Status ");
                        try {
                            updateOption = sc.nextLine();
                            if (updateOption.isEmpty()) {
                                System.out.println("Option Should Not be Empty ");
                                continue;
                            }
                            if (updateOption.equals("exit")) {
                                throw new Exception();
                            }

                            Integer options = new Integer(updateOption);
                            if (options < 1 || options > 3) {
                                throw new Exception();
                            }

                        } catch (Exception e) {
                            if (updateOption.equals("exit")) {
                                System.out.println("=== Exit ===");
                                update = true;
                            }
                            System.out.println("=== Enter the Valid Option (1 to 3) ===");

                        }
                        try {
                            if (updateOption.equals("1")) {
                                String updateTitle = null;
                                String titleOption = null;
                                System.out.println("Available Title ");
                                if (TaskManagerUtil.isEmptyTask(currentUser)) {
                                    TaskManagerUtil.displayTitle(currentUser);
                                    boolean titleFg = false;
                                    while (!titleFg) {
                                        System.out.println("Select the Any title to Update  ");
                                        titleOption = sc.nextLine();

                                        try {

                                            if (titleOption.isEmpty()) {
                                                System.out.println("Option Should not be Empty ");
                                                continue;
                                            }
                                            if (titleOption.equals("exit")) {
                                                throw new Exception();
                                            }

                                        } catch (Exception e) {
                                            if (titleOption.equals("exit")) {
                                                System.out.println("=== Exit ===");
                                                titleFg = true;
                                                update = true;
                                                continue;
                                            }
                                        }
                                        boolean updateTitleFg = false;
                                        while (!updateTitleFg) {

                                            System.out.print("Enter the New Title: ");
                                            try {
                                                updateTitle = sc.nextLine();
                                                if (updateTitle.equals("exit")) {
                                                    updateTitle = null;
                                                }

                                                if (updateTitle.isEmpty()) {
                                                    System.out.println("Title Should not be Empty ");
                                                    continue;
                                                }
                                                if (updateTitle.equals("exit")) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                if (updateTitle.equals("exit")) {
                                                    System.out.println("=== Exit ===");

                                                    titleFg = true;
                                                    update = true;
                                                }
                                            }
                                            Integer titleNumber = new Integer(titleOption);
                                            currentUser.getTaskArray()[titleNumber - 1].setTitle(updateTitle);
                                            updateTitleFg = true;
                                        }


                                        System.out.println("Title is Updated");
                                        update = true;
                                    }
                                } else {
                                    System.out.println("Title is empty here ");
                                }

                            } else if (updateOption.equals("2")) {

                                String updateDescription = null;
                                String descriptionOption = null;
                                System.out.println("Available Description ");
                                if (TaskManagerUtil.isEmptyTask(currentUser)) {
                                    TaskManagerUtil.displayTitle(currentUser);
                                    boolean descriptionFg = false;
                                    while (!descriptionFg) {
                                        System.out.println("Select the Any Description to Update  ");
                                        descriptionOption = sc.nextLine();
                                        try {
                                            if (descriptionOption.isEmpty()) {
                                                System.out.println("Option Should not be Empty ");
                                                continue;
                                            }
                                            if (descriptionOption.equals("exit")) {
                                                throw new Exception();
                                            }

                                        } catch (Exception e) {
                                            if (descriptionOption.equals("exit")) {
                                                System.out.println("=== Exit ===");
                                                descriptionFg = true;
                                                update = true;
                                                continue;

                                            }
                                        }
                                        boolean updateDescriptionFg = false;
                                        while (!updateDescriptionFg) {

                                            System.out.print("Enter the New Description: ");
                                            try {
                                                updateDescription = sc.nextLine();
                                                if (updateDescription.equals("exit")) {
                                                    updateDescription = null;
                                                }

                                                if (updateDescription.isEmpty()) {
                                                    System.out.println("Description Should not be Empty ");
                                                    continue;
                                                }
                                                if (updateDescription.equals("exit")) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                if (updateDescription.equals("exit")) {
                                                    System.out.println("=== Exit ===");
                                                    descriptionFg = true;
                                                    update = true;

                                                }
                                            }

                                            Integer descriptionNumber = new Integer(descriptionOption);
                                            currentUser.getTaskArray()[descriptionNumber - 1].setDescription(updateDescription);
                                            updateDescriptionFg = true;
                                        }
                                        System.out.println("Description is Updated");
                                        update = true;
                                    }
                                } else {
                                    System.out.println("Description is empty here ");
                                }

                            } else if (updateOption.equals("3")) {


                                System.out.println("Available Status ");
                                if (TaskManagerUtil.isEmptyTask(currentUser)) {
                                    TaskManagerUtil.displayTitle(currentUser);

                                    boolean statusFg = false;
                                    String statusOption = null;
                                    Integer statusNumber = 0;
                                    String updateStatusChoice = null;
                                    Integer selectStatusChoice = 0;

                                    while (!statusFg) {
                                        System.out.println("Select the Any Status to Update  ");
                                        statusOption = sc.nextLine();

                                        try {
                                            if (statusOption.isEmpty()) {
                                                System.out.println("Option Should not be Empty ");
                                                continue;
                                            }
                                            if (statusOption.equals("exit")) {
                                                throw new Exception();
                                            }


                                        } catch (Exception e) {
                                            if (statusOption.equals("exit")) {
                                                System.out.println("=== Exit ===");
                                                statusFg = true;
                                                update = true;


                                            }
                                        }
                                        statusNumber = new Integer(statusOption);

                                        boolean updateStatusFg = false;
                                        while (!updateStatusFg) {
                                            System.out.println("Pick Which Status want to Update");
                                            System.out.println("1.Todo");
                                            System.out.println("2.In-Progress");
                                            System.out.println("3.Done");


                                            try {
                                                updateStatusChoice = sc.nextLine();


                                                if (updateStatusChoice.equals("exit")) {
                                                    updateStatusChoice = null;
                                                }
                                                if (updateStatusChoice.isEmpty()) {
                                                    System.out.println("Status Should not be Empty ");
                                                    continue;
                                                }

                                                if (updateStatusChoice.equals("exit")) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                if (updateStatusChoice.equals("exit")) {
                                                    System.out.println("=== Exit ===");
                                                    statusFg = true;
                                                    update = true;

                                                }
                                            }
                                            selectStatusChoice = new Integer(updateStatusChoice);
                                            if (selectStatusChoice == 1) {
                                                String todo = "Todo";
                                                currentUser.getTaskArray()[statusNumber - 1].setStatus(todo);
                                                update = true;
                                            }
                                            if (selectStatusChoice == 2) {
                                                String inProgress = "In-Progress";
                                                currentUser.getTaskArray()[statusNumber - 1].setStatus(inProgress);
                                                update = true;
                                            }
                                            if (selectStatusChoice == 3) {
                                                String done = "Done";
                                                currentUser.getTaskArray()[statusNumber - 1].setStatus(done);
                                                update = true;
                                            }
                                            updateStatusFg = true;
                                        }
                                        System.out.println("Status is Updated");
                                        update = true;
                                    }
                                } else {
                                    System.out.println("Status is empty here ");
                                }
                            }
                        } catch (Exception e) {
                            if (updateOption.equals("exit")) {
                                System.out.println("=== Exit ===");
                                update = true;
                            }
                        }
                        optionFg = true;
                    }

                } catch (Exception e) {
                    if (updateOption.equals("exit")) {
                        System.out.println("=== Exit ===");
                        update = true;
                    }
                }
            }
            else {
                System.out.println("Not Task is Avalilable to Update ");
                break;
            }
        }
    }

    //delete Task

    public void deleteTask(UserInterface currentUser){
        System.out.println("Delete the Task");
        boolean delete=false;
        String deleteOption=null;
        Integer deleteNumOption=0;

        while(!delete){
            if(TaskManagerUtil.isEmptyTask(currentUser)) {
                TaskManagerUtil.displayTitle(currentUser);
                try {
                    System.out.println("Pick any one title to delete");
                    deleteOption = sc.nextLine();
                    if (deleteOption.isEmpty()) {
                        System.out.println("Delete Option Should not be empty");
                        continue;
                    }
                    if (deleteOption.equals("exit")) {
                        throw new Exception();
                    }
                    deleteNumOption = new Integer(deleteOption);
                    currentUser.getTaskArray()[deleteNumOption - 1] = null;

                    TaskInterface[] temporaryTask = new Task[currentUser.getTaskArray().length];
                    int num = 0;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i] != null) {
                            temporaryTask[num] = currentUser.getTaskArray()[i];
                            currentUser.getTaskArray()[num] = temporaryTask[num];
                            num++;
                        }
                    }
                    currentUser.setTaskArray(temporaryTask);
                } catch (Exception e) {
                    if (deleteOption.equals("exit")) {
                        System.out.println("=== Exit ===");
                        delete = true;
                    } else {
                        System.out.println("Invalid");
                    }
                }
            }else{
                System.out.println("There is No Title");
                break;
            }
        }
    }




}
