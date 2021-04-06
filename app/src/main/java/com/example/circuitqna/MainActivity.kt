package com.example.circuitqna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var txtQ: TextView
    lateinit var etA: EditText
    lateinit var btnSubmit: Button
    lateinit var btnReset: Button
//    lateinit var txtResult: TextView

    lateinit var RlCorrect: RelativeLayout
    lateinit var btnNextQ: Button

    lateinit var RlWrong: RelativeLayout
    lateinit var btnTryAgain: Button

//    arrayListOf<answer_list>(answer_list("asic"),)

    val qnaSet = arrayListOf<model>(
            model("List the reason why have PLDs taken over so much of the market?", arrayListOf<answer_list>(answer_list("cheaper"), answer_list("power"))),
            model("Recall major digital system category?", arrayListOf<answer_list>(answer_list("asic"), answer_list("microprocessor"), answer_list("dsp"))),
            model("Recall the name of programmable technology is used in FPGA devices?", arrayListOf<answer_list>(answer_list("sram"),answer_list("flash"),answer_list("antifuse"))),
            model("Recognize FPLA and explain it.", arrayListOf<answer_list>(answer_list("non memory"), answer_list("array"))),
            model("Identify that GAL16V8 has how many dedicated inputs, special function pins and explain them", arrayListOf<answer_list>(answer_list("16"), answer_list("8"))),
            model("Describe which are a mode of operation of the GAL16V8?", arrayListOf<answer_list>(answer_list("simple"),answer_list("complex"),answer_list("registered"))),
            model("Interpret the status of a tristate output buffer on a MAX7000S family device?", arrayListOf<answer_list>(answer_list("enable"),answer_list("global"), answer_list("macrocell"))),
            model("Explain Fundamentals of functional simulation.", arrayListOf<answer_list>(answer_list("entity"),answer_list("architecture"), answer_list("configuration"), answer_list("package"))),
            model("Explain VHDL.", arrayListOf<answer_list>(answer_list("hardware"),answer_list("automation"), answer_list("signal"))),
            model("Explain variables and attributes in VHDL with example.", arrayListOf<answer_list>(answer_list("package"), answer_list("attribute"), answer_list("signal"))),
            model("Explain sequential statements used in VHDL.", arrayListOf<answer_list>(answer_list("wait"), answer_list("processes"), answer_list("loops"))),
            model("Explain Architectures, types of architectures used in VHDL.", arrayListOf<answer_list>(answer_list("structure"),answer_list("entity"), answer_list("begin")))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtQ = findViewById(R.id.txtQ)
//        txtResult = findViewById(R.id.txtResult)
        etA = findViewById(R.id.etA)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnReset = findViewById(R.id.btnReset)

        RlCorrect = findViewById(R.id.RlCorrect)
        RlCorrect.visibility = View.INVISIBLE
        btnNextQ = findViewById(R.id.btnNextQ)

        RlWrong = findViewById(R.id.RlWrong)
        RlWrong.visibility = View.INVISIBLE
        btnTryAgain = findViewById(R.id.btnTryAgain)
        val ranNo = (0..11).random()

//        for (i in 0..1){
//            println("The Question is: "+qnaSet[i].question)
//
//            for (element in qnaSet[i].answer){
//                println("The keywords are: "+ element.keywords)
//            }
//        }

        txtQ.text = qnaSet[ranNo].question

        btnSubmit.setOnClickListener {

            if(etA.text.toString() != ""){
                var count = false
                val etAnswer:String = etA.text.toString().toLowerCase(Locale.ROOT)

                for (element in qnaSet[ranNo].answer){
                    if(element.keywords in etAnswer){
                        count = true
                        break
                    }
//                println("The keywords are: "+ element.keywords)
                }

                if(count){
//                    txtResult.text = "Success"
                    RlCorrect.visibility = View.VISIBLE
                } else {
//                    txtResult.text = "Failed"
                    RlWrong.visibility = View.VISIBLE
                }
            } else {
                Toast.makeText(this,"Empty Fields", Toast.LENGTH_SHORT).show()
            }
        }

        btnNextQ.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        btnTryAgain.setOnClickListener {
            RlWrong.visibility = View.INVISIBLE
            etA.setText("")
        }

        btnReset.setOnClickListener {
            etA.setText("")
        }
    }
}