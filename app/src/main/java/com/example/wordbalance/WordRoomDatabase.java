package com.example.wordbalance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = MyWord.class,exportSchema =false,version =1)
public  abstract class WordRoomDatabase extends RoomDatabase {
    private static WordRoomDatabase instance;
  public static WordRoomDatabase getInstance(Context context){
      if(instance== null)
      {
          instance= Room.databaseBuilder(context,WordRoomDatabase.class,"database")
                 .allowMainThreadQueries()
                //  .fallbackToDestructiveMigration()
                  .build();
      }
      return instance;
  }
public abstract DoaWords myDoaWords();




}
