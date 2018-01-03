package com.example.mvmax.mindgames.game;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.listener.OnBackClickListener;
import com.example.mvmax.mindgames.model.GameCardModel;
import com.example.mvmax.mindgames.toolbar.Toolbar;
import com.example.mvmax.mindgames.util.UiUtils;

public class GameFragment extends BaseFragment {

    public static final String EXTRA_GAME_CARD_MODEL = "extra_game_card_model";
    private AppCompatImageView mBlurredBackground;
    private AppCompatImageView mPoster;
    private TextView mName;
    private TextView mDescription;
    private GameCardModel mGameCardModel;

    public static Fragment newInstance(@NonNull final GameCardModel pGameCardModel) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_GAME_CARD_MODEL, pGameCardModel);

        final GameFragment baseFragment = new GameFragment();
        baseFragment.setArguments(bundle);

        return baseFragment;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setStatusBarPadding();
        initViews();
        bindHeader();
        bindViewPager(view);
    }

    private void bindViewPager(final View pView) {
        final TabLayout tabLayout = pView.findViewById(R.id.fragment_game_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Rules"));
        tabLayout.addTab(tabLayout.newTab().setText("Example"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = pView.findViewById(R.id.game_info_view_pager);
        final FragmentActivity activity = getActivity();

        if (activity == null) {
            return;
        }

        final InfoPagerAdapter adapter = new InfoPagerAdapter(activity.getSupportFragmentManager(), tabLayout, mGameCardModel.getRuleModelList());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(final TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(final TabLayout.Tab tab) {

            }
        });
    }

    private void bindHeader() {
        final int poster = mGameCardModel.getPoster();

        mBlurredBackground.setImageResource(poster);
        mPoster.setImageResource(poster);
        UiUtils.setTextOrHide(mName, mGameCardModel.getName());
        UiUtils.setTextOrHide(mDescription, mGameCardModel.getDescription());
    }

    private void initViews() {
        final Bundle bundle = getArguments();

        if (bundle == null) {
            return;
        }

        mGameCardModel = (GameCardModel) bundle.getSerializable(EXTRA_GAME_CARD_MODEL);

        final View view = getView();

        if (view != null) {
            final Toolbar toolbar = view.findViewById(R.id.toolbar_view);
            toolbar.getbackIconView().setOnClickListener(new OnBackClickListener(getContext()));

            mBlurredBackground = view.findViewById(R.id.game_fragment_background_image);
            mPoster = view.findViewById(R.id.game_fragment_poster);
            mName = view.findViewById(R.id.game_fragment_header_name);
            mDescription = view.findViewById(R.id.game_fragment_header_description);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }
}