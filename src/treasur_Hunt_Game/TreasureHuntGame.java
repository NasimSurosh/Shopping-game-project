package treasur_Hunt_Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Location {
  private String name;
  private String discription;

  public Location(String name, String discription) {
    super();
    this.name = name;
    this.discription = discription;
  }

  public String getName() {
    return name;
  }

  public String getDiscription() {
    return discription;
  }

  @Override
  public String toString() {
    return "Location [name=" + name + ", discription=" + discription + "]";
  }

}

class Treasure {
  private String name;
  private String description;
  private int value;

  public Treasure(String name, String description, int value) {
    super();
    this.name = name;
    this.description = description;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Treasure [name=" + name + ", description=" + description + ", value=" + value + "]";
  }

}

public class TreasureHuntGame {

  public static void showTreasure(List<Treasure> list) {
    System.out.println("Our treasure: ");
    for (int i = 0; i < list.size(); i++) {
      Treasure treasure = list.get(i);
      System.out.println((i + 1) + " " + treasure.getName() + " " + treasure.getDescription());
    }

  }

  public static void showInventory(Set<Treasure> inventory) {
    System.out.println("Our inventory: ");
    for (Treasure treasur : inventory) {
      System.out.println(treasur.getName() + " " + treasur.getDescription());
    }
  }

  public static void claculateTotalValue(Set<Treasure> inventory) {
    int totalValue = 0;
    for (Treasure treasur : inventory) {
      totalValue = totalValue + treasur.getValue();
    }
    System.out.println("Total value is: " + totalValue);

  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    Map<String, Location> location = new HashMap<>();
    List<Treasure> treasure = new ArrayList<>();
    Set<Treasure> inventory = new HashSet<>();

    location.put("Beach", new Location("Beach", "You are on a beautiful beach with golden sands."));
    treasure.add(new Treasure("Golden Coin", "A shiny gold coin", 10));

    String currentLocation = "Beach";
    while (true) {
      Location locationObject = location.get(currentLocation);
      String locationResult = locationObject.getDiscription();
      System.out.println(locationResult);

      int choice = scan.nextInt();
      switch (choice) {
      case 1:
        showTreasure(treasure);
        break;
      case 2:
        // implement the code
        break;
      case 3:
        showInventory(inventory);
        claculateTotalValue(inventory);
        System.exit(choice);
        break;
      default:
        System.out.println("Invalid choice!");

      }

    }

  }

}
