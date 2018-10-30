package com.baimeiyx.www.utils.myUtils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;


/**
 * 提示框的工具类
 *
 * @author mr.w
 */
public class DialogUtils {
    private static final String TAG = "DialogUtils";
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static QMUITipDialog loadDialog;

    /**
     * 显示提示框
     *
     * @param context
     * @param msg
     */
    public static QMUITipDialog showLoadDialog(Context context, String msg) {
        loadDialog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord(msg)
                .create();
        return loadDialog;
    }

    public static void showSuccessDialog(int delay, Context context, String msg) {
        _initQMUITipDialog(context, msg, QMUITipDialog.Builder.ICON_TYPE_SUCCESS, delay);

    }

    public static void showFailDialog(int delay, Context context, String msg) {
        _initQMUITipDialog(context, msg, QMUITipDialog.Builder.ICON_TYPE_FAIL, delay);

    }

    public static void showInfoDialog(int delay, Context context, String msg) {
        _initQMUITipDialog(context, msg, QMUITipDialog.Builder.ICON_TYPE_INFO, delay);

    }

    private static void _initQMUITipDialog(final Context context, final String msg, final int iconType, final int delay) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (loadDialog != null && loadDialog.isShowing()) {
                    loadDialog.hide();
                }
                QMUITipDialog dialog = new QMUITipDialog.Builder(context)
                        .setIconType(iconType)
                        .setTipWord(msg)
                        .create();
                dialog.show();
                hideDialog(dialog, delay);
            }
        });

    }

    private static void hideDialog(final QMUITipDialog dialog, int delay) {
        if (loadDialog != null && loadDialog.isShowing()) {
            loadDialog.hide();
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, delay);
    }
}
