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

//함수 만들기
//원래 fun Color.Companion.random() : Color 으로 만드려 했는데 뭐가 문제인지 길어짐..
//androidx.compose.ui.graphics.이거 없으면 오류나서 실행이 안됨 왜인지 나중에 알아보자
fun androidx.compose.ui.graphics.Color.Companion.random() : androidx.compose.ui.graphics.Color {
    //Random.nextInt(숫자) ⬅️ 숫자까지의 값 중 랜덤한 숫자 생성
    // 여기선 rgb값을 랜덤하게 만들기 위해 각 변수 생성 후 랜덤 값 넣었다
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    //반드시 return을 해줘야 반환되어 사용 가능!!!
    return Color(red, green, blue)
}

//어플 메인 실행부분
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoNumerGeneratorTheme {

                //데이터
                //상수를 쓴 이유는 변하지 않을 값이기 때문
                val buttonTitle = "로또번호 생성"

                //번호 생성 횟수
//                remember 함수는 코틀린의 코루틴 컨텍스트에서 사용되는 함수입니다.
//                코틀린의 코루틴 컨텍스트는 코루틴이 실행될 때 제공되는 상태 공간입니다.
//                코루틴 컨텍스트 안에서 실행되는 코드는 코루틴이 실행될 때 자동으로 상태를 저장하고 복구할 수 있습니다.
//
//                주어진 코드에서는 generatedCount 변수에 remember 함수가 적용되어 있습니다.
//                이는 코루틴 컨텍스트 안에서 generatedCount 변수의 값을 저장하고 복구할 수 있도록 합니다.
//                mutableStateOf 함수는 코틀린의 코루틴 컨텍스트에서 사용되는 함수로, 지정한 값을 가진 상태 객체를 생성합니다.
//                주어진 코드에서는 0을 지정하여 generatedCount 변수의 초기 값을 0으로 설정합니다.
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

                Surface( //코틀린과 함께 사용되는 Jetpack Compose UI 라이브러리에서 제공하는 컴포넌트
                    //Modifier 속성은 Surface 컴포넌트의 스타일과 레이아웃을 정의하는 속성. 아래에서는 fillMaxSize로 전체 가득채우기
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //전체적인 화면구성에서 열 안에 행으로 구성되기 때문에 Column을 사용하여 열 생성
                    Column(
                        //세로 정렬
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //로또 번들 : 숫자 나오는 동그라미
                        Row(//이 부분이 모양 지정하는 영역
                            //Modifier 속성은 Surface 컴포넌트의 스타일과 레이아웃을 정의하는 속성.
                            Modifier
                                .fillMaxWidth()
                                .padding(all = 10.dp)
                                .padding(vertical = 40.dp),
                            //가로영역 서로 공간두기
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            //아래 @Composable LottoBall에 함수 정의해둠.
                            LottoBall(number01)
                            LottoBall(number02)
                            LottoBall(number03)
                            LottoBall(number04)
                            LottoBall(number05)
                            LottoBall(number06)
                            LottoBall(number07)
                            }
                        //디자인을 위한 공간두기
                        Spacer(modifier = Modifier.height(150.dp))

                        //위에 정의한 generatedCount 변수 넣기
                        Text("생성된 횟수 : $generatedCount", fontSize = 30.sp)

                        //디자인을 위한 공간 두기
                        Spacer(modifier = Modifier.height(30.dp))

                        //로또번호 생성 버튼
                        androidx.compose.material.Button(onClick = {
                            //이 부분이 눌렸을때 실행되는 부분

                            //아래는 이전에 정의한lottoNumberRange(1~45까지의 범위의 랜덤 넘버를 변수에 넣어주는것 )
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
                            //버튼에서 보여지는 부분
                            Text(buttonTitle, fontSize = 30.sp)
                        }
                        }
                    }
                }
            }
        }
    }

//@Composable 어노테이션은 코틀린과 함께 사용되는 Jetpack Compose UI 라이브러리에서 제공하는 어노테이션입니다.
//@Composable 어노테이션은 함수나 프로퍼티에 적용될 수 있습니다.
//@Composable 어노테이션이 적용된 함수는 코드를 실행할 때 UI 요소로 컴파일됩니다.
//그러니까 한마디로 말해서 나중에 쓰려고 따로 빼둔 함수라고 생각하면 될듯
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