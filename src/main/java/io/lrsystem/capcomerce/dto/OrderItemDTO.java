package io.lrsystem.capcomerce.dto;

import io.lrsystem.capcomerce.entites.OrderItem;

public class OrderItemDTO {

    private Long productId;
    private String name;
    private double price;
    private Integer quantity;
    private String imgUrl;

    public OrderItemDTO(Long productId, String name, double price, Integer quantity,String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getSubTotal(){
        return quantity * price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
