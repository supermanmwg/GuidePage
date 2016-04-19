package com.guidepage;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.guidepage.customviews.ChildFollowView;
import com.guidepage.customviews.ChildNotFollowView;
import com.guidepage.customviews.HorizontalScrollView;
import com.guidepage.fragments.anonymousFragment;
import com.guidepage.fragments.freshGuideFragment;
import com.guidepage.fragments.recommedFragment;
import com.guidepage.fragments.settingFragment;
import com.guidepage.fragments.tantanFragment;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private HorizontalScrollView horizontalScrollView;
    private ChildFollowView middle;
    private ChildNotFollowView first;
    private ChildNotFollowView last;

    private View tantan;
    private View message;
    private View anonymous;
    private View setting;
    private View freshGuide;
    private View recommend;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d("haha", "persistent");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar= getSupportActionBar();
        if(null != actionBar) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);
        setMiddle(new tantanFragment(), true);

        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.parent);
        middle = (ChildFollowView) findViewById(R.id.middle);
        first = (ChildNotFollowView) findViewById(R.id.first);
        last = (ChildNotFollowView) findViewById(R.id.last);
        tantan = findViewById(R.id.tantan);
        tantan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "tantan", Toast.LENGTH_SHORT).show();
                setMiddle(new tantanFragment(), false);
                horizontalScrollView.goToChild2();
            }
        });

        message = findViewById(R.id.message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT).show();
                horizontalScrollView.goToChild3();
            }
        });

        anonymous = findViewById(R.id.anonymous);
        anonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "anonymous", Toast.LENGTH_SHORT).show();
                setMiddle(new anonymousFragment(), false);
                horizontalScrollView.goToChild2();
            }
        });

        freshGuide = findViewById(R.id.fresher_guide);
        freshGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "freshGuide", Toast.LENGTH_SHORT).show();
                setMiddle(new freshGuideFragment(), false);
                horizontalScrollView.goToChild2();
            }
        });


        setting = findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                setMiddle(new settingFragment(), false);
                horizontalScrollView.goToChild2();
            }
        });

        recommend = findViewById(R.id.recommend);
        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "recommend", Toast.LENGTH_SHORT).show();
                setMiddle(new recommedFragment(), false);
                horizontalScrollView.goToChild2();
            }
        });

        middle.setHorizontalScrollView(horizontalScrollView);
        first.setHorizontalScrollView(horizontalScrollView);
        last.setHorizontalScrollView(horizontalScrollView);

        first.setOnTouchListener(this);
        last.setOnTouchListener(this);
    }

    private void  setMiddle(Fragment fragment, boolean onStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.middle, fragment);
        if(onStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
