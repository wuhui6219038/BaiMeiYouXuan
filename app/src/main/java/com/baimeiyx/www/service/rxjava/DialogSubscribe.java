package com.baimeiyx.www.service.rxjava;

import android.content.Context;

import com.baimeiyx.www.App;
import com.baimeiyx.www.service.excetion.ApiException;
import com.baimeiyx.www.service.repository.ResponseCallBack;
import com.baimeiyx.www.service.excetion.ExceptionEngine;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.DialogUtils;
import com.example.mrw.baimeiyouxuan.R;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import io.reactivex.observers.DisposableObserver;

/**
 * 需要显示对话框的话直接用 {@link DialogSubscribe#showDialog}
 * 数据请求成功{@link DialogSubscribe#showSuccessDialog}
 * 数据请求失败{@link DialogSubscribe#showFailDialog(String)}
 * 直接关闭load对话框{@link DialogSubscribe#hideLoadDialog()}
 * 其中成功和失败都不需要手动关闭 会在1.5s后自动关闭
 * <p>
 * 重新封装一个带弹出框的观察者
 */
public abstract class DialogSubscribe<T extends BaseResult> extends DisposableObserver<T> {
    private static final String TAG = "DialogSubscribe";
    private Context mContext;
    private boolean showDialog = true;
    private QMUITipDialog dialog;
    private String toastInfo = App.INSTANCE.getResources().getString(R.string.toast_data_connneting);

    public DialogSubscribe(Context context) {
        this.mContext = context;

    }

    @Override
    protected void onStart() {
        dialog = DialogUtils.showLoadDialog(mContext, toastInfo);
        dialog.show();

    }

    @Override
    public void onNext(T data) {
        if (data.isOk()) {
            hideLoadDialog();
            dataSuccess(data);
        } else {
            String msg = data.getMessage() + data.getComment() == null ? "" : "(" + data.getComment() + ")";
            showFailDialog(msg);
        }
    }

    @Override
    public void onError(Throwable t) {
        ApiException apiException = ExceptionEngine.handleException(t);
        showFailDialog(apiException.getMessage());
    }

    @Override
    public void onComplete() {

    }


    public DialogSubscribe showLoadDialog(String toastInfo) {

        return this;
    }

    public DialogSubscribe showSuccessDialog(String toastInfo) {
        hideLoadDialog();
        DialogUtils.showSuccessDialog(mContext, toastInfo);
        return this;
    }

    public DialogSubscribe showFailDialog(String toastInfo) {
        hideLoadDialog();
        LogUtils.e(TAG, "toastInfo:" + toastInfo);
        DialogUtils.showFailDialog(mContext, toastInfo);
        return this;
    }

    public DialogSubscribe hideLoadDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        return this;
    }

    public abstract void dataSuccess(T data);
}
