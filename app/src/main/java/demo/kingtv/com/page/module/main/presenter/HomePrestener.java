package demo.kingtv.com.page.module.main.presenter;

import java.util.List;

import demo.kingtv.com.page.base.presenter.MvpBasePresenter;
import demo.kingtv.com.page.http.APIRetrofit;
import demo.kingtv.com.page.module.main.bean.LiveCategory;
import demo.kingtv.com.page.module.main.iml.IHomeView;
import demo.kingtv.com.page.utils.LogUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 首页数据列表
 */
public class HomePrestener extends MvpBasePresenter<IHomeView> {
    public HomePrestener(IHomeView view) {
        attachView(view);
    }

    /**
     * 获取数据列表
     */
    public void getAllCategories() {
        getView().showProgress();
        APIRetrofit.getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LiveCategory>>() {
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
                    public void onNext(final List<LiveCategory> list) {
                        LogUtils.d("Response:", "" + list);
                        if (isViewAttached()) {
                            getView().onGetLiveCategory(list);
                        }
                    }
                });

    }


}
