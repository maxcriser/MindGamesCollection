package com.example.mvmax.mindgames.model;

import com.example.mvmax.mindgames.rules.RuleModel;

import java.io.Serializable;
import java.util.List;

public class GameCardModel implements Serializable {

    private final int mPoster;
    private final String mName;
    private final String mDescription;
    private final List<RuleModel> mRuleModelList;

    public GameCardModel(final int pPoster, final String pName, final String pDescription, final List<RuleModel> pRuleModelList) {
        mPoster = pPoster;
        mName = pName;
        mDescription = pDescription;
        mRuleModelList = pRuleModelList;
    }

    public int getPoster() {
        return mPoster;
    }

    public String getName() {
        return mName;
    }

    public List<RuleModel> getRuleModelList() {
        return mRuleModelList;
    }

    public String getDescription() {
        return mDescription;
    }
}