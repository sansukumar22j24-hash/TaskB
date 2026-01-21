package Some.TODO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        User[] users=new User[4];
        Integer choice = 0;
        User availableUser = null;
        int userPositionArray = 0;
        boolean findUser;

        while(true) {

            findUser=false;
            System.out.println("Welcome to Your Task ");
            System.out.println("Enter your name");
            String username = sc.nextLine();
            for (int i = 0; i < users.length; i++) {
                if(users[i]==null){
                    continue;
                }
                else{
                    if(users[i].equals(username)){
                        findUser=true;
                        userPositionArray=i;
                        break;
                    }
                }

            }
            if(findUser==false){
                availableUser=new User(username);
                for (int i = 0; i < users.length; i++) {
                    if (users[i]==null){
                        users[i]=availableUser;
                        break;
                    }
                }
            }else{
                availableUser=users[userPositionArray];
            }

            while (choice!=5) {
                System.out.println("Available features");
                System.out.println("1.Add the task");
                System.out.println("2.Show the task");
                System.out.println("3.Update the task");
                System.out.println("4.Delete the task");
                System.out.println("5.Exit");
                System.out.println("Choose any Option ");
                choice = new Integer(sc.nextLine());

                if (choice == 1) {
                    System.out.println("Enter the description:");
                    String description = sc.nextLine();
                    Task task = new Task(description);
                    for (int i = 0; i < users.length; i++) {
                        if (availableUser.getAvailableTask()[i]==null){
                            availableUser.getAvailableTask()[i]=task;
                            break;
                        }
                    }
                    System.out.print("Your Task is created Success fully \n");

                } else if (choice == 2) {
                    System.out.println("The available Tasks you created ");
                    for (int i = 0; i < users.length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            System.out.print(i + 1 + ". ");
                            System.out.println(availableUser.getAvailableTask()[i].getDescription() );

                        }
                    }
                }
                else if(choice==3)
                {
                        System.out.println("Enter the number to update the task");
                        for (int i = 0; i < users.length; i++) {
                            if (availableUser.getAvailableTask()[i]!=null){
                                System.out.print(i+1+". ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());

                            }
                        }
                        System.out.print("Pick the choice: ");
                        Integer wantToUpdateChoice=new Integer(sc.nextLine());
                        System.out.print("Enter the New Description: ");
                        String wantToUpdateDescription=sc.nextLine();
                        availableUser.getAvailableTask()[wantToUpdateChoice-1].setDescription(wantToUpdateDescription);
                }
                    else if(choice==4)
                    {
                        System.out.println("Enter the number to delete the task");
                        for (int i = 0; i < users.length; i++) {
                            if (availableUser.getAvailableTask()[i]!=null){
                                System.out.print(i+1+". ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());

                            }
                        }
                        System.out.print("Pick the choice: ");
                        Integer wantToDeleteChoice=new Integer(sc.nextInt());
                        availableUser.getAvailableTask()[wantToDeleteChoice-1]=null;
                    }


                 else if (choice == 5) {
                    System.out.println("Exit here !");

                 } else {
                    System.out.println("Come Again! NextTime ");
                }
            }

        }

    }


}

