package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin implements Discountable,Dealable{
    Scanner input = new Scanner(System.in);

    private String adminName;
    private String adminPass;

    private Zoo Zootopia;

    public Admin(Zoo zoo) {
        this.adminName = "Yash";
        this.adminPass = "Yash123";
        Zootopia = zoo;

    }

    public Zoo getZootopia() {
        return Zootopia;
    }

    private Map<String, Integer> discounts = new HashMap<>();
    private Map<Integer, Integer> specialDeals = new HashMap<>();

    private HashMap<Integer, Attractions> attractions;

    private int attractionIdCounter;



    public Map<String, Integer> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Map<String, Integer> discounts) {
        this.discounts = discounts;
    }

    public Map<Integer, Integer> getSpecialDeals() {
        return specialDeals;
    }

    public void setSpecialDeals(Map<Integer, Integer> specialDeals) {
        this.specialDeals = specialDeals;
    }

    public int getAttractionIdCounter() {
        return attractionIdCounter;
    }

    public void setAttractionIdCounter(int attractionIdCounter) {
        this.attractionIdCounter = attractionIdCounter;
    }


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }






    public boolean adminLogin() {

        System.out.print("Enter Admin Username: ");
        String adminName = input.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPass = input.nextLine();
        if (getAdminName().equals(adminName) && getAdminPass().equals(adminPass)) {
            System.out.println("Logged in as Admin.");
            System.out.println(" ");

            return true;
        } else {
            return false;
        }


    }


    public int Adding_Attraction(int Attraction_Id) {
        System.out.println("Enter Attraction Name: ");
        String title = input.nextLine();
        System.out.println("Enter Attraction Description: ");
        String description = input.nextLine();


        Attractions att = new Attractions(Attraction_Id, title, description);
        Zootopia.getAttractions().put(Attraction_Id, att);
        Attraction_Id++;

        System.out.println("Attraction added successfully.");

        return Attraction_Id;

    }

    public void View_Attractions() {
        HashMap<Integer, Attractions> attractionList = Zootopia.getAttractions();
        if (attractionList.isEmpty()) {
            System.out.println("No attractions in the zoo");
        } else {
            int x = 0;
            for (Map.Entry<Integer, Attractions> entry : attractionList.entrySet()) {
                int Attraction_Id = entry.getKey();
                Attractions att = entry.getValue();
                x++;
                System.out.println(x + ". ");
                System.out.println(att.toString());
            }
        }
    }
    public void Visitor_View_Attractions() {
        HashMap<Integer, Attractions> attractionlist = Zootopia.getAttractions();
        if (attractionlist.isEmpty()) {
            System.out.println("No attractions in the zoo");

        } else {
            int x = 0;
            for (Map.Entry<Integer, Attractions> entry : attractionlist.entrySet()) {
                int Attraction_Id = entry.getKey();
                Attractions att = entry.getValue();
                x++;
                System.out.print(x + ". ");
                System.out.println("Attraction Name - " + att.getAttractionName());


            }
            int select = 0;
            System.out.println("Enter your choice: ");
            select = input.nextInt();
            int currentPosition = 1;
            Attractions AttractionChosen = null;
            for (Map.Entry<Integer, Attractions> entry : attractionlist.entrySet()) {
                if(currentPosition==select){
                    AttractionChosen=entry.getValue();
                    break;
                }
                currentPosition++;


            }
            if(AttractionChosen!=null){
                System.out.println(AttractionChosen.getDescription());
            }
            else{
                System.out.println("Please enter correct option.");
            }
        }
    }

    public void Modify_Attraction(){
        System.out.println("Enter Attraction Id: ");
        int AtId = input.nextInt();
        Attractions at1 = Zootopia.getAttractionById(AtId);
        if(Zootopia.getAttractions().containsKey(AtId)){
            System.out.println("Enter New Attraction Name: ");

            input.nextLine();

            at1.setAttractionName(input.nextLine());
            System.out.println("Enter New Description: ");
            at1.setDescription(input.nextLine());


        }
        else{
            System.out.println("Attraction with ID "+ AtId+" doesn't exist");
        }

    }

    public void Remove_Attraction(){
        System.out.println("Enter Attraction Id: ");
        int AtId = input.nextInt();
        Attractions at1 = Zootopia.getAttractionById(AtId);
        if(Zootopia.getAttractions().containsKey(AtId)){
            Zootopia.getAttractions().remove(AtId);
            System.out.println("Attraction with ID "+ AtId+" has been successfully removed");


        }
        else{
            System.out.println("Attraction with ID "+ AtId+" doesn't exist");

        }

    }
    public void Registering_Visitor(){
        System.out.println("Enter Visitor Name: ");
        String visitorName=input.nextLine();
        //input.nextLine();
        System.out.println("Enter Visitor Age: ");
        int visitorAge=input.nextInt();
        input.nextLine();
        System.out.println("Enter Visitor PhoneNumber: ");
        String visitorPhoneNumber=input.nextLine();
        System.out.println("Enter Visitor Balance: ");

        int visitorBalance= input.nextInt();
        input.nextLine();
        System.out.println("Enter Visitor Email: ");
        String visitorEmail = input.nextLine();
        System.out.println("Enter Visitor Password:  ");
        String visitorPassword=input.nextLine();

        Visitor v = new Visitor(visitorName,visitorAge,visitorPhoneNumber,visitorBalance,visitorEmail,visitorPassword);
        Zootopia.getVisitors().put(visitorEmail,v);

        System.out.println(" ");
        System.out.println("Registration is Successful.");
        System.out.println(" ");

    }
    public boolean Visitor_Login(String visitorEmail){


        if(Zootopia.getVisitors().containsKey(visitorEmail)){
            System.out.println(" ");
            System.out.println("Login Successful");
            System.out.println(" ");
            return true;
        }else{
            return false;
        }
    }


    public void Schedule_Event() {
        System.out.println("Enter Attraction Id: ");
        int AtId = input.nextInt();
        Attractions at1 = Zootopia.getAttractionById(AtId);
        if (Zootopia.getAttractions().containsKey(AtId)) {

            while (true) {
                System.out.println("""
                    Schedule Event:
                    1. Enter Status and Ticket Price
                    2. Number of Ticketed Visitors
                    3. Exit
                    """);
                int choose = input.nextInt();
                if (choose == 1) {
                    System.out.println("Enter Status of the Attraction (closed=0, open=1): ");
                    int status = input.nextInt();
                    if (status != 0 && status != 1) {
                        System.out.println("Invalid status. Status must be 0 (closed) or 1 (open).");
                    } else {
                        at1.setStatus(status);
                        System.out.println("Enter ticket price for the attraction (greater than 0): ");
                        int ticketPrice = input.nextInt();
                        if (ticketPrice <= 0) {
                            System.out.println("Ticket price must be greater than 0.");
                        } else {
                            at1.setTicketPrice(ticketPrice);
                            System.out.println("Event at the " + at1.getAttractionName() + " with a ticket price of ₹" + at1.getTicketPrice() + " has been scheduled.");
                            break;
                        }
                    }

                }else if(choose==2){
                    System.out.print("Number of ticketed visitors: "+at1.getTicketedVisitors());


                }

                else if (choose == 3) {
                    break;
                }
            }
        }
    }



    public int Add_Animal(int Animal_Id) {
        System.out.println("Enter Animal Name: ");
        String animal_name = input.nextLine();

        System.out.println("Enter Animal Type (Mammal, Reptile, or Amphibian): ");
        String animal_type = input.nextLine();

        if (animal_type.equalsIgnoreCase("Mammal") || animal_type.equalsIgnoreCase("Amphibian") || animal_type.equalsIgnoreCase("Reptile")) {
            Animals a = null;
            switch (animal_type.toLowerCase()) {
                case "mammal":
                    a = new Mammals(animal_name);
                    break;
                case "amphibian":
                    a = new Amphibians(animal_name);
                    break;
                case "reptile":
                    a = new Reptiles(animal_name);
                    break;
            }

            if (a != null) {
                System.out.println("Enter the noise the animal makes: ");
                String animal_noise = input.nextLine();
                a.setNoise(animal_noise);
                System.out.println("Enter the animal's history: ");
                String animal_history= input.nextLine();
                a.setAnimalHistory(animal_history);

                Zootopia.getAnimals().put(Animal_Id, a);
                Animal_Id++;
                System.out.println("Animal added to the zoo");
            } else {
                System.out.println("Invalid animal type.");
            }
        } else {
            System.out.println("Invalid animal type. Please enter 'Mammal', 'Amphibian', or 'Reptile'.");
        }

        return Animal_Id;
    }


    public void Remove_Animal() {
        View_Animals();
        System.out.println("Enter Animal Id: ");
        int AnimalId = input.nextInt();
        Animals animal1 = Zootopia.getAnimalById(AnimalId);
        if (Zootopia.getAnimals().containsKey(AnimalId)) {
            if (Zootopia.getAnimals().size() <= 6) {
                System.out.println("There must be at least 6 animals in the zoo. You cannot remove this animal.");
            } else {
                Zootopia.getAnimals().remove(AnimalId);
                System.out.println("Animal with ID " + AnimalId + " has been successfully removed.");
            }
        } else {
            System.out.println("Animal with ID " + AnimalId + " doesn't exist.");
        }
    }


    public void View_Animals() {
        HashMap<Integer, Animals> animalList = Zootopia.getAnimals();
        if (animalList.isEmpty()) {
            System.out.println("No animals in the zoo");
        } else {
            int x = 0;
            for (Map.Entry<Integer, Animals> entry : animalList.entrySet()) {
                int Animal_Id = entry.getKey();
                Animals animal = entry.getValue();
                x++;
                System.out.println(x + ". ");
                System.out.println("Animal ID - " + Animal_Id);
                System.out.println(animal.toString());
            }
        }
    }


    public void Visitor_View_Animals() {
        HashMap<Integer, Animals> animalList = Zootopia.getAnimals();
        if (animalList.isEmpty()) {
            System.out.println("No animals in the zoo");
        } else {
            int x = 0;
            for (Map.Entry<Integer, Animals> entry : animalList.entrySet()) {
                int Animal_Id = entry.getKey();
                Animals animal = entry.getValue();
                x++;
                System.out.print(x + ". ");
                System.out.println("Animal Name - " + animal.getName());
            }
            int select = 0;
            System.out.println("Enter your choice: ");
            select = input.nextInt();
            int currentPosition = 1;
            Animals AnimalChosen = null;
            for (Map.Entry<Integer, Animals> entry : animalList.entrySet()) {
                if (currentPosition == select) {
                    AnimalChosen = entry.getValue();
                    break;
                }
                currentPosition++;
            }
            if (AnimalChosen != null) {
                System.out.println("Animal Type: " + AnimalChosen.getType());
                System.out.println("Animal Noise: " + AnimalChosen.getNoise());
                System.out.println("Animal History: " + AnimalChosen.getAnimalHistory());
            } else {
                System.out.println("Please enter the correct option.");
            }
        }
    }


    public void UpdateAnimalDetails() {

        View_Animals();

        System.out.println("Enter Animal ID to update details: ");
        int AnimalId = input.nextInt();
        Animals animalToUpdate = Zootopia.getAnimalById(AnimalId);

        if (animalToUpdate != null) {
            // Display the current details
            System.out.println("Current Animal Name: " + animalToUpdate.getName());
            System.out.println("Current Animal Noise: " + animalToUpdate.getNoise());
            System.out.println("Current Animal History: " + animalToUpdate.getAnimalHistory());

            // Ask for new details
            System.out.print("Enter new Animal Name (Enter to keep current): ");
            input.nextLine();
            String newAnimalName = input.nextLine();
            if (!newAnimalName.isEmpty()) {
                animalToUpdate.setName(newAnimalName);
            }

            System.out.print("Enter new Animal Noise (Enter to keep current): ");
            String newAnimalNoise = input.nextLine();
            if (!newAnimalNoise.isEmpty()) {
                animalToUpdate.setNoise(newAnimalNoise);
            }

            System.out.print("Enter new Animal History (Enter to keep current): ");
            String newAnimalHistory = input.nextLine();
            if (!newAnimalHistory.isEmpty()) {
                animalToUpdate.setAnimalHistory(newAnimalHistory);
            }

            System.out.println("Animal details updated successfully.");
        } else {
            System.out.println("Animal with ID " + AnimalId + " doesn't exist.");
        }
    }


    @Override
    public void addDiscount(String category, int percentage) {
        discounts.put(category, percentage);
        System.out.println("Discount added successfully.");
    }

    @Override
    public void removeDiscount(String category) {
        viewDiscounts();
        if (discounts.containsKey(category)) {
            discounts.remove(category);
            System.out.println("Discount removed successfully.");
        } else {
            System.out.println("Discount category not found.");
        }
    }

    @Override
    public void addSpecialDeal(int attractions, int discountPercentage) {
        specialDeals.put(attractions, discountPercentage);
        System.out.println("Special deal added successfully.");
    }

    @Override
    public void removeSpecialDeal(int attractions) {

        //viewSpecialDeals();
        if (specialDeals.containsKey(attractions)) {
            specialDeals.remove(attractions);
            System.out.println("Special deal removed successfully.");
        } else {
            System.out.println("Special deal not found for the given number of attractions.");
        }
    }

    @Override
    public void viewDiscounts() {
        if (discounts.isEmpty()) {
            System.out.println("No discounts are available.");
        }else {
            int x = 0;
            for (Map.Entry<String, Integer> entry : discounts.entrySet()) {
                String discountCategory = entry.getKey();
                Integer discountPercentage = entry.getValue();
                x++;
                System.out.print(x + ". ");
                System.out.println(discountCategory + " (" + discountPercentage + "% discount)" + " - " + discountCategory.toUpperCase() + discountPercentage);
            }
        }
    }


    @Override
    public void viewSpecialDeals() {
        if (specialDeals.isEmpty()) {
            System.out.println("No special deals are available.");
        } else {
            int x = 0;
            System.out.println("Special Deals:");
            for (Map.Entry<Integer, Integer> entry : specialDeals.entrySet()) {
                int attractions = entry.getKey();
                int discountPercentage = entry.getValue();
                x++;
                System.out.println(x + ". Buy " + attractions + " tickets and get " + discountPercentage + "% off");
            }
        }
    }

    @Override
    public void updateDiscount(String category, int newPercentage) {
        if (discounts.containsKey(category)) {
            discounts.put(category, newPercentage);
            System.out.println("Discount updated successfully.");
        } else {
            System.out.println("Discount category not found.");
        }
    }

    @Override
    public void updateSpecialDeal(int attractions, int newDiscountPercentage) {
        if (specialDeals.containsKey(attractions)) {
            specialDeals.put(attractions, newDiscountPercentage);
            System.out.println("Special deal updated successfully.");
        } else {
            System.out.println("Special deal not found for the given number of attractions.");
        }
    }





}




