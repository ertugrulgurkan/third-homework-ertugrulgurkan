package com.ertugrul.springbootmongo.dto;

import java.util.Date;

public class ProductCommentDto {
    private String id;
    private String comment;
    private Date commentDate;
    private String userId;
    private String productId;

    public ProductCommentDto() {
    }

    public ProductCommentDto(String id, String comment, Date commentDate, String userId, String productId) {
        this.id = id;
        this.comment = comment;
        this.commentDate = commentDate;
        this.userId = userId;
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductCommentDto{" +
                "id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}