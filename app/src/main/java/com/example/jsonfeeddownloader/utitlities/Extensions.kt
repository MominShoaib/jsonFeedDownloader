package com.example.jsonfeeddownloader.utitlities

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}