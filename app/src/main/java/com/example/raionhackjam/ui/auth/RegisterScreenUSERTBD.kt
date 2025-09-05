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
import androidx.compose.ui.draw.clip
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
import com.example.raionhackjam.ui.poppinsFontFamily
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

fun RegisterScreenUSERTBD(modifier: Modifier = Modifier, navController: NavController) {
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
                //"Selamat Datang" Text
                Text(
                    "Selamat Datang",
                    fontFamily = poppinsFontFamily,
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
                    // Name Text Field
                    Text(
                        "Nama",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier
                        .height(8.dp))
                    var name by remember { mutableStateOf("") }
                    BasicTextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .border(1.dp, black, RoundedCornerShape(16.dp)),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = poppinsFontFamily,
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
                                    painter = painterResource(R.drawable.person_icon),
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

                    // Birth Date Field
                    Text(
                        "Tanggal Lahir",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier
                        .height(8.dp))

                    var bdate by remember { mutableStateOf("") }

                    val calendarState = rememberSheetState()

                    //Calendar Logic
                    CalendarDialog(
                        state = calendarState,
                        config = CalendarConfig(
                            monthSelection = true,
                            yearSelection = true
                        ),
                        selection = CalendarSelection.Date { date ->
                            bdate = date.toString()
                        },
                    )

                    BasicTextField(
                        value = bdate,
                        onValueChange = { bdate = it },
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .border(1.dp,
                                black,
                                RoundedCornerShape(16.dp)
                            ),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = poppinsFontFamily,
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
                                    .clickable (
                                        indication = null,
                                        interactionSource = remember { MutableInteractionSource() }
                                    ){
                                        calendarState.show()

                                    }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.date_icon),
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

                    // Email Text Field
                    Text(
                        "E-Mail",
                        fontFamily = poppinsFontFamily,
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
                            fontFamily = poppinsFontFamily,
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
                        fontFamily = poppinsFontFamily,
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
                            fontFamily = poppinsFontFamily,
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
                        .height(16.dp))

                    Text(
                        "Konfirmasi Kata Sandi",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier
                        .height(8.dp))

                    var passwordConfirmation by remember { mutableStateOf("") }

                    //Password Visibility Logic
                    var passwordConfirmationVisibility by remember { mutableStateOf(false) }
                    val passwordConfirmationVisibilityIcon = if (passwordConfirmationVisibility)
                        painterResource(R.drawable.password_icon)
                    else
                        painterResource(R.drawable.password_hidden_icon)

                    BasicTextField(
                        value = passwordConfirmation,
                        onValueChange = { passwordConfirmation = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .border(1.dp, black, RoundedCornerShape(16.dp)),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = poppinsFontFamily,
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
                        .height(8.dp))

                    var selectedGender by remember { mutableStateOf<String?>(null) }

                    Text(
                        "Jenis Kelamin",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(if (selectedGender == "Laki-Laki") base_blue else Color.White)
                                .clickable { selectedGender = "Laki-Laki" }
                                .border(1.dp, black, RoundedCornerShape(16.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "Laki-Laki",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = if (selectedGender == "Laki-Laki") Color.White else black
                            )
                        }


                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(if (selectedGender == "Perempuan") Color.Magenta else Color.White)
                                .clickable { selectedGender = "Perempuan" }
                                .border(1.dp, black, RoundedCornerShape(16.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "Perempuan",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = if (selectedGender == "Perempuan") Color.White else black
                            )
                        }
                    }

                    Spacer(modifier = Modifier
                        .height(32.dp))


                    //Daftar Button
                    OutlinedButton(
                        onClick = {
                            navController.navigate("roles_screen"){
                                popUpTo("register_screen") { inclusive = true }
                            }
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = base,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            "Selanjutnya",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.White,
                        )
                    }

//                    Spacer(modifier = Modifier
//                        .height(32.dp))




                        //Login Text
                        Row(
                            modifier = Modifier
                                .padding(top = 24.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Text(
                                "Sudah Punya akun? ",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = black
                            )

                            Text("Masuk",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = base_blue,
                                modifier = Modifier
                                    .clickable(
                                        indication = null,
                                        interactionSource = remember { MutableInteractionSource() }
                                    ) { navController.navigate("login_screen"){
                                        popUpTo("register_screen") { inclusive = true }
                                    } }
                            )
                        }
                    }
                }
            }
        }
    }

