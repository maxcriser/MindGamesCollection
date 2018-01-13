package com.example.mvmax.mindgames.gamecard.info;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.example.ExampleMessageModel;
import com.example.mvmax.mindgames.example.ExampleView;

import java.util.ArrayList;
import java.util.List;

public class GameCardExampleFragment extends Fragment {

    public static final String EXTRA_DIALOG_EXAMPLE_MODEL_LIST = "extra_example_message_model_list";
    List<ExampleMessageModel> mExampleMessageModelList;
    ExampleView mExampleView;

    public static Fragment newInstance(@NonNull final List<ExampleMessageModel> mRuleModelList) {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(EXTRA_DIALOG_EXAMPLE_MODEL_LIST, (ArrayList<? extends Parcelable>) mRuleModelList);

        final GameCardExampleFragment gameCardExampleFragment = new GameCardExampleFragment();
        gameCardExampleFragment.setArguments(bundle);

        return gameCardExampleFragment;
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        updateDialog();
    }

    private void initViews(final View pView) {
        mExampleView = pView.findViewById(R.id.game_fragment_dialog_example_view);
    }

    private void updateDialog() {
        final Bundle bundle = getArguments();

        if (bundle != null) {
            mExampleMessageModelList = bundle.getParcelableArrayList(EXTRA_DIALOG_EXAMPLE_MODEL_LIST);
        }

        mExampleView.setItems(mExampleMessageModelList);
    }
}