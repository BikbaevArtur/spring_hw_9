package ru.bikbaev.microservice_2.model;

import lombok.Data;

@Data
public class Order {
    private int idProduct;
    private String productName;
    private int quantity;
    private int purchasePriceProduct;
}
