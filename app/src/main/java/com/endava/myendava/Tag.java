package com.endava.myendava;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tag implements Serializable {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("subcategory")
    @Expose
    private String subcategory;
    @SerializedName("tag_data")
    @Expose
    private String tagData;
    @SerializedName("tag_id")
    @Expose
    private Integer tagId;
    @SerializedName("tag_name")
    @Expose
    private String tagName;
    @SerializedName("tag_description")
    @Expose
    private String tagDescription;

    public Tag() {

    }

    public Tag(String category, String subcategory, String tagData, Integer tagId, String tagName,
               String tagDescription) {
        this.category = category;
        this.subcategory = subcategory;
        this.tagData = tagData;
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getTagData() {
        return tagData;
    }

    public void setTagData(String tagData) {
        this.tagData = tagData;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }
}
