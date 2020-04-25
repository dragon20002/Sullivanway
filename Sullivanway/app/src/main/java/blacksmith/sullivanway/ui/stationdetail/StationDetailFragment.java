package blacksmith.sullivanway.ui.stationdetail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import blacksmith.sullivanway.BR;
import blacksmith.sullivanway.R;
import blacksmith.sullivanway.ViewModelProviderFactory;
import blacksmith.sullivanway.databinding.FragmentStationDetailBinding;
import blacksmith.sullivanway.ui.base.BaseFragment;

public class StationDetailFragment extends BaseFragment<FragmentStationDetailBinding, StationDetailViewModel>
        implements StationDetailNavigator
{
    public static final String TAG = StationDetailFragment.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private StationDetailViewModel mStationDetailViewModel;

    public static StationDetailFragment newInstance() {
        Bundle args = new Bundle();
        StationDetailFragment fragment = new StationDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_station_detail;
    }

    @Override
    public StationDetailViewModel getViewModel() {
        mStationDetailViewModel = new ViewModelProvider(this, factory).get(StationDetailViewModel.class);
        return mStationDetailViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStationDetailViewModel.setNavigator(this);
    }
}
