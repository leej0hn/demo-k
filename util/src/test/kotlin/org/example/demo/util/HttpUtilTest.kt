package org.example.demo.util

class HttpUtilTest {

}
fun main(){
    println("hello")
    val url = "http://10.112.78.34:8082/appliance/code/178120883699815"
    val resp = HttpUtil.get(url)
    println(resp)
}