package edu.temple.colorfragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CanvasFragment extends Fragment {

    public CanvasFragment() {

    }
    private View view;

    public static CanvasFragment newInstance() {
        CanvasFragment fragment = new CanvasFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_canvas, container, false);
        return view;
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }


    public void changeBackgroundColor(String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }
}