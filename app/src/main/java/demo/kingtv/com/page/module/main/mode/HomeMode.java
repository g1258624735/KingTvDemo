package demo.kingtv.com.page.module.main.mode;

import demo.kingtv.com.page.http.APIRetrofit;
import demo.kingtv.com.page.module.main.iml.IHomeMode;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/16.
 * mode 一般处理耗时操作
 */

public class HomeMode implements IHomeMode {
    @Override
    public void getAllCategories(Observer observer) {
        APIRetrofit.getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
