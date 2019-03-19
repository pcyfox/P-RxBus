package com.pcyfox.p_rxbus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.pcyfox.rxbus.RxBus
import com.pcyfox.rxbus.Subscribe
import com.pcyfox.rxbus.ThreadMode

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        RxBus.default.register(this)
    }

    //EventBus 3.0 回调
    @Subscribe(threadMode = ThreadMode.MAIN,priority = -1)
    fun eventBus(obj: String) {
        Log.d("TestActivity--->",obj)
        Toast.makeText(this,"TestActivity"+ obj, Toast.LENGTH_LONG).show()
    }
    fun onClick(view: View) {
      //  RxBus.default.removeStickyEvent(String::class.java)
        startActivity(Intent(this, Test2Activity::class.java))
    }
}
