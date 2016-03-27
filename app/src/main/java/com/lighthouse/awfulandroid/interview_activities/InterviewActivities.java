package com.lighthouse.awfulandroid.interview_activities;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.instructions.InstructionPageFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InterviewActivities extends AppCompatActivity {

    private final String[] activities = {"Lorem Ipsum"};

    @Bind(R.id.activities_list)
    ListView activitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_activities);
        ButterKnife.bind(this);

        showInstructions();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activities);
        activitiesList.setAdapter(adapter);
    }

    private void showInstructions() {
        InstructionPageFragment instructionsFragment = new InstructionPageFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        CharSequence userName = getIntent().getCharSequenceExtra("USER_NAME");
//
//        Toast.makeText(InterviewActivities.this,
//                "Hello, " + userName + "\nLet the games begin!", Toast.LENGTH_SHORT).show();
    }
}
