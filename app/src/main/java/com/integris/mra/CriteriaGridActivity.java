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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    private RadioGroup mRgShowCriteria;
    private RadioGroup mRgChooseLevel;
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
                    criteriaStrings = getResources().getStringArray(R.array.criteriaThread3);
                }
                if(position == 3){
                    criteriaStrings = getResources().getStringArray(R.array.criteriaThread4);
                }

                TextView tv1 = (TextView) findViewById(R.id.tvThreadCriteria1);
                tv1.setText(criteriaStrings[2]);

                TextView tv2 = (TextView) findViewById(R.id.tvThreadCriteria2);
                tv2.setText(criteriaStrings[3]);

                TextView tv3 = (TextView) findViewById(R.id.tvThreadCriteria3);
                tv3.setText(criteriaStrings[4]);

                TextView tv4 = (TextView) findViewById(R.id.tvThreadCriteria4);
                tv4.setText(criteriaStrings[5]);

                TextView tv5 = (TextView) findViewById(R.id.tvThreadCriteria5);
                tv5.setText(criteriaStrings[6]);

                TextView tv6 = (TextView) findViewById(R.id.tvThreadCriteria6);
                tv6.setText(criteriaStrings[7]);

                TextView tv7 = (TextView) findViewById(R.id.tvThreadCriteria7);
                tv7.setText(criteriaStrings[8]);

                TextView tv8 = (TextView) findViewById(R.id.tvThreadCriteria8);
                tv8.setText(criteriaStrings[9]);

                TextView tv9 = (TextView) findViewById(R.id.tvThreadCriteria9);
                tv9.setText(criteriaStrings[10]);

                TextView tv10 = (TextView) findViewById(R.id.tvThreadCriteria10);
                tv10.setText(criteriaStrings[11]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mRgShowCriteria = (RadioGroup) findViewById(R.id.rgShowCriteria);
        mRgShowCriteria.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbLevel){
                    mLayoutAll.setVisibility(View.GONE);
                    mLayoutLevel.setVisibility(View.VISIBLE);
                    mLayoutThread.setVisibility(View.GONE);
                }
                if(checkedId == R.id.rbThread){
                    mLayoutAll.setVisibility(View.GONE);
                    mLayoutLevel.setVisibility(View.GONE);
                    mLayoutThread.setVisibility(View.VISIBLE);
                }
                if(checkedId == R.id.rbAll){
                    mLayoutAll.setVisibility(View.VISIBLE);
                    mLayoutLevel.setVisibility(View.GONE);
                    mLayoutThread.setVisibility(View.GONE);
                }
            }
        });

        mRgChooseLevel = (RadioGroup) findViewById(R.id.rgChooseLevel);
        mRgChooseLevel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int mrlLevel = 0;
                if(checkedId == R.id.rbLevel1){
                    mrlLevel = 1;
                }
                if(checkedId == R.id.rbLevel2){
                    mrlLevel = 2;
                }
                if(checkedId == R.id.rbLevel3){
                    mrlLevel = 3;
                }
                if(checkedId == R.id.rbLevel4){
                    mrlLevel = 4;
                }
                if(checkedId == R.id.rbLevel5){
                    mrlLevel = 5;
                }
                if(checkedId == R.id.rbLevel6){
                    mrlLevel = 6;
                }
                if(checkedId == R.id.rbLevel7){
                    mrlLevel = 7;
                }
                if(checkedId == R.id.rbLevel8){
                    mrlLevel = 8;
                }
                if(checkedId == R.id.rbLevel9){
                    mrlLevel = 9;
                }
                if(checkedId == R.id.rbLevel10){
                    mrlLevel = 10;
                }

                TextView tvThread1 = (TextView) findViewById(R.id.tvThread1);
                TextView tvThread2 = (TextView) findViewById(R.id.tvThread2);
                TextView tvThread3 = (TextView) findViewById(R.id.tvThread3);
                TextView tvThread4 = (TextView) findViewById(R.id.tvThread4);

                String[] criteriaThread1 = getResources().getStringArray(R.array.criteriaThread1);
                String[] criteriaThread2 = getResources().getStringArray(R.array.criteriaThread2);
                String[] criteriaThread3 = getResources().getStringArray(R.array.criteriaThread3);
                String[] criteriaThread4 = getResources().getStringArray(R.array.criteriaThread4);

                tvThread1.setText(criteriaThread1[mrlLevel+1]);
                tvThread2.setText(criteriaThread2[mrlLevel+1]);
                tvThread3.setText(criteriaThread3[mrlLevel+1]);
                tvThread4.setText(criteriaThread4[mrlLevel+1]);
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
