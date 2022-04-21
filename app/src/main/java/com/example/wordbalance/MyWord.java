package com.example.wordbalance;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MyWord")
public class MyWord {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "name")
    String name ;
    @ColumnInfo(name = "Description")
    String Description ;
    @ColumnInfo(name = "categories")
    String categories ;

    public MyWord(String name, String description, String categories) {
        this.name = name;
        Description = description;
        this.categories = categories;
    }

    public MyWord() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
