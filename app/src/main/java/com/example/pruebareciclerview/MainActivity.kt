package com.example.pruebareciclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
  var pupusa:ArrayList<Pupusa>?=null
    private var recyclerView: RecyclerView? = null
    private var adaptador: AdapterList? = null
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       //parte de la conexion con el api services
        ApiService.create().getRellenos().enqueue(object : Callback<RellenoWrapper> {
            override fun onResponse(
                call: Call<RellenoWrapper>,
                response: Response<RellenoWrapper>
            ) {
// Muestra informacion de RellenoWrapper en UI
            }
            override fun onFailure(call: Call<RellenoWrapper>, t:Throwable) {
                TODO("not implemented")
            }
        })
        recyclerView=findViewById(R.id.recyclerId)
        pupusa= ArrayList<Pupusa>()
        pupusa!!.add(Pupusa("Revuelta",0,0))
        pupusa!!.add(Pupusa("Quezo",0,0))
        pupusa!!.add(Pupusa("Frijol con Quezo",0,0))
        pupusa!!.add(Pupusa("chicharon con quezo",0,0))
        pupusa!!.add(Pupusa("quezo con ajo",0,0))
        adaptador=AdapterList(pupusa!!)
        recyclerView!!.adapter=adaptador
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        var btnTotal=findViewById<Button>(R.id.btnTotal)
        var acumulador=0
        btnTotal.setOnClickListener{
//            for (pupusaitem in pupusa!!){
//                acumulador=acumulador+pupusaitem.conArroz+pupusaitem.conMaiz
//
//            }
//            btnTotal.text=acumulador.toString()
            val intentAct=Intent(this,DetalleOrden::class.java)
            intentAct.putExtra("pupusa",pupusa)
            startActivity ( intentAct)
        }





    }
}
