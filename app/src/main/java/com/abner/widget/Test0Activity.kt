package com.abner.widget

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 *AUTHOR:AbnerMing
 *DATE:2022/5/9
 *INTRODUCE:测试跳转页面一
 */
class Test0Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        findViewById<TextView>(R.id.tv_text).text="Test0Activity"
    }
}