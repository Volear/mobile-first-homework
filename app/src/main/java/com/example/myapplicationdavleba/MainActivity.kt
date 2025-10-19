package com.example.myapplicationdavleba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationdavleba.ui.theme.MyApplicationDavlebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val savings = SavingsAccount("S101", "Saba K.")
        val vip = VIPAccount("V202", "Tiko S.")
        
        savings.deposit(1000.0)
        vip.deposit(1000.0)
        
        savings.withdraw(500.0)
        savings.withdraw(600.0)
        
        vip.withdraw(100.0)
        
        savings.printInfo()
        vip.printInfo()
        
        enableEdgeToEdge()
        setContent {
            MyApplicationDavlebaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationDavlebaTheme {
        Greeting("Android")
    }
}