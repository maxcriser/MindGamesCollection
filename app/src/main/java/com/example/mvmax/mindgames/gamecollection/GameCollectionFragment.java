package com.example.mvmax.mindgames.gamecollection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.base.BaseFragment;
import com.example.mvmax.mindgames.gamecollection.adapter.GameCollectionPagerAdapter;
import com.example.mvmax.mindgames.gamecollection.listener.IGameCollectionListener;
import com.example.mvmax.mindgames.games.guessthestory.GuessTheStoryGame;
import com.example.mvmax.mindgames.clicklistener.OpenDrawerClickListener;
import com.example.mvmax.mindgames.toolbar.Toolbar;
import com.example.mvmax.mindgames.gamecollection.transformer.ShadowTransformer;

public class GameCollectionFragment extends BaseFragment {

    private static final String EXTRA_COLLECTION_LISTENER = "extra_collection_listener";

    private IGameCollectionListener mGameCollectionListener;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private GameCollectionPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            mGameCollectionListener.onPageSelected(mCardAdapter.getData().get(position).getPoster());
        }
    };

    public static Fragment newInstance(@NonNull final IGameCollectionListener pGameCollectionListener) {
        final Bundle bundle = new Bundle();

        bundle.putSerializable(EXTRA_COLLECTION_LISTENER, pGameCollectionListener);

        final GameCollectionFragment baseFragment = new GameCollectionFragment();
        baseFragment.setArguments(bundle);

        return baseFragment;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Bundle bundle = getArguments();

        if (bundle == null) {
            return;
        }

        mGameCollectionListener = (IGameCollectionListener) bundle.getSerializable(EXTRA_COLLECTION_LISTENER);

        setStatusBarPadding();
        initViews();
        initPager();
    }

    private void initPager() {
        final View view = getView();

        if (view == null) {
            return;
        }

        mViewPager = view.findViewById(R.id.view_pager);

        mCardAdapter = new GameCollectionPagerAdapter(getContext());
        mCardAdapter.addCardItem(new GuessTheStoryGame());
        mCardAdapter.addCardItem(new GuessTheStoryGame());
        mCardAdapter.addCardItem(new GuessTheStoryGame());

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
        final View view = getView();

        if (view == null) {
            return;
        }

        mGameCollectionListener.onPageSelected(R.drawable.template_blurred_background);

        mToolbar = view.findViewById(R.id.toolbar_view);
        mToolbar.getMenuIconView().setOnClickListener(new OpenDrawerClickListener(getContext()));
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }

    @Override
    public void onPause() {
        mGameCollectionListener.onPause();

        super.onPause();
    }

    @Override
    public void onResume() {
        mGameCollectionListener.onResume();

        super.onResume();
    }
}