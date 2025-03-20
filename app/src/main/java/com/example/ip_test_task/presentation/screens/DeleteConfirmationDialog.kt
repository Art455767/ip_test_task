package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DeleteConfirmationDialog(onDismiss: () -> Unit, onDeleteConfirmed: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Предупреждение",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Удаление товара")
            }

        },
        text = { Text("Вы действительно хотите удалить данный товар?") },
        confirmButton = {
            TextButton(
                onClick = {
                    onDeleteConfirmed()
                    onDismiss()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.Blue
                )
            ) {
                Text("Да")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.Blue
                )
            ) {
                Text("Нет")
            }
        },

        containerColor = Color.White.copy(alpha = 1.2f)
    )
}