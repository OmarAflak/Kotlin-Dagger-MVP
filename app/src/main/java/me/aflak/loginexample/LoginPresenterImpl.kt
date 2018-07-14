package me.aflak.loginexample

class LoginPresenterImpl(private val view: LoginView, private val interactor: LoginInteractor) : LoginPresenter{
    override fun onCreate() {
        view.showProgress(false)
    }

    override fun signIn(username: String, password: String) {
        view.showProgress(true)
        interactor.signIn(username, password, object : LoginInteractor.OnSignInListener{
            override fun onSuccess() {
                view.showProgress(false)
                view.showToast("Connected !")
            }

            override fun onUsernameError(error: String) {
                view.showProgress(false)
                view.showUsernameError(error)
                view.resetUsername()
                view.resetPassword()
            }

            override fun onPasswordError(error: String) {
                view.showProgress(false)
                view.showPasswordError(error)
                view.resetUsername()
                view.resetPassword()
            }
        })
    }
}
