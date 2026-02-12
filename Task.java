package TaskCli;

import java.io.StringReader;

public class Task {
    private String title;
    private String description;
    private String status;

    public Task(){

    }
    public Task(String title){
        this.title = title;
        this.status="Todo";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
