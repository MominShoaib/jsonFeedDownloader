package com.example.jsonfeeddownloader.activities

import GitHubUserModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonfeeddownloader.R
import com.example.jsonfeeddownloader.adapter.CustomAdapter
import com.example.jsonfeeddownloader.utitlities.showToast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)




        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        parseJson(queue)

        swipeRefresh.setOnRefreshListener()
        {

            parseJson(queue)

            swipeRefresh.isRefreshing = false
        }



    }

    private fun parseJson(requestQueue: RequestQueue) {
        val url = "https://api.github.com/users"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener
            { success ->
                val type: Type = object : TypeToken<ArrayList<GitHubUserModel?>?>() {}.type
                val githubUser: ArrayList<GitHubUserModel> = Gson().fromJson(success, type)
                setDataToRecyclerView(githubUser)
                //showToast(githubUser.toString())

            },

            Response.ErrorListener
            { error_ ->
                showToast("Network Request Failed")
            }
        )

        requestQueue.add(stringRequest)

    }

    private fun setDataToRecyclerView(githubUser: ArrayList<GitHubUserModel>) {

        val customAdapter = CustomAdapter(githubUser, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

    }






}