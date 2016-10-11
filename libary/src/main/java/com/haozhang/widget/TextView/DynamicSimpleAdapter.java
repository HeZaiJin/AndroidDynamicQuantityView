package com.haozhang.widget.TextView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haozhang.widget.R;

/**
 * @author HaoZhang
 * @date 2016/10/11.
 */
public class DynamicSimpleAdapter extends DynamicBaseAdapter {
    String[] mDatas;

    public DynamicSimpleAdapter() {
        mDatas = new String[]{"AA", "BBB", "CCC", "DD", "EEEE", "FFFFF", "GGGG", "H", "III"};
    }

    @Override
    public View getView(ViewGroup parent, int position, LayoutInflater inflater) {
        View item = inflater.inflate(R.layout.item_layout, null);
        TextView tv = (TextView) item.findViewById(R.id.item);
        tv.setText(mDatas[position]);
        return item;
    }

    @Override
    public int getCount() {
        return mDatas.length;
    }
}
