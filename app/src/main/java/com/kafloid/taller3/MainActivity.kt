package com.kafloid.taller3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.row.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton.setOnClickListener{
            VolleySingleton.getInstance(this).addToRequestQueue(getStringRequest())
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
}
