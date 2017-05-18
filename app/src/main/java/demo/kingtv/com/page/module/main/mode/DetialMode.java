package demo.kingtv.com.page.module.main.mode;

import demo.kingtv.com.page.http.APIRetrofit;
import demo.kingtv.com.page.module.main.iml.IDetailMode;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/16.
 */

public class DetialMode implements IDetailMode {
    @Override
    public void getAllList(Observer observer) {
        APIRetrofit.getAPIService()
                .getLiveListResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
