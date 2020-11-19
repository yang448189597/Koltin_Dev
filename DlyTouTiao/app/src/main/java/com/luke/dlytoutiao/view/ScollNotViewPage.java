package com.luke.dlytoutiao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class ScollNotViewPage extends ViewPager {
    public ScollNotViewPage(@NonNull Context context) {
        super(context);
    }

    public ScollNotViewPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //事件分发 拦截侧滑
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    // 消费掉滑动事件 不继续分发
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
