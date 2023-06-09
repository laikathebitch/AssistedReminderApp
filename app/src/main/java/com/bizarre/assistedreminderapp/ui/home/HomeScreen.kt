package com.bizarre.assistedreminderapp.ui.home

import ReminderListView
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel


import com.bizarre.assistedreminderapp.R
import com.bizarre.assistedreminderapp.ui.ProfileImage



import com.bizarre.assistedreminderapp.ui.theme.Typography
import com.bizarre.assistedreminderapp.ui.user.UserState
import com.bizarre.core_domain.entity.User
import java.net.URLDecoder

@Composable
fun HomeScreen(

    user1:String,
    uri1:String,
    navController: NavController,
    viewModel: AppViewModel = hiltViewModel(),

    ) {


    val viewState by viewModel.userState.collectAsState()

    when (viewState) {
        is UserState.Success -> {
            val user = getUser(viewModel)

            val name1 = user1
            val uri1 = uri1//URLDecoder.decode(text1.split("_")[1])?

            Log.d("PRIFILE","URRI:::: " + uri1)
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(

                        onClick = {
                            val updateString = "false"
                            val id = viewModel.reminder.value?.reminderId

                            navController.navigate("reminder/$updateString/$id")
                        },
                        contentColor = Color.Blue,
                        modifier = Modifier.padding(all = 20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                    }
                }
            ) {


               /* Icon(  imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp))*/
                Column {

                    Row(){

                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name),
                                    style = Typography.body1,

                                    color = MaterialTheme.colors.primary,
                                    modifier = Modifier
                                        .padding(start = 4.dp)
                                        .heightIn(24.dp)
                                )


                            },
                            backgroundColor = backgroundColor,

                            actions = {


                                Box(modifier = Modifier
                                    .size(70.dp)
                                    .clickable {
                                        navController.navigate("profile")
                                    }){
                                    ProfileImage(uri1,70)


                                }
                                IconButton(onClick = {

                                    navController.navigate("login")
                                }) {

                                    Icon(Icons.Filled.ExitToApp, null,tint = Color.Black)
                                }

                            }
                        )




                    }



                    Text("Hello $name1}!!!!")
                    ReminderListView(navController,user!!)





                }
            }


        }
        is UserState.Error -> {

        }
        is UserState.Loading -> {

        }
    }



}





private fun getUser(viewModel: AppViewModel): User {
    return viewModel.users.value[0]
}
