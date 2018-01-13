package com.example.mvmax.mindgames.games;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.ContextHolder;
import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.dialogexample.DialogMessageModel;
import com.example.mvmax.mindgames.gamecard.info.GameCardExampleFragment;
import com.example.mvmax.mindgames.gamecard.info.GameCardRulesFragment;
import com.example.mvmax.mindgames.model.GameCardTabModel;
import com.example.mvmax.mindgames.rules.RuleModel;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

public class YesNoGame extends BaseGame {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getPoster() {
        return R.drawable.template_poster;
    }

    @Override
    public String getName() {
        return LoremIpsum.getInstance().getWords(2, 3);
    }

    @Override
    public String getDescription() {
        return LoremIpsum.getInstance().getWords(5, 15);
    }

    @Override
    public List<RuleModel> getRuleList() {
        final List<RuleModel> rulesList = new ArrayList<>();
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));
        rulesList.add(new RuleModel(LoremIpsum.getInstance().getWords(2, 50), LoremIpsum.getInstance().getWords(10, 60)));

        return rulesList;
    }

    @Override
    public List<DialogMessageModel> getDialogMessageList() {
        final List<DialogMessageModel> exampleList = new ArrayList<>();
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.INFO));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PRESENTER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PLAYER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PRESENTER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.INFO));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PLAYER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PLAYER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PRESENTER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.INFO));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.PRESENTER));
        exampleList.add(new DialogMessageModel(LoremIpsum.getInstance().getWords(1, 20), DialogMessageModel.DialogMessageType.FINISH));

        return exampleList;
    }

    @Override
    public List<GameCardTabModel> getTabList() {
        final List<GameCardTabModel> tabListTwo = new ArrayList<>();
        tabListTwo.add(new GameCardTabModel(ContextHolder.get().getString(R.string.game_card_rules), GameCardRulesFragment.newInstance(getRuleList())));
        tabListTwo.add(new GameCardTabModel(ContextHolder.get().getString(R.string.game_card_example), GameCardExampleFragment.newInstance(getDialogMessageList())));

        return tabListTwo;
    }
}
