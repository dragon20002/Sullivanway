package blacksmith.sullivanway.ui.stationdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import blacksmith.sullivanway.BR;
import blacksmith.sullivanway.R;
import blacksmith.sullivanway.ViewModelProviderFactory;
import blacksmith.sullivanway.databinding.ActivityStationDetailBinding;
import blacksmith.sullivanway.ui.base.BaseActivity;
import blacksmith.sullivanway.utils.ScreenUtils;

public class StationDetailActivity extends BaseActivity<ActivityStationDetailBinding, StationDetailViewModel>
        implements StationDetailNavigator
{

    @Inject
    ViewModelProviderFactory factory;

    private StationDetailViewModel mStationDetailViewModel;

    private ActivityStationDetailBinding mActivityStationDetailBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, StationDetailActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_station_detail;
    }

    @Override
    public StationDetailViewModel getViewModel() {
        if (mStationDetailViewModel == null)
            mStationDetailViewModel = new ViewModelProvider(this, factory).get(StationDetailViewModel.class);
        return mStationDetailViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void goBack() {
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(StationDetailFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(StationDetailFragment.TAG);
        }
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityStationDetailBinding = getViewDataBinding();
        mStationDetailViewModel.setNavigator(this);
        setup();
    }

    private void setup() {
//        mCardsContainerView = mActivityStationDetailBinding.cardsContainer;
//        setupCardContainerView();
        subscribeToLiveData();
    }

    private void setupCardContainerView() {
        int screenWidth = ScreenUtils.getScreenWidth(this);
        int screenHeight = ScreenUtils.getScreenHeight(this);
    }

    private void showStationDetailFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(0, StationDetailFragment.newInstance(), StationDetailFragment.TAG)
                .commit();
    }

    private void subscribeToLiveData() {
        mStationDetailViewModel.getStationData().observe(this, stationDataList ->
                mStationDetailViewModel.setStationDataList(stationDataList));
    }

}
