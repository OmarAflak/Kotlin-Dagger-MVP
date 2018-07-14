package me.aflak.loginexample

interface LoginInteractor{
    fun signIn(username: String, password: String, listener: OnSignInListener)

    interface OnSignInListener{
        fun onSuccess()
        fun onUsernameError(error: String)
        fun onPasswordError(error: String)
    }
}
