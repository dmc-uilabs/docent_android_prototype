package com.integris.mra;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cameron.kagy on 2/9/2017.
 */
public class CriteriaAdapter extends BaseAdapter {
    private Context mContext;
    private boolean[] isColumnVisible;
    private int numColumns = 12;
    private String[] mCriteriaStrings;

    public CriteriaAdapter(Context c) {
        mContext = c;
        isColumnVisible = new boolean[10];
        for(int i=0; i<isColumnVisible.length; i++){
            isColumnVisible[i] = true;
        }

        mCriteriaStrings = new String[numColumns*3];
        String[] thread0 = mContext.getResources().getStringArray(R.array.criteriaThread0);
        String[] thread1 = mContext.getResources().getStringArray(R.array.criteriaThread1);
        String[] thread2 = mContext.getResources().getStringArray(R.array.criteriaThread2);

        for(int i=0; i<numColumns; i++){
            mCriteriaStrings[i] = thread0[i];
        }
        for(int i=0; i<numColumns; i++){
            mCriteriaStrings[i+numColumns] = thread1[i];
        }
        for(int i=0; i<numColumns; i++){
            mCriteriaStrings[i+numColumns*2] = thread2[i];
        }

        numColumns = 36;

    }

    public int getCount() {
        return numColumns;
    }

    public Object getItem(int position) {
        return null;
    }

    public String getCriteriaString(int position){
        return mCriteriaStrings[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;

        if(convertView == null){
            tv = new TextView(mContext);
            if(mCriteriaStrings[position].length() > 0){
                tv.setText("+");
            }else{
                tv.setText("");
            }
            tv.setBackgroundResource(R.drawable.custom_rectangle);
        }else{
            tv = (TextView) convertView;
        }

        return tv;
    }

    public void setColumnVisibility(int numCol, boolean isVisible){
        isColumnVisible[numCol-1] = isVisible;
        return;
    }
}
