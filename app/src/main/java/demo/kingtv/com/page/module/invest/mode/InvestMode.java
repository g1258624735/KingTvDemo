package demo.kingtv.com.page.module.invest.mode;

import demo.kingtv.com.page.http.APIRetrofit;
import demo.kingtv.com.page.module.invest.iml.IInvestMode;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gxj on 2017/5/16.
 * 我的列表
 */

public class InvestMode implements IInvestMode {
    @Override
    public void getAllList(Observer observer) {
        APIRetrofit.getAPIService()
                .getLiveListResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
