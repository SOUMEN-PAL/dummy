package com.example.dummy.screens.pages


sealed class Pages(val route : String) {
    data object SignUpPage : Pages("signup_page")
    data object LoginPage : Pages("login_page")
    data object DataPage : Pages("data_page")
    data object OTPPage : Pages("otp_page")
    fun withArgs(vararg args: String):String{
        return buildString {
            append(route)
            args.forEach {arg->
                append("/$arg")
            }
        }
    }
}