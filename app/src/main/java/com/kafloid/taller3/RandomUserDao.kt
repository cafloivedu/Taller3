package com.kafloid.taller3

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.fragment_main.*
import org.json.JSONObject

class RandomUserDao private constructor(var context: Context) {

    private val users =  MutableLiveData<List<RandomUser>>()
    private val userList = mutableListOf<RandomUser>()
    private var queue : RequestQueue

    init{
        queue = VolleySingleton.getInstance(context).requestQueue
    }

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
        VolleySingleton.getInstance(context).addToRequestQueue(getJsonObjectRequest())
    }

    fun getUsers() = users

    fun getJsonObjectRequest() : JsonObjectRequest {
        val url = "https://randomuser.me/api/?results=1"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                //parseObject(response)
                parseObjectGson(response)
            },
            Response.ErrorListener{
                //textViewUserName.text = "error"
                Log.d("WebRequestTest", "That didn't work!")
            }
        )
        return jsonObjectRequest
    }

    fun parseObjectGson(response: JSONObject) {
        var list = RandomUser.getUser(response)
        val size: Int = list.size
        val i: Int = 0
        for (i in 0.. size -1){
            val user = list.get(i)
            Log.d("WebJson", "element "+ user.name.first)

        }
    }
}