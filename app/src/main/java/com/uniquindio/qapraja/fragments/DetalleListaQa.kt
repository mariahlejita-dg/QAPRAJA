package com.uniquindio.qapraja.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

import com.uniquindio.praja20.vo.Job
import com.uniquindio.qapraja.R
import com.uniquindio.qapraja.util.CrudJob
import kotlinx.android.synthetic.main.fragment_detalle_lista_qa.*

/**
 * A simple [Fragment] subclass.
 */
class DetalleListaQa : Fragment() {

    var jobDetalle: Job?=null
    lateinit var button: Button
    lateinit var checkBox: CheckBox
     lateinit var v: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detalle_lista_qa, container, false)
        button = v.findViewById(R.id.btnChange)
        checkBox = v.findViewById(R.id.finishCheckBox)
        actualizar(v)
        return v
    }

    fun darDetallwe(job: Job){
        this.jobDetalle = job
        numberJob_process.text = job.numberJob
        jobName_process.text = job.title
        customer_process.text = job.customer
        mul_process.text = job.mul_job
        qty_process.text = job.qty
        pageCount_process.text = job.pageCount
        cv_process.text = job.cv
        text_process.text = job.text
        format_process.text = job.format
        stock_process.text = job.stock
        ink_process.text = job.ink
        finishSize_process.text = job.finisSize
        binding_process.text = job.binding
        dueDate_process.text = job.dueDate
        estado_process.text = job.estado
        comments_process.text = job.comment
    }
    fun actualizar(view: View){
        button.setOnClickListener(){
            if(checkBox.isChecked){
                jobDetalle!!.estado = "FINISHED"

                var crudJob:CrudJob = CrudJob()
                if(crudJob.actualizarProcess(jobDetalle!!)){
                    Toast.makeText(context,"Exitoso",Toast.LENGTH_LONG)
                }else{
                    Toast.makeText(context,"Fracaso",Toast.LENGTH_LONG)
                }

            }
        }
    }

}
