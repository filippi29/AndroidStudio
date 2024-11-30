package com.example.ioynios2024___lisi;

import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();
    String tempGrades;

    public Student(String n, String tempGrades){
        this.name = n;
        this.tempGrades = tempGrades;

        //παιρνει τους βαθμους απο το xml αρχειο (tempGrades) και απο string τους διαχωριζει και κανει int
        for (String i: tempGrades.split(",")){
            String clString = i.replaceAll("\\s", "");   //καθαρίζει όπου υπάρχει κενό στο i
            int grade = Integer.parseInt(clString);    //παιρνει τον βαθμό

            grades.add(grade);   //βαζει τον βαθμο στην arraylist
        }
    }

    public String findAverage(){
        double sum =0;
        int count =0;
        double average;

        for(int i=0; i<grades.size(); i++){
            if(grades.get(i) >= 5){
                sum += grades.get(i);
                count++;
            }
        }
        average = sum/count;
        return average +"";    //gia na einai string (giati to toast emfanizei mono string
    }

    //gia na parei to onoma
    public String getName() {
        return name;
    }
}
