package com.haozhang.widget.TextView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author HaoZhang
 * @date 2016/10/11.
 */
public abstract class DynamicBaseAdapter {
    public abstract View getView(ViewGroup parent, int position, LayoutInflater inflater);

    public abstract int getCount();
}
