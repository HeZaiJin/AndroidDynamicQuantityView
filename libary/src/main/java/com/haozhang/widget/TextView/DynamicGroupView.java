package com.haozhang.widget.TextView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author HaoZhang
 * @date 2016/10/11.
 */
public class DynamicGroupView extends ViewGroup {
    private static final String TAG = "DynamicGroupView";
    DynamicBaseAdapter mAdapter;
    LayoutInflater mInflater;

    public DynamicGroupView(Context context) {
        super(context);
        init(context);
    }

    public DynamicGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DynamicGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int rw = MeasureSpec.getSize(widthMeasureSpec);
        int rh = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            LayoutParams lParams = (LayoutParams) child.getLayoutParams();
            int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

            child.measure(width, height);
            height = child.getMeasuredHeight();
            width = child.getMeasuredWidth();
            int dia = width;
            if (height > dia) {
                dia = height;
            }
            lParams.dia = dia;

            if (i > 0) {
                View last = getChildAt(i - 1);
                LayoutParams params = (LayoutParams) last.getLayoutParams();
                int lastR = params.dia / 2;
                int r = lParams.dia / 2;
                if (i % 2 == 1) {
                    int offset = (int) (lastR + Math.sqrt((lastR + r + 10) * (lastR + r + 10) / 2.00)) - r;
                    lParams.left = params.left + offset;
                    lParams.top = params.top + offset;
                } else {
                    lParams.left = (int) (params.left + lastR + Math.sqrt(lastR * lastR / 2));
                    lParams.top = params.top + lastR - r - (int) (Math.sqrt((lastR + 10+r) * (lastR + r+ 10) / 2.00));
                }
            } else {
                lParams.top = 0;
                lParams.left = 0;
            }
        }

        int vw = rw;
        int vh = rh;
        setMeasuredDimension(vw, vh);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = this.getChildAt(i);
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            child.layout(params.left, params.top, params.left + params.dia, params.top + params.dia);
        }
    }

    public void setAdapter(DynamicBaseAdapter adapter) {
        this.mAdapter = adapter;
        removeAllViews();
        createItems();
    }


    void createItems() {
        int count = mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            View child = mAdapter.getView(this, i, mInflater);
            if (null == child) {
                throw new IllegalArgumentException("getView can not return null object");
            }
            addView(child, i);
        }
        requestLayout();
    }


    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int left = 0;
        public int top = 0;
        public int dia = 0;

        public LayoutParams(Context arg0, AttributeSet arg1) {
            super(arg0, arg1);
        }

        public LayoutParams(int arg0, int arg1) {
            super(arg0, arg1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams arg0) {
            super(arg0);
        }
    }

    @Override
    public android.view.ViewGroup.LayoutParams generateLayoutParams(
            AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }
}
