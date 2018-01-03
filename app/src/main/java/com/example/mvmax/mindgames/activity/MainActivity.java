package com.example.mvmax.mindgames.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.adapter.CardPagerPagerAdapter;
import com.example.mvmax.mindgames.listener.OpenDrawerClickListener;
import com.example.mvmax.mindgames.model.GameCardModel;
import com.example.mvmax.mindgames.rules.RuleModel;
import com.example.mvmax.mindgames.toolbar.Toolbar;
import com.example.mvmax.mindgames.transformer.ShadowTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private CardPagerPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            setBackground(mCardAdapter.getData().get(position).getPoster());
        }
    };

    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initPager();
    }

    private void initPager() {
        mViewPager = findViewById(R.id.view_pager);

        // TODO: 03.01.2018 remove after testing MOVE ALL CARDS TO GAME FRAGMENTS TO STATIC VARIABLES

        final List<RuleModel> list = new ArrayList<>();
        list.add(new RuleModel("title title", "description description description description description description"));
        list.add(new RuleModel("title title", "description description description description description description"));
        list.add(new RuleModel("title title", "description description description description description description"));
        list.add(new RuleModel("title title", "description description description description description description"));
        list.add(new RuleModel("title title", "description description description description description description"));
        list.add(new RuleModel("title title", "description description description description description description"));

        mCardAdapter = new CardPagerPagerAdapter(this);
        mCardAdapter.addCardItem(new GameCardModel(R.drawable.template_poster, "Game name", "The best of the best of the best game in the World.", list));
        mCardAdapter.addCardItem(new GameCardModel(R.drawable.template_poster_2, "Game name", "The best of the best of the best game in the World.", list));
        mCardAdapter.addCardItem(new GameCardModel(R.drawable.template_poster_3, "Game name", "The best of the best of the best game in the World.", list));
        mCardAdapter.addCardItem(new GameCardModel(R.drawable.template_poster_4, "Game name", "The best of the best of the best game in the World.", list));
        mCardAdapter.addCardItem(new GameCardModel(R.drawable.template_poster_5, "Game name", "The best of the best of the best game in the World.", list));
        mCardAdapter.addCardItem(new GameCardModel(R.drawable.template_poster_6, "Game name", "The best of the best of the best game in the World.", list));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling();

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(0);

        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mOnPageChangeListener.onPageSelected(0);
    }

    private void initViews() {
        setBackground(R.drawable.template_blurred_background);
        setContentStatusBarPadding();

        mToolbar = findViewById(R.id.toolbar_view);
        mToolbar.getMenuIconView().setOnClickListener(new OpenDrawerClickListener(this));
    }
}