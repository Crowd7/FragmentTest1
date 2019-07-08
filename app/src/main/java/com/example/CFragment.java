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
public class CFragment extends BaseFragment {

    private Button btnThird;

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_c, container, false);
        btnThird = root.findViewById(R.id.btnThird);

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameContent, new DFragment());
                ft.addToBackStack("THIRD_BACK_STACK");
                ft.commit();
            }
        });

        mMainActivity.updateActionBarTitle(getClass().getSimpleName());
        return root;
    }

    public void customBackPressed(){
        FragmentManager fm = getFragmentManager();
        fm.popBackStack("FIRST_BACK_STACK", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

}
