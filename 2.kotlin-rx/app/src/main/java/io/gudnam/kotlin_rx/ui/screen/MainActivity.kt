package io.gudnam.kotlin_rx.ui.screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.gudnam.kotlin_rx.R
import io.gudnam.kotlin_rx.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_rx.ui.activity.BaseActivity
import io.gudnam.kotlin_rx.ui.presenter.MainPresenter
import io.gudnam.kotlin_rx.ui.view.MainView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by gudnam on 2017. 3. 23..
 */
class MainActivity : BaseActivity(), MainView {

    override val layoutResource = R.layout.activity_main
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this, FindUserInfoInteractor())
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(createButtonClickObservable(), createNameTextChangeObservable(), createPasswordTextChangeObservable())
    }

    override fun subscribe(observable: Observable<String>) {
        disposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { query -> presenter.checkIsValidData(query) }
                .subscribe(
                        { result ->
                            presenter.onNext(result)
                        },
                        { e ->
                            presenter.onError()
                        },
                        {
                            presenter.onComplete()
                        }
                )
        )
    }

    override fun showProgressbar() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        pb_loading.visibility = View.GONE
    }

    override fun showButton() {
        btn_confirm.visibility = View.VISIBLE
    }

    override fun hideButton() {
        btn_confirm.visibility = View.GONE
    }

    override fun createButtonClickObservable(): Observable<String> {
        return Observable.create { emitter ->

            btn_confirm.setOnClickListener(View.OnClickListener {
                presenter.click()
                emitter.onNext(et_name.text.toString())
            })

            emitter.setCancellable {
                btn_confirm.setOnClickListener(null)
            }
        }
    }

    fun createNameTextChangeObservable(): Observable<String> {
        var nameTextChangeObservable: Observable<String> = Observable.create { emitter ->

            var watcher = object : TextWatcher {

                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emitter.onNext(p0.toString())
                }

            }

            et_name.addTextChangedListener(watcher)

            emitter.setCancellable {
                et_name.removeTextChangedListener(watcher)
            }
        }

        return nameTextChangeObservable
    }

    fun createPasswordTextChangeObservable(): Observable<String> {
        var passwordTextChangeObservable: Observable<String> = Observable.create { emitter ->

            var watcher = object : TextWatcher {

                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emitter.onNext(p0.toString())
                }

            }

            et_password.addTextChangedListener(watcher)

            emitter.setCancellable {
                et_password.removeTextChangedListener(watcher)
            }
        }

        return passwordTextChangeObservable
    }
}