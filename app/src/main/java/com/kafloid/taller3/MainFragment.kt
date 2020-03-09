package com.kafloid.taller3


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.kafloid.taller3.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.row.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), UserAdapter.onListInteraction {

    val users = mutableListOf<User>()
    private var adapter : UserAdapter? = null
    var count : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        adapter = UserAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener{
            //VolleySingleton.getInstance(this).addToRequestQueue(getStringRequest())
            //users.add(User("Nombre: " + count, "Correo: " + count, "Telefono: " + count))
            count++;
            adapter!!.updateData();
        }

        return view
    }



    override fun onListItemInteraction(item: User?) {
        Log.d("KRecycleView", "onListItemInteraction" + item!!.nombre)
    }

    override fun onListButtonInteraction(item: User?) {
        //users.remove(item)
        adapter!!.updateData();
    }


}
