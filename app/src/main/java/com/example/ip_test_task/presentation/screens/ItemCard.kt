package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ip_test_task.R
import com.example.ip_test_task.data.local.entities.Item
import java.util.Date
import java.util.Locale


@Composable
fun ItemCard(item: Item, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp)
                .background(Color(0xFFF0F0F0))
                .fillMaxWidth()
                .heightIn(min = 138.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 16.dp, start = 12.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onEdit, modifier = Modifier.size(24.dp)) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = stringResource(id = R.string.edit),
                            tint = Color.Blue
                        )
                    }

                    IconButton(onClick = onDelete, modifier = Modifier.padding(end = 8.dp)) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(id = R.string.delete),
                            tint = Color.Red
                        )
                    }
                }
            }

            val meaningfulTags = item.tags.split(",").filter { it.isNotBlank() }
            if (meaningfulTags.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    meaningfulTags.forEach { tag ->
                        Text(
                            text = tag.trim(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(start = 12.dp, top = 4.dp, bottom = 4.dp)
                                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(4.dp))
                                .padding(4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.padding(start = 14.dp, bottom = 0.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.in_stock),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Text(
                        text = "${item.amount}",
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(end = 56.dp, bottom = 0.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.date_added),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Text(
                        text = java.text.SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date(item.time)),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewItemCard() {
    ItemCard(
        item = Item(id = 1, name = "Sample Item", time = System.currentTimeMillis(), tags = "tag1, tag2", amount = 10),
        onEdit = {},
        onDelete = {}
    )
}