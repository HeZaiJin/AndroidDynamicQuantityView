package com.haozhang.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author HaoZhang
 * @date 2016/10/9.
 */
class ViewManager {
    private static volatile ViewManager sInst = null;

    public static ViewManager getInstance() {
        ViewManager inst = sInst;
        if (inst == null) {
            synchronized (ViewManager.class) {
                inst = sInst;
                if (inst == null) {
                    inst = new ViewManager();
                    sInst = inst;
                }
            }
        }
        return inst;
    }

    AndroidDynamicQuantityView mParent;
    Context mContext;
    ImageView mDecreseView;
    ImageView mIncreseView;
    TextView mTextView;

    private ViewManager() {

    }

    public void init(AndroidDynamicQuantityView group, AttributeSet attr) {
        mParent = group;
        mContext = group.getContext();
        QuantityManager.getInstance().init();
        createTextView();
        createDecreaseView();
        createIncreaseView();
    }

    void createDecreaseView() {
        mDecreseView = new ImageView(mContext);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        mDecreseView.setImageResource(R.drawable.icon_decrease);
        mParent.addView(mDecreseView, params);
    }

    void createTextView() {
        mTextView = new TextView(mContext);
        mTextView.setText(1+"");
        mTextView.setTextColor(Color.parseColor("#737b84"));
        mTextView.setTextSize(40);
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setBackgroundResource(R.drawable.text_background);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(126, 126);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        mParent.addView(mTextView, params);
    }

    void createIncreaseView() {
        mIncreseView = new ImageView(mContext);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        mIncreseView.setImageResource(R.drawable.icon_increase);
        mParent.addView(mIncreseView, params);
    }
}
