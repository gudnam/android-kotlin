package io.gudnam.kotlin_retrofit.ui.screen.auth

import android.support.annotation.VisibleForTesting
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.gudnam.kotlin_retrofit.R
import io.gudnam.kotlin_retrofit.data.api.APIService
import io.gudnam.kotlin_retrofit.di.ApplicationComponent
import io.gudnam.kotlin_retrofit.di.subcomponent.auth.PhoneNumberFragmentModule
import io.gudnam.kotlin_retrofit.ui.base.BaseFragment
import io.gudnam.kotlin_retrofit.ui.presenter.PhoneNumberPresenter
import io.gudnam.kotlin_retrofit.ui.view.PhoneNumberView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_phone_number.*
import javax.inject.Inject

/**
 * Created by gudnam on 2017. 4. 27..
 */
class PhoneNumberFragment : BaseFragment(), PhoneNumberView {

    override val layoutResource = R.layout.fragment_phone_number

    @Inject @VisibleForTesting
    lateinit var presenter: PhoneNumberPresenter

    @Inject
    lateinit var apiService: APIService

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(PhoneNumberFragmentModule(this)).injectTo(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
        subscribe(Observable.merge(createPhoneNumberTextChangeObservable(), createNextButtonClickObservable()))
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    fun createPhoneNumberTextChangeObservable(): Observable<String> {
        var textChangeObservable: Observable<String> = Observable.create { emitter ->

            var watcher = object : TextWatcher {

                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emitter.onNext(p0.toString())
                }

            }

            et_phone_number.addTextChangedListener(watcher)

            emitter.setCancellable {
                et_phone_number.removeTextChangedListener(watcher)
            }
        }

        return textChangeObservable
    }

    fun createNextButtonClickObservable(): Observable<String> {
        return Observable.create { emitter ->

            btn_next.setOnClickListener(View.OnClickListener {
                presenter.onNextButtonClicked(et_phone_number.text.toString())
                emitter.onNext(et_phone_number.text.toString())
            })

            emitter.setCancellable {
                btn_next.setOnClickListener(null)
            }
        }
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

    override fun showNextButton() {
        btn_next.visibility = View.VISIBLE
    }

    override fun hideNextButton() {
        btn_next.visibility = View.GONE
    }

    override fun showLastEditedPhoneNumber(text: String) {
        et_phone_number.setText(text)
    }

    override fun nextView() {
        changeFragment(IdentifyFragment())
    }

    override fun showMessage(message: String) {
        toast(message)
    }
}