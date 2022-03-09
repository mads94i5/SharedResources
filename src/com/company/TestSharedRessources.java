package com.company;

import java.util.Scanner;

public class TestSharedRessources {

    Catalogue catalogue;
    Scanner sc;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\033[0;32m";

    public static void main(String[] args) {
        TestSharedRessources test = new TestSharedRessources();
        test.sc = new Scanner(System.in);
        test.runProgram();
    }
    private void runProgram() {
        mainMenu();
    }
    private void mainMenu() {
        catalogue = new Catalogue(10);
        Item item1 = new Item("Sport", "Skateboard");
        catalogue.addItem(item1);
        Item item2 = new Item("Sport", "Mountainbike");
        catalogue.addItem(item2);
        Item item3 = new Item("Clothing", "Smoking");
        catalogue.addItem(item3);
        Item item4 = new Item("Clothing", "Dress");
        catalogue.addItem(item4);

        System.out.println("What do you want to do?");
        System.out.println("1. See the entire catalogue");
        System.out.println("2. See what is available");
        System.out.println("3. Add new item for sharing");
        System.out.println("4. Borrow item");
        System.out.println("5. Return item");

        String choiceString = sc.nextLine();
        int choice = Integer.parseInt(choiceString);

        switch (choice) {
            case 1 -> {  // get all items in cataloque
                Item[] allItems = catalogue.getFullList();
                for (int i = 0; i < allItems.length; i++) {
                    System.out.println(allItems[i]);
                }
                askToRunAgain();
            }
            case 2 -> {  // get available items in cataloque
                Item[] availableItems = catalogue.getAvailableItems();
                for (int i = 0; i < availableItems.length; i++) {
                    System.out.println(availableItems[i]);
                }
                askToRunAgain();
            }
            case 3 -> { // Add new Item to catalogue
                System.out.print("Enter item description: ");
                String newItemDescription = sc.nextLine();
                System.out.print("Enter item category: ");
                String newItemCategory = sc.nextLine();

                Item item10 = new Item("Music", "Guitar");
                catalogue.addItem(item10);

                Item newItem = new Item(newItemDescription, newItemCategory);
                catalogue.addItem(newItem);
                System.out.println("Added new item: " + newItem);
                askToRunAgain();
            }
            case 4 -> { // make item unavailable
                // Hardcoded search criteria Skateboard
                Item found = catalogue.findItem("Skateboard");
                catalogue.borrowItem(found);
                System.out.println("Borrowed item: " + found);
                askToRunAgain();
                break;
            }
            case 5 -> { // make item available again
                // Hardcoded search criteria Skateboard
                Item found = catalogue.findItem("Skateboard");
                catalogue.returnItem(found);
                System.out.println("Returned item: " + found);
                askToRunAgain();
                break;
            }
            default ->  // invalid choice
                System.out.println("Invalid choice.");
        }
    }
    private void createDefaultItems(){

    }
    private void askToRunAgain() {
        boolean answeredYesNo = false;
        while (!answeredYesNo) {
            System.out.print(ANSI_BLUE + "Do you want to run the program again? (" + ANSI_RED + "Y" + ANSI_BLUE + "/" + ANSI_RED + "N" + ANSI_BLUE + "): " + ANSI_RESET);
            String yesNo = sc.nextLine().toUpperCase();
            if (yesNo.equals("Y")) {
                System.out.println(ANSI_GREEN + "Ok. Restarting program." + ANSI_RESET);
                answeredYesNo = true;
                mainMenu();
            }
            else if (yesNo.equals("N")) {
                System.out.println(ANSI_RED + "Exiting program." + ANSI_RESET);
                answeredYesNo = true;
            }
            if (!answeredYesNo) {
                System.out.println(ANSI_YELLOW + "You can only enter '" + ANSI_RED + "Y" + ANSI_YELLOW + "' or '" + ANSI_RED + "N" + ANSI_YELLOW + "'. You entered: " + ANSI_RED + yesNo + ANSI_YELLOW + ". Try again." + ANSI_RESET);
            }
        }
    }
}
