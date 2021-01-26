package org.miage.Entity.request;

import javax.validation.constraints.*;
 
public class AddCoursRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private boolean free;
    private long price;

    public AddCoursRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
