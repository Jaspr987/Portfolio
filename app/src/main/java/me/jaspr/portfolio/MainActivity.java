package me.jaspr.portfolio;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.github.florent37.materialimageloading.MaterialImageLoading;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String name = getString(R.string.name);
        final Toolbar toolbar =  (Toolbar)findViewById(R.id.toolbar);
        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        final CardView card1 = (CardView)findViewById(R.id.card1);
        final CardView card2 = (CardView)findViewById(R.id.card2);
        final CardView card3 = (CardView)findViewById(R.id.card3);
        final ImageView imageView = (ImageView)findViewById(R.id.backdrop);

        //Using Material Image Loading Animation When Launching
        //MaterialImageLoading.animate(imageView).setDuration(2000).start();

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WorksActivity.class));
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_SENDTO).setData(Uri.parse("mailto:wang@jaspr.me")));
            }
        });
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Snackbar.make(collapsingToolbarLayout, "Email Me", Snackbar.LENGTH_LONG)
                        .show();
                return true;
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_logo);

        //Drawable to Bitmap
        Drawable drawable = getDrawable(R.drawable.ic_logo);
        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
        Bitmap recentIcon = bitmapDrawable.getBitmap();
        String recentTitle = getString(R.string.recent_title);
        int recentColor = getColor(R.color.orange_primary);

        //Set Recent Screen Windows Title, Icon and Color
        ActivityManager.TaskDescription  description = new ActivityManager.TaskDescription(recentTitle, recentIcon, recentColor);
        this.setTaskDescription(description);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, InfoActivity.class));
            return true;
        }

        if (i < 6) {
            i++;
        }else {
            Snackbar.make(collapsingToolbarLayout, getString(R.string.easter_egg), Snackbar.LENGTH_LONG)
                    .setAction("Excited", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
            i = 0;
        }

        return super.onOptionsItemSelected(item);
    }
}
