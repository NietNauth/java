package com.test.qlph.dto;

import java.util.Objects;
import java.util.UUID;

public class MenuDTO {
    private UUID itemId;
    private String itemCode;
    private String itemName;
    private String itemCategory;
    private Long itemPrice;

    public MenuDTO() {

    }

    public MenuDTO(UUID itemId, String itemCode, String itemName, String itemCategory, Long itemPrice) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return Objects.equals(itemId, menuDTO.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "UUID: " + itemId + " | Code: " + itemCode + " | Ten mon: " + itemName 
                + " | Loai: " + itemCategory + " | Gia: " + itemPrice + " VND";
    }
}
