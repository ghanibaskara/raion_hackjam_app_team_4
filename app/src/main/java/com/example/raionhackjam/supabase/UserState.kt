package com.example.raionhackjam.supabase

sealed class UserState {
    object Loading: UserState()
    data class success(val message: String): UserState()
    data class Error(val message: String): UserState()
}