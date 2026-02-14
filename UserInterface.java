package TaskCli;

public interface UserInterface {
    public String getName();
    public void setName(String name);
    public TaskInterface[] getTaskArray();
    public void setTaskArray(TaskInterface[] taskArray);

}
