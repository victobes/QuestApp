package com.example.snailquestapp;

import android.view.View;

public class QuestListner implements View.OnClickListener {
    int answer;
    MainActivity ma;
    public QuestListner(MainActivity m, int answer_num){
        answer = answer_num;
        ma = m;
    }
    @Override
    public void onClick(View v){
        ma.answer(answer);
    }
}

