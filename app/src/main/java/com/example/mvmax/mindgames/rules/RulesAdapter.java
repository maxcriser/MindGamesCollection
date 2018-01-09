package com.example.mvmax.mindgames.rules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mvmax.mindgames.ContextHolder;
import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.util.UiUtils;

import java.util.Collection;
import java.util.List;

public class RulesAdapter extends RecyclerView.Adapter<RulesAdapter.RuleViewHolder> {

    private List<RuleModel> mList;

    final class RuleViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mDescription;
        private final FrameLayout mTopLine;
        private final FrameLayout mBottomLine;

        private RuleViewHolder(final View view) {
            super(view);

            mTitle = view.findViewById(R.id.rule_title);
            mDescription = view.findViewById(R.id.rule_description);
            mTopLine = view.findViewById(R.id.rule_top_line);
            mBottomLine = view.findViewById(R.id.rule_bottom_line);
        }
    }

    public RulesAdapter(final List<RuleModel> pList) {
        mList = pList;
    }

    public void setData(final List<RuleModel> pList) {
        mList = pList;
    }

    public void addData(final Collection<RuleModel> pList) {
        if (mList != null) {
            mList.addAll(pList);
        }
    }

    @Override
    public RuleViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_rule, parent, false);

        return new RuleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RuleViewHolder holder, final int pCurrentPosition) {
        final RuleModel item = mList.get(pCurrentPosition);

        holder.mTitle.setText(item.getTitle());
        holder.mDescription.setText(item.getDescription());

        if (pCurrentPosition == 0) {
            holder.mTopLine.setVisibility(View.INVISIBLE);
        }

        if (pCurrentPosition == getItemCount() - 1) {
            holder.mBottomLine.setVisibility(View.INVISIBLE);
        } else {
            final ViewGroup.LayoutParams layoutParams = holder.mBottomLine.getLayoutParams();

            holder.mDescription.measure(0, 0);
            layoutParams.height = (int) UiUtils.dpToPx(ContextHolder.get(), holder.mDescription.getMeasuredHeight());
            holder.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}