package com.example.raionhackjam.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.raionhackjam.R
import com.example.raionhackjam.ui.poppinsFontFamily

// Enum untuk merepresentasikan pilihan peran agar kode lebih aman dan bersih
enum class UserRole {
    JURAGAN,
    KERJOMAN
}

@Composable
fun PilihPeranScreen(navController: NavController) {
    // State untuk menyimpan peran yang sedang dipilih. Awalnya null (tidak ada yang dipilih).
    var selectedRole by remember { mutableStateOf<UserRole?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul Halaman
        Text(
            text = "Pilih Peran",
            fontSize = 24.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 56.dp)
        )

        // Kartu Pilihan "Juragan"
        RoleCard(
            imageRes = R.drawable.juraganicon, // ❗ Ganti dengan gambar Anda
            title = "Juragan",
            subtitle = "Saya membutuhkan tenaga kerja",
            isSelected = selectedRole == UserRole.JURAGAN,
            onClick = { selectedRole = UserRole.JURAGAN }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Kartu Pilihan "KerjoMan"
        RoleCard(
            imageRes = R.drawable.kerjoman, // ❗ Ganti dengan gambar Anda
            title = "KerjoMan",
            subtitle = "Saya membutuhkan pekerjaan",
            isSelected = selectedRole == UserRole.KERJOMAN,
            onClick = { selectedRole = UserRole.KERJOMAN }
        )

        // Spacer ini akan mendorong tombol ke bagian bawah layar
        Spacer(modifier = Modifier.weight(1f))

        // Baris untuk Tombol Bawah
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Tombol Kembali
            OutlinedButton(
                onClick = { navController.navigate("register_screen"){
                    popUpTo("roles_screen"){ inclusive = true }
                } },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF2A3A6A)),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp)
            ) {
                Text(text = "Kembali", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            // Tombol Selanjutnya
            Button(
                onClick = { navController.navigate("home_screen") },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2A3A6A)),
                // Tombol akan nonaktif jika tidak ada peran yang dipilih
                enabled = selectedRole != null
            ) {
                Text(text = "Selanjutnya", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}


@Composable
fun RoleCard(
    imageRes: Int,
    title: String,
    subtitle: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    // PERUBAHAN 1: Ganti warna default (else) menjadi biru.
    // Warna saat terpilih bisa tetap terang atau diubah sesuai selera.
    val cardColor = if (isSelected) Color(0xFFE0E8FF) else Color(0xFF4A729F)
    val borderColor = if (isSelected) Color(0xFF2A3A6A) else Color.Transparent
    val textColor = if (isSelected) Color.Black else Color.White

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier
                        .size(160.dp)
                        .padding(end = 16.dp)
                )
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // PERUBAHAN 2: Ubah warna teks menjadi putih
                    Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = textColor)
                    Text(text = subtitle, fontSize = 14.sp, color = textColor) // Sedikit transparan
                }
                RadioButton(
                    selected = isSelected,
                    onClick = onClick,
                    // PERUBAHAN 3: Ubah warna RadioButton agar terlihat di background biru
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.White,
                        unselectedColor = Color.White.copy(alpha = 0.8f)
                    )
                )
            }
        }
    }
}