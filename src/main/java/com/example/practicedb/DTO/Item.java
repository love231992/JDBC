package com.example.practicedb.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int itemId;
    private int skuId;
    private String itemName;
    private String itemDesc;
    private double itemPrice;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", skuId=" + skuId +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemPrice=$" + itemPrice +
                '}';
    }
}
