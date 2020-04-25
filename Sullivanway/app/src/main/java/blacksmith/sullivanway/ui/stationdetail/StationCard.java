package blacksmith.sullivanway.ui.stationdetail;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;

import blacksmith.sullivanway.R;
import blacksmith.sullivanway.data.entity.others.StationData;

@NonReusable
@Layout(R.layout.card_layout)
public class StationCard {

    private StationData mStationData;

    public StationCard(StationData stationData) {
        mStationData = stationData;
    }

    @Resolve
    private void onResolved() {

    }


}
