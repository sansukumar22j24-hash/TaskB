package TaskCli;

public class User {
    private String name;
    private Task[] taskArray=new Task[10];
    public User(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Task[] getTaskArray() {
        return taskArray;
    }

    public void setTaskArray(Task[] taskArray) {
        this.taskArray = taskArray;
    }
}
