package fr.mbonnot;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
  public List<String> shoppingList = new ArrayList<>();

  public void addItem(String item) {
    shoppingList.add(item);
    System.out.println(item + " ajouté à la liste.");
  }

  public void removeItem(String item) {
    if (shoppingList.contains(item)) {
      shoppingList.remove(item);
      System.out.println(item + " retiré de la liste.");
    } else {
      System.out.println("L'élément n'existe pas dans la liste.");
    }
  }

  public void displayList() {
    System.out.println("Votre liste de courses : " + shoppingList);
  }

  public static void main(String[] args) {
    ShoppingList list = new ShoppingList();
    list.addItem("Pomme");
    list.addItem("Banane");
    list.addItem("Pomme");
    list.displayList();
    list.removeItem("Orange");
    list.removeItem("Banane");
    list.displayList();
  }
}
