package com.rumanweb.first_class

fun main(){
    var sum=0;
     for(i in 1 ..100){
         if(i%7==0 && i%8==0){
             sum += i;
         }
     }
    println(sum)
}