package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private Item[] items;

    public Catalogue(int setSize){
        items = new Item[setSize];
    }
    public Item[] getFullList(){
        return items;
    }
    public Item[] getAvailableItems(){
        int numberOfAvailableItems = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getIsAvailable()) {
                    numberOfAvailableItems += 1;
                }
            }
        }
        Item[] availableItems = new Item [numberOfAvailableItems];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getIsAvailable()) {
                    for (int o = 0; o < availableItems.length; o++) {
                        if (availableItems[o] == null) {
                            availableItems[o] = items[i];
                            break;
                        }
                    }
                }
            }
        }
        return availableItems;
    }
    public void addItem(Item item){
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }
    public Item findItem(String itemName) {
        Item foundItem = new Item();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getDescription() == itemName) {
                    foundItem = items[i];
                }
            }
        }
        return foundItem;
    }
    public void borrowItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i].setIsAvailable(false);
            }
        }
    }
    public void returnItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i].setIsAvailable(true);
            }
        }
    }
}
