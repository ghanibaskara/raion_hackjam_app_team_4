package com.example.raionhackjam

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.raionhackjam.biometrics.BiometricAuthenticationStatus
import com.example.raionhackjam.biometrics.BiometricAuthenticator
import com.example.raionhackjam.geminiAPI.ChatViewModel
import com.example.raionhackjam.ui.ChatPage
import com.example.raionhackjam.ui.auth.AuthScreen
import com.example.raionhackjam.ui.auth.LoginScreenUSERTBD
import com.example.raionhackjam.ui.auth.PilihPeranScreen
import com.example.raionhackjam.ui.auth.RegisterScreenUSERTBD
import com.example.raionhackjam.ui.maincomponent.HomeScreen
import com.example.raionhackjam.ui.poppinsFontFamily
import com.example.raionhackjam.ui.switzerFontFamily
import com.example.raionhackjam.ui.theme.RAIONHACKJAMTheme
import com.example.raionhackjam.ui.theme.base
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("ContextCastToActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash_screen") {
                composable("splash_screen") {
                    SplashScreen(navController)
                }

                composable("onboarding_screen") {
                    OnboardingScreen(navController)

                }
                composable("auth_screen") {
                    AuthScreen(navController = navController)
                }
                composable("register_screen") {
                    RegisterScreenUSERTBD(navController = navController)
                }
                composable("login_screen") {
                    LoginScreenUSERTBD(navController = navController)
                }
                composable("roles_screen") {
                    PilihPeranScreen(navController = navController)
                }
                composable("chat_screen") {
                    ChatPage(viewModel = chatViewModel, navController = navController)
                }
                composable("home_screen") {
                    HomeScreen()
                }
        }
    }

}

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1500L)
        navController.navigate("onboarding_screen") {
            popUpTo("splash_screen") {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier
            .padding()
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.tolonginicon),
            "",
            modifier = Modifier.scale(2.0f)
        )
    }


}

@Composable
fun OnboardingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(), // Padding kiri dan kanan
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 84.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboardingscreenbg),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = R.drawable.auth_screen_vector), // ❗ Ganti dengan nama file gambar Anda
                contentDescription = "Ilustrasi Pekerja",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }

        // Spacer untuk memberi jarak antara gambar dan teks
        Spacer(modifier = Modifier.height(64.dp))

        Text(
            text = "Lorem ipsum splash screen",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = base,
            fontFamily = poppinsFontFamily,

        )

        Spacer(modifier = Modifier.height(8.dp))

        // Bagian Teks Subjudul
        Text(
            text = "Lorem ipsum splash screen",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal
        )

        // Spacer untuk memberi jarak antara teks dan tombol
        Spacer(modifier = Modifier.height(64.dp))

        // Bagian Tombol
        //Second Button
        OutlinedButton(
            onClick = {
                navController.navigate("auth_screen")
            },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = base,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                "Mulai",
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.White,
            )
        }
    }
}
}


