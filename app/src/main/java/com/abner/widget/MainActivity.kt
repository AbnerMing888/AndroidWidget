package com.abner.widget

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_add).setOnClickListener {
            //动态方式添加一
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                val shortScan = ShortcutInfoCompat.Builder(this, "test_2")//唯一标识id
                    .setShortLabel(getString(R.string.app_test_2))//短标签
                    .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_launcher))//图标
                    //跳转的目标，定义Activity
                    .setIntent(Intent(Intent.ACTION_MAIN, null, this, MainActivity::class.java))
                    .build()
                //执行添加操作
                ShortcutManagerCompat.addDynamicShortcuts(this, mutableListOf(shortScan))

                toast("已添加")
            }

        }

        findViewById<Button>(R.id.btn_remove).setOnClickListener {
            //动态移除方式一
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                ShortcutManagerCompat.removeDynamicShortcuts(
                    this@MainActivity,
                    Collections.singletonList("test_2")//唯一标识id
                )
                toast("已移除")
            }
        }

        findViewById<Button>(R.id.btn_updata).setOnClickListener {
            //动态更新方式一
            val shortScan = ShortcutInfoCompat.Builder(this, "test_2")//唯一标识id
                .setShortLabel(getString(R.string.app_test_2_updata))//更新一个短标签
                .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_launcher))//图标
                //要跳转的目标
                .setIntent(Intent(Intent.ACTION_MAIN, null, this, MainActivity::class.java))
                .build()
            //执行更新操作
            ShortcutManagerCompat.updateShortcuts(this, mutableListOf(shortScan))

            toast("已更新")
        }

        findViewById<Button>(R.id.btn_add_1).setOnClickListener {
            //动态方式添加二
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                val info = ShortcutInfo.Builder(this, "test_3")//唯一标识id
                    .setShortLabel(getString(R.string.app_test_3))//短的标签
                    .setLongLabel(getString(R.string.app_test_3_long))//长的标签
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))//图标
                    .setIntent(intent)//跳转的目标，这里我设置的是当前
                    .build()
                //执行添加操作
                getSystemService(ShortcutManager::class.java)
                    .dynamicShortcuts = mutableListOf(info)

                toast("已添加")
            }

        }
        findViewById<Button>(R.id.btn_remove_1).setOnClickListener {
            //动态移除方式二
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                getSystemService(ShortcutManager::class.java)
                    .removeDynamicShortcuts(listOf("test_3"))//唯一的id标识
                toast("已移除")
            }

        }

        findViewById<Button>(R.id.btn_updata_1).setOnClickListener {
            //动态更新方式二
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                val info = ShortcutInfo.Builder(this, "test_3")//唯一标识id
                    .setShortLabel(getString(R.string.app_test_3_updata))//更新一个短标签
                    .setLongLabel(getString(R.string.app_test_3_long))//长标签
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))//图标
                    .setIntent(intent)//跳转的目标，这里我设置的是当前
                    .build()
                //执行更新操作
                getSystemService(ShortcutManager::class.java).updateShortcuts(listOf(info))

                toast("已更新")
            }
        }
    }


    fun toast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}