package com.example.factsapp.presentation

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.factsapp.presentation.ViewModel.ViewModel

//import androidx.lifecycle.ViewModel

@Composable
fun HomeScreen(
    viewModel: ViewModel = hiltViewModel(),
) {
    val facts by viewModel.facts.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB9E4C9))
            .padding(top = 44.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Facts",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom=16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        facts?.let { FactCard(fact = it) }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.getfacts()
            },
            modifier = Modifier.padding(horizontal=16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF4A6572))
        ) {
        Text(text = "Next")
    }
    }

}

@Preview
@Composable
fun prev(){
    HomeScreen()
}