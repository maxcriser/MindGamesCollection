package com.example.mvmax.mindgames.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.util.UiUtils;

public class AppDrawer extends RelativeLayout {

//    @Retention(RetentionPolicy.SOURCE)
//    @IntDef({Action.NONE,
//            Action.MENU,
//            Action.BACK})
//    public @interface Action {
//        int NONE = 0;
//        int MENU = 1;
//        int BACK = 2;
//    }

    public AppDrawer(final Context context) {
        super(context);
        init();
    }

    public AppDrawer(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AppDrawer(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private boolean containsFlag(final int flagSet, final int flag) {
        final int result = flagSet | flag;

        return result == flagSet;
    }

    private void initActions(final int pActions) {
//        if (pActions > Action.NONE) {
//            VIEW.setVisibility(containsFlag(pActions, Action.MENU) ? View.VISIBLE : View.GONE);
//        }
    }

    private void inflate() {
        inflate(getContext(), R.layout.view_drawer, this);

        setStatusBarPadding();
        // findViewById
    }

    private void init() {
        inflate();
    }

    private void init(final AttributeSet pAttrs) {
        inflate();

//        @SuppressLint("CustomViewStyleable") final TypedArray typedArray = getContext().obtainStyledAttributes(pAttrs, R.styleable.custom_AppDrawer, 0, 0);
//
//        try {
//            final int actions = typedArray.getInteger(R.styleable.custom_AppDrawer_action, Action.NONE);
//
//            updateVew(actions);
//        } finally {
//            typedArray.recycle();
//        }
    }

    private void setStatusBarPadding() {
        final View rootView = findViewById(R.id.content_drawer);
        rootView.setPadding(0, UiUtils.getStatusBarHeight(getContext()), 0, 0);
    }
}