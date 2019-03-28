package com.dasfilm.azzeddine.dasfilm.Views.CostumView;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;


/**
 * Created by azeddine on 4/6/18.
 */

public class LimitedChatTextView extends AppCompatTextView{
    private static final String TAG = "LimitedChatTextView";

    private int maxTextChar;

    public LimitedChatTextView(Context context) {
        super(context);
    }

    public LimitedChatTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LimitedChatTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getMaxTextChar() {
        return maxTextChar;
    }

    public void setMaxTextChar(int maxTextChar) {
        this.maxTextChar = maxTextChar;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        CharSequence limitedText = text;
        if(maxTextChar<text.length())  limitedText = text.toString().substring(0, maxTextChar -1)+"...";
        Log.d(TAG, "setText: "+limitedText);
        super.setText(limitedText, type);
    }

}
