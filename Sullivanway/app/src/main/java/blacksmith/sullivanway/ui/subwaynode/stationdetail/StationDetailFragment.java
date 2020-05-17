package blacksmith.sullivanway.ui.subwaynode.stationdetail;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import blacksmith.sullivanway.BR;
import blacksmith.sullivanway.R;
import blacksmith.sullivanway.ViewModelProviderFactory;
import blacksmith.sullivanway.data.entity.db.Station;
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
    public void openMapActivity() {

    }

    @Override
    public void openTimeTableActivity() {

    }

    @Override
    public void openCongestionActivity() {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

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

        Bundle args = getArguments();
        if (args != null) {
            long stationId = args.getLong("stationId", -1L);
            if (stationId != -1) {
                Station station = new Station();
                {
                    station.id = stationId;
                }

                mStationDetailViewModel.loadStation(station);
            } else {
                // TODO Alert No SubwayNode Selected!
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("알림")
                        .setMessage("역 정보를 찾을 수 없습니다.")
                        .create();
                alertDialogBuilder.show();
            }
        }
    }
}
