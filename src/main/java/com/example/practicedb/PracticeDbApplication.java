package com.example.practicedb;

import com.example.practicedb.DTO.Item;
import com.example.practicedb.Repository.ItemRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PracticeDbApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PracticeDbApplication.class, args);
        ItemRepo itemRepo = context.getBean(ItemRepo.class);

        Item item1 = Item.builder()
                .itemId(2)
                .skuId(1213)
                .itemName("Washing machine")
                .itemDesc("Samsung front Load Washing machine")
                .itemPrice(450.67)
                .build();
        Item item2 = Item.builder()
                .itemId(3)
                .skuId(1214)
                .itemName("Laptop")
                .itemDesc("HP Envy 360")
                .itemPrice(1300)
                .build();
        Item item5 = Item.builder()
                .itemId(5)
                .skuId(1216)
                .itemName("Tablet")
                .itemDesc("iPad Pro 13-inch model")
                .itemPrice(1799.00)
                .build();
// *******************          Save data in the DB using Builder        ************************
        itemRepo.saveItem(item5);
        //itemRepo.saveItem(item2);
        //itemRepo.saveItem(item3);

// *******************          Fetch & Print data        ************************
        itemRepo.getItems().forEach(System.out::println);
    }

}
