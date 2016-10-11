package com.haozhang.widget;

/**
 * @author HaoZhang
 * @date 2016/10/9.
 */
class QuantityManager {
    private static volatile QuantityManager sInst = null;

    public static QuantityManager getInstance() {
        QuantityManager inst = sInst;
        if (inst == null) {
            synchronized (QuantityManager.class) {
                inst = sInst;
                if (inst == null) {
                    inst = new QuantityManager();
                    sInst = inst;
                }
            }
        }
        return inst;
    }

    AndroidDynamicQuantityView.OnQuantityChangeListener mListener;

    private QuantityManager() {

    }

    int mCount;

    public void init() {
        mCount = 0;
    }

    public void increase() {
        if (mCount == 0) {
            // anim to spread

        } else {
            mCount++;
            if (null != mListener) {
                mListener.onChange(mCount);
            }
        }
    }

    public void decrease() {
        if (mCount == 1) {
            // anim to shrink

        } else {
            mCount--;
            if (null != mListener) {
                mListener.onChange(mCount);
            }
        }
    }

    public void setListener(AndroidDynamicQuantityView.OnQuantityChangeListener listener) {
        this.mListener = listener;
    }
}
