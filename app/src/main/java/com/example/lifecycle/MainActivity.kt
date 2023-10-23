package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast


fun EditText.isNotEmpty(): Boolean {
    return this.text.toString().isNotEmpty()
}


class MainActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var birthdayEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var agreeCheckBox: CheckBox
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameEditText = findViewById(R.id.textView3)
        lastNameEditText = findViewById(R.id.textView4)
        birthdayEditText = findViewById(R.id.textView7)
        addressEditText = findViewById(R.id.textView9)
        emailEditText = findViewById(R.id.textView11)
        agreeCheckBox = findViewById(R.id.checkBox3)
        registerButton = findViewById(R.id.button)

        registerButton.setOnClickListener {

            if (validateFields()) {

                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validateFields(): Boolean {
        val firstName = firstNameEditText.text.toString().trim()
        val lastName = lastNameEditText.text.toString().trim()
        val birthday = birthdayEditText.text.toString().trim()
        val address = addressEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val agree = agreeCheckBox.isChecked

        // Kiểm tra xem tất cả các trường đã được điền đầy đủ và chấp nhận điều khoản hay không
        return firstName.isNotEmpty() && lastName.isNotEmpty() &&
                birthday.isNotEmpty() && address.isNotEmpty() &&
                email.isNotEmpty() && agree
    }

}