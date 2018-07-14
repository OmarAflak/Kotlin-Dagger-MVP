package me.aflak.loginexample

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LoginModule(private val view: LoginView) {
    @Provides @Singleton
    fun provideLoginView() : LoginView {
        return view
    }

    @Provides @Singleton
    fun provideLoginInteractor() : LoginInteractor {
        return LoginInteractorImpl()
    }

    @Provides @Singleton
    fun provideLoginPresenter(view: LoginView, interactor: LoginInteractor) : LoginPresenter {
        return LoginPresenterImpl(view, interactor)
    }
}