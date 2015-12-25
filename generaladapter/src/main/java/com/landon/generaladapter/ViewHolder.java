package com.landon.generaladapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xu on 2015/12/25.
 */
public class ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;

    private ViewHolder(Context context, ViewGroup parent, int layoutID, int position){
        mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutID,parent,false);
        mConvertView.setTag(this);
    }

    /**
     * 获得一个ViewHolder对象
     * @param context
     * @param convertView
     * @param parent
     * @param layoutID
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutID, int position){
        if(convertView == null){
            return new ViewHolder(context,parent,layoutID,position);
        }
        else return (ViewHolder)convertView.getTag();
    }

    /**
     * 获得控件
     * @param viewID 控件ID
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewID){
        View view = mViews.get(viewID);
        if(view == null){
            view = mConvertView.findViewById(viewID);
            mViews.put(viewID,view);
        }
        return (T)view;
    }

    /**
     * 获得convertview
     * @return
     */
    public View getConvertView(){
        return mConvertView;
    }
}
