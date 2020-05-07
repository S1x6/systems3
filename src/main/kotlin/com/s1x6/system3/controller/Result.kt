package com.s1x6.system3.controller

open class Result

data class SuccessResult(var status: String, var body: Any?) : Result()
data class ErrorResult(val status: String, var errorText: String) : Result()

fun wrapSuccess(body: Any? = null): Result = SuccessResult("OK", body)
fun wrapError(errorText: String): Result = ErrorResult("ERROR", errorText)