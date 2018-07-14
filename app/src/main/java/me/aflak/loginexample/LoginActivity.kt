package me.aflak.loginexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {
    @Inject lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerLoginComponent.builder()
                .loginModule(LoginModule(this))
                .build().inject(this)

        activity_login_connect.setOnClickListener {
            presenter.signIn(activity_login_username.text.toString(), activity_login_password.text.toString())
        }
        presenter.onCreate()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(enabled: Boolean) {
        activity_login_progress.visibility = when(enabled){
            true -> View.VISIBLE
            false -> View.INVISIBLE
        }
    }

    override fun showUsernameError(error: String) {
        activity_login_username.error = error
    }

    override fun showPasswordError(error: String) {
        activity_login_password.error = error
    }

    override fun getUsername(): String {
        return activity_login_username.text.toString()
    }

    override fun resetUsername() {
        activity_login_username.setText("")
    }

    override fun resetPassword() {
        activity_login_password.setText("")
    }
}
