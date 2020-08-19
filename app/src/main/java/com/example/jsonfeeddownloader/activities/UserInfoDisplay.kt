package com.example.jsonfeeddownloader.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.jsonfeeddownloader.R
import kotlinx.android.synthetic.main.row_display.*
import kotlinx.android.synthetic.main.user_info_display.*

class UserInfoDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.user_info_display)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intentUser = intent
        val displayID = intentUser.getIntExtra("iID", 0)
        val displayName = intentUser.getStringExtra("iName")
        val displayImageURL = intentUser.getStringExtra("iImageURL")
        val displayFollowersURL = intentUser.getStringExtra("iFollowersURL")
        val displayFollowingURL = intentUser.getStringExtra("iFollowingURL")
        val displayUserUrl = intentUser.getStringExtra("iUserURL")
        actionBar.setTitle(displayName)


        idFullDisplay.text = displayID.toString()
        nameFullDisplay.text = displayName
        urlFullDisplay.text = displayUserUrl
        followersUrlFullDisplay.text = displayFollowersURL
        followingUrlFullDisplay.text = displayFollowingURL

        Glide.with(this).load(displayImageURL).circleCrop().into(imageFullDisplay)


    }
}