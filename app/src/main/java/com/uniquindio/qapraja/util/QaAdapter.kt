package com.uniquindio.qapraja.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.uniquindio.praja20.vo.Job
import com.uniquindio.qapraja.R
import kotlinx.android.synthetic.main.resumenqa.view.*

class QaAdapter (fragment: Fragment, var ListaQa :ArrayList<Job>): RecyclerView.Adapter<QaAdapter.QaViewHolder>(){
    var listener:OnClicjAdaptadorDeQa
    init {
        listener = fragment as OnClicjAdaptadorDeQa
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): QaAdapter.QaViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.resumenqa,p0,false)

        return QaViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaQa.size
    }

    override fun onBindViewHolder(p0: QaViewHolder, p1: Int) {
        p0.bindEnvio(ListaQa[p1])
    }

    inner class QaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val numberJob : TextView = itemView.txtQa

        init {
            itemView.setOnClickListener(this)
        }
        fun bindEnvio(job: Job){
            numberJob.text = job.numberJob

        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
            Log.d("Job","Elemento $adapterPosition clickeado ${numberJob.text}")
        }
    }
    interface OnClicjAdaptadorDeQa{
        fun onClickPosition(pos :Int)
    }

}