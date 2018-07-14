package me.aflak.loginexample

interface LoginPresenter{
    fun onCreate()
    fun signIn(username: String, password: String)
}
