package com.uniquindio.praja20.vo

import android.os.Parcel
import android.os.Parcelable

class Job(): Parcelable {

    var numberJob:String?=null
    var customer:String?=null
    var title:String?=null
    var mul_job:String?=null
    var file:String?=null
    var qty:String?=null
    var pageCount:String?=null
    var cv:String?=null
    var text:String?=null
    var format:String?=null
    var stock:String?=null
    var finisSize:String?=null
    var ink:String?=null
    var binding:String?=null
    var dueDate:String?=null
    var p:String?=null
    var comment:String?=null
    var estado:String?=null
    var nombreMaq:String?=null
    var nombreQa :String?=null
    var hora:String ?=null

    constructor(job: Job):this(){
        numberJob = job.numberJob
        customer = job.customer
        title = job.title
        mul_job = job.mul_job
        file = job.file
        qty = job.qty
        pageCount = job.pageCount
        cv = job.cv
        text = job.text
        format = job.format
        stock = job.stock
        finisSize = job.finisSize
        ink = job.ink
        binding = job.binding
        dueDate = job.dueDate
        p = job.p
        comment = job.comment
        estado = job.estado
        nombreMaq = job.nombreMaq
        nombreQa  = job.nombreQa
        hora = job.hora
    }
    constructor(
        numberJob: String,
        customer: String,
        title: String,
        mul_job: String,
        file: String,
        qty: String,
        pageCount: String,
        cv: String,
        text: String,
        format: String,
        stock: String,
        finisSize: String,
        ink: String,
        binding: String,
        dueDate: String,
        p: String,
        comment: String,
        estado: String,
        nombreMaq:String):this() {
        this.numberJob = numberJob
        this.customer = customer
        this.title = title
        this.mul_job = mul_job
        this.file = file
        this.qty = qty
        this.pageCount = pageCount
        this.cv = cv
        this.text = text
        this.format = format
        this.stock = stock
        this.finisSize = finisSize
        this.ink = ink
        this.binding = binding
        this.dueDate = dueDate
        this.p = p
        this.comment = comment
        this.estado = estado
        this.nombreMaq = nombreMaq
    }
    constructor(parcel: Parcel) : this() {
        numberJob = parcel.readString()
        customer = parcel.readString()
        title = parcel.readString()
        mul_job = parcel.readString()
        file = parcel.readString()
        qty = parcel.readString()
        pageCount = parcel.readString()
        cv = parcel.readString()
        text = parcel.readString()
        format = parcel.readString()
        stock = parcel.readString()
        finisSize = parcel.readString()
        ink = parcel.readString()
        binding = parcel.readString()
        dueDate = parcel.readString()
        p = parcel.readString()
        comment = parcel.readString()
        estado = parcel.readString()
        nombreMaq = parcel.readString()
        nombreQa = parcel.readString()
        hora = parcel.readString()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(numberJob)
        dest?.writeString(customer)
        dest?.writeString(title)
        dest?.writeString(mul_job)
        dest?.writeString(file)
        dest?.writeString(qty)
        dest?.writeString(pageCount)
        dest?.writeString(cv)
        dest?.writeString(text)
        dest?.writeString(format)
        dest?.writeString(stock)
        dest?.writeString(finisSize)
        dest?.writeString(ink)
        dest?.writeString(binding)
        dest?.writeString(dueDate)
        dest?.writeString(p)
        dest?.writeString(comment)
        dest?.writeString(estado)
        dest?.writeString(nombreQa)
        dest?.writeString(nombreMaq)
        dest?.writeString(hora)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Job> {
        override fun createFromParcel(parcel: Parcel): Job {
            return Job(parcel)
        }

        override fun newArray(size: Int): Array<Job?> {
            return arrayOfNulls(size)
        }
    }
}