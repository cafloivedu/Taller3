package com.kafloid.taller3;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

public class RandomUser {

    public static Gson g = new Gson();
    public String gender;
    public  Name name;

    public  static  class Name{
        public String title;
        public String first;
        public String last;

        public Name (){

        }

        @NonNull
        @Override
        public String toString(){
            return super g.toJson(this);
        }
    }
}
