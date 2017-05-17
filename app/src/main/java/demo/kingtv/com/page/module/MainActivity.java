package demo.kingtv.com.page.module;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.BaseActivity;
import demo.kingtv.com.page.module.invest.ui.InvestFragment;
import demo.kingtv.com.page.module.main.ui.HomeFragment;
import demo.kingtv.com.page.module.mine.ui.MineFragment;

/**
 * author gxj
 * date 2017/5/11
 * 主界面
 */
public class MainActivity extends BaseActivity {
    String[] name_title = {"首页", "列表", "我的"};
    private HomeFragment homeFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = (@NonNull MenuItem item) -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                showHomeFragment();
                return true;
            case R.id.navigation_dashboard:
                showInvestFragment();
                return true;
            case R.id.navigation_notifications:
                showMineFragment();
                return true;
        }
        return false;
    };
    private InvestFragment investFragment;
    private MineFragment mineFragment;

    private void showHomeFragment() {
        setTopTitle(name_title[0]);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.main_activity_content, homeFragment);
        }
        fragmentTransaction.show(homeFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void showInvestFragment() {
        setTopTitle(name_title[1]);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (investFragment == null) {
            investFragment = new InvestFragment();
            fragmentTransaction.add(R.id.main_activity_content, investFragment);
        }
        fragmentTransaction.show(investFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void showMineFragment() {
        setTopTitle(name_title[2]);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (mineFragment == null) {
            mineFragment = new MineFragment();
            fragmentTransaction.add(R.id.main_activity_content, mineFragment);
        }
        fragmentTransaction.show(mineFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    protected void initData() {
        showHomeFragment();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_main;
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        hideFragment(transaction, homeFragment);
        hideFragment(transaction, investFragment);
        hideFragment(transaction, mineFragment);
    }

    private void hideFragment(FragmentTransaction transaction, Fragment fragment) {
        if (fragment != null) {
            transaction.hide(fragment);
        }
    }
}
