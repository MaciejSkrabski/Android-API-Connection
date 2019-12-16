package com.example.apiconnection


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TH = TaskHelper()
        this.zart.text = TH.execute().get()

        this.button.setOnClickListener { val TH = TaskHelper(); this.zart.text = TH.execute().get() }
    }


}
