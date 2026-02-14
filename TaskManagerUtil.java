package TaskCli;

public abstract class TaskManagerUtil {
    public static void displayTitle(UserInterface currentUser){

        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
            if (currentUser.getTaskArray()[i] != null) {
                System.out.print(i + 1 + ".");
                System.out.println(currentUser.getTaskArray()[i].getTitle());
                System.out.println(" <"+currentUser.getTaskArray()[i].getStatus()+"> ");

            }
        }

    }
    public static void displayStatus(UserInterface currentUser,String status){
        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                if(currentUser.getTaskArray()[i].getStatus().equals(status)) {
                if (currentUser.getTaskArray()[i] != null) {
                    if (currentUser.getTaskArray()[i].getStatus().equals("Todo")) {
                        System.out.print(i + 1 + ". ");
                        System.out.print(currentUser.getTaskArray()[i].getTitle());
                        System.out.println(currentUser.getTaskArray()[i].getDescription());
                        System.out.println(" <" + currentUser.getTaskArray()[i].getStatus() + "> ");
                    }
                }
            }
        }

    }

    public static boolean isEmptyTask(UserInterface currentUser){
        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
            if(currentUser.getTaskArray()!=null){
                return true;
            }
        }return false;
    }

}
