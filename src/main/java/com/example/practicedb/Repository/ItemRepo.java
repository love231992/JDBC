package com.example.practicedb.Repository;

import com.example.practicedb.DTO.Item;
import com.example.practicedb.Queries.SqlQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    SqlQueries sqlQueries;

// **********************   Method to save data to the DB *****************
    public void saveItem(Item item){
        //String sql = "INSERT INTO ITEM VALUES (?,?,?,?,?)";
        String sql = String.valueOf(sqlQueries.save.append("ITEM").append(sqlQueries.save2));
        int rows = jdbcTemplate.update(sql,item.getItemId(),item.getSkuId()
                ,item.getItemName(),item.getItemDesc(),item.getItemPrice());
        System.out.println("Number of rows affected : "+rows);
    }

//************ Method to fetch all the items from the database
    public List<Item> getItems(){
        //String sql ="SELECT * FROM ITEM";
        String sql = String.valueOf(sqlQueries.fetch.append("ITEM"));

//*********************       Row Mapper    *******************************
//        RowMapper<Item> mapper = new RowMapper<Item>() {
//            @Override
//            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Item item = new Item();
//                item.setItemId(rs.getInt("ITEM_ID"));
//                item.setSkuId(rs.getInt("SKU_ID"));
//                item.setItemName(rs.getString("ITEM_NAME"));
//                item.setItemDesc(rs.getString("ITEM_DESC"));
//                item.setItemPrice(rs.getDouble("ITEM_PRICE"));
//                return item;
//            }
//        };
        //return jdbcTemplate.query(sql,mapper);

//        ******************** BeanPropertyRowMapper ******************************
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Item.class));
    }
}
