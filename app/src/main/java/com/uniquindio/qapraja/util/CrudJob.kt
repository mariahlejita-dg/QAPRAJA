package com.uniquindio.qapraja.util

import com.google.firebase.auth.FirebaseAuth
import com.uniquindio.praja20.vo.Job
import java.text.SimpleDateFormat
import java.util.*

class CrudJob {
    var fireBasa: ManagerFireBase
    lateinit var  firebaseAuth: FirebaseAuth
    constructor(){
        fireBasa = ManagerFireBase.managerInstance
    }

    fun actualizarProcess(job: Job):Boolean{
        if(job != null){
            if(job.estado == "PAUSED"){
                fireBasa.insetarConLLavePaused(job)
                fireBasa.eliminarJobProcess(job.numberJob)
                return true
            }else if(job.estado =="FINISHED"){

                firebaseAuth = FirebaseAuth.getInstance()
                var c = Calendar.getInstance()
                var timeFormat = SimpleDateFormat("hh:mm", Locale.US)
                var time = timeFormat.format(c.time)
                job.hora = time.toString()
                fireBasa.insetarConLLaveFinished(job)


                fireBasa.eliminarJobProcess(job.numberJob)
                return true
            }
        }
        return false
    }



}