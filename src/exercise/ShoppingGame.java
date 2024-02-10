package exercise;

import java.util.ArrayList;
import java.util.Scanner;

class VirtualItem {
  private int itemID;
  private String name;
  private double price;
  private int points;

  public VirtualItem(int itemID, String name, double price, int points) {
    super();
    this.itemID = itemID;
    this.name = name;
    this.price = price;
    this.points = points;
  }

  public int getItemID() {
    return itemID;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getPoints() {
    return points;
  }

  public void setItemID(int itemID) {
    this.itemID = itemID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @Override
  public String toString() {
    return "VirtualItem [itemID=" + itemID + ", name=" + name + ", price=" + price + ", points=" + points + "]";
  }

}

class PowerUp extends VirtualItem {
  String effect;

  public PowerUp(int itemID, String name, double price, int points, String effect) {
    super(itemID, name, price, points);
    this.effect = effect;

  }

  public String getEffect() {
    return effect;
  }

  public void setEffect(String effect) {
    this.effect = effect;
  }

}

class Decoration extends VirtualItem {
  String theme;

  public Decoration(int itemID, String name, double price, int points, String theme) {
    super(itemID, name, price, points);
    this.theme = theme;

  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

}

public class ShoppingGame {

  public static void main(String[] args) {

    ArrayList<VirtualItem> shoppingList = new ArrayList<>();
    double points = 100;
    int allpoints = 0;

    Scanner scan = new Scanner(System.in);

    while (true) {
      System.out.println("start your game and add Items");
      System.out.println("Enter your choice");
      System.out.println("1. To add to cart");
      System.out.println("2. To decorate the cart");
      System.out.println("3. To View the cart");
      System.out.println("4. To exit from game");
      System.out.println("Your point is: " + points);
      int choice = scan.nextInt();

      switch (choice) {
      case 1:
        System.out.println("Enter power name:");
        String powerName = scan.nextLine();
        scan.nextLine();
        System.out.println("Enter the price for power:");
        double powerPrice = scan.nextDouble();
        System.out.println("Enter points for power:");
        int powerPoint = scan.nextInt();
        System.out.println("Enter power effect: ");
        String powerEffect = scan.nextLine();

        PowerUp pW = new PowerUp(shoppingList.size() + 1, powerName, powerPrice, powerPoint, powerEffect);
        shoppingList.add(pW);
        points = points - pW.getPrice();
        break;

      case 2:
        System.out.println("Decorate the cart eith Entering (Name): ");
        String decorateName = scan.nextLine();
        scan.nextLine();
        System.out.println("Ener price for decoration:");
        double decoratePrice = scan.nextDouble();
        System.out.println("Enter points for decoration:");
        int decoratePoints = scan.nextInt();
        System.out.println("Enter theme for decoration");
        String decorateTheme = scan.nextLine();

        Decoration dL = new Decoration(shoppingList.size() + 1, decorateName, decoratePrice, decoratePoints,
            decorateTheme);
        points = points - dL.getPrice();
        break;
      case 3:
        for (VirtualItem list : shoppingList) {
          System.out.println(list);
        }
        break;
      case 4:
        System.out.println("Exit");
        for (VirtualItem result : shoppingList) {
          allpoints = allpoints + result.getPoints();
        }
        System.out.println("Total points are " + allpoints);
        System.out.println("Player points are: " + points);
        System.exit(0);
        break;
      default:
        System.out.println("wrong number!");
        scan.close();
      }

    }

  }

}
