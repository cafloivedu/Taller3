package com.kafloid.taller3

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingleton constructor(context: Context){
    companion object{
        @Volatile
        private var INSTANCE : VolleySingleton? = null
        fun getInstance(context: MainFragment) =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: VolleySingleton(context).also{ INSTANCE = it}
            }
    }

    val requestQueue : RequestQueue by lazy{
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T>addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}