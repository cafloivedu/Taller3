package com.kafloid.taller3;

import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RandomUser {

    public static Gson g = new Gson();
    public String gender;
    public Name name;
    public Location location;
    public String email;
    public Login login;
    public Dob dob;
    public Registered registered;
    public String phone;
    public String cell;
    public Id id;
    public Picture picture;
    public String nat;


    public static ArrayList<RandomUser> getUser(JSONObject response){
        ArrayList<RandomUser> list = new ArrayList<>();
        try {
            JSONArray info = response.getJSONArray("results");
            for (int i = 0; i < info.length(); i++){
                String persona = info.getJSONObject(i).toString();
                RandomUser temp = g.fromJson(persona, RandomUser.class);
                list.add(temp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static class Location{
        public Street street;
        public String city;
        public String state;
        public String postcode;
        public Coordinates coordinates;
        public Timezone timezone;

        public Location (){}

        @Override
        public String toString() { return g.toJson(this);}
    }

    public static class Street {
        public String number;
        public String name;

        public Street(){}

        @Override
        public String toString() { return g.toJson(this);}
    }

    public  static  class Name{
        public String title;
        public String first;
        public String last;

        public Name (){

        }

        @NonNull
        @Override
        public String toString(){
            return  g.toJson(this);
        }
    }

    public static class Id{
        public String name;
        public String value;

        public Id(){}

        @Override
        public String toString() { return g.toJson(this);}

    }

    public static class Registered{
        public String date;
        public String age;

        public Registered(){}

        @Override
        public String toString() { return g.toJson(this);}
    }

    public static class Login{
        public String username;
        public String password;
        public String salt;
        public String md5;
        public String sha1;
        public String sha256;

        public Login(){}

        @Override
        public String toString() { return g.toJson(this);}
    }

    public static class Dob {
        public String date;
        public String age;
        public Dob(){

        }
        @Override
        public String toString() { return g.toJson(this);}
    }

    public static class Picture {
        public String large;
        public String medium;
        public String thumbnail;
        public Picture(){

        }
        @Override
        public String toString() { return g.toJson(this);}
    }

    public static class Timezone {
        public String offset;
        public String description;

        public Timezone(){

        }
        @Override
        public String toString() { return g.toJson(this);}
    }

    public static class Coordinates{
        public String latitude;
        public String longitude;

        public Coordinates(){}

        @Override
        public String toString() { return g.toJson(this);}
    }


}
