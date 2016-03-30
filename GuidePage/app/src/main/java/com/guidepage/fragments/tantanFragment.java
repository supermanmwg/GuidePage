package com.guidepage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.guidepage.R;
import com.guidepage.listeners.CustomTouchListener;

/**
 * Created by weiguangmeng on 16/3/23.
 */
public class tantanFragment extends Fragment {

    ImageView rectangle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tantan, container, false);
        rectangle = (ImageView) view.findViewById(R.id.rectangle);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CustomTouchListener customTouchListener = new CustomTouchListener(rectangle);
        rectangle.setOnTouchListener(customTouchListener);
    }

}
