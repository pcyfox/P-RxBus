package com.pcyfox.rxbus

class BusData {

    lateinit var id: String
    lateinit var status: String

    constructor() {}
    constructor(id: String, status: String) {
        this.id = id
        this.status = status
    }
}
