package com.seladanghijau.i_sras.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.activities.MainActivity;
import com.seladanghijau.i_sras.adapter.SoalanAdapter;
import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.dtos.Soalan;
import com.seladanghijau.i_sras.helper.DBHelper;
import com.seladanghijau.i_sras.helper.Helper;
import com.seladanghijau.i_sras.providers.SoalanProvider;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    Fragment homeFragment, communityFragment, workplaceFragment;
    Button btnPreviousC, btnNextC;
    List<Soalan> soalanList, soalanList2, soalanList3, soalanList4, soalanList5, soalanList6, soalanList7, soalanList8, soalanList9;
    ListView lvKeyArea1_1, lvKeyArea1_2, lvKeyArea1_3, lvKeyArea1_4, lvKeyArea1_5, lvKeyArea2_1, lvKeyArea3_1, lvKeyArea3_2, lvKeyArea4_1;
    SoalanAdapter soalanAdapter, soalanAdapter2, soalanAdapter3, soalanAdapter4, soalanAdapter5, soalanAdapter6, soalanAdapter7, soalanAdapter8, soalanAdapter9;
    List<Answer> answerList, answerList2, answerList3, answerList4, answerList5, answerList6, answerList7, answerList8, answerList9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Dalam ini untuk apa apa code selain set listener dgn findviewbyid
        try {
            new DBHelper(getActivity()).initDB(); // initialize sqlitedb
        } catch (Exception e) { e.printStackTrace(); }

        answerList = new ArrayList<>();
        answerList2 = new ArrayList<>();
        answerList3 = new ArrayList<>();
        answerList4 = new ArrayList<>();
        answerList5 = new ArrayList<>();
        answerList6 = new ArrayList<>();
        answerList7 = new ArrayList<>();
        answerList8 = new ArrayList<>();
        answerList9 = new ArrayList<>();

        soalanList = new ArrayList<>();
        soalanList2 = new ArrayList<>();
        soalanList3 = new ArrayList<>();
        soalanList4 = new ArrayList<>();
        soalanList5 = new ArrayList<>();
        soalanList6 = new ArrayList<>();
        soalanList7 = new ArrayList<>();
        soalanList8 = new ArrayList<>();
        soalanList9 = new ArrayList<>();

        //soalanList = SoalanProvider.loadSoalanBasedOnCategory(1);
        soalanList = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 1, 3);
        soalanList2 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 4, 10);
        soalanList3 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 11, 13);
        soalanList4 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 14, 14);
        soalanList5 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 15, 17);
        soalanList6 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 18, 26);
        soalanList7 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 27, 29);
        soalanList8 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 30, 31);
        soalanList9 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 32, 34);

        //answerlist
        answerList = CreateAnswer(soalanList);
        answerList2 = CreateAnswer(soalanList2);
        answerList3 = CreateAnswer(soalanList3);
        answerList4 = CreateAnswer(soalanList4);
        answerList5 = CreateAnswer(soalanList5);
        answerList6 = CreateAnswer(soalanList6);
        answerList7 = CreateAnswer(soalanList7);
        answerList8 = CreateAnswer(soalanList8);
        answerList9 = CreateAnswer(soalanList9);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentcommunity, container, false);
        //inflate fragment layout kat sini
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //kat sini set findviewby id dgn listener e.g Button btnNext = (Button) getActivity().findViewById(R.id.btnNext2);
        homeFragment = getFragmentManager().findFragmentById(R.id.HomeFragment);
        communityFragment = getFragmentManager().findFragmentById(R.id.CommunityFragment);
        workplaceFragment = getFragmentManager().findFragmentById(R.id.WorkplaceFragment);

        lvKeyArea1_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_1);
        lvKeyArea1_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_2);
        lvKeyArea1_3 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_3);
        lvKeyArea1_4 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_4);
        lvKeyArea1_5 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_5);
        lvKeyArea2_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_1);
        lvKeyArea3_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_1);
        lvKeyArea3_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_2);
        lvKeyArea4_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea4_1);

        Helper.getListViewSize(lvKeyArea1_1);
        Helper.getListViewSize(lvKeyArea1_2);
        Helper.getListViewSize(lvKeyArea1_3);
        Helper.getListViewSize(lvKeyArea1_4);
        Helper.getListViewSize(lvKeyArea1_5);
        Helper.getListViewSize(lvKeyArea2_1);
        Helper.getListViewSize(lvKeyArea3_1);
        Helper.getListViewSize(lvKeyArea3_2);
        Helper.getListViewSize(lvKeyArea4_1);

        soalanAdapter = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList, answerList, lvKeyArea1_1);
        soalanAdapter2 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList2, answerList2, lvKeyArea1_2);
        soalanAdapter3 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList3, answerList3, lvKeyArea1_3);
        soalanAdapter4 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList4, answerList4, lvKeyArea1_4);
        soalanAdapter5 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList5, answerList5, lvKeyArea1_5);
        soalanAdapter6 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList6, answerList6, lvKeyArea2_1);
        soalanAdapter7 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList7, answerList7, lvKeyArea3_1);
        soalanAdapter8 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList8, answerList8, lvKeyArea3_2);
        soalanAdapter9 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList9, answerList9, lvKeyArea4_1);

        soalanAdapter.notifyDataSetChanged();
        soalanAdapter2.notifyDataSetChanged();
        soalanAdapter3.notifyDataSetChanged();
        soalanAdapter4.notifyDataSetChanged();
        soalanAdapter5.notifyDataSetChanged();
        soalanAdapter6.notifyDataSetChanged();
        soalanAdapter7.notifyDataSetChanged();
        soalanAdapter8.notifyDataSetChanged();
        soalanAdapter9.notifyDataSetChanged();

        lvKeyArea1_1.setAdapter(soalanAdapter);
        lvKeyArea1_2.setAdapter(soalanAdapter2);
        lvKeyArea1_3.setAdapter(soalanAdapter3);
        lvKeyArea1_4.setAdapter(soalanAdapter4);
        lvKeyArea1_5.setAdapter(soalanAdapter5);
        lvKeyArea2_1.setAdapter(soalanAdapter6);
        lvKeyArea3_1.setAdapter(soalanAdapter7);
        lvKeyArea3_2.setAdapter(soalanAdapter8);
        lvKeyArea4_1.setAdapter(soalanAdapter9);

        btnPreviousC = (Button) getActivity().findViewById(R.id.btnPreviousC);
        btnNextC = (Button) getActivity().findViewById(R.id.btnNextC);

        btnPreviousC.setOnClickListener(new OnButtonClick());
        btnNextC.setOnClickListener(new OnButtonClick());
    }

    private class OnButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.btnPreviousC:
                    fragmentTransaction.hide(communityFragment);
                    fragmentTransaction.show(homeFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnNextC :
                    // retrieve user's answer & store the answer into db
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea1_1);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea1_2);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea1_3);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea1_4);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea1_5);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea2_1);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea3_1);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea3_2);
                    ((MainActivity) getActivity()).communityVitalCount += Helper.getUserAnswerVital(lvKeyArea4_1);

                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea1_1);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea1_2);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea1_3);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea1_4);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea1_5);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea2_1);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea3_1);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea3_2);
                    ((MainActivity) getActivity()).communityRecommendedCount += Helper.getUserAnswerRecommended(lvKeyArea4_1);

                    fragmentTransaction.hide(communityFragment);
                    fragmentTransaction.show(workplaceFragment);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    }

    //Create answer list based on soalan id
    public List<Answer> CreateAnswer(List<Soalan> soalanList){

        List<Answer> answerList = new ArrayList<>();

        for (int i=0; i<soalanList.size(); i++){
            Answer answer = new Answer();
            answer.setAnswerId(soalanList.get(i).getSoalanId());

            answerList.add(answer);
        }

        return answerList;
    }
}
