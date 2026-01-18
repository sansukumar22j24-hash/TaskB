package Some;


import java.util.*;
import java.util.Scanner;
class Todo {
    int id;
    String title;
    String status; // todo, in-progress, done

    Todo(int id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public String toString() {
        return id + " | " + title + " | " + status;
    }
}


class TodoService {
    List<Todo> todos = new ArrayList<>();

    // CREATE
    void addTodo(Todo todo) {
        todos.add(todo);
        System.out.println("Todo added");
    }

    // READ
    void viewTodos() {
        if (todos.isEmpty()) {
            System.out.println("No todos found");
            return;
        }
        for (Todo t : todos) {
            System.out.println(t);
        }
    }

    // UPDATE
    void updateStatus(int id, String newStatus) {
        for (Todo t : todos) {
            if (t.id == id) {
                t.status = newStatus;
                System.out.println("Status updated");
                return;
            }
        }
        System.out.println("Todo not found");
    }

    // DELETE
    void deleteTodo(int id) {
        Iterator<Todo> it = todos.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                System.out.println("Todo deleted");
                return;
            }
        }
        System.out.println("Todo not found");
    }

    // SEARCH by ID
    void searchById(int id) {
        for (Todo t : todos) {
            if (t.id == id) {
                System.out.println(t);
                return;
            }
        }
        System.out.println("Todo not found");
    }

    // SEARCH by Title
    void searchByTitle(String keyword) {
        for (Todo t : todos) {
            if (t.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(t);
            }
        }
    }

    // FILTER by Status
    void filterByStatus(String status) {
        for (Todo t : todos) {
            if (t.status.equalsIgnoreCase(status)) {
                System.out.println(t);
            }
        }
    }

    // SORT by Title
    void sortByTitle() {
        todos.sort(Comparator.comparing(t -> t.title));
    }

    // SORT by ID desc
    void sortByIdDesc() {
        todos.sort((a, b) -> b.id - a.id);
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoService service = new TodoService();

        while (true) {
            System.out.println("\n--- TODO APP ---");
            System.out.println("1. Add Todo");
            System.out.println("2. View Todos");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Todo");
            System.out.println("5. Search by ID");
            System.out.println("6. Search by Title");
            System.out.println("7. Filter by Status");
            System.out.println("8. Sort by Title");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Status(todo/in-progress/done): ");
                    String status = sc.nextLine();
                    service.addTodo(new Todo(id, title, status));
                    break;

                case 2:
                    service.viewTodos();
                    break;

                case 3:
                    System.out.print("Todo Id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Status: ");
                    status = sc.nextLine();
                    service.updateStatus(id, status);
                    break;

                case 4:
                    System.out.print("Todo Id: ");
                    id = sc.nextInt();
                    service.deleteTodo(id);
                    break;

                case 5:
                    System.out.print("Todo Id: ");
                    id = sc.nextInt();
                    service.searchById(id);
                    break;

                case 6:
                    System.out.print("Keyword: ");
                    title = sc.nextLine();
                    service.searchByTitle(title);
                    break;

                case 7:
                    System.out.print("Status: ");
                    status = sc.nextLine();
                    service.filterByStatus(status);
                    break;

                case 8:
                    service.sortByTitle();
                    System.out.println("Sorted by title");
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}
