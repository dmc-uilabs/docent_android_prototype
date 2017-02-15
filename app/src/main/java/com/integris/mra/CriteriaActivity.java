package com.integris.mra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TableLayout;

/**
 * Created by cameron.kagy on 2/7/2017.
 */
public class CriteriaActivity extends AppCompatActivity {

    CheckBox mCbCol1;
    CheckBox mCbCol2;
    CheckBox mCbCol3;
    CheckBox mCbCol4;
    CheckBox mCbCol5;
    CheckBox mCbCol6;
    CheckBox mCbCol7;
    CheckBox mCbCol8;
    CheckBox mCbCol9;
    CheckBox mCbCol10;


    TableLayout mTableCriteria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria);

        mTableCriteria = (TableLayout) findViewById(R.id.tableCriteria);

        mCbCol1 = (CheckBox) findViewById(R.id.cbCol1);
        mCbCol1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(2, !mTableCriteria.isColumnCollapsed(2));
            }
        });

        mCbCol2 = (CheckBox) findViewById(R.id.cbCol2);
        mCbCol2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(3, !mTableCriteria.isColumnCollapsed(3));
            }
        });

        mCbCol3 = (CheckBox) findViewById(R.id.cbCol3);
        mCbCol3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(4, !mTableCriteria.isColumnCollapsed(4));
            }
        });

        mCbCol4 = (CheckBox) findViewById(R.id.cbCol4);
        mCbCol4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(5, !mTableCriteria.isColumnCollapsed(5));
            }
        });

        mCbCol5 = (CheckBox) findViewById(R.id.cbCol5);
        mCbCol5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(6, !mTableCriteria.isColumnCollapsed(6));
            }
        });

        mCbCol6 = (CheckBox) findViewById(R.id.cbCol6);
        mCbCol6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(7, !mTableCriteria.isColumnCollapsed(7));
            }
        });

        mCbCol7 = (CheckBox) findViewById(R.id.cbCol7);
        mCbCol7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(8, !mTableCriteria.isColumnCollapsed(8));
            }
        });

        mCbCol8 = (CheckBox) findViewById(R.id.cbCol8);
        mCbCol8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(9, !mTableCriteria.isColumnCollapsed(9));
            }
        });

        mCbCol9 = (CheckBox) findViewById(R.id.cbCol9);
        mCbCol9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(10, !mTableCriteria.isColumnCollapsed(10));
            }
        });

        mCbCol1 = (CheckBox) findViewById(R.id.cbCol1);
        mCbCol1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTableCriteria.setColumnCollapsed(0, !mTableCriteria.isColumnCollapsed(0));
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
                Intent intent = new Intent(CriteriaActivity.this, CriteriaActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuAssessment:
                Intent assessmentIntent = new Intent(CriteriaActivity.this, MainActivity.class);
                startActivity(assessmentIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}