package com.company;

public class Item {
    private final String category;
    private final String description;
    private boolean isAvailable;

    public Item(String setCategory, String setDescription){
        this.category = setCategory;
        this.description = setDescription;
        this.isAvailable = true;
    }
    public Item(){
        this.category = "";
        this.description = "";
        this.isAvailable = false;
    }
    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", is available=" + isAvailable +
                '}';
    }
    public String getCategory(){
        return this.category;
    }
    public String getDescription(){
        return this.description;
    }
    public boolean getIsAvailable(){
        return this.isAvailable;
    }
    public void setIsAvailable(boolean newIsAvailable){
        this.isAvailable = newIsAvailable;
    }
}
