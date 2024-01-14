package org.example;

public interface Discountable {

    void addDiscount(String category, int percentage);
    void removeDiscount(String category);
    void viewDiscounts();

    void updateDiscount(String category, int newPercentage);
}

