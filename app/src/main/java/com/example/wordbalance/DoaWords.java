package com.example.wordbalance;

import android.provider.UserDictionary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DoaWords {

    @Insert
    public void insertWord(MyWord myWord);
    @Delete
    public  void deleteWord(MyWord myWord);
    @Update
    public  void updateWord(MyWord myWord);


    @Query("DELETE  FROM MyWord " )
    public  void deleteALlWords();
   @Query("SELECT * FROM MyWord ")
   List<MyWord> getWords( );


}
