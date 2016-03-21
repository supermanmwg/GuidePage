package com.guidepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.guidepage.customviews.ChildFollowView;
import com.guidepage.customviews.ChildNotFollowView;
import com.guidepage.customviews.HorizontalScrollView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private HorizontalScrollView horizontalScrollView;
    private ChildFollowView middle;
    private ChildNotFollowView first;
    private ChildNotFollowView last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.parent);
        middle = (ChildFollowView) findViewById(R.id.middle);
        first = (ChildNotFollowView) findViewById(R.id.first);
        last = (ChildNotFollowView) findViewById(R.id.last);

        middle.setHorizontalScrollView(horizontalScrollView);
        first.setHorizontalScrollView(horizontalScrollView);
        last.setHorizontalScrollView(horizontalScrollView);

        first.setOnTouchListener(this);
        last.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
