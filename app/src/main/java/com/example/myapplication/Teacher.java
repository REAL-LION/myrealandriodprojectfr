package com.example.myapplication;


public class Teacher {

    private int cooldown, points;
    private String teacherName;

    public Teacher() {
        teacherName="error";
        points=0;
    }



    public Teacher(String s, int x) {
        teacherName=s;
        points=x;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
