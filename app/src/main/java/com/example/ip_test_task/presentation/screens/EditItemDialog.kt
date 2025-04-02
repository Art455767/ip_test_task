package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ip_test_task.R
import com.example.ip_test_task.data.local.entities.Item

@Composable
fun EditItemDialog(
    item: Item,
    onDismiss: () -> Unit,
    onSave: (Item) -> Unit,
) {
    var quantity by remember { mutableIntStateOf(item.amount) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(id = R.string.settings),
                    tint = Color.Gray,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        text = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.item_quantity),
                    fontSize = 22.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { if (quantity > 0) quantity-- },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "-",
                            fontSize = 24.sp,
                            color = colorResource(id = R.color.birch),
                            modifier = Modifier
                                .border(BorderStroke(2.dp, colorResource(id = R.color.birch)), CircleShape)
                                .size(32.dp)
                                .padding(vertical = 2.dp, horizontal = 12.dp)
                        )
                    }

                    Box(modifier = Modifier.height(36.dp)) {
                        Text(
                            text = quantity.toString(),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { quantity++ },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            fontSize = 24.sp,
                            color = colorResource(id = R.color.birch),
                            modifier = Modifier
                                .border(BorderStroke(2.dp, colorResource(id = R.color.birch)), CircleShape)
                                .size(32.dp)
                                .padding(vertical = 2.dp, horizontal = 9.dp)
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onSave(item.copy(amount = quantity))
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(text = stringResource(id = R.string.accept), color = colorResource(id = R.color.birch))
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(text = stringResource(id = R.string.cancel), color = colorResource(id = R.color.birch))
            }
        },
        shape = RoundedCornerShape(36.dp)
    )
}