package com.lighthouse.awfulandroid.activities.interview_activities;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.http.ForecastListener;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.models.Forecast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class ActivityListFragment extends Fragment {

    private final String[] activities = {"Lorem Ipsum", "Weather"};

    @Inject
    ForecastService forecastService;

    @Bind(R.id.activities_list)
    ListView activitiesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AwfulAndroidApp.get(getActivity()).getComponent().inject(this);

        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);
        ButterKnife.bind(this, view);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, activities);
        activitiesList.setAdapter(adapter);

        return view;
    }

    @OnItemClick(R.id.activities_list)
    public void onItemClick(int position) {
        if (position == 1) {
            forecastService.getForecastFor("22.2", "90.0", new ForecastListener() {
                @Override
                public void onForecastLoaded(Forecast forecast) {
                    Toast.makeText(getActivity(), forecast.getCurrently().getIcon() + "\r", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onForecastFailed(Exception e) {

                }
            });
        }
    }
}