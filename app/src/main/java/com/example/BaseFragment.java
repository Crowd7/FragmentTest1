package com.example;

import android.content.Context;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    protected MainActivity mMainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mMainActivity = (MainActivity) context;
    }
}
