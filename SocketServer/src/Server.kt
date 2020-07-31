import java.io.PrintWriter
import java.net.ServerSocket
import java.util.*
import kotlin.concurrent.thread

class Server(port: Int) {

    fun initServer(port:Int){
        println("initialising the server")
        val server = ServerSocket(port);
        println("server initialised in port:$port")
        while (true){
            println("waiting for client")
            val socket = server.accept();
            println("Client connected: ${socket.inetAddress.hostAddress}")
            val scanner =Scanner(socket.getInputStream());
            val output =PrintWriter(socket.getOutputStream(),true);
            var clientName =  scanner.nextLine()
            var nextLine =""
            while (nextLine !=null && !Objects.equals("exit",nextLine)){
                if(scanner.hasNext()){
                    println(nextLine)
                    nextLine = scanner.nextLine()
                    println("client: "+clientName+" -  "+nextLine)
                    val date = Date()
                    println("Server: "+date);
                    output.println(date)

                }else{
                    nextLine = "exit";
                }
            }
        }
        println("Done with this application ,bye!")

    }

    init {
        initServer(port)
    }


}