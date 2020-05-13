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

    fun agregarTrabajo(job : Job):Boolean{
        if (job != null){
            if(job.estado == "PENDING"){
                fireBasa.insetarConLLave(job)
                return true
            }else{
                fireBasa.insetarConLLaveProcess(job)
                return true
            }
        }
        return false
    }

    fun actualizar(job: Job):Boolean{
        if (job != null){
            if(job.estado == "IN PROCESS"){
                fireBasa.insetarConLLaveProcess(job)
                fireBasa.eliminarJob(job!!.numberJob)
                return true
            }
        }
        return false
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
    fun actualizarPaused(job: Job):Boolean{
        if(job != null){
            if(job.estado == "IN PROCESS"){
                fireBasa.insetarConLLaveProcess(job)
                fireBasa.eliminarJobPaused(job.numberJob)
                return true
            }
        }
        return false
    }


}