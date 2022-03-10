package com.company;

public class Catalogue {
    private final Item[] items;

    public Catalogue(int setSize) {
        items = new Item[setSize];
    }
    public Item[] getFullList() {
        return items;
    }
    public Item[] getAvailableItems() {
        Item[] availableItems = new Item[getNumberOfAvailableItems()];
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
    private int getNumberOfAvailableItems() {
        int numberOfAvailableItems = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getIsAvailable()) {
                    numberOfAvailableItems += 1;
                }
            }
        }
        return numberOfAvailableItems;
    }
    public void addItem(Item item) {
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
                if (items[i].getDescription().equals(itemName)) {
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