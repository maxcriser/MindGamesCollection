package com.example.mvmax.mindgames.gamecard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mvmax.mindgames.model.GameCardModel;
import com.example.mvmax.mindgames.model.GameCardTabModel;

import java.util.List;

public class InfoPagerAdapter extends FragmentStatePagerAdapter {

    private final int mTabsCount;
    private final List<GameCardTabModel> mTabs;

    InfoPagerAdapter(final FragmentManager fm, final GameCardModel pGameCardModel) {
        super(fm);
        mTabs = pGameCardModel.getTabList();
        mTabsCount = mTabs.size();
    }

    @Override
    public Fragment getItem(final int pPosition) {
        return mTabs.get(pPosition).getFragment();
    }

    @Override
    public int getCount() {
        return mTabsCount;
    }
}
