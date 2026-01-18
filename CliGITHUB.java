package Some;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
abstract  class GithubEvent{
    protected String repoName;
    public GithubEvent(String repoName){
        this.repoName=repoName;
    }
    public abstract void displayEvent();
}
class PushEvent extends GithubEvent{
    public PushEvent(String repoName){
        super(repoName);
        }
        @Override
    public void displayEvent(){
            System.out.println("Pushed commit to "+repoName);
        }
}
public class CliGITHUB {
    public static void main(String[] args) {
        String userName="octocat";
        userActivity(userName);
    }
    public static void userActivity(String userName){
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/"+userName+"/events")).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                parseAndShow(response.body());
            } else {
                System.out.println("User is not found ");
            }
        }
            catch(Exception e){
                System.out.println("Errot connnectiong to github:"+e.getMessage());
            }



    }
    private static void parseAndShow(String json) {
        // Simple logic to find the first repo name in the raw JSON text
        if (json.contains("\"name\":\"")) {
            int start = json.indexOf("\"name\":\"") + 8;
            int end = json.indexOf("\"", start);
            String repo = json.substring(start, end);

            // 5. POLYMORPHISM: Using the specific subclass
            GithubEvent event = new PushEvent(repo);
            event.displayEvent();
        }
    }

}
