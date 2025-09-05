package com.example.raionhackjam.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.raionhackjam.R
import com.example.raionhackjam.ui.poppinsFontFamily
import com.example.raionhackjam.ui.poppinsFontFamily
import com.example.raionhackjam.ui.theme.base
import com.example.raionhackjam.ui.theme.base_blue
import com.example.raionhackjam.ui.theme.black

@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(base),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Auth Screen Worker Icon
        Icon(
            modifier = Modifier.padding(
                top = 108.dp,
                start = 16.dp,
                bottom = 32.dp
            ),
            painter = painterResource(
                id = R.drawable.auth_screen_vector
            ),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        //App Title
        Row {
            Text(
                "Tolong",
                color = Color.White,
                fontSize = 36.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(
                    bottom = 48.dp
                )
            )
            Text(
                "In",
                color = Color.White,
                fontSize = 36.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(
                    bottom = 48.dp
                )
            )
        }

        //Card
        Card(
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(
                Color.White
            ),
            shape = RoundedCornerShape(
                48.dp,
                48.dp,
                0.dp,
                0.dp
            ),
        ) {
            //Card Content
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //"Daftar Sebagai" Text
                    Text(
                        "Daftar Sebagai",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = black
                    )

                    //First Button
                    OutlinedButton(
                        onClick = {
                            navController.navigate("register_screen")
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.White,
                        ),
                        border = BorderStroke(2.dp, base),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            "Daftar",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = black,
                        )
                    }

                    //Second Button
                    OutlinedButton(
                        onClick = {
                            navController.navigate("login_screen")
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
                            "Masuk",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.White,
                        )
                    }


                }
            }
        }

    }
}
