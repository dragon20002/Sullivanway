package blacksmith.sullivanway.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import blacksmith.sullivanway.BR;
import blacksmith.sullivanway.R;
import blacksmith.sullivanway.ViewModelProviderFactory;
import blacksmith.sullivanway.databinding.ActivityMainBinding;
import blacksmith.sullivanway.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements MainNavigator
{
    @Inject
    ViewModelProviderFactory factory;

    private MainViewModel mMainViewModel;

    private ActivityMainBinding mActivityMainBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        if (mMainViewModel == null)
            mMainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        return mMainViewModel;
    }

    @Override
    public void openSubwayNodeActivity() {

    }

    @Override
    public void openSettingsActivity() {

    }

    @Override
    public void showSearchView() {

    }

    @Override
    public void goBack() {

    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);

        mMainViewModel.loadSubwayNodes();

        setup();
    }

    private void setup() {
        // TODO - setup
    }

}
