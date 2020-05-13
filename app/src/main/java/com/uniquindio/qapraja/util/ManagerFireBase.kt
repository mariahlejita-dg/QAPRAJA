package com.uniquindio.qapraja.util

import android.util.Log
import com.google.firebase.database.*
import com.uniquindio.praja20.vo.Job

class ManagerFireBase private constructor(){
    private var database: FirebaseDatabase?=null
    private var dataRef: DatabaseReference?=null
    public lateinit var listener:OnActualizarAdaptador

    init{
        database = FirebaseDatabase.getInstance()
        dataRef =database!!.reference

    }
    interface OnActualizarAdaptador {
        fun actualizarAdaptador(job:Job)
        fun actualizarAdaptadorProcess(job:Job)
        fun actualizarAdaptadorFinished(job:Job)
        fun actualizarAdaptadorPaused(job:Job)
    }
    companion object {


        private var instancia: ManagerFireBase? = null
        val managerInstance: ManagerFireBase
            //Definimos una información y retornamos. Permite manejar el Firebase.
            get() {
                if (instancia == null) {
                    instancia = ManagerFireBase()
                }

                return instancia!!
            }
    }


    fun insetarConLLavePaused(job: Job) {
        dataRef!!.child("JOBS_PAUSED").child(job.numberJob!!).setValue(job)
    }
    fun insetarConLLaveFinished(job: Job) {
        dataRef!!.child("JOBS_FINISHED").child(job.numberJob!!).setValue(job)
    }


    fun eliminarJobProcess(id: String?) {
        if (id != null) {
            dataRef!!.child("JOBS_PROCESS").child(id).removeValue()
        }
    }


    fun escucharEventoFireBaseProcess() {
        dataRef!!.child("JOBS_PROCESS").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.v("ManagerFire", "onCancelled")
            }
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                Log.v("ManagerFire", "onChildMoved")
            }
            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
                //val envio:Envio = p0!!.getValue(Envio::class.java)!!
                //envio.nombrePlanta = p0!!.key
                // listener?.actualizarAdaptador(envio)
            }
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                Log.v("ManagerFire", "onChildAdded")
                val job = p0!!.getValue(Job::class.java)!!
                job.numberJob= p0!!.key
                listener.actualizarAdaptadorProcess(job)
            }
            override fun onChildRemoved(p0: DataSnapshot) {
                Log.v("ManagerFire", "onChildRemoved")
            }
        })
    }



}

