package me.aflak.loginexample

import android.os.Handler

class LoginInteractorImpl : LoginInteractor{
    override fun signIn(username: String, password: String, listener: LoginInteractor.OnSignInListener) {
        Handler().postDelayed({
            when {
                username!="omar" -> listener.onUsernameError("incorrect")
                password!="pass" -> listener.onPasswordError("incorrect")
                else -> listener.onSuccess()
            }
        }, 2000)
    }
}
