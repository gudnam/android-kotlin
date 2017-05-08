package io.gudnam.kotlin_rx.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by gudnam on 2017. 3. 23..
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var disposable: CompositeDisposable = CompositeDisposable()
    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
    }

    override fun onResume() {
        super.onResume()
        disposable = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        Log.i("test", "onPause")
        disposable?.let {
            if (!it.isDisposed) {
                Log.i("test", "dispose")
                it.dispose()
            }
        }
    }
}