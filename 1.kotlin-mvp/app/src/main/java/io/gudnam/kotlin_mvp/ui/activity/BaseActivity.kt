package io.gudnam.kotlin_mvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by gudnam on 2017. 3. 23..
 */
abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
    }
}