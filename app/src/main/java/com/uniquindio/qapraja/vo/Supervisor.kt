package com.uniquindio.qapraja.vo

 open class Supervisor {
    var nameSupervisor: String ?=null
    var id: String?=null
    var email : String?=null

    constructor(nameSupervisor:String,  id: String, email:String){
        this.nameSupervisor = nameSupervisor
        this.id = id
        this.email = email
    }

}