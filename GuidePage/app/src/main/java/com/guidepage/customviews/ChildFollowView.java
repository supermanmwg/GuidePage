package com.guidepage.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by weiguangmeng on 16/3/21.
 */
public class ChildFollowView extends LinearLayout {
    private HorizontalScrollView horizontalScrollView;

    public ChildFollowView(Context context) {
        super(context);
    }

    public ChildFollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                horizontalScrollView.requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                horizontalScrollView.requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setHorizontalScrollView(HorizontalScrollView horizontalScrollView) {
        this.horizontalScrollView = horizontalScrollView;
    }
}
