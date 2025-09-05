package com.example.raionhackjam.supabase

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient

import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.supabaseJson
import kotlinx.coroutines.launch

class SupabaseAuthViewModel : ViewModel() {
        private val _userState = mutableStateOf<UserState>(UserState.Loading)
        val userState: State<UserState> = _userState

        fun signUp(
            userEmail: String,
            userPassword: String,
            context: Context) {
            viewModelScope.launch {
                _userState.value = UserState.Loading
                try {
                    com.example.raionhackjam.supabase.SupabaseClient.client.gotrue.signUpWith(Email) {
                        email = userEmail
                        password = userPassword
                    }
                    saveToken(context)
                    _userState.value = UserState.success("Sign Up Successful")
                } catch (e: Exception) {
                    _userState.value = UserState.Error("Sign Up Failed: ${e.message}")
                }
            }
        }

        private fun saveToken(context: Context){
            viewModelScope.launch {
                val accessToken = com.example.raionhackjam.supabase.SupabaseClient.client.gotrue.currentAccessTokenOrNull() ?: ""
                val sharedPref = SharedPreferenceHelper(context)
                sharedPref.saveStringData("accessToken", accessToken)
            }
        }

    private fun getToken(context: Context): String? {
        val sharedPref = SharedPreferenceHelper(context)
        return sharedPref.getStringData("accessToken")
    }

    fun login(
        context: Context,
        userEmail: String,
        userPassword: String,
    ) {
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                com.example.raionhackjam.supabase.SupabaseClient.client.gotrue.loginWith(Email) {
                    email = userEmail
                    password = userPassword
                }
                saveToken(context)
                _userState.value = UserState.success("Logged in successfully!")
            } catch (e: Exception) {
                _userState.value = UserState.Error("Error : ${e.message}" )
            }

        }
    }

    fun logout(context: Context) {
        val sharedPref = SharedPreferenceHelper(context)
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                com.example.raionhackjam.supabase.SupabaseClient.client.gotrue.logout()
                sharedPref.clearPreferences()
                _userState.value = UserState.success("Logged out successfully!")
            } catch (e: Exception) {
                _userState.value = UserState.Error(e.message ?: "")
            }
        }
    }

    fun isUserLoggedIn(
        context: Context,
    ) {
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                val token = getToken(context)
                if(token.isNullOrEmpty()) {
                    _userState.value = UserState.success("User not logged in!")
                } else {
                    com.example.raionhackjam.supabase.SupabaseClient.client.gotrue.retrieveUser(token)
                    com.example.raionhackjam.supabase.SupabaseClient.client.gotrue.refreshCurrentSession()
                    saveToken(context)
                    _userState.value = UserState.success("User already logged in!")
                }
            } catch (e: RestException) {
                _userState.value = UserState.Error(e.error)
            }
        }
    }
    }