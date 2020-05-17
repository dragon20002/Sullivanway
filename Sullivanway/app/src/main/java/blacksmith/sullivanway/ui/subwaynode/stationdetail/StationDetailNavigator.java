package blacksmith.sullivanway.ui.subwaynode.stationdetail;

public interface StationDetailNavigator {

    void openMapActivity();

    void openTimeTableActivity();

    void openCongestionActivity();

    void swipeLeft();

    void swipeRight();

    void goBack();

    void handleError(Throwable throwable);
}
