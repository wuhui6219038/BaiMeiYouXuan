package com.baimeiyx.www.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.example.mrw.baimeiyouxuan.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.baimeiyx.www.ui.fragment.HealthFoodsTypeSearchFragment.FOODID;
import static com.baimeiyx.www.ui.fragment.HealthFoodsTypeSearchFragment.FOODNAME;

public class HealthFoodsSearch extends BaseFragment {
    private static final String TAG = "HealthFoodsSearch";
    @BindView(R.id.et_search_info)
    EditText etSearchInfo;
    @BindView(R.id.tv_clear)
    TextView tvClear;
    @BindView(R.id.view_empty)
    FrameLayout viewEmpty;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    @BindView(R.id.tv_enpty)
    TextView tvEnpty;
    Unbinder unbinder;
    private String searchInfo;
    private List<String> searchHistory;

    public static HealthFoodsSearch newInstance() {
        HealthFoodsSearch fragment = new HealthFoodsSearch();
        return fragment;
    }

    @Override
    protected void setToolbar() {
        ivBack.setImageDrawable(getResources().getDrawable(R.drawable.ic_back_blcak));
        tvTitle.setText(getResources().getString(R.string.app_name));
        tvTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        BarUtils.setColor(mActivity, Color.WHITE, 0);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_health_foods_search;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _initListener();
    }


    private void _initListener() {
        etSearchInfo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                searchInfo = etSearchInfo.getText().toString();
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Log.e(TAG, "onEditorAction: 搜索");
                    if (TextUtils.isEmpty(searchInfo)) {
                        ToastUtils.showShortToast("请输入搜索食品");
                    } else {
                        _storeHistory();
                        showDetail(searchInfo);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        _showHistory();
    }

    private void _showHistory() {
        if (spUtils.getString(SP_FOOD_SEARCH_HISTORY) != null) {
            searchHistory = new ArrayList<>(Arrays.asList(gson.fromJson(spUtils.getString(SP_FOOD_SEARCH_HISTORY), String[].class)));
        }
        if (searchHistory != null && !searchHistory.isEmpty()) {
            idFlowlayout.setVisibility(View.VISIBLE);
            idFlowlayout.setAdapter(new TagAdapter<String>(searchHistory) {
                @Override
                public View getView(FlowLayout parent, int position, String o) {
                    TextView tv = (TextView) getLayoutInflater().inflate(R.layout.item_foods_search_history,
                            idFlowlayout, false);
                    tv.setText(o);
                    return tv;
                }
            });
            idFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    showDetail(searchHistory.get(position));
                    return true;
                }
            });
        } else {
            viewEmpty.setVisibility(View.VISIBLE);
            tvEnpty.setText(getResources().getString(R.string.text_no_history));
            idFlowlayout.setVisibility(View.GONE);
        }
    }

    private void _storeHistory() {

        if (!TextUtils.isEmpty(searchInfo)) {
            if (searchHistory == null)
                searchHistory = new ArrayList<>();
            if (!searchHistory.contains(searchInfo)) {
                searchHistory.add(searchInfo);
                spUtils.putString(SP_FOOD_SEARCH_HISTORY, gson.toJson(searchHistory));
            }
        }
    }

    private void showDetail(String searchInfo) {
        Bundle data = new Bundle();
        data.putString(FOODNAME, searchInfo);
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, HealthFoodsTypeSearchFragment.newInstance(data));

    }

    @OnClick({R.id.tv_clear, R.id.iv_delete})
    public void doClcik(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_clear:
                etSearchInfo.setText("");
                break;
            case R.id.iv_delete:
                spUtils.putString(SP_FOOD_SEARCH_HISTORY, null);
                Log.e(TAG, "doClcik: " );
                searchHistory.clear();
                _showHistory();

                break;
        }

    }

}
