package com.cncn.library.listview.listview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cncn.library.R;

public class DividerDecoration extends RecyclerView.ItemDecoration {

    // private Drawable mDivider;
    private int mInsets;

    public DividerDecoration(Context context) {
        // mDivider = a.getDrawable(0);
        mInsets = context.getResources().getDimensionPixelSize(R.dimen.divider_decoration);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        // We can supply forced insets for each item view here in the Rect
        outRect.set(0, mInsets, 0, mInsets / 2);
    }
}