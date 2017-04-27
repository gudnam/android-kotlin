package io.gudnam.kotlin_di.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.gudnam.kotlin_di.App
import io.gudnam.kotlin_di.di.ApplicationComponent
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by gudnam on 2017. 4. 27..
 */
abstract class BaseFragment : Fragment() {

    protected var disposable: CompositeDisposable = CompositeDisposable()
    protected abstract val layoutResource: Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        injectDependencies(App.graph)

        val view = inflater?.inflate(layoutResource, container, false)

        if (view != null)
            return view

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        disposable = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        disposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    abstract fun injectDependencies(applicationComponent: ApplicationComponent)
}