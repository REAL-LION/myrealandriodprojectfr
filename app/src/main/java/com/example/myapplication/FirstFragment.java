package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Teacher> teacherList;
    private Teacher selectedTeacher;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        teacherList=createTeacherList();
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherList=updateTeacherListfromSelected();


        binding.buttonViers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                selectedTeacher = new Teacher("viers",0);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }

        });
        binding.buttonOtano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTeacher = new Teacher("otano",0);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.buttonGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTeacher = new Teacher("guru",0);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public ArrayList <Teacher> createTeacherList(){
        ArrayList <Teacher> temp = new ArrayList<>();
        temp.add(new Teacher("viers", 0));
        temp.add(new Teacher("otano", 0));
        temp.add(new Teacher("guru", 0));
        return temp;
    }
    public ArrayList <Teacher> updateTeacherList(int x1,int x2, int x3){
        int vP=0;
        int oP=0;
        int gP=0;

        for(Teacher t: teacherList) {
            if(t.getTeacherName()=="viers")
               vP= t.getPoints()+x1;
            if(t.getTeacherName()=="otano")
                oP= t.getPoints()+x2;
            if(t.getTeacherName()=="guru")
                oP= t.getPoints()+x3;
        }

        ArrayList <Teacher> temp = new ArrayList<>();
        temp.add(new Teacher("viers", vP));
        temp.add(new Teacher("otano", oP));
        temp.add(new Teacher("guru", gP));
        return temp;
    }

    public ArrayList <Teacher> updateTeacherListfromSelected(){
        int vP=0;
        int oP=0;
        int gP=0;

        if (selectedTeacher.getTeacherName()=="viers")
            vP=selectedTeacher.getPoints();
        if (selectedTeacher.getTeacherName()=="otano")
            oP=selectedTeacher.getPoints();
        if (selectedTeacher.getTeacherName()=="guru")
            gP=selectedTeacher.getPoints();

        ArrayList <Teacher> temp = new ArrayList<>();
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
}