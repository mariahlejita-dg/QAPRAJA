package com.uniquindio.qapraja.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.uniquindio.praja20.vo.Job
import com.uniquindio.qapraja.R
import kotlinx.android.synthetic.main.fragment_detalle_lista_qa.*

/**
 * A simple [Fragment] subclass.
 */
class DetalleListaQa : Fragment() {

    var jobDetalle: Job?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_lista_qa, container, false)
    }

    fun darDetallwe(job: Job){
        this.jobDetalle = job
        numJobQa.text = job.numberJob
        jobNameqa.text = job.title
        customerqa.text = job.customer
        mulqa.text = job.mul_job
        qtyqa.text = job.qty
        pageCountqa.text = job.pageCount
        cvqa.text = job.cv
        textqa.text = job.text
        formatqa.text = job.format
        stockqa.text = job.stock
        inkqa.text = job.ink
        finishSizeqa.text = job.finisSize
        bindingqa.text = job.binding
        dueDateqa.text = job.dueDate
        estadoqa.text = job.estado
        commentsqa.text = job.comment
    }
}
