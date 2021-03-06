package demo.kingtv.com.page.base.iml;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/20
 */

public interface BaseView extends MvpView{


    void showProgress();

    void onCompleted();

    void onError(Throwable e);
}
