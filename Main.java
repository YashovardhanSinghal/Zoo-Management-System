package org.example;


import java.util.Scanner;

public class Main {

    // Add instances of Mammals




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Attraction_Id = 1;
        int Animal_Id = 7;
        Zoo z = new Zoo();

        z.getAnimals().put(1, new Mammals("Giraffe", "Grunt", "Tall herbivorous mammals with long necks."));
        z.getAnimals().put(2, new Mammals("Kangaroo", "Hopping", "Famous known for hopping found in Australia mostly."));


        z.getAnimals().put(3, new Amphibians("Toad", "Croak", "Found in ponds mostly."));
        z.getAnimals().put(4, new Amphibians("Newt", "Chirp", "Small amphibians capable of chirping."));

        z.getAnimals().put(5, new Reptiles("Lizard", "Scuttle", "Reptiles that may scuttle when moving."));
        z.getAnimals().put(6, new Reptiles("Iguana", "Hiss", "Reptiles known for hissing when threatened."));

        //Animals Lion = new Mammals()
        int choose = 0;
        System.out.println(" #### <<<Welcome to ZOOtopia!>>> ####");
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("""
                    1. Enter as Admin
                    2. Enter as a Visitor
                    3. View Special Deals
                    """);

            System.out.println("--------------------------------");
            System.out.print("Enter your choice: ");
            choose = input.nextInt();
            if (choose == 1) {
                //System.out.println("ssssss");
                //Admin ad = new Admin();
                if (z.Yash.adminLogin()) {
                    //System.out.println("noooooooooo");
                    AdminLoop:
                    while (true) {
                        System.out.println("""
                                Admin Menu:
                                1. Manage Attractions
                                2. Manage Animals
                                3. Schedule Events
                                4. Set Discounts
                                5. Set Special Deal
                                6. View Visitor Stats
                                7. View Feedback
                                8. Exit
                                """);
                        int C1 = 0;
                        C1 = input.nextInt();
                        switch (C1) {
                            case 1:
                                AttractionLoop:
                                while (true) {

                                    System.out.println("""
                                            Manage Attractions:
                                            1. Add Attraction
                                            2. View Attractions
                                            3. Modify Attraction
                                            4. Remove Attraction
                                            5. Exit
                                            """);
                                    int C2 = 0;
                                    C2 = input.nextInt();
                                    switch (C2) {
                                        case 1:
                                            Attraction_Id=z.Yash.Adding_Attraction(Attraction_Id);
                                            System.out.println(" ");
                                            continue AdminLoop;
                                        case 2:
                                            z.Yash.View_Attractions();
                                            continue AdminLoop;
                                        case 3:
                                            z.Yash.Modify_Attraction();
                                            continue AdminLoop;

                                        case 4:
                                            z.Yash.Remove_Attraction();
                                            continue AdminLoop;
                                        case 5:
                                            //System.out.println("Logged out");
                                            break AttractionLoop;
                                    }


                                }
                                break;


                            case 2:
                                AnimalsLoop:
                                while (true) {

                                    System.out.println("""
                                            Manage Animals:
                                            1. Add Animal
                                            2. Update Animal Details
                                            3. Remove Animal
                                            4. Exit
                                            """);
                                    int C2 = 0;
                                    C2 = input.nextInt();
                                    switch (C2) {
                                        case 1:
                                            Animal_Id=z.Yash.Add_Animal(Animal_Id);
                                            System.out.println(" ");
                                            continue AnimalsLoop;
                                        case 2:

                                            z.Yash.UpdateAnimalDetails();
                                            System.out.println(" ");
                                            continue AnimalsLoop;



                                        case 3:
                                            z.Yash.Remove_Animal();
                                            System.out.println(" ");
                                            continue AnimalsLoop;

                                        case 4:
                                            System.out.println("Logged out");
                                            break AnimalsLoop;

                                    }
                                }break;
                            case 3:

                                z.Yash.Schedule_Event();
                                break;


                            case 4:
                                DiscountsLoop:
                                while(true){
                                    System.out.println("""
                                            Set Discounts:
                                            1. Add Discount
                                            2. Modify Discount
                                            3. Remove Discount
                                            4. Exit
                                            """);
                                    int C2 = 0;
                                    C2 = input.nextInt();
                                    switch (C2) {
                                        case 1:
                                            System.out.print("Enter Discount Category enter either MINOR(age<18) or SENIOR(age>60): ");
                                            String discountCategory = input.next();
                                            System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                            int discountPercentage = input.nextInt();
                                            z.Yash.addDiscount(discountCategory, discountPercentage);
                                                System.out.println(" ");
                                            continue DiscountsLoop;
                                        case 2:

                                            System.out.println("Enter discount category to be updated: ");
                                            String discountCategory1 = input.next();
                                            System.out.print("Enter New Discount Percentage (e.g., 20 for 20%): ");
                                            int discountPercentage1 = input.nextInt();
                                            z.Yash.updateDiscount(discountCategory1,discountPercentage1);
                                            System.out.println(" ");
                                            continue DiscountsLoop;


                                        case 3:
                                            z.Yash.viewDiscounts();
                                            System.out.print("Enter Discount Category to remove: ");
                                            String removeDiscountCategory = input.next();
                                            z.Yash.removeDiscount(removeDiscountCategory);
                                            continue DiscountsLoop;
                                        case 4:
                                            System.out.println("Logged out");
                                            break DiscountsLoop;

                                    }
                                }
                                break;
                            case 5:
                                SpecialDealLoop:

                                while(true) {
                                    System.out.println("""
                                            Set Special Deals:
                                            1. Add Deal
                                            2. Modify Deal
                                            3. Remove Deal
                                            4. Exit
                                            """);


                                    int C2 = 0;
                                    C2 = input.nextInt();
                                    switch (C2) {

                                        case 1:

                                            System.out.print("Enter Number of attractions to be visited: ");
                                            int attractionNumber = input.nextInt();
                                            System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                            int discountPercentage = input.nextInt();
                                            z.Yash.addSpecialDeal(attractionNumber, discountPercentage);
                                            System.out.println(" ");
                                            continue SpecialDealLoop;
                                        case 2:
                                            z.Yash.viewSpecialDeals();

                                            System.out.print("Enter the category to be edited( for 2 tickets enter 2 , for 3tickets enter 3): ");
                                            int attractionNumber1 = input.nextInt();
                                            System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                            int discountPercentage1 = input.nextInt();
                                            z.Yash.updateSpecialDeal(attractionNumber1, discountPercentage1);
                                            System.out.println(" ");
                                            continue SpecialDealLoop;
                                        case 3:
                                            z.Yash.viewSpecialDeals();
                                            System.out.println("Enter the the special deal category to remove by number");
                                            int dealCategory=input.nextInt();
                                            z.Yash.removeSpecialDeal(dealCategory);
                                            System.out.println(" ");
                                            continue SpecialDealLoop;
                                        case 4:
                                            break SpecialDealLoop;
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Visitor Statistics:");
                                System.out.println("- Total Visitors: "+z.totalVisitors());
                                System.out.println("- Total Revenue $: "+z.getTotalRevenue());
                                z.MostPopularAttraction();
                                break;
                            case 7:
                                z.view_Feedback();
                                break;
                            case 8:
                                System.out.println("Logged out.");
                                break AdminLoop;

                        }

                    }

                } else{
                    System.out.println("Enter correct credentials");


                }
            }else if(choose==2) {
                while (true) {


                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    int C1 = 0;
                    C1 = input.nextInt();
                    if (C1 == 1) {
                        z.Yash.Registering_Visitor();

                    } else if (C1==2) {
                        System.out.println("Enter Visitor Email: ");
                        input.nextLine();
                        String visitorEmail=input.nextLine();
                        System.out.println("Enter Visitor Password: ");
                        String visitorPassword = input.nextLine();
                        Visitor v= z.getVisitorByEmailId(visitorEmail);
                        if(z.Yash.Visitor_Login(visitorEmail)){
                            VisitorLoop:
                            while(true){
                                System.out.println("""
                                        Visitor Menu:
                                        1. Explore the Zoo
                                        2. Buy Membership
                                        3. Buy Tickets
                                        4. View Discounts
                                        5. View Special Deals
                                        6. Visit Animals
                                        7. Visit Attractions
                                        8. Leave Feedback
                                        9. Log Out
                                        """);
                                int C2 =0;
                                System.out.println("Enter your choice: ");
                                C2=input.nextInt();
                                switch (C2){
                                    case 1:
                                        ExploreLoop:
                                        while(true) {
                                            System.out.println("""
                                                    Explore the Zoo:
                                                    1. View Attractions
                                                    2. View Animals
                                                    3. Exit
                                                    """);
                                            int C3 = 0;
                                            System.out.println("Enter you choice: ");
                                            C3 = input.nextInt();
                                            switch (C3) {
                                                case 1:
                                                    z.Yash.Visitor_View_Attractions();
                                                    System.out.println(" ");
                                                    break;
                                                case 2:
                                                    z.Yash.Visitor_View_Animals();
                                                    System.out.println(" ");
                                                    break;
                                                case 3:
                                                    break ExploreLoop;


                                            }
                                        }
                                        break;

                                    case 2:
                                        v.buyMembership(z.Yash);
                                        break;

                                    case 3:
                                        v.buyTickets(z);
                                        break;

                                    case 4:
                                        z.Yash.viewDiscounts();
                                        break;

                                    case 5:
                                        z.Yash.viewSpecialDeals();
                                        break;

                                    case 6:

                                        v.visitAnimal(z);
                                        break;
                                    case 7:
                                        v.visitAttraction(z);
                                        break;


                                    case 8:
                                        v.set_Feedback(z);
                                        break;
                                    case 9:
                                        break VisitorLoop;

                                        
                                }
                            }
                        }


                    }
                    else{
                        break;
                    }
                }

            }

            else if(choose==3){
                z.Yash.viewSpecialDeals();


            }
        }
    }
}