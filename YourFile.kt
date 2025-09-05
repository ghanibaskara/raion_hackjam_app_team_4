// ...existing code...
OutlinedTextField(
    value = text,
    onValueChange = { newText -> /* ...existing code... */ },
    modifier = Modifier
        .fillMaxWidth()
        .height(48.dp), // Set the height to 48.dp
    textStyle = TextStyle(
        fontSize = 16.sp, // Adjust font size to fit within the height
        textAlign = TextAlign.Start // Ensure proper alignment
    ),
    // ...existing code...
)
// ...existing code...
