package blacksmith.sullivanway.ui.subwaynode;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import blacksmith.sullivanway.data.DataManager;
import blacksmith.sullivanway.data.entity.db.SubwayNode;
import blacksmith.sullivanway.data.entity.others.StationVo;
import blacksmith.sullivanway.ui.base.BaseViewModel;
import blacksmith.sullivanway.utils.AppLogger;
import blacksmith.sullivanway.utils.rx.SchedulerProvider;

public class SubwayNodeViewModel extends BaseViewModel<SubwayNodeNavigator> {

    /* Data from DB etc */
    private final MutableLiveData<SubwayNode> subwayNodeData;

    private final MutableLiveData<List<StationVo>> stationVoListData;

    /* Observable for View */
    private final ObservableField<SubwayNode> subwayNode = new ObservableField<>();

    private final ObservableList<StationVo> stationVoList = new ObservableArrayList<>();

    /* VM Constructor */
    public SubwayNodeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        subwayNodeData = new MutableLiveData<>();
        stationVoListData = new MutableLiveData<>();
    }

    public void loadStations(SubwayNode subwayNode) {
        getCompositeDisposable().add(getDataManager()
                .getSubwayNode(subwayNode)
                .doOnNext(_subwayNode -> AppLogger.d("loadSubwayNode: %s", _subwayNode.id))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(_subwayNode -> {
                    if (_subwayNode != null) {
                        AppLogger.d("loadSubwayNode: %s", _subwayNode.id);
                        subwayNodeData.setValue(_subwayNode);
                    }
                }, throwable -> AppLogger.d(throwable, "loadSubwayNode: 0"))
        );

        getCompositeDisposable().add(getDataManager()
                .getStationVos(subwayNode)
                .doOnNext(stationVos -> AppLogger.d("loadStationVos", stationVos.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(stationVos -> {
                    if (stationVos != null) {
                        AppLogger.d("loadStationVos", stationVos.size());
                        stationVoListData.setValue(stationVos);
                    }
                }, throwable -> AppLogger.d(throwable, "loadStations: 0"))
        );
    }

    /* Getter, Setter */
    public MutableLiveData<SubwayNode> getSubwayNodeData() {
        return subwayNodeData;
    }

    public MutableLiveData<List<StationVo>> getStationVoListData() {
        return stationVoListData;
    }

    public ObservableField<SubwayNode> getSubwayNode() {
        return subwayNode;
    }

    public void setSubwayNode(SubwayNode subwayNode) {
        this.subwayNode.set(subwayNode);
    }

    public void setStationVoList(List<StationVo> stationVoList) {
        this.stationVoList.clear();
        this.stationVoList.addAll(stationVoList);
    }

}
