package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                ThursdayTriviaWeek3()
            }
        }
    }
}

@Composable
fun ThursdayTriviaWeek3(){
    Surface(modifier = Modifier.fillMaxSize(), color=MaterialTheme.colors.background){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            banner()
            Spacer(Modifier.weight(1f))
            Score(0, 4)
            Spacer(Modifier.weight(3f))
            Row(
                verticalAlignment= Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(100.dp)
            ) {
                //player 1
                currentRound("You chose", "Rock")
                //player 2
                currentRound("Android chose", "Paper")
            }
            Spacer(Modifier.weight(3f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ){
                playerButton("Rock")
                playerButton("Paper")
                playerButton("Scissor")
            }
            Spacer(Modifier.weight(1f))
            //hashtag
            Text("#JetPackCompose", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
            Spacer(Modifier.weight(0.5f))
        }
    }
}

@Composable
fun banner() {
    val image: Painter = painterResource(id = R.drawable.gdsc_nsec_rps_banner)
    Image(painter = image,contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth())
}

@Composable
fun Score(currentScore: Int, total: Int){
  Column {
      Text("Score", fontSize= 30.sp)
      Text("$currentScore/$total", fontSize=50.sp, fontWeight = FontWeight.SemiBold)
  }
}

@Composable
fun currentRound(playerName: String, shapeChosen: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(playerName, fontSize = 16.sp)
        Text(shapeChosen, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun playerButton(shape: String){
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(160,32,240, 255)),
                shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(height = 90.dp, width = 90.dp),
    ) {

        Text(shape, fontSize = 15.sp, color = Color.White)
    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        ThursdayTriviaWeek3()
    }
}