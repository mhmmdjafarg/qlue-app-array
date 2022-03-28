package com.pbd.techtestqlue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.pbd.techtestqlue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val utils: Utils = Utils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner: Spinner = binding.mode
        ArrayAdapter.createFromResource(
            this,
            R.array.calculate_mode,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val resources = getResources().getStringArray(R.array.calculate_mode)
        binding.btnSubmit.setOnClickListener {
            val inputData = binding.inputData
            val result = binding.result
            if (inputData.length() > 0) {
                var data = try {
                    inputData.text.toString().split(",").map { it.trim(); it.toInt() }
                } catch (e: Exception) {
                    arrayListOf() // set as empty if format invalid
                }

                if (data.isNotEmpty()) {
                    data = when (spinner.selectedItem) {
                        resources[0] -> utils.sortArray(data as ArrayList<Int>)
                        resources[1] -> utils.multiplyArray(data as ArrayList<Int>)
                        resources[2] -> utils.evenOddArray(data as ArrayList<Int>)
                        else -> {
                            data
                        }
                    }
                    result.text = data.toString()
                    setResultVisibility(visible = true)

                } else {
                    inputData.error = "Format invalid"
                    setResultVisibility(visible = false)
                }
            } else {
                inputData.error = "This field is required"
                setResultVisibility(visible = false)
            }
        }
    }

    private fun setResultVisibility(visible: Boolean) {
        val result = binding.result
        val resultTitle = binding.resultTextTitle
        if (visible) {
            result.visibility = View.VISIBLE
            resultTitle.visibility = View.VISIBLE
        } else {
            result.visibility = View.INVISIBLE
            resultTitle.visibility = View.INVISIBLE
        }
    }
}