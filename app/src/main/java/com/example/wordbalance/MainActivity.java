package com.example.wordbalance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.wordbalance.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DoaWords doaWords2;
    List<MyWord> listOfWord=new ArrayList<>();
   AdaptorWord adaptor ;
    private static final String[] COUNTRIES = new String[]{
            "sports", "Tecnolog", "General", "Science", "Travel ","culture"
    };
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
         // adaptor care list  of categories
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView) binding.mainTvCategoriosName;
        textView.setAdapter(adapter);
     // WordRoomDatabase.getInstance(this).myDoaWords().deleteALlWords();
        doaWords2 = WordRoomDatabase.getInstance(this).myDoaWords();
        adaptor=new AdaptorWord(doaWords2.getWords());
        binding.recyclerView.setAdapter(adaptor);
       // doaWords2 = WordRoomDatabase.getInstance(this).myDoaWords();

        binding.mainBtAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                addWord();



              //  getNumberOfWords();
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
        String  nameWord,discription, categores;
        nameWord=binding.mainEdtNewWord.getText().toString().trim();
        discription=binding.mainEdtDiscrption.getText().toString().trim();
        categores=binding.mainTvCategoriosName.getText().toString().trim();
        if(nameWord.isEmpty()||discription.isEmpty()||categores.isEmpty())
        {
            Toast.makeText(this, "fill  new word first", Toast.LENGTH_SHORT).show();
            return;
        }
        MyWord myWord = new MyWord(nameWord, discription, categores);
        insertNewWord(myWord);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listOfWord=doaWords2.getWords();
        adaptor.notifyDataSetChanged();
    }

    private void insertNewWord(MyWord myWord) {
        WordRoomDatabase.getInstance(this).myDoaWords().insertWord(myWord);
        Toast.makeText(this, "word success", Toast.LENGTH_SHORT).show();
       // finish();
      listOfWord.add(myWord);

    }


    void getNumberOfWords()
    {
        Log.i(TAG, "getNumberOfWords:"+ doaWords2.getWords().size());
    }
    private void reAddNewWord() {

    }
}