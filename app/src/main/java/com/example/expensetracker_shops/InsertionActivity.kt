package com.example.expensetracker_shops

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.expensetracker_shops.R.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertionActivity : AppCompatActivity(){
    private lateinit var shopName: EditText
    private lateinit var shopAddress :EditText
    private lateinit var shopMobNo: EditText
    private lateinit var btnSaveData : Button

    private lateinit var dbRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_insertion)

        shopName = findViewById(R.id.shopname)
        shopAddress = findViewById(R.id.shopAddress)
        shopMobNo = findViewById(R.id.shopMobNo)
        btnSaveData = findViewById(R.id.btnSave)

        dbRef = FirebaseDatabase.getInstance().getReference("Shops")

        btnSaveData.setOnClickListener {
            saveShopsData()
        }

    }
    private fun saveShopsData(){
        val sName = shopName.text.toString()
        val sAddress = shopAddress.text.toString()
        val sMob = shopMobNo.text.toString()

        if(sName.isEmpty()){
            shopName.error = "please enter shop name"
        }
        if(sAddress.isEmpty()){
            shopAddress.error = "please enter shop address"
        }
        if(sMob.isEmpty()){
            shopMobNo.error = "please enter shop's contact number"
        }
        val shopId = dbRef.push().key!!
    }

}