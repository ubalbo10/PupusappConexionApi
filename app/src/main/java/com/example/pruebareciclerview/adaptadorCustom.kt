package com.example.pruebareciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterList(items:ArrayList<Pupusa>): RecyclerView.Adapter<AdapterList.ViewHolder>() {

    var ListDatos=ArrayList<Pupusa>()

    init {
        this.ListDatos=items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterList.ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListDatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.asignarDatos(ListDatos[position])
        holder.btnMaiz.setOnClickListener {
            var pupusa=ListDatos.get(position)
            pupusa.conMaiz=pupusa.conMaiz+1
            holder.btnMaiz.setText("Maiz:${pupusa.conMaiz}")
        }
        holder.btnArroz.setOnClickListener {
            var pupusa=ListDatos.get(position)
            pupusa.conArroz=pupusa.conArroz+1
            holder.btnArroz.setText("Arroz:${pupusa.conArroz}")
        }

    }

    class ViewHolder(itemView: View /**/) : RecyclerView.ViewHolder(itemView){



        var relleno:TextView = itemView.findViewById<TextView>(R.id.txtrelleno)
        var btnMaiz:Button = itemView.findViewById<Button>(R.id.Maiz)
        var btnArroz:Button = itemView.findViewById<Button>(R.id.Arroz)
        init {
            relleno= itemView.findViewById<TextView>(R.id.txtrelleno)
            btnMaiz= itemView.findViewById<Button>(R.id.Maiz)
            btnArroz= itemView.findViewById<Button>(R.id.Arroz)
        }



        interface Recyclerlistener{
            fun onclickMaiz()
            fun onclickArroz()

        }

        fun asignarDatos(datos: Pupusa) {
            relleno.text=datos.relleno
            btnArroz.text="Arroz"
            btnMaiz.text="Maiz"
        }







    }
}