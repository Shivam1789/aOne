package com.school.kotlin.utils.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoRegularButton extends android.support.v7.widget.AppCompatButton{


    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public RobotoRegularButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public RobotoRegularButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public RobotoRegularButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto_bold.ttf");
        this.setTypeface(font);
    }


}