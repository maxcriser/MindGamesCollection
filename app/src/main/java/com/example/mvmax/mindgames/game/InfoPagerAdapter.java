package com.example.mvmax.mindgames.game;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mvmax.mindgames.game.info.GameExampleFragment;
import com.example.mvmax.mindgames.game.info.GameRulesFragment;
import com.example.mvmax.mindgames.rules.RuleModel;

import java.util.List;

public class InfoPagerAdapter extends FragmentStatePagerAdapter {

    private final int mTabsCount;
    private final List<RuleModel> mRuleModelList;

    InfoPagerAdapter(final FragmentManager fm, final TabLayout pTabLayout, final List<RuleModel> pRuleModelList) {
        super(fm);
        mTabsCount = pTabLayout.getTabCount();
        mRuleModelList = pRuleModelList;
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0:
                return GameRulesFragment.newInstance(mRuleModelList);
            case 1:
                return new GameExampleFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabsCount;
    }
}
