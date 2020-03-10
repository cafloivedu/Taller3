package com.kafloid.taller3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class RandomUserViewModel (application: Application): AndroidViewModel(application) {

    private var randomUserDao : RandomUserDao
    init{
        randomUserDao = RandomUserDao.getInstance(this.getApplication())
    }

    fun addUser(){
        randomUserDao.addUsers()
    }

    fun getUsers(): MutableLiveData<List<RandomUser>>{
        return randomUserDao.getUsers()
    }
}