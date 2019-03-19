package com.pcyfox.p_rxbus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pcyfox.rxbus.RxBus
import com.pcyfox.rxbus.Subscribe
import com.pcyfox.rxbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RxBus.default.register(this)
    }

    fun onClick(view: View) {
        if (view.id == R.id.btn_1) {
            RxBus.default.post("123456789")
        }else{
            RxBus.default.postSticky("Sticky------")
            startActivity(Intent(this, TestActivity::class.java))
        }

    }

    //EventBus 3.0 回调
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 4)
    fun eventBus(obj: String) {
        Toast.makeText(this,"MainActivity"+ obj, Toast.LENGTH_LONG).show()
    }
}
