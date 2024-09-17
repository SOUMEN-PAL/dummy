package com.example.dummy.Farmer.Home

data class TransactionData(
    val name: String?,
    val date: String?,
    val amount: String,
    val type: String

){
    constructor() : this("Banana", "Sept 12, 2024", "₹45", "Credit")

}
