package com.example.wordbalance;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public interface DoaWords {

    @Insert
    public void insertWord(MyWord myWord);
    @Delete
    public  void deleteWord(MyWord myWord);
    @Update
    public  void updateWord(MyWord myWord);
    @Query("SELECT * FROM WORDS")
    @Delete
    public  void deleteALlWords(MyWord myWord);
    @Query("SELECT * FROM WORDS WHERE categories LIKE'A%'"  )
    public  void filterByCate(MyWord myWord);


}
