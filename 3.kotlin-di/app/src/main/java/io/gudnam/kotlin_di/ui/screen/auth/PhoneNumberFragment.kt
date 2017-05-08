package io.gudnam.kotlin_di.ui.screen.auth

import android.support.annotation.VisibleForTesting
import io.gudnam.kotlin_di.R
import io.gudnam.kotlin_di.di.ApplicationComponent
import io.gudnam.kotlin_di.di.subcomponent.auth.PhoneNumberFragmentModule
import io.gudnam.kotlin_di.ui.base.BaseFragment
import io.gudnam.kotlin_di.ui.presenter.PhoneNumberPresenter
import io.gudnam.kotlin_di.ui.view.PhoneNumberView
import kotlinx.android.synthetic.main.fragment_phone_number.*
import javax.inject.Inject

/**
 * Created by gudnam on 2017. 4. 27..
 */
class PhoneNumberFragment : BaseFragment(), PhoneNumberView {

    override val layoutResource = R.layout.fragment_phone_number

    @Inject @VisibleForTesting
    lateinit var presenter: PhoneNumberPresenter

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(PhoneNumberFragmentModule(this)).injectTo(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showLastEditedPhoneNumber(text: String) {
        et_phone_number.setText(text)
    }

}