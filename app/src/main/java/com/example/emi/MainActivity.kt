package com.example.emi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camer_bttn.setOnClickListener {

            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)


        }


        name_bttn.setOnClickListener {

            val send = name_edit.text.toString()
            val intent = Intent(this, Main3Activity::class.java)
            intent.putExtra("Name", send)
            startActivity(intent)
        }

        val seekP = findViewById<SeekBar>(R.id.seek_p)
        seekP?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


                emi_cal()
            }
        })

        val seekR = findViewById<SeekBar>(R.id.seek_r)
        seekR?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


                emi_cal()
            }
        })


        val seekN = findViewById<SeekBar>(R.id.seek_n)
        seekN?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


                emi_cal()
            }
        })




    }
    fun emi_cal(){
        var n =seek_n.progress.toDouble()
        var p = seek_p.progress.toDouble()
        var r = seek_r.progress.toDouble()

        val top = p*r*Math.pow(1+r,n)
        val bottom = Math.pow(1+r,n-1)
        val solution = top/bottom

        emi.text = solution.toString()
    }


}