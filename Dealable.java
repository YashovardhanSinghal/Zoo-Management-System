package org.example;

public interface Dealable {

    void addSpecialDeal(int attractions, int discountPercentage);
    void removeSpecialDeal(int attractions);


    void viewSpecialDeals();

    void updateSpecialDeal(int attractions, int newDiscountPercentage);
}

