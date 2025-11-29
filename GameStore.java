package gamestore;

import java.io.*;
import java.util.Scanner;

public class GameStore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("_________ Welcome to our Games Shop _________");
        System.out.println("Enter your name and your ID respectively: ");
        String name = input.next();
        String ID = input.next();

        Customer customer = new Customer(ID, name);
        Purchase purchase = new Purchase(customer);

        int choice = 0;

        do {
            System.out.println(" ================== Main Menu ===================");
            System.out.println("1 - add Product ");
            System.out.println("2 - remove product");
            System.out.println("3 - search product ");
            System.out.println("4 - Display invoice  "); 
            System.out.println("5- Save receipt to file  "); 
            System.out.println("6- Load previous receipt  "); 
            System.out.println("7- Exit ");
            System.out.println("-------------------------------------------------");
            System.out.println("Choose an option:");

            boolean valid = false;
            while (!valid) {
                try {
                    choice = input.nextInt();
                    validateMenuChoice(choice);
                    valid = true;
                } catch (InvalidProductException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please enter a correct menu option:");
                }
            }

            switch (choice) {

                case 1:
                    System.out.println("What type of product do you want to add?");
                    System.out.println("1 - Video Game");
                    System.out.println("2 - Electronic Item");
                    int type = input.nextInt();

                    while (type != 1 && type != 2) {
                        System.out.println("Incorrect input, rewrite again");
                        type = input.nextInt();
                    }

                    switch (type) {

                        case 1:
                            System.out.println("Game name --- price --- type");
                            System.out.println("Mario (M) --- 50$ --- digital (D) or physical (P)");
                            System.out.println("Sonic (S) --- 30$ --- digital (D) or physical (P)");

                            char namegame = ' ';
                            boolean validName = false;

                            while (!validName) {
                                try {
                                    System.out.println("Enter name (M or S):");
                                    namegame = input.next().charAt(0);

                                    if (namegame != 'M' && namegame != 'm' &&
                                        namegame != 'S' && namegame != 's') {

                                        throw new InvalidProductNameException("Invalid game name! Please enter M or S.");
                                    }

                                    validName = true;

                                } catch (InvalidProductNameException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            System.out.println("Enter type (D or P):");
                            char typeofgame = input.next().charAt(0);

                            while (typeofgame != 'D' && typeofgame != 'd' &&
                                   typeofgame != 'P' && typeofgame != 'p') {

                                System.out.println("Incorrect input, please enter D or P:");
                                typeofgame = input.next().charAt(0);
                            }

                            if (namegame == 'M' || namegame == 'm') {
                                VideoGame v1 = new VideoGame(typeofgame, "Mario", 50);
                                if (purchase.addProducts(v1))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");

                            } else {
                                VideoGame v2 = new VideoGame(typeofgame, "Sonic", 30);
                                if (purchase.addProducts(v2))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");
                            }
                            break;

                        case 2:
                            System.out.println("item name --- price --- year of release");
                            System.out.println("Console (1) --- 1000$ --- 2013 (3) or 2020 (0)");
                            System.out.println("Controller (2) --- 500$ --- 2014 (4) or 2025 (5)");
                            System.out.println("Enter the number of the name and year:");

                            int ename = input.nextInt();
                            int year = input.nextInt();

                            if (ename == 1) {
                                System.out.println("Choose storage:");
                                System.out.println("(1) 256 GB or (2) 512 GB");
                                int storage = input.nextInt();

                                System.out.println("(Y) with CD Port or (N) without CD Port");
                                char cd = input.next().charAt(0);

                                if (storage == 1) storage = 256;
                                else storage = 512;

                                Console e1 = new Console(storage, cd, year, "Console", 1000);
                                if (purchase.addProducts(e1))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");

                            } else {
                                ElectronicItem e2 = new ElectronicItem(year, "Controller", 500);
                                if (purchase.addProducts(e2))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");
                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println("What type of product do you want to remove?");
                    System.out.println("1 - Mario  2 - Sonic  3 - Controller  4 - Console");

                    int kind = input.nextInt();
                    while (kind < 1 || kind > 4) {
                        System.out.println("Incorrect input, rewrite again");
                        kind = input.nextInt();
                    }

                    String toRemove =
                        (kind == 1) ? "Mario" :
                        (kind == 2) ? "Sonic" :
                        (kind == 3) ? "Controller" :
                                      "Console";

                    if (purchase.removeProducts(toRemove))
                        System.out.println("Removed Successfully");
                    else
                        System.out.println("Item not found");
                    break;

                case 3:
                    System.out.println("What type of product do you want to search?");
                    System.out.println("1 - Mario  2 - Sonic  3 - Controller  4 - Console");

                    int search = input.nextInt();
                    while (search < 1 || search > 4) {
                        System.out.println("Incorrect input, rewrite again");
                        search = input.nextInt();
                    }

                    String searchName =
                        (search == 1) ? "Mario" :
                        (search == 2) ? "Sonic" :
                        (search == 3) ? "Controller" :
                                        "Console";

                    if (purchase.searchProducts(searchName) != -1)
                        System.out.println("Item found");
                    else
                        System.out.println("Not found");
                    break;

                case 4:
                    System.out.println("\n========== PURCHASE RECEIPT ==========");
                    System.out.println(purchase);
                    System.out.println("======================================");
                    break;

                case 5:
                    try {
                        purchase.saveToFile();
                        System.out.println("Receipt saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Error saving receipt: " + e.getMessage());
                    }
                    break;

                case 6:
                    Purchase loaded = purchase.loadFromFile();
                    if (loaded != null) {
                        System.out.println("=== Loaded Previous Receipt ===");
                        System.out.println(loaded);
                    }
                    break;

                case 7:
                    System.out.println("We will be happy to see you again!");
                    break;
            }

        } while (choice != 7);
    }

    public  static void validateMenuChoice(int choice) throws InvalidProductException {
        if (choice < 1 || choice > 7)
            throw new InvalidProductException("Menu choice must be between 1 and 7.");
    }
}
