package com.uniquindio.qapraja.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.uniquindio.praja20.vo.Job
import com.uniquindio.qapraja.R
import com.uniquindio.qapraja.util.ManagerFireBase
import com.uniquindio.qapraja.util.QaAdapter
import kotlinx.android.synthetic.main.activity_list_qa.*
import kotlinx.android.synthetic.main.fragment_lista_qafrag.*
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class ListaQafrag : Fragment(), QaAdapter.OnClicjAdaptadorDeQa, ManagerFireBase.OnActualizarAdaptador {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_qafrag, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onClickPosition(pos: Int) {
        listener.onQaSeleccionado(listJobs.get(pos))
    }

    override fun actualizarAdaptador(job: Job) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var managerFireBase: ManagerFireBase
    var adaptador: QaAdapter? = null
    var listJobs: ArrayList<Job> = ArrayList()
    private lateinit var listener: OnQaSeleccionadoListener

    override fun actualizarAdaptadorProcess(job: Job) {
        listJobs.add(0,job)
        adaptador!!.notifyItemInserted(0)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adaptador = QaAdapter(this, listJobs)
        listaJobsQa.adapter = adaptador
        listaJobsQa.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        managerFireBase = ManagerFireBase.managerInstance
        managerFireBase.listener = this
        managerFireBase.escucharEventoFireBaseProcess()
    }

    interface OnQaSeleccionadoListener{
        fun onQaSeleccionado(job: Job)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            try {
                listener = context as OnQaSeleccionadoListener
            } catch (e: ClassCastException) {
                throw ClassCastException("${activity.toString()} debe implementar la interfaz OnJobProcessSeleccionadoListener")
            }
        }
    }
    override fun actualizarAdaptadorFinished(job: Job) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun actualizarAdaptadorPaused(job: Job) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
