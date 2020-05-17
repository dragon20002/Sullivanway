package blacksmith.sullivanway.ui.main;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import blacksmith.sullivanway.data.DataManager;
import blacksmith.sullivanway.data.entity.db.SubwayNode;
import blacksmith.sullivanway.ui.base.BaseViewModel;
import blacksmith.sullivanway.utils.AppLogger;
import blacksmith.sullivanway.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    /* Data from DB etc */
    private final MutableLiveData<List<SubwayNode>> subwayNodeListData;

    /* VM Constructor */
    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        subwayNodeListData = new MutableLiveData<>();
    }

    public void loadSubwayNodes() {
        getCompositeDisposable().add(getDataManager()
                .getSubwayNodes()
                .doOnNext(subwayNodes -> AppLogger.d("loadSubwayNodes: %s", subwayNodes.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(subwayNodes -> {
                    if (subwayNodes != null) {
                        AppLogger.d("loadSubwayNodes: %s", subwayNodes.size());
                        subwayNodeListData.setValue(subwayNodes);
                    }
                }, throwable -> AppLogger.d(throwable, "loadSubwayNodes: 0"))
        );
    }

    /* Getter, Setter */
    public MutableLiveData<List<SubwayNode>> getSubwayNodeListData() {
        return subwayNodeListData;
    }

}
