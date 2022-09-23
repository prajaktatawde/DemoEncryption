package com.example.demoencryption

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoencryption.databinding.ActivityMainBinding
import com.example.demoencryption.utils.AES
import com.example.demoencryption.utils.RSA
import com.example.demoencryption.utils.SHA256


class MainActivity : AppCompatActivity() {

    var user_id = "user123"
    var password = "pass123"
    var concat_user_pass = ""
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtUsername.setText("UserName: " + user_id)
        binding.txtPassword.setText("Password: " + password)

        //rsa start
        val encryptedValue_user_id = RSA.encryptMessage(user_id)
        val encryptedValue_password = RSA.encryptMessage(password)

        binding.txtRsaEncryptUserid.setText("Exncrypted UserId:\n\n" + encryptedValue_user_id)
        binding.txtRsaEncryptPassword.setText("Exncrypted Password:\n\n" + encryptedValue_password)
        //rsa end

        //concatinate username and password
        concat_user_pass = encryptedValue_user_id.plus("#").plus(encryptedValue_password)

        binding.txtEncryptConcate.setText("Encrypted Concate:\n\n" + concat_user_pass)

        //hash concatenated string using SHA256
        val hash_value = SHA256.hash_value(concat_user_pass)
        binding.txtSha.setText("SHA256:\n\n" + hash_value)
        // hash end

        //aes encrypt
        val encryptedString_aes: String = AES.encrypt(hash_value!!)!!

        // Call decryption
        val decryptedString_aes: String = AES.decrypt(encryptedString_aes!!)!!

        binding.txtAesEncryt.setText("AES encrypt:\n\n" + encryptedString_aes)
        binding.txtAesDecrypt.setText("AES decrypt:\n\n" + decryptedString_aes)

    }

}

