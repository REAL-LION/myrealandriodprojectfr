package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private static boolean start=true;
    private static ArrayList<Teacher> teacherList;
    private static Teacher selectedTeacher = new Teacher();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle   savedInstanceState) {
       // View view = inflater.inflate(R.layout.fragment_second, container, false);
       // TextView Scores = (TextView) inflater.inflate(R.layout.fragment_first, container, false);
        // mWebView = (WebView) view.findViewById(R.id.activity_main_webview);
        // progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);

        //Scores.setText(updateTeacherScores());

        {
//google firstfrag access from main activity
            binding = FragmentFirstBinding.inflate(inflater, container, false);

            if(start) {
                teacherList = createTeacherList();
            start=false;
            }

            return binding.getRoot();

        }
    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherList = updateTeacherListfromSelected();
        ((MainActivity)getActivity()).updateTextView(updateTeacherScoresfromList());

                binding.buttonViers.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        selectedTeacher = new Teacher("viers", 0);

                        NavHostFragment.findNavController(FirstFragment.this)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment);
                    }

                });
        binding.buttonOtano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTeacher = new Teacher("otano", 0);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.buttonGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTeacher = new Teacher("guru", 0);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });




// Load and use views afterwards



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public ArrayList<Teacher> createTeacherList() {
        ArrayList<Teacher> temp = new ArrayList<>();
        temp.add(new Teacher("viers", 0));
        temp.add(new Teacher("otano", 0));
        temp.add(new Teacher("guru", 0));
        return temp;
    }

    public ArrayList<Teacher> updateTeacherList(int x1, int x2, int x3) {
        int vP = 0;
        int oP = 0;
        int gP = 0;

        for (Teacher t : teacherList) {
            if (t.getTeacherName() == "viers")
                vP = t.getPoints() + x1;
            if (t.getTeacherName() == "otano")
                oP = t.getPoints() + x2;
            if (t.getTeacherName() == "guru")
                oP = t.getPoints() + x3;
        }

        ArrayList<Teacher> temp = new ArrayList<>();
        temp.add(new Teacher("viers", vP));
        temp.add(new Teacher("otano", oP));
        temp.add(new Teacher("guru", gP));
        return temp;
    }

    public static ArrayList<Teacher> updateTeacherListfromSelected() {
        int vP = 0;
        int oP = 0;
        int gP = 0;

        for (Teacher t : teacherList) {
            if (t.getTeacherName() == "viers")
                vP = t.getPoints();
            if (t.getTeacherName() == "otano")
                oP = t.getPoints();
            if (t.getTeacherName() == "guru")
                oP = t.getPoints();
        }

        if (selectedTeacher.getTeacherName() == "viers")
            vP += selectedTeacher.getPoints();
        if (selectedTeacher.getTeacherName() == "otano")
            oP += selectedTeacher.getPoints();
        if (selectedTeacher.getTeacherName() == "guru")
            gP += selectedTeacher.getPoints();

        ArrayList<Teacher> temp = new ArrayList<>();
        temp.add(new Teacher("viers", vP));
        temp.add(new Teacher("otano", oP));
        temp.add(new Teacher("guru", gP));
        return temp;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public Teacher getSelectedTeacher() {
        return selectedTeacher;
    }

    public void setSelectedTeacher(Teacher selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    public String updateTeacherScores() {

        String s = "";
        int vP = 0;
        int oP = 0;
        int gP = 0;

        if (selectedTeacher.getTeacherName() == "viers")
            vP = selectedTeacher.getPoints();
        if (selectedTeacher.getTeacherName() == "otano")
            oP = selectedTeacher.getPoints();
        if (selectedTeacher.getTeacherName() == "guru")
            gP = selectedTeacher.getPoints();

        s="SCORE:\n \nViers: "+vP+"\n \nOtano: "+oP+"\n \nGuru: "+gP+"\n";

    return s;
    }

    public String updateTeacherScoresfromList() {
        String s = "";
        int vP = 0;
        int oP = 0;
        int gP = 0;

        for (Teacher t : teacherList) {
            if (t.getTeacherName() == "viers")
                vP = t.getPoints();
            if (t.getTeacherName() == "otano")
                oP = t.getPoints();
            if (t.getTeacherName() == "guru")
                oP = t.getPoints();
        }


        s="SCORE:\n \nViers: "+vP+"\n \nOtano: "+oP+"\n \nGuru: "+gP+"\n";
        return s;
    }



/*
    public void handleText(View v){
        EditText t =findViewById(R.id.source);
    }
*/
}