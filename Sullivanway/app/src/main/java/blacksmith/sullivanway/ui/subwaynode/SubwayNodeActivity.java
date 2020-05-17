package blacksmith.sullivanway.ui.subwaynode;

import android.app.AlertDialog;
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
import blacksmith.sullivanway.data.entity.db.SubwayNode;
import blacksmith.sullivanway.databinding.ActivitySubwayNodeBinding;
import blacksmith.sullivanway.ui.base.BaseActivity;
import blacksmith.sullivanway.ui.subwaynode.stationdetail.StationDetailFragment;
import blacksmith.sullivanway.utils.ScreenUtils;

public class SubwayNodeActivity extends BaseActivity<ActivitySubwayNodeBinding, SubwayNodeViewModel>
        implements SubwayNodeNavigator
{
    @Inject
    ViewModelProviderFactory factory;

    private SubwayNodeViewModel mSubwayNodeViewModel;

    private ActivitySubwayNodeBinding mActivityStationNodeBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, SubwayNodeActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_subway_node;
    }

    @Override
    public SubwayNodeViewModel getViewModel() {
        if (mSubwayNodeViewModel == null)
            mSubwayNodeViewModel = new ViewModelProvider(this, factory).get(SubwayNodeViewModel.class);
        return mSubwayNodeViewModel;
    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void goBack() {
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
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
        mActivityStationNodeBinding = getViewDataBinding();
        mSubwayNodeViewModel.setNavigator(this);

        Intent intent = getIntent();
        long subwayNodeId = intent.getLongExtra("subwayNodeId", -1L);
        if (subwayNodeId != -1L) {
            SubwayNode subwayNode = new SubwayNode();
            {
                subwayNode.id = subwayNodeId;
            }
            mSubwayNodeViewModel.loadStations(subwayNode);

            setup();
        } else {
            // TODO Alert No SubwayNode Selected!
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("알림")
                    .setMessage("선택된 역을 찾을 수 없습니다.")
                    .create();
            alertDialogBuilder.show();
        }
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
        mSubwayNodeViewModel.getSubwayNodeData().observe(this, subwayNode ->
                mSubwayNodeViewModel.setSubwayNode(subwayNode));

        mSubwayNodeViewModel.getStationVoListData().observe(this, stationVos ->
                mSubwayNodeViewModel.setStationVoList(stationVos));
    }

}
