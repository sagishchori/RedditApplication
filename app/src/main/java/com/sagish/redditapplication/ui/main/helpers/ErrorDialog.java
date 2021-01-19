package com.sagish.redditapplication.ui.main.helpers;

import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class ErrorDialog {

    /**
     * Creates an {@link AlertDialog} to show some information to the user as a
     * popup.
     *
     * @param context
     * @param title
     * @param message
     * @param posText
     * @param negText
     * @param listener
     *
     * @return              The dialog to show
     */
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
