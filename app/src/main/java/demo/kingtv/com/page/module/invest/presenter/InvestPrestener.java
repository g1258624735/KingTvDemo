package demo.kingtv.com.page.module.invest.presenter;

import demo.kingtv.com.page.base.presenter.MvpBasePresenter;
import demo.kingtv.com.page.http.APIRetrofit;
import demo.kingtv.com.page.module.invest.bean.LiveListResult;
import demo.kingtv.com.page.module.invest.iml.IInvestMode;
import demo.kingtv.com.page.module.invest.iml.IInvestView;
import demo.kingtv.com.page.module.invest.mode.InvestMode;
import demo.kingtv.com.page.module.main.iml.IDetialView;
import demo.kingtv.com.page.utils.LogUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 小分类下数据列表
 * @gxj
 * @date 2017/5/18
 */
public class InvestPrestener extends MvpBasePresenter<IInvestView> {

    private final IInvestMode mode;

    public InvestPrestener(IInvestView view) {
        attachView(view);
        mode = new InvestMode();
    }

    /**
     * 获取数据列表
     */
    public void getAllList() {
        getView().showProgress();
        mode.getAllList(new Observer<LiveListResult>() {
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
