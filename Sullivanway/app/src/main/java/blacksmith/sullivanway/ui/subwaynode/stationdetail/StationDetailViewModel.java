package blacksmith.sullivanway.ui.subwaynode.stationdetail;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import blacksmith.sullivanway.data.DataManager;
import blacksmith.sullivanway.data.entity.db.Station;
import blacksmith.sullivanway.data.entity.others.StationDetailVo;
import blacksmith.sullivanway.ui.base.BaseViewModel;
import blacksmith.sullivanway.utils.AppLogger;
import blacksmith.sullivanway.utils.rx.SchedulerProvider;

public class StationDetailViewModel extends BaseViewModel<StationDetailNavigator> {

    /* Data from DB etc */
    private final MutableLiveData<StationDetailVo> stationDetailVoData;

    /* Observable for View */
    private final ObservableField<StationDetailVo> stationDetailVo = new ObservableField<>();

    /* VM Constructor */
    public StationDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        stationDetailVoData = new MutableLiveData<>();
    }

    public void loadStation(Station station) {
        getCompositeDisposable().add(getDataManager()
                .getStationDetailVo(station)
                .doOnNext(stationDetail -> AppLogger.d("loadStation: %s", stationDetail.station.id))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(stationDetailVo -> {
                    if (stationDetailVo != null) {
                        AppLogger.d("loadStation: %s", stationDetailVo.station.id);
                        stationDetailVoData.setValue(stationDetailVo);
                    }
                }, throwable -> AppLogger.d(throwable, "loadStation: 0"))
        );
    }

    /* Getter, Setter */
    public LiveData<StationDetailVo> getStationDetailVoData() {
        return stationDetailVoData;
    }

    public ObservableField<StationDetailVo> getStationDetailVo() {
        return stationDetailVo;
    }

    public void setStationDetailVo(StationDetailVo stationDetailVo) {
        this.stationDetailVo.set(stationDetailVo);
    }

}
