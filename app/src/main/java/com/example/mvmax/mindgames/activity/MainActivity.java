package com.example.mvmax.mindgames.activity;

import android.os.Bundle;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.base.BaseActivity;
import com.example.mvmax.mindgames.gamecollection.listener.GameCollectionListener;

public class MainActivity extends BaseActivity {

    private final GameCollectionListener mOnPageChangeListener = new GameCollectionListener() {

        @Override
        public void onPageSelected(final int pPoster) {
            setBackground(pPoster);
        }

        @Override
        public void onResume() {
            enableDrawer();
        }

        @Override
        public void onPause() {
            disableDrawer();
        }
    };

    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);

        showCollectionFragment(mOnPageChangeListener);
    }
}