package id.raihan.todokmp.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import id.raihan.todokmp.domain.RequestState
import id.raihan.todokmp.domain.TodoTask
import androidx.compose.runtime.*
import androidx.compose.ui.semantics.Role.Companion.Button
import id.raihan.todokmp.presentation.components.LoadingScreen


class HomeScreen  : Screen {


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = { Text("Home") })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    shape = RoundedCornerShape(size = 12.dp)
                ){
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon"
                    )
                }
            }
        ){ padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
                    .padding(top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding())
            ){

            }
        }
    }

    @Composable
    fun DisplayTasks(
        modifier: Modifier = Modifier,
        tasks : RequestState<List<TodoTask>>,
        showActive : Boolean = true,
        onSelect : ((TodoTask) -> Unit )? = null,
        onFavorite : ((TodoTask, Boolean) -> Unit )? = null,
        onComplete : ((TodoTask, Boolean) -> Unit ),
        onDelete : ((TodoTask) -> Unit )? = null

    ){
        var showDialog by remember { mutableStateOf(false) }
        var taskToDelete  : TodoTask? by remember { mutableStateOf(null) }

        if (showDialog) {
            AlertDialog(
                title = {
                    Text(text = "Delete", fontSize = MaterialTheme.typography.titleLarge.fontSize)
                },
                text = {
                    Text(
                        text = "Are you sure you want to remove '${taskToDelete!!.title}' task?",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                },
                confirmButton = {
                    Button(onClick = {
                        onDelete?.invoke(taskToDelete!!)
                        showDialog = false
                        taskToDelete = null
                    }) {
                        Text(text = "Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            taskToDelete = null
                            showDialog = false
                        }
                    ) {
                        Text(text = "Cancel")
                    }
                },
                onDismissRequest = {
                    taskToDelete = null
                    showDialog = false
                }
            )
        }
    }
}