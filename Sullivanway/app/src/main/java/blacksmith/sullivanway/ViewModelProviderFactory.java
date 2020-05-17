package blacksmith.sullivanway;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import blacksmith.sullivanway.data.DataManager;
import blacksmith.sullivanway.ui.main.MainViewModel;
import blacksmith.sullivanway.ui.subwaynode.SubwayNodeViewModel;
import blacksmith.sullivanway.ui.subwaynode.stationdetail.StationDetailViewModel;
import blacksmith.sullivanway.utils.rx.SchedulerProvider;

/**
 * Created by jyotidubey on 22/02/19.
 */
@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataManager, schedulerProvider);
        }
        if (modelClass.isAssignableFrom(SubwayNodeViewModel.class)) {
            //noinspection unchecked
            return (T) new SubwayNodeViewModel(dataManager, schedulerProvider);
        }
        if (modelClass.isAssignableFrom(StationDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new StationDetailViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}