package com.kafloid.taller3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.row.*
import kotlinx.android.synthetic.main.fragment_main.textViewUserName
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: RandomUserViewModel
    private var userList = mutableListOf<RandomUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(RandomUserViewModel::class.java)

        viewModel.getUsers().observe(this, Observer { users ->
            run{
                userList = users as MutableList<RandomUser>
                Log.d("LiveData", "userList size "+ userList.size)
            }
        })

        floatingActionButton.setOnClickListener{
            //VolleySingleton.getInstance(this).addToRequestQueue(getJsonObjectRequest())
            viewModel.addUser()
        }
    }

    fun getStringRequest() : StringRequest {
        val url = "https://randomuser.me/api/"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>{ response ->
                textViewUserName.text = response.toString()
            },
            Response.ErrorListener{
                textViewUserName.text = "error"
            }
        )
        return stringRequest
    }



    fun parseObject(response: JSONObject) {
        val jsonArrayResults: JSONArray = response.getJSONArray("results")
        val size: Int = jsonArrayResults.length()
        val i: Int = 0
        for (i in 0.. size -1){
            val userObject = jsonArrayResults.getJSONObject(i)
            val gender = userObject.getString("gender")
            val nameObject = userObject.getJSONObject("name")
            val firstName = nameObject.getString("first")
            Log.d("JSONParsing", gender + " " + firstName)

        }
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
