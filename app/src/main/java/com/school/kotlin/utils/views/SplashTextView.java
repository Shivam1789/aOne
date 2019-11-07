package com.school.kotlin.utils.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SplashTextView extends android.support.v7.widget.AppCompatTextView {


    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public SplashTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SplashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public SplashTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/GenBkBasB_0.ttf");
        this.setTypeface(font);
    }


}