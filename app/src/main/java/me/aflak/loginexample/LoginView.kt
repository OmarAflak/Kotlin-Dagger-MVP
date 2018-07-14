package me.aflak.loginexample

interface LoginView {
    fun showToast(message: String)
    fun showProgress(enabled: Boolean)
    fun showUsernameError(error: String)
    fun showPasswordError(error: String)
    fun getUsername() : String
    fun resetUsername()
    fun resetPassword()
}
