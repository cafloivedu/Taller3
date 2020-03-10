package com.kafloid.taller3

import android.content.Context
import androidx.lifecycle.MutableLiveData

class RandomUserDao private constructor(var context: Context) {

    private val users =  MutableLiveData<List<RandomUser>>()
    private val userList = mutableListOf<RandomUser>()

    companion object{
        private var INSTANCE: RandomUserDao? = null
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this ){
                INSTANCE ?: RandomUserDao(context).also {
                    INSTANCE = it
                }
            }
    }

    fun addUsers(){

    }

    fun getUsers() = users
}