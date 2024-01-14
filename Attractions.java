package org.example;

import java.util.HashMap;

public class Attractions {

    private int AttractionId;

    private String AttractionName;

    private String Description;

    private int Status = 0;

    private int TicketPrice = 0;

    private int VisitorCount=0;

    private int TicketedVisitors=0;

    public int getVisitorCount() {
        return VisitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        VisitorCount = visitorCount;
    }

    public int getTicketedVisitors() {
        return TicketedVisitors;
    }

    public void setTicketedVisitors(int ticketedVisitors) {
        TicketedVisitors = ticketedVisitors;
    }

    private HashMap<Integer,Animals> animals=new HashMap<>();




    public Attractions(int attractionId, String attractionName, String description) {
        AttractionId = attractionId;
        AttractionName = attractionName;
        Description = description;
    }

    public HashMap<Integer, Animals> getAnimals() {
        return animals;
    }

    public void setAnimals(HashMap<Integer, Animals> animals) {
        this.animals = animals;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getAttractionId() {
        return AttractionId;
    }

    public void setAttractionId(int attractionId) {
        AttractionId = attractionId;
    }

    public String getAttractionName() {
        return AttractionName;
    }

    public void setAttractionName(String attractionName) {
        AttractionName = attractionName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getTicketPrice() {
        return TicketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        TicketPrice = ticketPrice;
    }


    public String toString() {
        return "Attraction ID: " + AttractionId +
                "\nAttraction Name: " + AttractionName +
                "\nTicket Price: ₹" + TicketPrice +
                "\nStatus: " + (Status == 1 ? "Open" : "Closed") +
                "\nVisitor Count: " + VisitorCount;
    }
}

