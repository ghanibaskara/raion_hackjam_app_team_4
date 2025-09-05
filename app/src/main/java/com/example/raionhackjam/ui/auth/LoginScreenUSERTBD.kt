package com.example.raionhackjam.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.raionhackjam.R
import com.example.raionhackjam.ui.poppinsFontFamily
import com.example.raionhackjam.ui.switzerFontFamily
import com.example.raionhackjam.ui.theme.base
import com.example.raionhackjam.ui.theme.base_blue
import com.example.raionhackjam.ui.theme.black
import com.example.raionhackjam.ui.theme.gray
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenUSERTBD(modifier: Modifier = Modifier, navController: NavController) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(base),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //App Title
        Row (
            modifier = Modifier
                .padding(
                    top = 48.dp)
        ){
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
        Card (
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
            )
        ) {
            //Card Layout Using Column
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = 36.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //"Selamat Datang Kembali" Text
                Text(
                    "Selamat Datang Kembali",
                    fontFamily = switzerFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(
                            bottom = 16.dp
                        ),
                    color = black
                )

                //Text Fields Column
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 28.dp
                        ),
                ) {
                    // Email Text Field
                    Text(
                        "E-Mail",
                        fontFamily = switzerFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier
                        .height(8.dp))
                    var email by remember { mutableStateOf("") }
                    BasicTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .border(1.dp, black, RoundedCornerShape(16.dp)),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = switzerFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        ),
                        decorationBox = { innerTextField ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        start = 20.dp
                                    )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.email_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp
                                        )
                                ) {
                                    innerTextField()
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier
                        .height(16.dp))

                    // Password Text Field
                    Text(
                        "Kata Sandi",
                        fontFamily = switzerFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier
                        .height(8.dp))
                    var password by remember { mutableStateOf("") }

                    //Password Visibility Logic
                    var passwordVisibility by remember { mutableStateOf(false) }
                    val passwordVisibilityIcon = if (passwordVisibility)
                        painterResource(R.drawable.password_icon)
                    else
                        painterResource(R.drawable.password_hidden_icon)

                    BasicTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .border(1.dp, black, RoundedCornerShape(16.dp)),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = switzerFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        ),
                        visualTransformation = if (passwordVisibility) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        decorationBox = { innerTextField ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        start = 20.dp
                                    )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.password_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp
                                        )
                                ) {
                                    innerTextField()
                                }

                                IconButton(
                                    onClick = {
                                        passwordVisibility = !passwordVisibility
                                    },
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                ) {
                                    Icon(
                                        painter = passwordVisibilityIcon,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier
                        .height(32.dp))

                    //Masuk Button
                    OutlinedButton(
                        onClick = {},
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = base,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            "Masuk",
                            fontFamily = switzerFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.White,
                        )
                    }

                    Spacer(modifier = Modifier
                        .height(32.dp))

                    //Atau Masuk Dengan FB & Google
                    Column (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        //Text And Divider Row
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = gray,
                                thickness = 1.dp, // Ketebalan garis
                                modifier = Modifier
                                    .weight(0.5f)
                                    .padding(
                                        end = 4.dp
                                    )
                            )

                            Text(
                                "Atau daftar dengan",
                                fontFamily = switzerFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = black
                            )

                            Divider(
                                color = gray,
                                thickness = 1.dp, // Ketebalan garis
                                modifier = Modifier
                                    .weight(0.5f)
                                    .padding(
                                        start = 4.dp
                                    )
                            )
                        }

                        //Facebook and Google Row
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 16.dp
                                ),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.facebook_icon),
                                contentDescription = "fesnuk icon",
                                tint = Color.Unspecified
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            Icon(
                                painter = painterResource(R.drawable.google_icon),
                                contentDescription = "google icon",
                                tint = Color.Unspecified
                            )
                        }

                        //Register Text
                        Row(
                            modifier = Modifier
                                .padding(top = 24.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                "Belum Punya akun? ",
                                fontFamily = switzerFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = black
                            )

                            Text("Daftar",
                                fontFamily = switzerFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = base_blue,
                                modifier = Modifier
                                    .clickable(
                                        indication = null,
                                        interactionSource = remember { MutableInteractionSource() }
                                    ) { navController.navigate("register_screen") {
                                        popUpTo("login_screen") { inclusive = true }
                                    } }
                            )
                        }
                    }
                }
            }
        }
    }
}
