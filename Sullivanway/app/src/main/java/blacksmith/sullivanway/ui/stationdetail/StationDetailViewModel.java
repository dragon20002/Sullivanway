package blacksmith.sullivanway.ui.stationdetail;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import blacksmith.sullivanway.data.DataManager;
import blacksmith.sullivanway.data.entity.db.SubwayNode;
import blacksmith.sullivanway.data.entity.others.StationData;
import blacksmith.sullivanway.ui.base.BaseViewModel;
import blacksmith.sullivanway.utils.AppLogger;
import blacksmith.sullivanway.utils.rx.SchedulerProvider;

public class StationDetailViewModel extends BaseViewModel<StationDetailNavigator> {

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final MutableLiveData<List<StationData>> stationData;

    private final ObservableList<StationData> stationDataList = new ObservableArrayList<>();

    private int action = NO_ACTION;

    public StationDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        stationData = new MutableLiveData<>();
        loadStation();
    }

    public int getAction() {
        return action;
    }

    public LiveData<List<StationData>> getStationData() {
        return stationData;
    }

    public ObservableList<StationData> getStationDataList() {
        return stationDataList;
    }

    public void setStationDataList(List<StationData> stationDatas) {
        action = ACTION_ADD_ALL;
        stationDataList.clear();
        stationDataList.addAll(stationDatas);
    }

    public void loadStation() {
        // START TEST
        SubwayNode tempSubwayNode = new SubwayNode();
        tempSubwayNode.id = 1L;
        tempSubwayNode.x = 498;
        tempSubwayNode.y = 81;
        // END

        getCompositeDisposable().add(getDataManager()
                .getStationData(tempSubwayNode)
                .doOnNext(list -> AppLogger.d("loadStations: %s", list.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(stationList -> {
                    if (stationList != null) {
                        AppLogger.d("loadStations: %s", stationList.size());
                        action = ACTION_ADD_ALL;
                        stationData.setValue(stationList);
                    }
                }, throwable -> AppLogger.d(throwable, "loadStations: 0"))
        );
    }

    public void removeStation() {
        action = ACTION_DELETE_SINGLE;
        stationData.getValue().remove(0);
    }

}
