package com.example.practicedb.Queries;

import org.springframework.stereotype.Component;

@Component
public class SqlQueries {
    public StringBuilder fetch = new StringBuilder("SELECT * FROM ");
    public StringBuilder save =new StringBuilder("INSERT INTO ") ;
    public StringBuilder save2 = new StringBuilder(" VALUES (?,?,?,?,?) ");

}
