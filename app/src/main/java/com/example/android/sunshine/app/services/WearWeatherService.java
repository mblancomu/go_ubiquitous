package com.example.android.sunshine.app.services;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;
import com.example.android.sunshine.app.utils.Constants;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by manuel on 11/06/16.
 */
public class WearWeatherService extends WearableListenerService {

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        super.onDataChanged(dataEvents);

        for (DataEvent dataEvent : dataEvents) {
                        if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                                if (dataEvent.getDataItem().getUri().getPath().equals(Constants.PATH)) {
                                       SunshineSyncAdapter.syncImmediately(this);
                                    }
                            }
                    }
            }
}
