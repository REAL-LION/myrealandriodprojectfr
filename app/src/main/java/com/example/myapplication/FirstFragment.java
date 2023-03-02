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
        ArrayList <Teacher> temp = new ArrayList<>();
        temp.add(new Teacher("viers", x1));
        temp.add(new Teacher("otano", x2));
        temp.add(new Teacher("guru", x3));
        return temp;
    }
}