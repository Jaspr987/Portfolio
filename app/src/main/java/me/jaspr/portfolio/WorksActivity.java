package me.jaspr.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Jaspr on 15/8/29.
 */
public class WorksActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works);
        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView card1 = (CardView)findViewById(R.id.card_work_1);
        CardView card2 = (CardView)findViewById(R.id.card_work_2);
        CardView card3 = (CardView)findViewById(R.id.card_work_3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorksActivity.this, WorkDetailActivity.class));
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorksActivity.this, WorkDetailActivity.class));
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorksActivity.this, WorkDetailActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //show finish activity animation
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }
}
