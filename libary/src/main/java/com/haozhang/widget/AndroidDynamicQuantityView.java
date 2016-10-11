package com.haozhang.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * @author HaoZhang
 * @date 2016/10/9.
 */
public class AndroidDynamicQuantityView extends RelativeLayout {

    public OnQuantityChangeListener mQuantityChangeListener;

    public AndroidDynamicQuantityView(Context context) {
        super(context);
        init(null);
    }

    public AndroidDynamicQuantityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AndroidDynamicQuantityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    void init(AttributeSet attr) {
        ViewManager.getInstance().init(this, attr);
    }

    public void setQuantityChangeListener(OnQuantityChangeListener listener) {
        this.mQuantityChangeListener = listener;
        QuantityManager.getInstance().setListener(listener);
    }

    public OnQuantityChangeListener getQuantityChangeListener() {
        return mQuantityChangeListener;
    }

    public interface OnQuantityChangeListener {
        public void onChange(int count);
    }
}
