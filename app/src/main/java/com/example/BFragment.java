package com.example;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends BaseFragment {
    private Button btn2;

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_b, container, false);
        btn2 = root.findViewById(R.id.btnSecond);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.hide(BFragment.this);
                ft.add(R.id.frameContent, new CFragment());
                ft.addToBackStack("SECOND_BACK_STACK");
                ft.commit();
            }
        });

        mMainActivity.updateActionBarTitle(getClass().getSimpleName());
        return root;
    }

}
