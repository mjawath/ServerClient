import java.io.BufferedOutputStream
import java.io.DataOutputStream
import java.io.PrintWriter
import java.net.Socket
import java.util.*

fun main(args: Array<String>){

    val doubles = Date().toString();

    println("Hello! i am a Client! myname is : "+doubles);
    val socket = Socket("localhost",8465);
    println("connected to server");

        val outputStream = PrintWriter(BufferedOutputStream(socket.getOutputStream()),true);
        val inputStream = Scanner(System.`in`)
        val serverinput = Scanner(socket.getInputStream())
        outputStream.println(doubles);

        var nextLine =""
    while (nextLine !=null && !"exit".equals(nextLine)){
        nextLine= inputStream.nextLine();
//        println("Client: " +nextLine);
        outputStream.println(nextLine)
        println("server: "+serverinput.nextLine())
        }



}