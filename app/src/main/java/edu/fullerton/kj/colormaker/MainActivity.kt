package edu.fullerton.kj.colormaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.widget.SwitchCompat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var resetButton: Button
    private lateinit var redSwitch: SwitchCompat
    private lateinit var greenSwitch: SwitchCompat
    private lateinit var blueSwitch: SwitchCompat
    private lateinit var redSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var redEditText: EditText
    private lateinit var greenEditText: EditText
    private lateinit var blueEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectViewPointers()
        resetButtonCallback()
        redSwitchCallback()
        blueSwitchCallback()
        greenSwitchCallback()
        redSeekBarCallback()
        greenSeekBarCallback()
        blueSeekBarCallback()
    }

    private fun connectViewPointers() {
        resetButton = this.findViewById(R.id.reset_button)
        redSwitch = this.findViewById(R.id.red_switch)
        redSeekBar = this.findViewById(R.id.red_seekBar)
        redEditText = this.findViewById(R.id.red_editTextNumberDecimal)
        greenSwitch = this.findViewById(R.id.green_switch)
        greenSeekBar = this.findViewById(R.id.green_seekBar)
        greenEditText = this.findViewById(R.id.green_editTextNumberDecimal)
        blueSwitch = this.findViewById(R.id.blue_switch)
        blueSeekBar = this.findViewById(R.id.blue_seekBar)
        blueEditText = this.findViewById(R.id.blue_editTextNumberDecimal)
    }

    private fun resetButtonCallback() {
        resetButton.setOnClickListener {
            if(redSwitch.isChecked)
                redSwitch.toggle()
            if(greenSwitch.isChecked)
                greenSwitch.toggle()
            if(blueSwitch.isChecked)
                blueSwitch.toggle()
            redSeekBar.progress = 0
            greenSeekBar.progress = 0
            blueSeekBar.progress = 0
            redEditText.setText("")
            greenEditText.setText("")
            blueEditText.setText("")
        }
    }

    private fun redSwitchCallback() {
        redSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                redSeekBar.isEnabled = true
                redEditText.isEnabled = true
            } else {
                redSeekBar.isEnabled = false
                redEditText.isEnabled = false
            }
        }
    }

    private fun greenSwitchCallback() {
        greenSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                greenSeekBar.isEnabled = true
                greenEditText.isEnabled = true
            } else {
                greenSeekBar.isEnabled = false
                greenEditText.isEnabled = false
            }
        }
    }

    private fun blueSwitchCallback() {
        blueSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                blueSeekBar.isEnabled = true
                blueEditText.isEnabled = true
            } else {
                blueSeekBar.isEnabled = false
                blueEditText.isEnabled = false
            }
        }
    }

    var rescaledValue = 0.00392156862
    var newValue: Double = 0.00
    var startNum = 0
    var endNum = 0
    private fun redSeekBarCallback() {
        redSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                newValue = p1*rescaledValue
                val roundOffValue = (newValue * 100.0).roundToInt() / 100.0
                redEditText.setText(roundOffValue.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                startNum = redSeekBar.progress
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                endNum = redSeekBar.progress
            }
        })
    }

    private fun greenSeekBarCallback() {
        greenSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                newValue = p1*rescaledValue
                val roundOffValue = (newValue * 100.0).roundToInt() / 100.0
                greenEditText.setText(roundOffValue.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                startNum = greenSeekBar.progress
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                endNum = greenSeekBar.progress
            }
        })
    }

    private fun blueSeekBarCallback() {
        blueSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                newValue = p1*rescaledValue
                val roundOffValue = (newValue * 100.0).roundToInt() / 100.0
                blueEditText.setText(roundOffValue.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                startNum = blueSeekBar.progress
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                endNum = blueSeekBar.progress
            }
        })
    }
}