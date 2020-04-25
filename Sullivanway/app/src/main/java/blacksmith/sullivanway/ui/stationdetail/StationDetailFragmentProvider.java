package blacksmith.sullivanway.ui.stationdetail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StationDetailFragmentProvider {

    @ContributesAndroidInjector
    abstract StationDetailFragment provideStationDetailFragmentFactory();
}
