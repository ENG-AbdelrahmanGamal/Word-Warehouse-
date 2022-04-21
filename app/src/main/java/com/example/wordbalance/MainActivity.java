package com.example.wordbalance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wordbalance.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DoaWords doaWords2;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        doaWords2 = WordRoomDatabase.getInstance(this).myDoaWords();
        binding.mainBtAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWord();
                getNumberOfWords();
            }
        });
binding.mainBtShare.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        doaWords2.deleteALlWords();
    }
});
    }


    void addWord() {
        MyWord myWord = new MyWord("Good", "that called when great something", "ageneral");
        doaWords2.insertWord(myWord);
    }
    void getNumberOfWords()
    {
        Log.i(TAG, "getNumberOfWords:"+ doaWords2.filterByCate().size());
    }
}