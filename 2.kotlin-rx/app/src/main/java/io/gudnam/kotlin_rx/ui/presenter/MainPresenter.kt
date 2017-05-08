package io.gudnam.kotlin_rx.ui.presenter

import android.util.Log
import io.gudnam.kotlin_rx.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_rx.ui.view.MainView
import io.reactivex.Observable
import java.util.*

/**
 * Created by gudnam on 2017. 3. 21..
 */
class MainPresenter(
        override val view: MainView,
        val interactor: FindUserInfoInteractor) : Presenter<MainView> {

    fun onCreate() {
        view.hideButton()
        view.hideProgressbar()
    }

    fun onResume(buttonClickObservable: Observable<String>, nameTextChangeObservable: Observable<String>, passwordTextChangeObservable: Observable<String>) {
        view.subscribe(Observable.merge(buttonClickObservable, nameTextChangeObservable, passwordTextChangeObservable))
    }

    fun checkIsValidData(query: String?): List<String>? {

        Log.i("test", "query : " + query)

        var list: ArrayList<String> = ArrayList()
        if (!query.isNullOrEmpty())
            list.add(query!!)
        return list
    }

    fun onNext(results: List<String>?) {
        view.hideProgressbar()
        view.hideButton()
        results?.let {
            for(result in it) {
                Log.i("test", "result : " + result)
                view.showButton()
            }
        }
    }

    fun onComplete() {
    }

    fun onError() {
    }

    fun click() {
        view.showProgressbar()
    }
}