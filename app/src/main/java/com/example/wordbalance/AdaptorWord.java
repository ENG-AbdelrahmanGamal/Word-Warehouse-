package com.example.wordbalance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordbalance.databinding.ActivityItemsNewWordsBinding;

import java.util.ArrayList;
import java.util.List;

public class AdaptorWord  extends RecyclerView.Adapter<AdaptorWord.WordsHolder> {

    List<MyWord> words;
    DoaWords doaWords2;

    public AdaptorWord(List<MyWord> words) {
        this.words = words;
    }

    @NonNull
    @Override
    public WordsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

  return new WordsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.activity_items_new_words, parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull WordsHolder holder, int position) {
    holder.binding.setWords(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


    public static class WordsHolder extends RecyclerView.ViewHolder {
        ActivityItemsNewWordsBinding binding ;
        public WordsHolder(@NonNull ActivityItemsNewWordsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
}