package TaskCli;

import java.io.StringReader;

public class Task {
    private String title;
    private String description;

    public Task(){

    }
    public Task(String title){
        this.title = title;
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
}
