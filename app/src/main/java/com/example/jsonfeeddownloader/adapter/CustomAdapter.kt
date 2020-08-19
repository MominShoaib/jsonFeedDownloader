package com.example.jsonfeeddownloader.adapter

import GitHubUserModel
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jsonfeeddownloader.R
import com.example.jsonfeeddownloader.activities.UserInfoDisplay
import kotlinx.android.synthetic.main.row_display.view.*
import android.content.Context as Context1

class CustomAdapter(val arrayList: ArrayList<GitHubUserModel>, val context: Context1) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: GitHubUserModel) {
            itemView.idTextView.text = model.id.toString()
            itemView.nameTextView.text = model.login
            itemView.urlTextView.text = model.html_url
            itemView.following.text = model.following_url
            itemView.followers.text = model.followers_url




            Glide.with(itemView.imageView).load(model.avatar_url)
               .into(itemView.imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_display, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {

            val model = arrayList[position]
            val tempID = model.id
            val tempName = model.login
            val tempImageURL = model.avatar_url
            val tempFollowersURL = model.followers_url
            val tempFollowingURL = model.following_url
            val tempUserURL = model.html_url

            val intent = Intent(context, UserInfoDisplay::class.java)
            intent.putExtra("iID", tempID)
            intent.putExtra("iName", tempName)
            intent.putExtra("iImageURL", tempImageURL)
            intent.putExtra("iFollowersURL", tempFollowersURL)
            intent.putExtra("iFollowingURL", tempFollowingURL)
            intent.putExtra("iUserURL", tempUserURL)

            context.startActivity(intent)
        }

    }
}