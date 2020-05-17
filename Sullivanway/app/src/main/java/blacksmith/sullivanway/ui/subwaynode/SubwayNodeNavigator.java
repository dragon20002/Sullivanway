package blacksmith.sullivanway.ui.subwaynode;

public interface SubwayNodeNavigator {

    void swipeLeft();

    void swipeRight();

    void goBack();

    void handleError(Throwable throwable);
}
