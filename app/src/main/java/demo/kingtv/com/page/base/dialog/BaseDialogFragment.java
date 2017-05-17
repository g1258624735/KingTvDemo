package demo.kingtv.com.page.base.dialog;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import demo.kingtv.com.page.R;


/**
 * 弹出框
 * Created by gxj on 2016/5/31.
 */
public abstract class BaseDialogFragment extends DialogFragment {

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public View getView() {
        View contentView = getActivity().getLayoutInflater().inflate(dialogView(), null, false);
        init(contentView);
        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public int getTheme() {
        return R.style.DialogStyle;
    }


    protected abstract int dialogView();

    Window window;
    WindowManager.LayoutParams wlp;

    protected void init(View view) {
        window = getDialog().getWindow();
        assert window != null;
        wlp = window.getAttributes();
    }

    protected void fullScreen(int gravity) {
        wlp.gravity = gravity;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
    }


    protected void fullScreen() {
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
    }

    protected void NofullScreen(int gravity) {
        DisplayMetrics display = this.getResources().getDisplayMetrics();
        wlp.gravity = gravity;
        wlp.width = display.widthPixels - ((int) (display.widthPixels * 0.1));
        window.setAttributes(wlp);
    }

    @Override
    public void dismissAllowingStateLoss() {
        if (getFragmentManager() != null && getFragmentManager().beginTransaction() != null)
            super.dismissAllowingStateLoss();
    }

    @Override
    public void dismiss() {
        if (getFragmentManager() != null && getFragmentManager().beginTransaction() != null)
            super.dismiss();
    }

    public void show(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        show(fragmentActivity.getSupportFragmentManager(), System.currentTimeMillis() + "");
    }

    public void show(FragmentActivity fragmentActivity, String tag) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        show(fragmentActivity.getSupportFragmentManager(), tag);
    }
}
