package com.baimeiyx.www.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.view.StepView;
import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.view.circleprogress.ArcProgress;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.module.http.result.CustomerExpectResult;
import com.baimeiyx.www.utils.ActivityUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseUserFragment<CustomerExpectResult> {
    @BindView(R.id.text_icon)
    TextView textIcon;
    @BindView(R.id.text_icon_next)
    TextView textIconNext;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.arc_progress)
    ArcProgress arcProgress;
    @BindView(R.id.tv_weight_record)
    TextView tvWeightRecord;
    @BindView(R.id.tv_weight_record_en)
    TextView tvWeightRecordEn;


    @BindView(R.id.stepview)
    StepView stepview;
    @BindView(R.id.et_search_info)
    EditText etSearchInfo;
    @BindView(R.id.ll_weight_record)
    LinearLayout llWeightRecord;
    @BindView(R.id.tv_icon_search)
    TextView tvIconSearch;
    @BindView(R.id.tv_icon_message)
    TextView tvIconMessage;

    private HomeViewModel mViewModel;
    private static final String[] STEPTILTE = {"S", "A", "B", "C", "F"};

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _init();
    }

    private void _init() {

        ImageUtils.loadImageByUrl(getActivity(), ivBg, "http://www.baimeiyx.com/wx-app/cover.png");
        SvgUtils.setIcon(mActivity, textIcon, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, tvIconMessage, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, textIconNext, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, tvIconSearch, "iconfont.ttf");
        stepview.setStepsTitle(STEPTILTE);
        _initView();

    }

    private static final String TAG = "HomeFragment";

    private void _initView() {

//        test()
    }


    @OnClick({R.id.ll_weight_record})
    public void doClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ll_weight_record:
                ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.weight_record.WeightRecordActivity");
                break;

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.setDataRepository(dataRepository);
        mViewModel.getCustomerExpect().observe(this, this);
    }

    @Override
    protected void onDataSuccessChanged(CustomerExpectResult baseResult) {

    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarHome));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarHome), 0);
        ivBack.setVisibility(View.GONE);
    }


    ///////////
//    private DataManager dataManager;
//
//    private void test() {
    //new Consumer<Response<LoginResult>>() {
    //                    @Override
    //                    public void accept(Response<LoginResult> loginResultResponse) throws Exception {
    //                        loginResultResponse.body()
    //                    }
    //                }
//        dataManager = new DataManager();
//        dataManager.getApiService()
//                .doObservableLogin("", "")
//                .compose(RxJavaUtils.rxSchedulerHelper())
//                .retryWhen(new RetryExceptionObservable())
//                .subscribe(new Consumer<Response<LoginResult>>() {
//                    @Override
//                    public void accept(Response<LoginResult> response) throws Exception {
//                        appViewModel.getObserver().set
//                        LogUtils.e(TAG, response.body());
//                    }
//                });


//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("hello world----");
//                e.onError(new Throwable("always fails"));
//
//            }
//        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<Observable>>() {
//            @Override
//            public ObservableSource<Observable> apply(Observable<Throwable> throwableObservable) throws Exception {
//                return throwableObservable.zipWith(Observable.range(1, 3), new BiFunction<Throwable, Integer, Observable>() {
//                    @Override
//                    public Observable apply(Throwable throwable, Integer integer) throws Exception {
//                        Log.e(TAG, "delay retry by " + integer + " second(s)");
//                        if (integer == 3) {
//                            Log.e(TAG, "apply: 我尝试了3次还是扑街了");
//                            return Observable.error(throwable);
//                        } else
//                            return Observable.timer(4, TimeUnit.SECONDS);
//                    }
//
//                }).flatMap(new Function<Observable, ObservableSource<Observable>>() {
//                    @Override
//                    public ObservableSource<Observable> apply(Observable observable) throws Exception {
//                        return observable;
//                    }
//                });
//            }
//        }).subscribe(new Consumer<String>() {
//                         @Override
//                         public void accept(String s) throws Exception {
//                             Log.e(TAG, "accept: " + s);
//                         }
//                     }, new Consumer<Throwable>()
//
//                     {
//                         @Override
//                         public void accept(Throwable throwable) throws Exception {
//                             Log.e(TAG, "Throwable: " + throwable.getMessage());
//                         }
//                     }, new
//
//                             Action() {
//                                 @Override
//                                 public void run() throws Exception {
//                                     Log.e(TAG, "run: 完成");
//                                 }
//                             }
//        );
//        Observable.create((Subscriber<? super String> s) -> {
//            System.out.println("subscribing");
//            s.onError(new RuntimeException("always fails"));
//        }).retryWhen(attempts -> {
//            return attempts.zipWith(Observable.range(1, 3), (n, i) -> i).flatMap(i -> {
//                System.out.println("delay retry by " + i + " second(s)");
//                return Observable.timer(i, TimeUnit.SECONDS);
//            });
//        }).toBlocking().forEach(System.out::println);


//        Flowable.create(new FlowableOnSubscribe<String>() {
//            int count = 0;
//
//            @Override
//            public void subscribe(FlowableEmitter<String> e) {
//                count++;
//                e.onError(new Throwable("always fails"));
//                e.onNext("hello world----" + count);
//
//            }
//        }, BackpressureStrategy.BUFFER)
//                .compose(RxJavaUtils.rxSchedulerHelper())
//                .retryWhen(new Function<Flowable<Throwable>, Publisher<Flowable>>() {
//                    @Override
//                    public Publisher<Flowable> apply(Flowable<Throwable> throwableFlowable) {
//                        return throwableFlowable.zipWith(Flowable.range(1, 3), new BiFunction<Throwable, Integer, Flowable>() {
//                            @Override
//                            public Flowable apply(Throwable throwable, Integer integer) throws Exception {
//                                Log.e(TAG, "delay retry by " + integer + " second(s)");
//                                if (integer == 3) {
//                                    Log.e(TAG, "apply: 我尝试了3次还是扑街了");
//                                    return Flowable.error(throwable);
//                                } else
//                                    return Flowable.error(throwable);
////                                    return Flowable.timer(1, TimeUnit.SECONDS);
//                            }
//
//                            ;
//                        });
//                    }
//
//                    ;
//                })
//                .onErrorReturn(new Function<Throwable, String>() {
//                    @Override
//                    public String apply(Throwable throwable) throws Exception {
//                        Log.e(TAG, "在onErrorReturn处理了: " + throwable.toString());
//                        return throwable.getMessage();
//                    }
//                })
//                .subscribe(new Consumer<String>() {
//                               @Override
//                               public void accept(String s) throws Exception {
//                                   Log.e(TAG, "accept: " + s);
//                               }
//                           }, new Consumer<Throwable>() {
//                               @Override
//                               public void accept(Throwable throwable) throws Exception {
//                                   Log.e(TAG, "Throwable: " + throwable.getMessage());
//                               }
//                           }, new Action() {
//                               @Override
//                               public void run() throws Exception {
//                                   Log.e(TAG, "run: 完成");
//                               }
//                           }
//                );
//    }
}
