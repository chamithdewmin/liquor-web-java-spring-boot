package com.example.liquor.dto;

public class productDTO {

    private int id;
    private String name;
    private String description;
    private String category;
    private double price;
    private int volume; // Bottle size in ml
    private double alcoholPercentage; // Alcohol percentage
    private String brand;
    private String imageName;
    private String imageType;

    public productDTO() {
    }

    public productDTO(int id, String name, String description, String category, double price, int volume, double alcoholPercentage, String brand, String imageName, String imageType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.volume = volume;
        this.alcoholPercentage = alcoholPercentage;
        this.brand = brand;
        this.imageName = imageName;
        this.imageType = imageType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}

