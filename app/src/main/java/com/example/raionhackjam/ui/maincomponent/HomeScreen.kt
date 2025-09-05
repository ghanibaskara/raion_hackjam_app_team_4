package com.example.raionhackjam.ui.maincomponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.raionhackjam.geminiAPI.ChatViewModel
import com.example.raionhackjam.ui.ChatPage
import com.example.raionhackjam.ui.theme.base

enum class BottomNavItem {
    BERANDA, OBROLAN, RIWAYAT, PROFIL
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val chatViewModel: ChatViewModel = viewModel()
    var selectedItem by remember { mutableStateOf(BottomNavItem.BERANDA) }

    Scaffold(
        bottomBar = {
            HomeBottomNavigation(
                selectedItem = selectedItem,
                onItemSelected = { item ->
                    selectedItem = item
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(paddingValues)
        ) {
            when (selectedItem) {
                BottomNavItem.BERANDA -> BerandaScreen()
                BottomNavItem.OBROLAN -> ChatPage(navController = navController, viewModel = chatViewModel)
                BottomNavItem.RIWAYAT -> RiwayatScreen()
                BottomNavItem.PROFIL -> ProfilScreen()
            }
        }
    }
}

@Composable
fun BerandaScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 160.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(64.dp))
            HelpCard(modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            UserProfileCard(modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            UserProfileCard(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
    HeaderSection()
}

@Composable
fun RiwayatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Halaman Riwayat", fontSize = 20.sp)
    }
}

@Composable
fun ProfilScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Halaman Profil", fontSize = 20.sp)
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
            .height(180.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(base)
                .padding(horizontal = 16.dp, vertical = 64.dp)
        ) {
            Text(
                text = "Halo, Arian",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Lorem ipsum ini apa ya",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp
            )
        }
        SearchBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 28.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text("Apa yang kamu cari?", color = Color.Gray) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(28.dp)),
        shape = RoundedCornerShape(28.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
        )
    )
}

@Composable
fun HelpCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF3F61A2), Color(0xFF4C75C3))
                    )
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = "Butuh bantuan?",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Cari bantuan di.. di mana ya apa namanya",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D285B))
                    ) {
                        Text("Cari pekerjaan", color = Color.White)
                    }
                }
                Box(modifier = Modifier.size(120.dp).background(Color.Gray.copy(alpha = 0.5f)))
            }
        }
    }
}

@Composable
fun UserProfileCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.size(48.dp).clip(CircleShape).background(Color.LightGray))
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Dimas", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("@masdimas", color = Color.Gray, fontSize = 14.sp)
                }
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color(0xFFFFC107)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("4.9", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color.Gray, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Soekarno Hatta, Malang", fontSize = 12.sp, modifier = Modifier.weight(1f))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFFFEB3B).copy(alpha = 0.5f)
                ) {
                    Text(
                        text = "Cekatan",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        color = Color(0xFFC49D04)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Seorang apaan yak ceritanya, aaa iii uuu eee ooo, seorang dua orang tiga orang satu dua tiga empat lima enak tujuh delapan",
                fontSize = 14.sp,
                color = Color.DarkGray,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TagChip(icon = Icons.AutoMirrored.Filled.Send, text = "Kurir")
                TagChip(icon = Icons.Default.Star, text = "Cepat")
                TagChip(icon = Icons.Default.Star, text = "Penjaga")
            }
        }
    }
}

@Composable
fun TagChip(icon: ImageVector, text: String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFE8EAF6),
        contentColor = Color(0xFF3F51B5)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = text, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(text, fontSize = 12.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun HomeBottomNavigation(
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.BERANDA to Icons.Default.Home,
        BottomNavItem.OBROLAN to Icons.Default.MailOutline,
        BottomNavItem.RIWAYAT to Icons.Default.DateRange,
        BottomNavItem.PROFIL to Icons.Default.Person
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        items.forEach { (item, icon) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = selectedItem == item,
                onClick = { onItemSelected(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF0D285B),
                    selectedTextColor = Color(0xFF0D285B),
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFFE8EAF6)
                )
            )
        }
    }
}