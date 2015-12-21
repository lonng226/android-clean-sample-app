package com.kodelabs.mycosts.presentation.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodelabs.mycosts.R;
import com.kodelabs.mycosts.domain.model.Cost;
import com.kodelabs.mycosts.utils.DateUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dmilicic on 12/13/15.
 */
public class CostItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Cost> mCostList;
    private Context    mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.cost_item_title)
        public TextView mTitle;

        @Bind(R.id.cost_item_value)
        public TextView mTotalCost;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public CostItemAdapter(List<Cost> costList, Context context) {
        mCostList = costList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.cost_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Cost cost = mCostList.get(position);
        ViewHolder holder = (ViewHolder) viewHolder;

        final String title = String.format(mContext.getString(R.string.total_expenses),
                DateUtils.dateToText(mContext, cost.getDate()));

        holder.mTitle.setText(title);
        holder.mTotalCost.setText(String.valueOf(cost.getAmount()));
    }

    @Override
    public int getItemCount() {
        return mCostList.size();
    }
}