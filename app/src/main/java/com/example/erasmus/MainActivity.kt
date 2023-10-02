package com.example.erasmus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.erasmus.model.Activity
import com.example.erasmus.model.ActivityRepository.activties
import com.example.erasmus.ui.theme.ErasmusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErasmusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ErasmusApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErasmusApp(modifier: Modifier = Modifier) {
        Scaffold(
            topBar = {
                ErasmusTopBar()
            }
        ) { it -> LazyColumn(contentPadding = it) {
            items(activties) {
                ErasmusItem(activity = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErasmusTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun ErasmusItem(activity: Activity, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium),
        end = dimensionResource(R.dimen.padding_small),
        bottom = dimensionResource(R.dimen.padding_small)
    )
        .clip(MaterialTheme.shapes.medium)) {
        Column(modifier = Modifier) {
            Text(
                text = stringResource(activity.nameRes),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(activity.titleRes),
                style = MaterialTheme.typography.displayLarge
            )
            Image(
                painter = painterResource(activity.imageRes),
                contentDescription = stringResource(activity.descriptionRes),
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
            )
            Text(
                text = stringResource(activity.descriptionRes),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview
@Composable
fun ErasmusPreview() {
    ErasmusTheme(darkTheme = false) {
        ErasmusApp()
    }
}

@Preview
@Composable
fun WoofDarkThemePreview() {
    ErasmusTheme(darkTheme = true) {
        ErasmusApp()
    }
}