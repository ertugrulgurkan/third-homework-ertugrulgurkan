package com.ertugrul.springbootmongo.dto;

public class CategoryDto {

    private String id;
    private String name;
    private Long level;
    private String superCategoryId;

    public CategoryDto() {
    }

    public CategoryDto(String id, String name, Long level, String superCategoryId) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.superCategoryId = superCategoryId;
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getSuperCategoryId() {
        return superCategoryId;
    }

    public void setSuperCategoryId(String superCategoryId) {
        this.superCategoryId = superCategoryId;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", superCategoryId=" + superCategoryId +
                '}';
    }
}
