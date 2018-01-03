package com.example.mvmax.mindgames.game.info;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.game.GameFragment;
import com.example.mvmax.mindgames.rules.RuleModel;
import com.example.mvmax.mindgames.rules.RulesView;

import java.util.ArrayList;
import java.util.List;

public class GameRulesFragment extends Fragment {

    public static final String EXTRA_RULE_MODEL_LIST = "extra_rule_model_list";
    List<RuleModel> mRuleModelList;
    RulesView mRulesView;

    public static Fragment newInstance(@NonNull final List<RuleModel> mRuleModelList) {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(EXTRA_RULE_MODEL_LIST, (ArrayList<? extends Parcelable>) mRuleModelList);

        final GameRulesFragment baseFragment = new GameRulesFragment();
        baseFragment.setArguments(bundle);

        return baseFragment;
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_rules, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        updateRules();
    }

    private void initViews(final View pView) {
        mRulesView = pView.findViewById(R.id.game_fragment_rules_view);
    }

    private void updateRules() {
        final Bundle bundle = getArguments();

        if (bundle != null) {
            mRuleModelList = bundle.getParcelableArrayList(EXTRA_RULE_MODEL_LIST);
        }

        mRulesView.setItems(mRuleModelList);
    }
}