package com.uniquindio.qapraja.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Machine() :Parcelable{
    var nombreMaq:String?=null
    var nombreQa :String?=null
    var hora:String ?=null
    var format:String?=null
    var id:String?=null

    constructor(machine: Machine):this(){

        nombreMaq = machine.nombreMaq
        nombreQa = machine.nombreQa
        hora = machine.hora
        format = machine.format
        id =machine.id
    }

    constructor(nombreMaquina:String,id:String,nombreQa1:String,hora1:String,format1:String):this(){
        nombreMaq = nombreMaquina
        nombreQa =nombreQa1
        hora = hora1
        format = format1
        this.id = id
    }
    constructor(nombreMaquina:String,id:String):this(){
        nombreMaq = nombreMaquina
        this.id = id
    }
    constructor(parcel: Parcel) : this() {
        nombreMaq = parcel.readString()
        nombreQa = parcel.readString()
        format = parcel.readString()
        hora = parcel.readString()
        id = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreMaq)
        parcel.writeString(nombreQa)
        parcel.writeString(format)
        parcel.writeString(hora)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Machine> {
        override fun createFromParcel(parcel: Parcel): Machine {
            return Machine(parcel)
        }

        override fun newArray(size: Int): Array<Machine?> {
            return arrayOfNulls(size)
        }
    }
}