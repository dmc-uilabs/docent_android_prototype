package com.integris.mra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionnaireActivity.class);

                EditText etLocation = (EditText) findViewById(R.id.etLocation);
                String location = etLocation.getText().toString();
                intent.putExtra("EXTRA_LOCATION", location);

                EditText etScope = (EditText) findViewById(R.id.etScope);
                String scope = etScope.getText().toString();
                intent.putExtra("EXTRA_SCOPE", scope);

                EditText etRole = (EditText) findViewById(R.id.etRole);
                String role = etRole.getText().toString();
                intent.putExtra("EXTRA_ROLE", role);

                EditText etName = (EditText) findViewById(R.id.etName);
                String name = etName.getText().toString();
                intent.putExtra("EXTRA_NAME", name);

                startActivity(intent);

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
                Intent intent = new Intent(MainActivity.this, CriteriaGridActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuAssessment:
                Intent assessmentIntent = new Intent(MainActivity.this, QuestionnaireActivity.class);
                startActivity(assessmentIntent);
                return true;
            case R.id.menuMilestones:
                Intent milestonesIntent = new Intent(MainActivity.this, MilestonesActivity.class);
                startActivity(milestonesIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {

        MenuItem itemAssessment = menu.findItem(R.id.menuAssessment);
        itemAssessment.setEnabled(false);
        return true;
    }
}
