package io.gudnam.kotlin_retrofit.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.gudnam.kotlin_retrofit.App
import io.gudnam.kotlin_retrofit.R
import io.gudnam.kotlin_retrofit.di.ApplicationComponent
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

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val ft = (context as FragmentActivity).supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit);
        ft.replace(R.id.container, f)
        ft.commit()
    }

    fun clearBackStack() {
        val manager = (context as FragmentActivity).supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    fun toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }
}