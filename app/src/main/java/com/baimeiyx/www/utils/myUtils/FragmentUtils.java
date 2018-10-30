package com.baimeiyx.www.utils.myUtils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.mrw.baimeiyouxuan.R;

/**
 * @author mr.w
 * 碎片管理
 */
public class FragmentUtils {
    private FragmentUtils() {
    }

    /**
     * 替换之前的页面
     *
     * @param fragmentManager
     * @param containId
     * @param fragment
     */
    public static void showFragmentReplace(FragmentManager fragmentManager, int containId, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragmentManager.getFragments().size() > 0) {
            transaction.setCustomAnimations(R.animator.fragment_slide_left_enter,
                    R.animator.fragment_slide_left_exit,
                    R.animator.fragment_slide_right_enter,
                    R.animator.fragment_slide_right_exit

            );
        }
        transaction.replace(containId, fragment).commit();
    }


    public static void showFragmentAddStack(FragmentManager fragmentManager, int containId, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragmentManager.getFragments().size() > 0) {
            transaction.setCustomAnimations(R.animator.fragment_slide_left_enter,
                    R.animator.fragment_slide_left_exit,
                    R.animator.fragment_slide_right_enter,
                    R.animator.fragment_slide_right_exit);
        }
        transaction.replace(containId, fragment).addToBackStack(fragment.getClass().getName()).commit();
    }
}
