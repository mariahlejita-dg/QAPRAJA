package com.uniquindio.qapraja.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uniquindio.praja20.util.QA_PARCEL
import com.uniquindio.praja20.vo.Job
import com.uniquindio.qapraja.R
import com.uniquindio.qapraja.fragments.DetalleListaQa

class DetalleQa : AppCompatActivity() {
    var fragmentoDetalle: DetalleListaQa? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_qa)
        val job: Job = intent.getParcelableExtra<Job>(QA_PARCEL)
        fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleQa) as DetalleListaQa?
        fragmentoDetalle!!.darDetallwe(job)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(fragmentoDetalle!=null){
            fragmentoDetalle!!.onActivityResult(requestCode,resultCode,data)
        }
    }
}
