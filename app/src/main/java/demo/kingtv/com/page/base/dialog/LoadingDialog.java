package demo.kingtv.com.page.base.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import demo.kingtv.com.page.R;


/**
 * Created by gxj on 2016/11/29.
 */

public class LoadingDialog extends BaseDialogFragment {
    private final static String TAG = "tag_loading_dialog";

    @Override
    protected int dialogView() {
        return R.layout.dialog_loading_layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

}
