package com.ertugrul.springbootmongo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDto {

    private String id;
    private String name;
    private BigDecimal price;
    private Date createDate;
    private Long categoryId;

    public ProductDto(String id, String name, BigDecimal price, Date createDate, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.categoryId = categoryId;
    }

    public ProductDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", categoryId=" + categoryId +
                '}';
    }
}
