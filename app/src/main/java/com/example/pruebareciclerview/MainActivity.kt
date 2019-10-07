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
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
  var pupusa:ArrayList<Pupusa>?=null
    private var recyclerView: RecyclerView? = null
    private var adaptador: AdapterList? = null
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       //parte de la conexion con el api services

            ApiService.create().getRellenos().enqueue(object : retrofit2.Callback<List<Relleno>> {
                override fun onFailure(call: Call<List<Relleno>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<List<Relleno>>,
                    response: Response<List<Relleno>>
                ) {
                    recyclerView=findViewById(R.id.recyclerId)

                    var pupusas=response.body()
                    adaptador=AdapterList(pupusas!!)
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

                    }

                }

            })
        }
       // recyclerView=findViewById(R.id.recyclerId)
//        pupusa= ArrayList<Pupusa>()
//        pupusa!!.add(Pupusa("Revuelta",0,0))
//        pupusa!!.add(Pupusa("Quezo",0,0))
//        pupusa!!.add(Pupusa("Frijol con Quezo",0,0))
//        pupusa!!.add(Pupusa("chicharon con quezo",0,0))
//        pupusa!!.add(Pupusa("quezo con ajo",0,0))
//        adaptador=AdapterList(pupusa!!)
//        recyclerView!!.adapter=adaptador
//        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//        var btnTotal=findViewById<Button>(R.id.btnTotal)
//        var acumulador=0
//        btnTotal.setOnClickListener{
////            for (pupusaitem in pupusa!!){
////                acumulador=acumulador+pupusaitem.conArroz+pupusaitem.conMaiz
////
////            }
////            btnTotal.text=acumulador.toString()
//            val intentAct=Intent(this,DetalleOrden::class.java)
//            intentAct.putExtra("pupusa",pupusa)
//            startActivity ( intentAct)
//        }





    }

