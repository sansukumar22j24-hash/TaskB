package Learn;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;

public class Main {

    static User[] userArray = new User[5];


    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        //server.createContext("/");
        server.createContext("/login", new LoginHandler());
        server.createContext("/task/add", new addTaskHandler());
        server.createContext("/task/list", new ListTaskHandler());
        server.start();
        System.out.println("Server is Started on the port http://localhost:8080");
    }


    //login
    static class LoginHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String userName = new String(exchange.getRequestBody().readAllBytes());
            User currentUser = null;

            for (int i = 0; i < userArray.length; i++) {
                if (userArray[i] != null) {
                    if (userArray[i].getUsername().equals(userName)) {
                        currentUser = userArray[i];
                        break;
                    }
                }
            }
            if (currentUser == null) {
                currentUser = new User(userName);
                for (int i = 0; i < userArray.length; i++) {
                    if (userArray[i] == null) {
                        userArray[i] = currentUser;
                        break;
                    }
                }
            }
            String response = "Logged in as " + userName;
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        }
    }

    //add task
    static class addTaskHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {
            String body = new String(exchange.getRequestBody().readAllBytes());
            String[] data = body.split(",");

            String userName = data[0];
            String description = data[1];
            for (User user : userArray) {
                if (user != null) {
                    if (user.getUsername().equals(userName)) {
                        for (int i = 0; i < user.getTaskArray().length; i++) {
                            if (user.getTaskArray()[i] == null) {
                                user.getTaskArray()[i] = new Task(description);
                                break;
                            }
                        }
                    }

                }
            }
            String response = "Task Added";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        }

    }

    //list Task
    static class ListTaskHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String username = new String(exchange.getRequestBody().readAllBytes());
            StringBuilder response = new StringBuilder();
            for (User user : userArray) {
                if (user != null && user.getUsername().equals(username)) {
                    for (Task task : user.getTaskArray()) {
                        if (task != null) {
                            response.append(task.getTaskDescription()).append("\n");
                        }
                    }
                }
            }

            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.toString().getBytes());
            exchange.close();
        }
    }


}













    //    HttpServer server= HttpServer.create(new InetSocketAddress(8080),0);
//    // created server on the ported 80080
//    server.createContext("/start", new HelloHandler());
//    server.setExecutor(null);
//    server.start();
//    System.out.println("server is started on the htttp:localhost:8080/start");
//
//}
//static class HelloHandler implements HttpHandler{
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        String response="Hello from Java Backend ";
//        exchange.sendResponseHeaders(200,response.length());
//        OutputStream os=exchange.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
//    }
