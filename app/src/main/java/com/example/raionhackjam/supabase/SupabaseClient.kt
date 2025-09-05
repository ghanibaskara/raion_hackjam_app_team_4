package com.example.raionhackjam.supabase

import android.content.Context
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object SupabaseClient{
    val client = createSupabaseClient(
        supabaseUrl = "https://polpolyeqpxrxwckhvak.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBvbHBvbHllcXB4cnh3Y2todmFrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTcwODE3NjMsImV4cCI6MjA3MjY1Nzc2M30.PdALcGieCIC6-Bb0LB4bYUlGcIb-VrSVl03oMVdExMU"
    ) {
        install(GoTrue)
    }

}