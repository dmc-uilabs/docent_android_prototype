package com.integris.mra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cameron.kagy on 2/9/2017.
 */
public class CriteriaGridActivity extends AppCompatActivity {
    private CriteriaAdapter mAdapter;

    private CheckBox mCbCol1;
    private CheckBox mCbCol2;
    private CheckBox mCbCol3;
    private CheckBox mCbCol4;
    private CheckBox mCbCol5;
    private CheckBox mCbCol6;
    private CheckBox mCbCol7;
    private CheckBox mCbCol8;
    private CheckBox mCbCol9;
    private CheckBox mCbCol10;
    private TableLayout mTableCriteria;
    private RadioButton mRbThread;
    private RadioButton mRbAll;
    private RadioButton mRbLevel;
    private LinearLayout mLayoutAll;
    private LinearLayout mLayoutThread;
    private LinearLayout mLayoutLevel;
    private Spinner mSpThreads;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria_grid);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        mAdapter = new CriteriaAdapter(this);

        gridview.setAdapter(new CriteriaAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(CriteriaGridActivity.this, mAdapter.getCriteriaString(position),
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLayoutThread = (LinearLayout) findViewById(R.id.layoutThread);
        mLayoutLevel = (LinearLayout) findViewById(R.id.layoutLevel);
        mLayoutAll = (LinearLayout) findViewById(R.id.layoutAll);

        mSpThreads = (Spinner) findViewById(R.id.spThreads);
        mSpThreads.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] criteriaStrings = new String[10];

                if(position == 0){
                    criteriaStrings = getResources().getStringArray(R.array.criteriaThread1);
                }
                if(position == 1){
                    criteriaStrings = getResources().getStringArray(R.array.criteriaThread2);
                }
                if(position == 2){
                    criteriaStrings = getResources().getStringArray(R.array.criteriaThread2);
                }
                if(position == 3){
                    criteriaStrings = getResources().getStringArray(R.array.criteriaThread2);
                }

                TextView tv1 = (TextView) findViewById(R.id.tvThreadCriteria1);
                tv1.setText(criteriaStrings[0]);

                TextView tv2 = (TextView) findViewById(R.id.tvThreadCriteria2);
                tv2.setText(criteriaStrings[1]);

                TextView tv3 = (TextView) findViewById(R.id.tvThreadCriteria3);
                tv3.setText(criteriaStrings[2]);

                TextView tv4 = (TextView) findViewById(R.id.tvThreadCriteria4);
                tv4.setText(criteriaStrings[3]);

                TextView tv5 = (TextView) findViewById(R.id.tvThreadCriteria5);
                tv5.setText(criteriaStrings[4]);

                TextView tv6 = (TextView) findViewById(R.id.tvThreadCriteria6);
                tv6.setText(criteriaStrings[5]);

                TextView tv7 = (TextView) findViewById(R.id.tvThreadCriteria7);
                tv7.setText(criteriaStrings[6]);

                TextView tv8 = (TextView) findViewById(R.id.tvThreadCriteria8);
                tv8.setText(criteriaStrings[7]);

                TextView tv9 = (TextView) findViewById(R.id.tvThreadCriteria9);
                tv9.setText(criteriaStrings[8]);

                TextView tv10 = (TextView) findViewById(R.id.tvThreadCriteria10);
                tv10.setText(criteriaStrings[9]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mRbAll = (RadioButton) findViewById(R.id.rbAll);
        mRbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mLayoutAll.setVisibility(View.VISIBLE);
                    mLayoutLevel.setVisibility(View.GONE);
                    mLayoutThread.setVisibility(View.GONE);
                }
            }
        });
        mRbThread = (RadioButton) findViewById(R.id.rbThread);
        mRbThread.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mLayoutAll.setVisibility(View.GONE);
                    mLayoutLevel.setVisibility(View.GONE);
                    mLayoutThread.setVisibility(View.VISIBLE);
                }
            }
        });
        mRbLevel = (RadioButton) findViewById(R.id.rbLevel);
        mRbLevel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mLayoutAll.setVisibility(View.GONE);
                    mLayoutLevel.setVisibility(View.VISIBLE);
                    mLayoutThread.setVisibility(View.GONE);
                }
            }
        });

        mTableCriteria = (TableLayout) findViewById(R.id.tableCriteria);

        mCbCol1 = (CheckBox) findViewById(R.id.cbCol1);
        mCbCol1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(1, b);
            }
        });

        mCbCol2 = (CheckBox) findViewById(R.id.cbCol2);
        mCbCol2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(2, b);
            }
        });

        mCbCol3 = (CheckBox) findViewById(R.id.cbCol3);
        mCbCol3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(3, b);
            }
        });

        mCbCol4 = (CheckBox) findViewById(R.id.cbCol4);
        mCbCol4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(4, b);
            }
        });

        mCbCol5 = (CheckBox) findViewById(R.id.cbCol5);
        mCbCol5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(5, b);
            }
        });

        mCbCol6 = (CheckBox) findViewById(R.id.cbCol6);
        mCbCol6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(6, b);
            }
        });

        mCbCol7 = (CheckBox) findViewById(R.id.cbCol7);
        mCbCol7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(7, b);
            }
        });

        mCbCol8 = (CheckBox) findViewById(R.id.cbCol8);
        mCbCol8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(8, b);
            }
        });

        mCbCol9 = (CheckBox) findViewById(R.id.cbCol9);
        mCbCol9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(9, b);
            }
        });

        mCbCol10 = (CheckBox) findViewById(R.id.cbCol10);
        mCbCol10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAdapter.setColumnVisibility(10, b);
            }
        });


        RadioButton rbAll = (RadioButton) findViewById(R.id.rbAll);
        rbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        RadioButton rbLevel = (RadioButton) findViewById(R.id.rbLevel);
        RadioButton rbThread = (RadioButton) findViewById(R.id.rbThread);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {

        MenuItem mrlItem = menu.findItem(R.id.menuMrl);
        mrlItem.setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuMrl:
                Intent intent = new Intent(CriteriaGridActivity.this, CriteriaActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuAssessment:
                Intent assessmentIntent = new Intent(CriteriaGridActivity.this, MainActivity.class);
                startActivity(assessmentIntent);
                return true;
            case R.id.menuMilestones:
                Intent milestonesIntent = new Intent(CriteriaGridActivity.this, MilestonesActivity.class);
                startActivity(milestonesIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
