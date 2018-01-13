package com.example.mvmax.mindgames.model;

import com.example.mvmax.mindgames.dialogexample.DialogMessageModel;
import com.example.mvmax.mindgames.games.BaseGame;
import com.example.mvmax.mindgames.rules.RuleModel;

import java.io.Serializable;
import java.util.List;

public class GameCardModel implements Serializable {

    private final BaseGame mBaseGame;

    public GameCardModel(final BaseGame pBaseGame) {
        mBaseGame = pBaseGame;
    }

    public List<GameCardTabModel> getTabList() {
        return mBaseGame.getTabList();
    }

    public int getPoster() {
        return mBaseGame.getPoster();
    }

    public String getName() {
        return mBaseGame.getName();
    }

    public List<RuleModel> getRuleList() {
        return mBaseGame.getRuleList();
    }

    public List<DialogMessageModel> getDialogExampleModelList() {
        return mBaseGame.getDialogMessageList();
    }

    public String getDescription() {
        return mBaseGame.getDescription();
    }
}