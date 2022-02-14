package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

public class MainActivity : MainActivityViewProtocol() {
    private lateinit var btnProcess: Button
    private lateinit var edtNum1: EditText
    private lateinit var edtNum2: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnProcess = findViewById(R.id.btnProcess)
        edtNum1 = findViewById(R.id.edtNum1)
        edtNum2 = findViewById(R.id.edtNum2)
        presenter?.onCreate(intent)
        presenter?.run {
            // Setup presenter
            setToastProcessButton = {
                it?.let {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                    return@let
                }.also {
                    Toast.makeText(requireContext(), "Please check data again!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnProcess.setOnClickListener {
            presenter?.onClickProcessButton(edtNum1.text.toString(),edtNum2.text.toString())
        }

    }
}