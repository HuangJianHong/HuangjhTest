package com.cncn.library.listview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.cncn.library.R;

/**
 * <请描述这个类是干什么的>
 *
 * @author caiyk@cncn.com
 * @data: 2016/5/20 10:29
 * @version: V1.0
 */
public abstract class PullZoomLoadMoreAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerAdapter<T, VH> {
    private LoadMoreHolder footerViewHolder;

    public PullZoomLoadMoreAdapter(Context context) {
        super(context);
        footerViewHolder = new LoadMoreHolder(LayoutInflater.from(context).inflate(R.layout.footer_loadmore, null));
        this.addFooterView(0x11, (VH) footerViewHolder);
    }


    @Override
    public void onLoadMoreStart() {
        if (footerViewHolder != null) {
            footerViewHolder.onLoadMoreStart();
        }
    }

    @Override
    public void noMoreDataCallback() {
        if (footerViewHolder != null) {
            footerViewHolder.onNoMoreData();
        }
    }

    @Override
    public void onLoadMoreReset() {
        if (footerViewHolder != null) {
            footerViewHolder.onLoadMoreReset();
        }
    }

    @Override
    public void onLoadMoreFailData(int failCode) {
        if (footerViewHolder != null) {
            footerViewHolder.onLoadMoreFailData(failCode);
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder instanceof LoadMoreHolder) {
            ((LoadMoreHolder) holder).stopAnimate(false);
            return;
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof LoadMoreHolder) {
            ((LoadMoreHolder) holder).stopAnimate(true);
        }
    }

    public static class LoadMoreHolder extends RecyclerView.ViewHolder {

        private ViewGroup mFooterView;
        private ImageView rotateImage;
        private TextView tvLoadMore;

        private Animation animation;

        private boolean isNoMoreData;

        protected int loadMoreType = 0; //1开始加载  2无数据 3重置

        protected boolean init = true;

        public LoadMoreHolder(View itemView) {
            super(itemView);

            mFooterView = (ViewGroup) itemView;
            rotateImage = (ImageView) mFooterView.findViewById(R.id.img_more);
            tvLoadMore = (TextView) mFooterView.findViewById(R.id.tv_more);

            animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.rotate);
            LinearInterpolator lin = new LinearInterpolator();
            animation.setInterpolator(lin);

            loadMoreType = 0;
            //刚开始隐藏
            stopAnimate(true);
            showFooter(false);
        }

        public void showFooter(boolean show) {
            for (int i = 0; i < mFooterView.getChildCount(); i++) {
                mFooterView.getChildAt(i).setVisibility(show ? View.VISIBLE : View.INVISIBLE);
            }
        }

        public void onLoadMoreStart() {
            init = false;
            if (loadMoreType != 1) {
                loadMoreType = 1;

                showFooter(true);

                mFooterView.setVisibility(View.VISIBLE);
                tvLoadMore.setVisibility(View.VISIBLE);
                rotateImage.setVisibility(View.VISIBLE);

                rotateImage.setAnimation(animation);
                tvLoadMore.setText(tvLoadMore.getContext().getString(R.string.load_more_ing));
            }
        }

        public void onLoadMoreFailData(int failCode) {
            loadMoreType = 2;
            tvLoadMore.setText(String.format(tvLoadMore.getContext().getString(R.string.load_more_error), failCode));
            rotateImage.clearAnimation();
            rotateImage.setVisibility(View.GONE);
            isNoMoreData = true;
            mFooterView.setVisibility(View.VISIBLE);
            tvLoadMore.setVisibility(View.VISIBLE);
        }

        public void onNoMoreData() {
            loadMoreType = 2;
            tvLoadMore.setText(tvLoadMore.getContext().getString(R.string.load_more_over));
            rotateImage.clearAnimation();
            rotateImage.setVisibility(View.GONE);
            isNoMoreData = true;
            mFooterView.setVisibility(View.VISIBLE);
            tvLoadMore.setVisibility(View.VISIBLE);
        }

        public void onLoadMoreReset() {
            if (loadMoreType != 3 && !init) {
                isNoMoreData = false;
                onLoadMoreStart();
                loadMoreType = 3;
                showFooter(false);
            }
        }

        public void stopAnimate(boolean stop) {
            if (rotateImage.getVisibility() == View.VISIBLE) {
                if (stop) {
                    rotateImage.clearAnimation();
                } else {
                    if (!isNoMoreData && !init) {
                        rotateImage.startAnimation(animation);
                    }
                }
            }
        }
    }
}
