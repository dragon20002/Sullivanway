/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package blacksmith.sullivanway.utils;

import androidx.databinding.BindingAdapter;

import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.List;

import blacksmith.sullivanway.data.entity.others.StationData;
import blacksmith.sullivanway.ui.stationdetail.StationCard;
import blacksmith.sullivanway.ui.stationdetail.StationDetailViewModel;

/**
 * Created by amitshekhar on 11/07/17.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter", "action"})
    public static void addStationItems(SwipePlaceHolderView cardsContainerView, List<StationData> stationList, int action) {
        if (action == StationDetailViewModel.ACTION_ADD_ALL) {
            if (stationList != null) {
                cardsContainerView.removeAllViews();
                for (StationData station : stationList) {
                    if (station != null) {
                        cardsContainerView.addView(new StationCard(station));
                    }
                }
                ViewAnimationUtils.scaleAnimateView(cardsContainerView);
            }
        }
    }

}
