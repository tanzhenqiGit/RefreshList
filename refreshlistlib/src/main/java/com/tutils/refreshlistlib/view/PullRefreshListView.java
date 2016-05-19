package com.tutils.refreshlistlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tutils.refreshlistlib.R;

/**
 * Created by lz100 on 2016/5/19.
 */
public class PullRefreshListView extends ListView {

    public PullRefreshListView(Context context) {
        super(context);
        initialize(context);
    }

    public PullRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public PullRefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSelection(1);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        setSelection(1);
    }

    private void initialize(Context context)
    {
        mRotateAnimation = new RotateAnimation(0, -180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        mRotateAnimation.setInterpolator(new LinearInterpolator());
        mRotateAnimation.setDuration(ANIMATION_REFRESH_DURATION_TIME);
        mRotateAnimation.setFillAfter(true);

        mLayoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mRefreshHeadView = mLayoutInflater.inflate(R.layout.pull_refresh_listview_header,
                this, false);
        mRefreshImage = (ImageView) mRefreshHeadView.findViewById(
                R.id.pull_to_refresh_image);
        mRefreshTxt = (TextView) mRefreshHeadView.findViewById
                (R.id.pull_to_refresh_text);
        mRefreshLastUpdateTxt = (TextView) mRefreshHeadView.findViewById(
                R.id.pull_to_refresh_updated_at);
        mRefreshProgressBar = (ProgressBar) mRefreshHeadView.findViewById(
                R.id.pull_to_refresh_progress);
        mRefreshImage.setMinimumHeight(IMAGE_VIEW_MIN_HEIGHT);

        mRefreshHeadView.setOnClickListener(mOnclickListener);
        addHeaderView(mRefreshHeadView);
        setOnScrollListener(mScrollListner);
        measureView(mRefreshHeadView);
    }

    private void measureView(View view)
    {
        ViewGroup.LayoutParams params =  view.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, params.width);
        int lpHeight = params.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        view.measure(childWidthSpec, childHeightSpec);
    }

    private OnClickListener mOnclickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


    private OnScrollListener mScrollListner = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };


    private final int ANIMATION_REFRESH_DURATION_TIME = 250; //250MS
    private RotateAnimation mRotateAnimation;
    private LayoutInflater mLayoutInflater;
    private View mRefreshHeadView;
    private ImageView mRefreshImage;
    private final int IMAGE_VIEW_MIN_HEIGHT = 50;
    private TextView mRefreshTxt, mRefreshLastUpdateTxt;
    private ProgressBar mRefreshProgressBar;
}
