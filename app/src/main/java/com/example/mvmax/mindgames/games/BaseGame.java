package com.example.mvmax.mindgames.games;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.gamecard.info.example.ExampleMessageModel;
import com.example.mvmax.mindgames.gamecard.model.GameCardTabModel;
import com.example.mvmax.mindgames.gamecard.info.rules.RuleModel;

import java.util.List;

public abstract class BaseGame extends Fragment {

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return null;
    }

    public abstract int getPoster();

    public abstract String getName();

    public abstract String getDescription();

    public abstract List<RuleModel> getRuleList();

    public abstract List<ExampleMessageModel> getDialogMessageList();

    public abstract List<GameCardTabModel> getTabList();

}