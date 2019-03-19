package com.pcyfox.p_rxbus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.pcyfox.rxbus.RxBus
import com.pcyfox.rxbus.Subscribe
import com.pcyfox.rxbus.ThreadMode

class Test2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RxBus.default.register(this)
    }

    //EventBus 3.0 回调
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 3)
    fun eventBus(obj: String) {
        Toast.makeText(this, "Test2Activity" + obj, Toast.LENGTH_LONG).show()
        RxBus.default.removeStickyEvent(obj::class.java)
    }


}
