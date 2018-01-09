package com.example.mvmax.mindgames.game;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mvmax.mindgames.game.info.GameExampleFragment;
import com.example.mvmax.mindgames.game.info.GameRulesFragment;
import com.example.mvmax.mindgames.model.GameCardModel;

public class InfoPagerAdapter extends FragmentStatePagerAdapter {

    private final int mTabsCount;
    private final GameCardModel mGameCardModel;

    InfoPagerAdapter(final FragmentManager fm, final TabLayout pTabLayout, final GameCardModel pGameCardModel) {
        super(fm);
        mTabsCount = pTabLayout.getTabCount();
        mGameCardModel = pGameCardModel;
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0:
                return GameRulesFragment.newInstance(mGameCardModel.getRuleModelList());
            case 1:
                return GameExampleFragment.newInstance(mGameCardModel.getDialogExampleModelList());
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabsCount;
    }
}
