package io.gudnam.kotlin_rx.ui.screen

import android.os.Bundle
import android.widget.TextView
import io.gudnam.kotlin_rx.R
import io.gudnam.kotlin_rx.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_rx.ui.activity.BaseActivity
import io.gudnam.kotlin_rx.ui.presenter.MainPresenter
import io.gudnam.kotlin_rx.ui.view.MainView

/**
 * Created by gudnam on 2017. 3. 23..
 */
class MainActivity : BaseActivity(), MainView {

    override val layoutResource = R.layout.activity_main
    lateinit var presenter: MainPresenter

    val tv_name by lazy { findViewById(R.id.tv_name) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this, FindUserInfoInteractor())
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showUserName(name: String) {
        tv_name.text = name
    }
}