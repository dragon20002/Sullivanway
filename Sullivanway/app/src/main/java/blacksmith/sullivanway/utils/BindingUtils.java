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
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import blacksmith.sullivanway.data.entity.others.StationDetailVo;

/**
 * Created by amitshekhar on 11/07/17.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter", "action"})
    public static void addStationItems(RecyclerView recyclerView, List<StationDetailVo> stationList, int action) {
//        if (action == SubwayNodeViewModel.ACTION_ADD_ALL) {
//            recyclerView.getAdapter();
//            if (stationList != null) {
//                recyclerView.removeAllViews();
//                for (StationData station : stationList) {
//                    if (station != null) {
//                        recyclerView.addView(new StationCard(station));
//                    }
//                }
//                ViewAnimationUtils.scaleAnimateView(recyclerView);
//            }
//        }
    }

}
