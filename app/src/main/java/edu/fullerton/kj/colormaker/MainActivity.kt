package edu.fullerton.kj.colormaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.widget.SwitchCompat

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
}