package fr.mbonnot;

import java.util.ArrayList;
import java.util.List;

class TaskManager {

  public static List<String> tasks = new ArrayList<>();

  public void addTask(String task) {
    tasks.add(task);
    System.out.println("Tâche ajoutée: " + task);
  }

  public void removeTask(String task) {
    if (tasks.contains(task)) {
      tasks.remove(task);
    } else {
      System.out.println("Tâche non trouvée.");
    }
  }

  public void displayTasks() {
    System.out.println("Liste des tâches: " + tasks);
  }

  public static void main(String[] args) {
    TaskManager manager = new TaskManager();
    manager.addTask("Acheter du lait");
    manager.addTask("Envoyer un email");
    manager.displayTasks();
    manager.removeTask("Envoyer un email");
    manager.displayTasks();
  }
}
