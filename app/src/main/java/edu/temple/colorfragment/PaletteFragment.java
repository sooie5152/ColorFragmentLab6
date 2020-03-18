package edu.temple.colorfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import static edu.temple.colorfragment.R.id.colorSpinner;

public class PaletteFragment extends Fragment {

    private static final String ARG_PARAM1 = "colors";
    private static final String ARG_PARAM2 = "colorsHex";


    private String[] mParam1;
    private String[] mParam2;
    private View view;

    private OnFragmentInteractionListener mListener;

    public PaletteFragment() {

    }



    public static PaletteFragment newInstance(String[] param1, String[] param2) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, param1);
        args.putStringArray(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getStringArray(ARG_PARAM1);
            mParam2 = getArguments().getStringArray(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_palette, container, false);
        Spinner spinner = view.findViewById(colorSpinner);
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), mParam1, mParam2);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentInteraction(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {

            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(int position);
    }
}