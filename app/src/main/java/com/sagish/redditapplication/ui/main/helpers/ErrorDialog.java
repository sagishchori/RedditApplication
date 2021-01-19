package com.sagish.redditapplication.ui.main.helpers;

import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class ErrorDialog {

    public static AlertDialog getErrorDialog(Context context, @Nullable String title, @Nullable String message,
                                             @Nullable String posText, @Nullable String negText,
                                             @Nullable DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(posText, listener)
                .setNegativeButton(negText, listener);

        return builder.create();
    }
}
