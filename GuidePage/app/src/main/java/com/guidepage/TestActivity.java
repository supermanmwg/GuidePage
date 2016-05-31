package com.guidepage;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.library.SwipeCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwg on 16-5-5.
 */
public class TestActivity extends AppCompatActivity {

    SwipeCard swipeCard;

    private ArrayList<String> mData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        swipeCard = (SwipeCard)findViewById(R.id.swipe_card);

        mData = new ArrayList<>();
        Adapter adapter = new SwipeStackAdapter(mData);
        swipeCard.setAdapter(adapter);

        fillWithTestData();
    }

    private void fillWithTestData() {
        for (int x = 0; x < 10; x++) {
            mData.add(" " + (x + 1));
        }
    }

    public class SwipeStackAdapter extends BaseAdapter {

        private List<String> mData;

        public SwipeStackAdapter(List<String> data) {
            this.mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView =getLayoutInflater().inflate(R.layout.card, parent, false);
            }

            TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
            textViewCard.setText(mData.get(position));

            return convertView;
        }
    }
}
