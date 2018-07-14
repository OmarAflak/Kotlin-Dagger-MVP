package me.aflak.loginexample

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(activity: LoginActivity)
}