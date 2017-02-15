package com.integris.mra;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class QuestionnaireActivity extends AppCompatActivity {
    LinearLayout mLayoutYes;
    LinearLayout mLayoutNo;
    LinearLayout mLayoutNotApplicable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        mLayoutYes = (LinearLayout) findViewById(R.id.yesLayout);
        mLayoutNo = (LinearLayout) findViewById(R.id.noLayout);
        mLayoutNotApplicable = (LinearLayout) findViewById(R.id.notApplicableLayout);

        ImageButton btnAttach = (ImageButton) findViewById(R.id.btnAttachFile);
        btnAttach.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

            }
        });

        RadioGroup rgAnswer = (RadioGroup) findViewById(R.id.rgAnswers);
        rgAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                if(i == R.id.rbYes){
                    mLayoutYes.setVisibility(View.VISIBLE);
                    mLayoutNo.setVisibility(View.GONE);
                    mLayoutNotApplicable.setVisibility(View.GONE);
                }
                if(i == R.id.rbNo){
                    mLayoutYes.setVisibility(View.GONE);
                    mLayoutNo.setVisibility(View.VISIBLE);
                    mLayoutNotApplicable.setVisibility(View.GONE);
                }
                if(i == R.id.rbNA){
                    mLayoutYes.setVisibility(View.GONE);
                    mLayoutNo.setVisibility(View.GONE);
                    mLayoutNotApplicable.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuMrl:
                Intent intent = new Intent(QuestionnaireActivity.this, CriteriaGridActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuAssessment:
                Intent assessmentIntent = new Intent(QuestionnaireActivity.this, MainActivity.class);
                startActivity(assessmentIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
