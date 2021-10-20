package app.wataso_.watanabe.anzan2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ランダムに数字を生成する
        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        //ランダムに得た数字をテキストに反映する
        number2Text.text= randomNumber1.toString()
        number1Text.text= randomNumber2.toString()

        val randomOperator = Random.nextInt(2)

        var operatorText = ""

        var correctAnswer = 0

        //足し算の場合
        if (randomOperator == 0){
            //テキストを足し算に表記
            operatorText=" + "
            //反映
            signText.text = operatorText
            //結果の書き換え
            correctAnswer = randomNumber1 + randomNumber2
        }
        else{
            operatorText=" - "

            signText.text = operatorText

            correctAnswer = randomNumber1 - randomNumber2

        }

        checkButton.setOnClickListener{

            val yourAnswer = inputText.text.toString()

            if (yourAnswer.isNotEmpty()){

                //不正解、正解を表示する画面に常用を送る変数の設定
                val answerPage = Intent(this,AnswerActivity::class.java)
                //問題を文字列で作る
                val questionText = randomNumber1.toString() + operatorText + randomNumber2.toString() +"="
                //問題をセット
                answerPage.putExtra("question",questionText)
                //入力した数字をセット
                answerPage.putExtra("answer",yourAnswer)

                answerPage.putExtra("correct",correctAnswer.toString())
                //判定を表示する画面を起動
                startActivity(answerPage)

                finish()

            }
        }
    }
}