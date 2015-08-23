package me.jaspr.portfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jaspr on 15/8/23.
 */
public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
