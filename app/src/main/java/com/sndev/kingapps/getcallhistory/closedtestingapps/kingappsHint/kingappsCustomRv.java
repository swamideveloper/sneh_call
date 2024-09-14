package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsHint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


public class kingappsCustomRv extends RecyclerView {
    private static final int SPEED = 50;
    private static final String TAG = "AutoScrollRecyclerView";
    private boolean isStopAutoScroll;
    private boolean mCanTouch;
    private int mCurrentSpeed;
    private boolean mInflate;
    private UniformSpeedInterpolator mInterpolator;
    private boolean mIsOpenAuto;
    private boolean mLoopEnabled;
    private boolean mPointTouch;
    private boolean mReady;
    private boolean mReverse;
    private int mSpeedDx;
    private int mSpeedDy;

    public boolean canTouch() {
        return this.mCanTouch;
    }

    public boolean getReverse() {
        return this.mReverse;
    }

    public boolean isLoopEnabled() {
        return this.mLoopEnabled;
    }

    public void pauseAutoScroll(boolean z) {
        this.isStopAutoScroll = z;
    }

    public void setCanTouch(boolean z) {
        this.mCanTouch = z;
    }

    public kingappsCustomRv(Context context) {
        this(context, null);
    }

    public kingappsCustomRv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public kingappsCustomRv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentSpeed = 50;
        this.mCanTouch = true;
        this.isStopAutoScroll = false;
        this.mInterpolator = new UniformSpeedInterpolator();
        this.mReady = false;
    }

    public void startAutoScroll() {
        this.isStopAutoScroll = false;
        openAutoScroll(this.mCurrentSpeed, false);
    }

    public void openAutoScroll(int i, boolean z) {
        this.mReverse = z;
        this.mCurrentSpeed = i;
        this.mIsOpenAuto = true;
        notifyLayoutManager();
        startScroll();
    }

    public void setLoopEnabled(boolean z) {
        this.mLoopEnabled = z;
        if (getAdapter() != null) {
            getAdapter().notifyDataSetChanged();
            startScroll();
        }
    }

    public void setReverse(boolean z) {
        this.mReverse = z;
        notifyLayoutManager();
        startScroll();
    }

    private void startScroll() {
        if (this.mIsOpenAuto && getScrollState() != 2 && this.mInflate && this.mReady) {
            this.mSpeedDy = 0;
            this.mSpeedDx = 0;
            smoothScroll();
        }
    }

    private void smoothScroll() {
        if (this.isStopAutoScroll) {
            return;
        }
        int abs = Math.abs(this.mCurrentSpeed);
        if (this.mReverse) {
            abs = -abs;
        }
        smoothScrollBy(abs, abs, this.mInterpolator);
    }

    private void notifyLayoutManager() {
        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.setReverseLayout(this.mReverse);
                return;
            }
            return;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        if (staggeredGridLayoutManager != null) {
            staggeredGridLayoutManager.setReverseLayout(this.mReverse);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(Adapter adapter, boolean z) {
        super.swapAdapter(generateAdapter(adapter), z);
        this.mReady = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(Adapter adapter) {
        super.setAdapter(generateAdapter(adapter));
        this.mReady = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mCanTouch) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mPointTouch = true;
            } else if ((action == 1 || action == 3) && this.mIsOpenAuto) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCanTouch) {
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && this.mIsOpenAuto) {
                this.mPointTouch = false;
                smoothScroll();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        startScroll();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mInflate = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        if (this.mPointTouch) {
            this.mSpeedDx = 0;
            this.mSpeedDy = 0;
        } else if (i == 0) {
            int i3 = this.mSpeedDy + i2;
            this.mSpeedDy = i3;
            if (Math.abs(i3) >= Math.abs(this.mCurrentSpeed)) {
                this.mSpeedDy = 0;
                smoothScroll();
            }
        } else {
            int i4 = this.mSpeedDx + i;
            this.mSpeedDx = i4;
            if (Math.abs(i4) >= Math.abs(this.mCurrentSpeed)) {
                this.mSpeedDx = 0;
                smoothScroll();
            }
        }
    }

    private NestingRecyclerViewAdapter generateAdapter(Adapter adapter) {
        return new NestingRecyclerViewAdapter(this, adapter);
    }

    
    public static class UniformSpeedInterpolator implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }

        private UniformSpeedInterpolator() {
        }
    }

    
    public static class NestingRecyclerViewAdapter<VH extends ViewHolder> extends Adapter<VH> {
        Adapter<VH> mAdapter;
        private kingappsCustomRv mRecyclerView;

        NestingRecyclerViewAdapter(kingappsCustomRv mZ_AutoScrollRecyclerView, Adapter<VH> adapter) {
            this.mAdapter = adapter;
            this.mRecyclerView = mZ_AutoScrollRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.mAdapter.onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            super.registerAdapterDataObserver(adapterDataObserver);
            this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
            this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i) {
            this.mAdapter.onBindViewHolder(vh, generatePosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void setHasStableIds(boolean z) {
            super.setHasStableIds(z);
            this.mAdapter.setHasStableIds(z);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (getLoopEnable()) {
                return Integer.MAX_VALUE;
            }
            return this.mAdapter.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.mAdapter.getItemViewType(generatePosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.mAdapter.getItemId(generatePosition(i));
        }

        private int generatePosition(int i) {
            return getLoopEnable() ? getActualPosition(i) : i;
        }

        private int getActualPosition(int i) {
            int itemCount = this.mAdapter.getItemCount();
            return i >= itemCount ? i % itemCount : i;
        }

        private boolean getLoopEnable() {
            return this.mRecyclerView.mLoopEnabled;
        }

        public boolean getReverse() {
            return this.mRecyclerView.mReverse;
        }
    }
}
