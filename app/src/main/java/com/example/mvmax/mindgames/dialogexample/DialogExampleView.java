package com.example.mvmax.mindgames.dialogexample;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.mvmax.mindgames.R;

import java.util.List;

public class DialogExampleView extends RelativeLayout {

    private RecyclerView mRecyclerView;

    public DialogExampleView(final Context context) {
        super(context);
        init();
    }

    public DialogExampleView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DialogExampleView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void inflate() {
        inflate(getContext(), R.layout.view_dialog_example, this);

        mRecyclerView = findViewById(R.id.dialog_example_view_recycler_view);
    }

    private void init() {
        inflate();
    }

    private void init(final AttributeSet pAttrs) {
        inflate();
    }

    public void setItems(final List<DialogMessageModel> pDialogExampleModelList) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        final DialogExampleAdapter mDialogExampleAdapter = new DialogExampleAdapter(pDialogExampleModelList);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mDialogExampleAdapter);
    }
}