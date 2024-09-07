package com.example.dummy.viewModels

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummy.User
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.concurrent.TimeUnit

class MainViewModel() : ViewModel(){
    private var _email = mutableStateOf("")
    private var _password = mutableStateOf("")
    private var _phoneNumber = mutableStateOf("")
    private var _otp = mutableStateOf("")
    private var _isVerificationCompleted = mutableStateOf(false)
    private var _signInSucessful = mutableStateOf(false)


    //Firebase setup
    private var _myAuth : FirebaseAuth = Firebase.auth
    private var verificationID = mutableStateOf("")
    lateinit var credential: PhoneAuthCredential
    private var firestore : FirebaseFirestore = Firebase.firestore

    //Exposing the values
    val email = _email
    val password = _password
    val phoneNumber = _phoneNumber
    val otp = _otp
    val isVerificationCompleted = _isVerificationCompleted
    val signInSucessful = _signInSucessful




    // Checking if user is logged in
    suspend fun isUserLoggedIn(): Boolean {
        return try {
            val isLoggedIn = _myAuth.currentUser != null
            if (isLoggedIn) {
                _email.value = _myAuth.currentUser?.email.toString()
                _phoneNumber.value = _myAuth.currentUser?.phoneNumber.toString()
            }
            isLoggedIn
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error checking login status: ${e.message}", e)
            false
        }
    }


    //PhoneNumber Authentication
    fun getPhoneNumber(number : String){
        _phoneNumber.value = number
    }
    fun getOtp(otp : String){
        _otp.value = otp
    }

    fun sendOtp(activity: Activity){
        val number = "+91${_phoneNumber.value}"
        sendVerification(number , activity)

    }

    fun sendVerification(number : String , activity: Activity){
        val options = PhoneAuthOptions
            .newBuilder(_myAuth)
            .setPhoneNumber(number)
            .setTimeout(60L , TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(verificationCallBack)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }


    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        _myAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                _signInSucessful.value = task.isSuccessful
            }
    }

    //callback function
    val verificationCallBack : OnVerificationStateChangedCallbacks = object : OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {

            _isVerificationCompleted.value = true
            signInWithPhoneAuthCredential(credential)

        }

        override fun onVerificationFailed(e: FirebaseException) {
            Log.e("FirebaseVerification", "Verification failed: ${e.message}", e)
        }

        override fun onCodeSent(s: String, p1: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(s, p1)
            verificationID.value = s

        }
    }

    fun verifyOTP(onSuccess: (Boolean) -> Unit) {
        try {
            credential = PhoneAuthProvider.getCredential(verificationID.value, otp.value)
            _myAuth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onSuccess(true)
                    } else {
                        Log.e("MainViewModel", "OTP verification failed: ${task.exception?.message}", task.exception)
                        onSuccess(false)
                    }
                }
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error verifying OTP: ${e.message}", e)
            onSuccess(false)
        }
    }

    //email password authentication
    fun getEmail(email:String){
        _email.value = email
    }
    fun getPassword(password : String){
        _password.value = password
    }

    fun linkPhoneCredential(user1: User, onResult: (Boolean) -> Unit) {
        val user = _myAuth.currentUser

        val credential_email = EmailAuthProvider.getCredential(email.value , password.value)
            user?.linkWithCredential(credential_email)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onResult(true)
                        viewModelScope.launch {
                            SaveUserToFireBase(user = user1)
                        }
                    } else {
                        Log.e(
                            "MainViewModel",
                            "Linking phone credential failed: ${task.exception?.message}",
                            task.exception
                        )
                        onResult(false)
                    }
                }
    }

    private suspend fun SaveUserToFireBase(user: User) {
        try {
            firestore.collection("users").document(user.email).set(user).await()
            Log.d("MainViewModel", "User saved to Firestore")
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error saving user to Firestore: ${e.message}", e)
        }
    }


    fun login(onResult: (Boolean) -> Unit) {
        _myAuth.signInWithEmailAndPassword(email.value, password.value)
            .addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }

    fun signOut(){
        _email.value = ""
        _password.value = ""
        _myAuth.signOut()
    }
}