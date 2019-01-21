package com.example.joe.st_giorgis_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Membership.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Membership#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Membership extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    BottomSheetBehavior bottomSheetBehavior;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Membership() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Membership.
     */
    // TODO: Rename and change types and number of parameters
    public static Membership newInstance(String param1, String param2) {
        Membership fragment = new Membership();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_membership, container, false);
//        LinearLayout bottomlinearLayout = view.findViewById(R.id.bottomLinearLayout);
        Button bottomSheet_btn = view.findViewById(R.id.btn_mem_continue);
        bottomSheet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransferBottomSheet transferBottomSheet = TransferBottomSheet.newInstance();
                transferBottomSheet.show(getFragmentManager(), "Choose Source");
            }
        });

        Button button_pay_love = view.findViewById(R.id.pay_with_love);
        button_pay_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransferBottomSheet transferBottomSheet = TransferBottomSheet.newInstance();
                transferBottomSheet.show(getFragmentManager(), "Choose Source");
            }
        });
//        bottomSheetBehavior = BottomSheetBehavior.from(bottomlinearLayout);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
