import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clientejuego {
    public static void main(String[] args) throws Exception{
        try{
            Socket socket = new Socket( "10.204.221.22",8444);
            Scanner teclado = new Scanner(System.in);
            var writer = new PrintWriter(socket.getOutputStream());

            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                var mensaje = reader.readLine();
                System.out.println(mensaje);

                if (mensaje.contains("elige")) {
                    var mano = teclado.next();
                    writer.println(mano);
                    writer.flush();
                }
            }
        } catch (Exception e){
            System.out.println("Se acabó el juego, desconectando...");
            System.exit(0);
        }
    }
}
