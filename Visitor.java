package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Visitor {

    private String Name;
    private int Age;
    private String PhoneNumber;
    private int Balance;
    private String Email;
    private String Password;

    private String Membership = "None";
    private String Feedback="";


    private HashMap<Integer, Integer> attractionTickets = new HashMap<>();

    public HashMap<Integer, Integer> getAttractionTickets() {
        return attractionTickets;
    }

    Scanner input = new Scanner(System.in);

    public Visitor(String name, int age, String phoneNumber, int balance, String email, String password) {
        this.Name = name;
        this.Age = age;
        this.PhoneNumber = phoneNumber;
        this.Balance = balance;
        this.Email = email;
        this.Password = password;
    }

    public String getMembership() {
        return Membership;
    }

    public void setMembership(String membership) {
        Membership = membership;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getBalance() {
        return Balance;
    }


    public void setBalance(int balance) {
        Balance = balance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public void deductBalance(int price) {
        this.Balance = this.Balance - price;
    }

    public boolean isEligibleForDiscount(String discountCode, int age) {
        // Use regular expression to extract alphabetical part from the discount code
        String category = discountCode.replaceAll("[^A-Za-z]", "");

        if ("MINOR".equalsIgnoreCase(category) && age < 18) {
            return true;
        } else if ("SENIOR".equalsIgnoreCase(category) && age > 60) {
            return true;
        }
        return false;
    }

    public int applyDiscount(int discountPercentage, Admin admin, int membershipPrice) {
        if (discountPercentage > 0) {
            int discountedPrice = (discountPercentage * membershipPrice) / 100;
            int newPrice = membershipPrice - discountedPrice;
            System.out.println("Discount applied: " + discountPercentage + "% off. New price: ₹" + newPrice);
            return newPrice; // Return the new price after applying the discount.
        }
        return membershipPrice; // If no discount is applied, return the original price.
    }


    public void buyMembership(Admin admin) {
        System.out.println("Buy Membership:");
        System.out.println("1. Basic Membership (₹20)");
        System.out.println("2. Premium Membership (₹50)");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        String membershipType = "";
        int membershipPrice = 0;
        int discountedMembershipPrice = membershipPrice;

        if (choice == 1) {
            membershipType = "Basic Membership";
            membershipPrice = 20;

        } else if (choice == 2) {
            membershipType = "Premium Membership";
            membershipPrice = 50;
        } else {
            System.out.println("Invalid choice. Please select 1 for Basic Membership or 2 for Premium Membership.");
            return;
        }

        input.nextLine();
        System.out.print("Enter discount code (if you have one, or press Enter to skip): ");
        String discountCode = input.nextLine();

        discountedMembershipPrice = membershipPrice;
        int discountPercentage = 0;

        if (!discountCode.isEmpty()) {
            String category = discountCode.replaceAll("[^A-Za-z]", "");
            if (admin.getDiscounts().containsKey(category)) {
                int maxDiscount = admin.getDiscounts().get(category);
                if (discountCode.equals(category + maxDiscount)) {
                    discountPercentage = maxDiscount;
                }
            }
        }
//        System.out.println("Visitor age: " + getAge());
//        System.out.println("Discount code: " + discountCode);
//        System.out.println("Is eligible for discount: " + isEligibleForDiscount(discountCode, getAge()));


        if (isEligibleForDiscount(discountCode, getAge())) {
            discountedMembershipPrice = applyDiscount(discountPercentage, admin, membershipPrice);

        }
        int p1=getBalance();
        if (getBalance() >= discountedMembershipPrice) {
            setMembership(membershipType);
            deductBalance(discountedMembershipPrice);
            int p2=getBalance();
            admin.getZootopia().addTotalRevenue(p1-p2);
            System.out.println("Membership purchased successfully. Your balance is now ₹" + getBalance() + ".");
        } else {
            System.out.println("Insufficient balance to purchase " + membershipType + ".");
        }
    }


    //public void buyTickets
    public void visitAnimal(Zoo zoo) {
        if ("None".equals(getMembership())) {
            System.out.println("You don't have a membership. You need to buy a membership first.");
            buyMembership(zoo.Yash);
            return;
        }
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Animals> animalsMap = zoo.getAnimals(); // Get the animals map from the Zoo
        // Display a list of animals
        System.out.println("List of Animals:");
        for (Integer animalId : animalsMap.keySet()) {
            Animals animal = animalsMap.get(animalId);
            System.out.println(animalId + ". " + animal.getName());
        }

        // Ask the visitor to choose an animal
        System.out.print("Enter the ID of the animal you want to visit: ");
        int animalId = input.nextInt();
        input.nextLine();  // Consume the newline character

        // Check if the selected animal exists
        if (animalsMap.containsKey(animalId)) {
            Animals selectedAnimal = animalsMap.get(animalId);

            System.out.println("You are visiting " + selectedAnimal.getName());
            System.out.println("What would you like to do?");
            System.out.println("1. Feed the animal");
            System.out.println("2. Read about the animal");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();  // Consume the newline character

            if (choice == 1) {
                selectedAnimal.makeSound();
            } else if (choice == 2) {
                selectedAnimal.describe();
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Animal with ID " + animalId + " does not exist.");
        }
    }

    public void visitAttraction(Zoo zoo) {


        if ("None".equals(getMembership())) {
            System.out.println("You don't have a membership. You need to buy a membership first.");
            buyMembership(zoo.Yash);
            return;
        }

        HashMap<Integer, Attractions> attractions = zoo.getAttractions();
        List<Attractions> openAttractions = new ArrayList<>();

        for (Attractions attraction : attractions.values()) {
            if (attraction.getStatus() == 1) {
                openAttractions.add(attraction);
            }
        }

        if (openAttractions.isEmpty()) {
            System.out.println("No attractions are currently open.");
            return;
        }

        System.out.println("List of Open Attractions:");
        System.out.printf("%-3s %-25s %s%n", "ID", "Attraction Name", "Price");

        for (Attractions attraction : openAttractions) {
            System.out.printf("%-3d %-25s ₹%d%n", attraction.getAttractionId(), attraction.getAttractionName(), attraction.getTicketPrice());
        }

        System.out.print("Enter the ID of the attraction you want to visit: ");
        int attractionId = input.nextInt();
        input.nextLine();

        if (attractions.containsKey(attractionId)) {
            Attractions selectedAttraction = attractions.get(attractionId);

            if (attractionTickets.containsKey(attractionId) && attractionTickets.get(attractionId) > 0) {
                System.out.println("1 Ticket Used");
                System.out.println("Thank you for visiting " + selectedAttraction.getAttractionName()+". Hope you enjoyed the attraction.");
                int currentTicketCount=attractionTickets.get(attractionId);
                attractionTickets.put(attractionId,currentTicketCount-1);
                selectedAttraction.setVisitorCount(selectedAttraction.getVisitorCount()+1);



            } else {
                System.out.println("You do not have a valid ticket for this attraction.");
            }
        } else {
            System.out.println("Attraction with ID " + attractionId + " does not exist.");
        }
    }






    public int applySpecialDeal(int specialDealPercentage, int totalTicketPrice) {
        int discountAmount = (specialDealPercentage * totalTicketPrice) / 100;

        int discountedTotalPrice = totalTicketPrice - discountAmount;

        if (discountedTotalPrice < 0) {
            discountedTotalPrice = 0;
        }

        return discountedTotalPrice;
    }

    public void buyTickets(Zoo zoo) {
        if ("Premium Membership".equals(getMembership())) {
            System.out.println("You have a Premium Membership. You can visit attractions without buying tickets.");
            return;
        } else if (!"Basic Membership".equals(getMembership())) {
            System.out.println("You don't have a membership. You need to buy a membership first.");
            buyMembership(zoo.Yash);
            return;
        }

        //Scanner input = new Scanner(System.in);
        HashMap<Integer, Attractions> attractions = zoo.getAttractions();

        if (attractions.isEmpty()) {
            System.out.println("No attractions are available to purchase tickets for.");
        } else {
            List<Attractions> selectedAttractions = new ArrayList<>();
            int totalTicketPrice = 0;

            while (true) {
                System.out.println("Select an Attraction to Buy a Ticket:");
                System.out.printf("%-3s %-25s %s%n", "ID", "Attraction Name", "Price");

                for (Integer attractionId : attractions.keySet()) {
                    Attractions attraction = attractions.get(attractionId);

                    // Check if the attraction is open based on its status
                    if (attraction.getStatus() == 1) {
                        System.out.printf("%-3d %-25s ₹%d%n", attractionId, attraction.getAttractionName(), attraction.getTicketPrice());
                    }
                }

                System.out.print("Enter the ID of the attraction you want to visit (0 to finish): ");
                int attractionId = input.nextInt();
                input.nextLine();  // Consume the newline character

                if (attractionId == 0) {
                    break;
                }

                if (attractions.containsKey(attractionId)) {
                    Attractions selectedAttraction = attractions.get(attractionId);

                    if (selectedAttraction.getStatus() != 1) {
                        System.out.println("This attraction is not open. Please choose an open attraction.");
                        continue;
                    }

                    selectedAttractions.add(selectedAttraction);

                    totalTicketPrice += selectedAttraction.getTicketPrice();
                    selectedAttraction.setTicketedVisitors(selectedAttraction.getTicketedVisitors()+1);

                    attractionTickets.put(attractionId,attractionTickets.getOrDefault(attractionId,0)+1);


                    System.out.println("Ticket for " + selectedAttraction.getAttractionName() + " added to your cart.");
                } else {
                    System.out.println("Invalid attraction ID. Please choose a valid attraction or enter 0 to finish.");
                }
            }

            if (totalTicketPrice > 0) {
                System.out.println("Total cart price: ₹" + totalTicketPrice);
                System.out.print("Enter a discount code (if you have one, or press Enter to skip): ");
                String discountCode = input.nextLine().trim();

                int discountPercentage = 0;

                if (!discountCode.isEmpty()) {
                    String category = discountCode.replaceAll("[^A-Za-z]", "");
                    if (zoo.Yash.getDiscounts().containsKey(category)) {
                        int maxDiscount = zoo.Yash.getDiscounts().get(category);
                        if (discountCode.equalsIgnoreCase(category + maxDiscount)) {
                            if (isEligibleForDiscount(category, getAge())) {
                                discountPercentage = maxDiscount;
                            } else {
                                System.out.println("You are not eligible for this discount.");
                                return;
                            }
                        } else {
                            System.out.println("Invalid discount code.");
                            return;
                        }
                    } else {
                        System.out.println("Invalid discount code.");
                        return;
                    }
                }

                // Display the total price after applying the discount code
                int discountedTotalPrice = totalTicketPrice - (totalTicketPrice * discountPercentage) / 100;
                System.out.println("Total price after discount: ₹" + discountedTotalPrice);

                int specialDealPercentage = zoo.getSpecialDealPercentage(selectedAttractions);

                // Apply the special deal
                int totalPriceAfterSpecialDeal = applySpecialDeal(specialDealPercentage, discountedTotalPrice);

                // Display the price after applying the special deal
                System.out.println("Total price after special deal: ₹" + totalPriceAfterSpecialDeal);

                // Check if the visitor has enough balance to buy the tickets
                System.out.println("Your balance is ₹" + getBalance());
                if (getBalance() >= totalPriceAfterSpecialDeal) {
                    System.out.print("Do you want to continue with the purchase (yes/no)? ");
                    String continuePurchase = input.nextLine().trim().toLowerCase();
                    int p1=getBalance();
                    if (continuePurchase.equals("yes")) {
                        deductBalance(totalPriceAfterSpecialDeal);
                        int p2=getBalance();
                        System.out.println("Tickets purchased successfully.");
                        zoo.addTotalRevenue(p1-p2);
                        System.out.println("Your balance is now ₹" + getBalance() + ".");
                        System.out.println("Applied special deal: " + specialDealPercentage + "% off. on purchasing " + selectedAttractions.size() + " tickets");
                    } else {
                        System.out.println("Purchase cancelled.");
                        attractionTickets.clear();

                    }
                } else {
                    System.out.println("Insufficient balance to purchase tickets.");
                    attractionTickets.clear();
                }
            }
        }
    }

    public void set_Feedback(Zoo zoo){
        if ("None".equals(getMembership())) {
            System.out.println("You don't have a membership. You need to buy a membership first.");
            buyMembership(zoo.Yash);
            return;
        }

        System.out.println("Leave Feedback: ");
        System.out.println("Enter your feedback(max 200 characters): ");

        String feedback;
        feedback=input.nextLine();
        //input.nextLine();


        setFeedback(feedback);
        System.out.println("Thank you for your feedback.");
    }



    public String toString() {
        return "Visitor: " + getName();
    }








}



