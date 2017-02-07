package com.cncn.library.listview.listview.zoom;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.cncn.library.util.LogUtil;
import com.cncn.library.listview.adapter.RecyclerAdapter;


public class PullToZoomViewEx extends PullToZoomBase<RecyclerView> implements AbsListView.OnScrollListener {

    private static final String TAG = PullToZoomViewEx.class.getSimpleName();
    protected View mHeaderView;//头部View
    protected View mZoomView;//缩放拉伸View
    private FrameLayout mHeaderContainer;
    private int mHeaderHeight;
    private ScalingRunnable mScalingRunnable;

    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float paramAnonymousFloat) {
            float f = paramAnonymousFloat - 1.0F;
            return 1.0F + f * (f * (f * (f * f)));
        }
    };

    public PullToZoomViewEx(Context context) {
        this(context, null);
    }

    public PullToZoomViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScalingRunnable = new ScalingRunnable();
        mRootView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (mZoomView != null && !isHideHeader() && isPullToZoomEnabled()) {
                    float f = mHeaderHeight - mHeaderContainer.getBottom();
                    Log.d(TAG, "onScroll --> f = " + f);
                    if (isParallax()) {
                        if ((f > 0.0F) && (f < mHeaderHeight)) {
                            int i = (int) (0.65D * f);
                            mHeaderContainer.scrollTo(0, -i);
                        } else if (mHeaderContainer.getScrollY() != 0) {
                            mHeaderContainer.scrollTo(0, 0);
                        }
                    }

                    LogUtil.d(TAG, "onScroll " + f);
                    if (headerListener != null) {
                        headerListener.height((int) f, mHeaderHeight);
                    }
                }

                if (isLastItemVisible()) {
                    if (loadMoreListener != null) {
                        loadMoreListener.onLoadMore();
                    }
                }


            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }
        });
    }

    /**
     * 是否显示headerView
     *
     * @param isHideHeader true: show false: hide
     */
    @Override
    public void setHideHeader(boolean isHideHeader) {
        if (isHideHeader != isHideHeader()) {
            super.setHideHeader(isHideHeader);
            if (isHideHeader) {
                removeHeaderView();
            } else {
                updateHeaderView();
            }
        }
    }

    public void setZoomView(View zoomView) {
        if (zoomView != null) {
            this.mZoomView = zoomView;
            updateHeaderView();
        }
    }

    public void setHeaderView(View headerView) {
        if (headerView != null) {
            this.mHeaderView = headerView;
            updateHeaderView();
        }
    }

    /**
     * 移除HeaderView
     * 如果要兼容API 9,需要修改此处逻辑，API 11以下不支持动态添加header
     */
    private void removeHeaderView() {
        if (mHeaderContainer != null) {
            if (mRootView != null && mRootView.getAdapter() != null) {

                RecyclerAdapter mAdapter = (RecyclerAdapter) mRootView.getAdapter();

                if (mAdapter != null) {

                    if (mAdapter.getHeader(0) != null)
                        mAdapter.removeHeaderView(mAdapter.getHeader(0));
                }

            }
        }
    }

    /**
     * 更新HeaderView  先移除-->再添加zoomView、HeaderView -->然后添加到listView的head
     * 如果要兼容API 9,需要修改此处逻辑，API 11以下不支持动态添加header
     */
    private void updateHeaderView() {
        if (mHeaderContainer != null) {

            if (mRootView != null && mRootView.getAdapter() != null) {

                RecyclerAdapter mAdapter = (RecyclerAdapter) mRootView.getAdapter();

                if (mAdapter != null) {

                    if (mAdapter.getHeader(0) != null)
                        mAdapter.removeHeaderView(mAdapter.getHeader(0));

                    mHeaderContainer.removeAllViews();

                    if (mZoomView != null) {
                        mHeaderContainer.addView(mZoomView);
                    }

                    if (mHeaderView != null) {
                        mHeaderContainer.addView(mHeaderView);
                    }

                    mHeaderHeight = mHeaderContainer.getHeight();


                    mAdapter.addHeaderView(RecyclerAdapter.INT_TYPE_HEADER, new RecyclerView.ViewHolder(mHeaderContainer) {
                    });
                }
            }
        }
    }

    /**
     * 创建listView 如果要兼容API9,需要修改此处
     *
     * @param context 上下文
     * @param attrs   AttributeSet
     * @return ListView
     */
    @Override
    protected RecyclerView createRootView(Context context, AttributeSet attrs) {
        RecyclerView rv = new RecyclerView(context, attrs);
        return rv;
    }

    /**
     * 重置动画，自动滑动到顶部
     */
    @Override
    protected void smoothScrollToTop() {
        mScalingRunnable.startAnimation(200L);
    }

    /**
     * zoomView动画逻辑
     *
     * @param newScrollValue 手指Y轴移动距离值
     */
    @Override
    protected void pullHeaderToZoom(int newScrollValue) {
        if (mScalingRunnable != null && !mScalingRunnable.isFinished()) {
            mScalingRunnable.abortAnimation();
        }

        ViewGroup.LayoutParams localLayoutParams = mHeaderContainer.getLayoutParams();
        localLayoutParams.height = Math.abs(newScrollValue) + mHeaderHeight;
        mHeaderContainer.setLayoutParams(localLayoutParams);
    }

    @Override
    protected boolean isReadyForPullStart() {
        return isFirstItemVisible();
    }

    private boolean isFirstItemVisible() {
        if (mRootView != null) {
            final RecyclerView.Adapter adapter = mRootView.getAdapter();
            final LinearLayoutManager mLayoutmanager = (LinearLayoutManager) mRootView.getLayoutManager();


            if (null == adapter || adapter.getItemCount() == 0) {
                return true;
            } else {
                /**
                 * This check should really just be:
                 * mRootView.getFirstVisiblePosition() == 0, but PtRListView
                 * internally use a HeaderView which messes the positions up. For
                 * now we'll just add one to account for it and rely on the inner
                 * condition which checks getTop().
                 */

                int[] into = {0, 0};
                if (mLayoutmanager != null)
                    into[0] = mLayoutmanager.findFirstVisibleItemPosition();
                if (into.length > 0 && into.length > 0 && into[0] <= 1) {
                    final View firstVisibleChild = mRootView.getChildAt(0);
                    if (firstVisibleChild != null) {
                        return firstVisibleChild.getTop() >= mRootView.getTop();
                    }
                }
            }
        }

        return false;
    }


    public boolean isLastItemVisible() {
        if (mRootView != null) {
            final RecyclerView.Adapter adapter = mRootView.getAdapter();
            LinearLayoutManager layoutManager = (LinearLayoutManager) mRootView.getLayoutManager();

            if (adapter == null || adapter.getItemCount() == 0) {
                LogUtil.d(TAG, "空数据");
                return true;
            } else {
                if (layoutManager != null) {
                    int lastPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                    if (lastPosition == adapter.getItemCount() - 1 && lastPosition > 5) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public void handleHeader() {
        mHeaderContainer = new FrameLayout(getContext());
        if (mZoomView != null) {
            mHeaderContainer.addView(mZoomView);
        }
        if (mHeaderView != null) {
            mHeaderContainer.addView(mHeaderView);
        }
        RecyclerAdapter mAdapter = (RecyclerAdapter) mRootView.getAdapter();
        if (mAdapter != null) {

            mAdapter.addHeaderView(RecyclerAdapter.INT_TYPE_HEADER, new RecyclerView.ViewHolder(mHeaderContainer) {
            });
        }
    }

    /**
     * 设置HeaderView高度
     *
     * @param width  宽
     * @param height 高
     */
    public void setHeaderViewSize(int width, int height) {
        if (mHeaderContainer != null) {
            Object localObject = mHeaderContainer.getLayoutParams();
            if (localObject == null) {
                localObject = new AbsListView.LayoutParams(width, height);
            }
            ((ViewGroup.LayoutParams) localObject).width = width;
            ((ViewGroup.LayoutParams) localObject).height = height;
            mHeaderContainer.setLayoutParams((ViewGroup.LayoutParams) localObject);
            mHeaderHeight = height;
        }
    }

    public void setHeaderLayoutParams(AbsListView.LayoutParams layoutParams) {
        if (mHeaderContainer != null) {
            mHeaderContainer.setLayoutParams(layoutParams);
            mHeaderHeight = layoutParams.height;
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2,
                            int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        Log.d(TAG, "onLayout --> ");
        if (mHeaderHeight == 0 && mHeaderContainer != null) {
            mHeaderHeight = mHeaderContainer.getHeight();
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mZoomView != null && !isHideHeader() && isPullToZoomEnabled()) {
            float f = mHeaderHeight - mHeaderContainer.getBottom();
            if (isParallax()) {
                if ((f > 0.0F) && (f < mHeaderHeight)) {
                    int i = (int) (0.65D * f);
                    mHeaderContainer.scrollTo(0, -i);
                } else if (mHeaderContainer.getScrollY() != 0) {
                    mHeaderContainer.scrollTo(0, 0);
                }
            }
        }


    }


    class ScalingRunnable implements Runnable {
        protected long mDuration;
        protected boolean mIsFinished = true;
        protected float mScale;
        protected long mStartTime;

        ScalingRunnable() {
        }

        public void abortAnimation() {
            mIsFinished = true;
        }

        public boolean isFinished() {
            return mIsFinished;
        }

        public void run() {
            if (mZoomView != null) {
                float f2;
                ViewGroup.LayoutParams localLayoutParams;
                if ((!mIsFinished) && (mScale > 1.0D)) {
                    float f1 = ((float) SystemClock.currentThreadTimeMillis() - (float) mStartTime) / (float) mDuration;
                    f2 = mScale - (mScale - 1.0F) * PullToZoomViewEx.sInterpolator.getInterpolation(f1);
                    localLayoutParams = mHeaderContainer.getLayoutParams();
                    Log.d(TAG, "ScalingRunnable --> f2 = " + f2);
                    if (f2 > 1.0F) {
                        localLayoutParams.height = ((int) (f2 * mHeaderHeight));
                        mHeaderContainer.setLayoutParams(localLayoutParams);
                        post(this);
                        return;
                    }
                    mIsFinished = true;
                }
            }
        }

        public void startAnimation(long paramLong) {
            if (mZoomView != null) {
                mStartTime = SystemClock.currentThreadTimeMillis();
                mDuration = paramLong;
                mScale = ((float) (mHeaderContainer.getBottom()) / mHeaderHeight);
                mIsFinished = false;
                post(this);
            }
        }
    }


    private onHeaderScrollListener headerListener;

    public void setHeaderListener(onHeaderScrollListener listener) {
        this.headerListener = listener;
    }

    public interface onHeaderScrollListener {
        void height(int y, int mHeaderHeight);
    }

    private OnLoadMoreListener loadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
