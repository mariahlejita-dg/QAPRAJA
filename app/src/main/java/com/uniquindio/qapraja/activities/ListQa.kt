package com.uniquindio.qapraja.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uniquindio.praja20.util.QA_PARCEL
import com.uniquindio.praja20.vo.Job
import com.uniquindio.qapraja.R
import com.uniquindio.qapraja.fragments.DetalleListaQa
import com.uniquindio.qapraja.fragments.ListaQafrag

class ListQa : AppCompatActivity(), ListaQafrag.OnQaSeleccionadoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_qa)
    }

    override fun onQaSeleccionado(job: Job) {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleQa)
        if(fragment !=null){
            (fragment as DetalleListaQa).darDetallwe(job)
        }
        val intent2 : Intent = Intent(this, DetalleQa::class.java)
        intent2.putExtra(QA_PARCEL,job)

        startActivity(intent2)
    }
}
