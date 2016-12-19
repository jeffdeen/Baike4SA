package com.ar.lee.baikeapplication.entrycomment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.data.EntryComment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EntryCommentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EntryCommentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EntryCommentFragment extends Fragment implements EntryCommentContract.View{

    private OnFragmentInteractionListener mListener;

    private EntryCommentContract.Presenter mPresenter;

    private RecyclerView commentRecyclerView;

    public EntryCommentFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(EntryCommentContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EntryCommentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EntryCommentFragment newInstance() {
        EntryCommentFragment fragment = new EntryCommentFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return initViews(inflater.inflate(R.layout.fragment_entry_comment, container, false));
    }

    private View initViews(View fragment){
        commentRecyclerView = (RecyclerView) fragment.findViewById(R.id.entry_comment_list);
        List<EntryComment> list = new ArrayList<>();
        list.add(new EntryComment());
        list.add(new EntryComment());
        list.add(new EntryComment());
        CommentListAdapter adapter = new CommentListAdapter(getContext(), list);
        commentRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        commentRecyclerView.setAdapter(adapter);
        commentRecyclerView.addItemDecoration(new CommentListDecoration(getContext(), CommentListDecoration.VERTICAL_LIST));

        return fragment;
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
