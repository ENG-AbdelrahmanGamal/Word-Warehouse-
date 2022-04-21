package com.example.wordbalance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;

import com.example.wordbalance.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
DoaWords doaWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

      doaWords=WordRoomDatabase.getInstance(this).myDoaWords();
  binding.mainBtAddNewWord.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          addWord();
      }
  });

    }


    void addWord()
    {
        MyWord myWord=new MyWord("Good","that called when great something","general");
        doaWords.insertWord(myWord);
    }
}