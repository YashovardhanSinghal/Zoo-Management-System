package org.example;


import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    public Admin Yash;
    private int TotalRevenue=0;

    public int getTotalRevenue() {
        return TotalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        TotalRevenue = totalRevenue;
    }
    public void addTotalRevenue(int addRevenue){
        TotalRevenue+=addRevenue;
    }

    private HashMap<Integer, Attractions> attractions = new HashMap<>();


    private HashMap<String,Visitor> visitors = new HashMap<>();


    private HashMap<Integer,Animals> animals= new HashMap<>();



    public HashMap<Integer, Animals> getAnimals() {
        return animals;
    }


    public HashMap<String, Visitor> getVisitors() {
        return visitors;
    }

    public HashMap<Integer, Attractions> getAttractions() {

        return attractions;
    }
    public Attractions getAttractionById(int AttractionId){
        return attractions.get(AttractionId);
    }
    public Animals getAnimalById(int AnimalId){
        return animals.get(AnimalId);
    }
    public void setAttractions() {
        this.attractions = new HashMap<>();
    }


    public Visitor getVisitorByEmailId(String visitorEmail){
        return visitors.get(visitorEmail);
    }
    public Zoo(){
        Yash = new Admin(this);
    }

    public int getSpecialDealPercentage(List<Attractions> selectedAttractions) {
        int totalAttractionNumber = selectedAttractions.size();

        if (Yash.getSpecialDeals().containsKey(totalAttractionNumber)) {
            return Yash.getSpecialDeals().get(totalAttractionNumber);
        }

        return 0; // If no special deal applies
    }


    public void view_Feedback(){
        int x=0;
        if(visitors.isEmpty()){
            System.out.println("No visitors.");
            return;
        }
        for (Visitor visitor : visitors.values()) {
            x++;
            System.out.print(x+". ");
            System.out.println("Visitor Name: " + visitor.getName());
            System.out.println("Visitor Email: " + visitor.getEmail());
            System.out.println("Visitor Membership: " + visitor.getMembership());
            System.out.println("Visitor Feedback: " + visitor.getFeedback());
            System.out.println();
        }
    }

    public void MostPopularAttraction() {
        Attractions mostPopularAttraction = null;
        int maxVisitorCount = -1;

        for (Attractions attraction : attractions.values()) {
            int ticketedVisitors = attraction.getVisitorCount();

            if (ticketedVisitors > maxVisitorCount) {
                maxVisitorCount = ticketedVisitors;
                mostPopularAttraction = attraction;
            }
        }

        if (mostPopularAttraction != null) {
            System.out.println("The most popular attraction is: " + mostPopularAttraction.getAttractionName());
        } else {
            System.out.println("No attractions found.");
        }
    }

    public int totalVisitors(){
        return  visitors.size();

    }



}
