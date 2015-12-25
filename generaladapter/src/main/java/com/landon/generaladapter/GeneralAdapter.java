package com.landon.generaladapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

@SuppressWarnings("unchecked")
/**
 * Created by xu on 2015/12/25.
 */

public abstract class GeneralAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutID;

    public GeneralAdapter(Context context, List<T> datas, int itemLayoutID){
        mItemLayoutID = itemLayoutID;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        mContext = context;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = ViewHolder.get(mContext,convertView,parent,mItemLayoutID,position);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder viewHolder, T item);

}
