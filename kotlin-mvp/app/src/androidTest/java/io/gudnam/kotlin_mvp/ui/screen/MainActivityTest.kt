package io.gudnam.kotlin_mvp.ui.screen

import android.support.test.annotation.UiThreadTest
import android.test.ActivityInstrumentationTestCase2
import android.view.View
import android.widget.TextView
import io.gudnam.kotlin_mvp.ui.presenter.MainPresenter
import org.mockito.Mockito

/**
 * Created by gudnam on 2017. 3. 23..
 */
class MainActivityTest : ActivityInstrumentationTestCase2<MainActivity>(MainActivity::class.java) {

    lateinit var presenter: MainPresenter
    lateinit var mainView: View
    lateinit var mainActivity: MainActivity
    lateinit var tv_name: TextView


    override fun setUp() {
        super.setUp()

        presenter = Mockito.mock(MainPresenter::class.java)
        mainActivity = activity
        tv_name = activity.tv_name
    }

    @UiThreadTest
    fun testShowName() {
        val name = "gudnam"
        mainActivity.showUserName(name)
        assertEquals(name, tv_name.text)
    }
}