package com.apptikar.easy.peresentation

import android.nfc.Tag
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.WindowLayoutInfo
import com.apptikar.easy.peresentation.navigation.EasyNavGraph
import com.apptikar.dribbox.utils.ScreenInfo
import com.apptikar.easy.common.theme.EasyTheme
import kotlinx.coroutines.flow.StateFlow

@Composable
fun EasyModal(
    devicePosture: StateFlow<WindowLayoutInfo>,
    windowSizeDp: DpSize,
    tag: Tag?,
) {
    val devicePostureValue by devicePosture.collectAsState()

    EasyTheme {
        val screenClassifier = ScreenInfo().screenClassifier(windowDpSize =windowSizeDp, devicePosture = devicePostureValue)
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                scaffoldState = scaffoldState,
            ){paddingValues ->

                Row(Modifier.fillMaxSize()) {
                    EasyNavGraph(screenClassifier = screenClassifier, navController = navController , modifier = Modifier.padding(paddingValues),scaffoldState,tag)

                }

            }
        }
    }

}