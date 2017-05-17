package io.gudnam.kotlin_retrofit.ui.presenter

import io.gudnam.kotlin_retrofit.domain.interactor.GetAuthNumberInteractor
import io.gudnam.kotlin_retrofit.domain.repository.AuthRepository
import io.gudnam.kotlin_retrofit.ui.entity.mapper.AuthDetailDataMapper
import io.gudnam.kotlin_retrofit.ui.view.PhoneNumberView
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by gudnam on 2017. 3. 24..
 */
@RunWith(MockitoJUnitRunner::class)
class PhoneNumberPresenterTest {

    @Mock
    lateinit var view: PhoneNumberView

    @Mock
    lateinit var authRepository: AuthRepository

    lateinit var authNumberInteractor: GetAuthNumberInteractor
    lateinit var authDetailDataMapper: AuthDetailDataMapper

    lateinit var presenter: PhoneNumberPresenter

    @Before
    fun setUp() {
        authNumberInteractor = GetAuthNumberInteractor(authRepository)
        presenter = PhoneNumberPresenter(view, authNumberInteractor, authDetailDataMapper)
    }

    @Test
    fun shouldReturnTrueWhenValidPhoneNumber() {
        var phoneNumber = "01011112222"
        assertTrue(presenter.checkIsValidData(phoneNumber))
    }

    @Test
    fun shouldReturnFalseWhenPhoneNumberLengthLessThan10() {
        var phoneNumber = "010111122"
        assertFalse(presenter.checkIsValidData(phoneNumber))
    }
}