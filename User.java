package Some.TODO;

public class User {

    private String name;
    private Task[] availableTask=new Task[10];

    public  User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task[] getAvailableTask() {
        return availableTask;
    }

    public void setAvailableTask(Task[] availableTask) {
        this.availableTask = availableTask;
    }
}
