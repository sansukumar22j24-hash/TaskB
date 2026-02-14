package TaskCli;

public class User implements UserInterface {
    private String name;
    private TaskInterface[] taskArray=new Task[10];
    public User(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public TaskInterface[] getTaskArray() {
        return taskArray;
    }

    public void setTaskArray(TaskInterface[] taskArray) {
        this.taskArray = taskArray;
    }
}
