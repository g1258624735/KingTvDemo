package demo.kingtv.com.page.module.mine.presenter;

import demo.kingtv.com.page.base.presenter.MvpBasePresenter;
import demo.kingtv.com.page.module.invest.bean.LiveListResult;
import demo.kingtv.com.page.module.main.iml.IDetailMode;
import demo.kingtv.com.page.module.main.iml.IDetialView;
import demo.kingtv.com.page.module.main.mode.DetialMode;
import demo.kingtv.com.page.module.mine.iml.IMineMode;
import demo.kingtv.com.page.module.mine.iml.IMineView;
import demo.kingtv.com.page.module.mine.mode.MineMode;
import demo.kingtv.com.page.utils.LogUtils;
import rx.Observer;

/**
 * @author gxj
 * @date 2017/5/18
 */
public class MinePrestener extends MvpBasePresenter<IMineView> {

    private final IMineMode mode;

    public MinePrestener(IMineView view) {
        attachView(view);
        mode = new MineMode();
    }

    /**
     * 获取个人信息
     */
    public void getMineInfo() {
        getView().showProgress();
        getView().onCompleted();
    }
}
