package com.example.moviecounter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp), // <-- aumentamos padding
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer // <-- nuevo color
        ),
        elevation = CardDefaults.cardElevation(8.dp) // <-- aumentamos elevación
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall, // <-- estilo más grande
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}


@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        label = { Text("Search movie") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}


@Composable
fun MovieList(movies: List<String>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(movies) { movie ->
            Text(
                text = movie,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Divider()
        }
    }
}
