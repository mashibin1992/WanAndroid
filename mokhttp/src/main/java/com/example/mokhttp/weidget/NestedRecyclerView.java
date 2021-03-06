package com.example.mokhttp.weidget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class NestedRecyclerView extends RecyclerView implements NestedScrollingParent2 {

    private static final String TAG = NestedRecyclerView.class.getSimpleName();

    private NestedScrollingParentHelper mParentHelper;

    public NestedRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public NestedRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NestedRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View target, int axes, int type) {
        Log.d(TAG, "onStartNestedScroll axes = " + axes);
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.d(TAG, "onNestedScrollAccepted: ");
        mParentHelper.onNestedScrollAccepted(child, target, axes, type);
        startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL, type);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        Log.d(TAG, "onStopNestedScroll: ");
        mParentHelper.onStopNestedScroll(target, type);
        stopNestedScroll(type);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target) {
        onStopNestedScroll(target, ViewCompat.TYPE_TOUCH);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.d(TAG, "onNestedScroll dxConsumed = " + dxConsumed + ",, dyConsumed = " + dyConsumed + ",,dxUnconsumed = " + dxUnconsumed + ",,dyUnconsumed" + dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @Nullable int[] consumed, int type) {

        // dy > 0 ???????????? dy < 0 ????????????
        boolean consum = false;
        if (dy > 0){
            consum = canScrollVertically(dy) || !target.canScrollVertically(dy);
        } else {
            consum = !target.canScrollVertically(dy);
        }
        if (consum){
            scrollBy(0, dy);
            if (consumed != null) {
                consumed[1] = dy;
            }
        }
        Log.d(TAG, "onNestedPreScroll:::dy::" + dy + ",,consumed[1]::" + (consumed != null ? consumed[1] : ""));

    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed) {
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, ViewCompat.TYPE_TOUCH);
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed) {
        onNestedPreScroll(target, dx, dy, consumed, ViewCompat.TYPE_TOUCH);
    }

    @Override
    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY,
                                 boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(@NonNull View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return mParentHelper.getNestedScrollAxes();
    }

}
