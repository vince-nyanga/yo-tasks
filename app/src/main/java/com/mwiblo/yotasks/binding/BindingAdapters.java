package com.mwiblo.yotasks.binding;

import android.databinding.BindingAdapter;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;



import java.util.Date;

/**
 * @author Vincent
 */

public class BindingAdapters {

    @BindingAdapter("date")
    public static void setDate(TextView textView, Date date){
        CharSequence dateString  = "Created on " +DateFormat.format("dd/MM/yyyy", date);
        textView.setText(dateString);
    }

    @BindingAdapter("show")
    public static void setVisibility(View view, boolean show){
        view.setVisibility(show? View.VISIBLE: View.GONE);
    }
}
