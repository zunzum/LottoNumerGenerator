package com.zunzum.lottonumergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zunzum.lottonumergenerator.ui.theme.LottoNumerGeneratorTheme
import kotlin.random.Random

//fun main() {
//
//    val lottoNumberRange = (1..45)
//    println(lottoNumberRange.random())
//    println(lottoNumberRange.random())
//    println(lottoNumberRange.random())
//    println(lottoNumberRange.random())
//    println(lottoNumberRange.random())
//    println(lottoNumberRange.random())
//    println(lottoNumberRange.random())
//}

fun androidx.compose.ui.graphics.Color.Companion.random() : androidx.compose.ui.graphics.Color {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color(red, green, blue)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoNumerGeneratorTheme {

                //데이터
                //상수
                val buttonTitle = "로또번호 생성"

                //번호 생성 횟수
                var generatedCount by remember { mutableStateOf(0) }

                var number01 by remember { mutableStateOf(0) }
                var number02 by remember { mutableStateOf(0) }
                var number03 by remember { mutableStateOf(0) }
                var number04 by remember { mutableStateOf(0) }
                var number05 by remember { mutableStateOf(0) }
                var number06 by remember { mutableStateOf(0) }
                var number07 by remember { mutableStateOf(0) }

                //1~45까지 로또 번호
                val lottoNumberRange = (1..45)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        //로또 번들
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(all = 10.dp)
                                .padding(vertical = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            LottoBall(number01)
                            LottoBall(number02)
                            LottoBall(number03)
                            LottoBall(number04)
                            LottoBall(number05)
                            LottoBall(number06)
                            LottoBall(number07)
                            }

                        Spacer(modifier = Modifier.height(150.dp))

                        Text("생성된 횟수 : $generatedCount", fontSize = 30.sp)

                        Spacer(modifier = Modifier.height(30.dp))

                        //로또번호 생성 버튼
                        androidx.compose.material.Button(onClick = {
                            number01 = lottoNumberRange.random()
                            number02 = lottoNumberRange.random()
                            number03 = lottoNumberRange.random()
                            number04 = lottoNumberRange.random()
                            number05 = lottoNumberRange.random()
                            number06 = lottoNumberRange.random()
                            number07 = lottoNumberRange.random()
                            //클릭 횟수 추가
                            generatedCount++
                        }) {
                            Text(buttonTitle, fontSize = 30.sp)
                        }
                        }
                    }
                }
            }
        }
    }


@Composable
fun LottoBall(number : Int) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.random()),
        contentAlignment = Alignment.Center
    ) {
        Text(
            number.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    LottoNumerGeneratorTheme {
        Greeting("Android")
    }
}