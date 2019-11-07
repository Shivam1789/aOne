package com.school.kotlin.utils.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoRegularEditText extends android.support.v7.widget.AppCompatEditText {


    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public RobotoRegularEditText(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public RobotoRegularEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public RobotoRegularEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto_reguler.ttf");
        this.setTypeface(font);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }



}