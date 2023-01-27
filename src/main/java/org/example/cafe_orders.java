package org.example;

public class cafe_orders {
    private String name_of_cafe;
    private String name_of_dish;
    private int price;

    public cafe_orders(String name_of_cafe, String name_of_dish, int price) {
        this.name_of_cafe = name_of_cafe;
        this.name_of_dish = name_of_dish;
        this.price = price;
    }

    public String getName_of_cafe() {
        return name_of_cafe;
    }

    public void setName_of_cafe(String name_of_cafe) {
        this.name_of_cafe = name_of_cafe;
    }

    public String getName_of_dish() {
        return name_of_dish;
    }

    public void setName_of_dish(String name_of_dish) {
        this.name_of_dish = name_of_dish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
