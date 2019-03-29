package com.baimeiyx.www.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bm.library.Info;
import com.bm.library.PhotoView;
import com.example.mrw.baimeiyouxuan.R;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public class ShowImgActivity extends BaseActivity {
    public static final String IMGURL = "imgURL";

    PhotoView mPhotoView;
    Info mInfo;

    private String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgUrl = getIntent().getExtras().getString(IMGURL);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show_img);
        BarUtils.setColor(this, Color.BLACK, 0);
        mPhotoView = findViewById(R.id.img);
        mPhotoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        mPhotoView.enable();
        ImageUtils.loadImgSrcByUrl(this, mPhotoView, imgUrl);
        mInfo = mPhotoView.getInfo();
        mPhotoView.animaFrom(mInfo);
        mPhotoView.setOnClickListener((view) -> {
            finish();

        });
//        mPhotoView.setOnLongClickListener((view) -> {
//            new QMUIDialog.MessageDialogBuilder(ShowImgActivity.this)
//                    .setMessage("是否保存图片？")
//                    .addAction("取消", null)
//                    .addAction("保存", new QMUIDialogAction.ActionListener() {
//                        @Override
//                        public void onClick(QMUIDialog dialog, int index) {
//                            dialog.dismiss();
////                            ImageUtils/
//                        }
//                    })
//                    .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
//            return false;
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
