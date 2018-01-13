package com.example.mvmax.mindgames.collection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.adapter.CardPagerPagerAdapter;
import com.example.mvmax.mindgames.fragment.BaseFragment;
import com.example.mvmax.mindgames.games.YesNoGame;
import com.example.mvmax.mindgames.listener.OpenDrawerClickListener;
import com.example.mvmax.mindgames.toolbar.Toolbar;
import com.example.mvmax.mindgames.transformer.ShadowTransformer;

public class CollectionFragment extends BaseFragment {

    private static final String EXTRA_COLLECTION_LISTENER = "extra_collection_listener";

    private CollectionListener mCollectionListener;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private CardPagerPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            mCollectionListener.onPageSelected(mCardAdapter.getData().get(position).getPoster());
        }
    };

    public static Fragment newInstance(@NonNull final CollectionListener pCollectionListener) {
        final Bundle bundle = new Bundle();

        bundle.putSerializable(EXTRA_COLLECTION_LISTENER, pCollectionListener);

        final CollectionFragment baseFragment = new CollectionFragment();
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

        mCollectionListener = (CollectionListener) bundle.getSerializable(EXTRA_COLLECTION_LISTENER);

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

        mCardAdapter = new CardPagerPagerAdapter(getContext());
        mCardAdapter.addCardItem(new YesNoGame());
        mCardAdapter.addCardItem(new YesNoGame());
        mCardAdapter.addCardItem(new YesNoGame());

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

        mCollectionListener.onPageSelected(R.drawable.template_blurred_background);

        mToolbar = view.findViewById(R.id.toolbar_view);
        mToolbar.getMenuIconView().setOnClickListener(new OpenDrawerClickListener(getContext()));
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }

    @Override
    public void onPause() {
        mCollectionListener.onPause();

        super.onPause();
    }

    @Override
    public void onResume() {
        mCollectionListener.onResume();

        super.onResume();
    }
}