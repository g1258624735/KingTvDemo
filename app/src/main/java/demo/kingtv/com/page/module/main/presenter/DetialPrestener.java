package demo.kingtv.com.page.module.main.presenter;

import demo.kingtv.com.page.base.presenter.MvpBasePresenter;
import demo.kingtv.com.page.http.APIRetrofit;
import demo.kingtv.com.page.module.invest.bean.LiveListResult;
import demo.kingtv.com.page.module.main.iml.IDetialView;
import demo.kingtv.com.page.utils.LogUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 小分类下数据列表
 */
public class DetialPrestener extends MvpBasePresenter<IDetialView> {
    public DetialPrestener(IDetialView view) {
        attachView(view);
    }

    /**
     * 获取数据列表
     */
    public void getAllList() {
        getView().showProgress();
        APIRetrofit.getAPIService()
                .getLiveListResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiveListResult>() {
                    @Override
                    public void onCompleted() {
                        if (isViewAttached())
                            getView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached())
                            getView().onError(e);
                    }

                    @Override
                    public void onNext(final LiveListResult list) {
                        LogUtils.d("Response:", "" + list);
                        if (isViewAttached()) {
                            getView().onGetLiveList(list);
                        }
                    }
                });

    }


}
