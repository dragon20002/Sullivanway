package blacksmith.sullivanway.ui.main;

interface MainNavigator {

    void openSubwayNodeActivity();

    void openSettingsActivity();

    void showSearchView();

    void goBack();

    void handleError(Throwable throwable);
}
