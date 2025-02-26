import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverjuego {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8444);

            Socket socket1 = serverSocket.accept();
            PrintWriter escritorSocket = new PrintWriter(socket1.getOutputStream(), true);
            var lectorSocket = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            escritorSocket.println("Esperando al segundo jugador...");
            Socket socket2 = serverSocket.accept();
            PrintWriter escritorSocket2 = new PrintWriter(socket2.getOutputStream(), true);
            var lectorSocket2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));

            escritorSocket.println("Todo listo, empezando partida");
            escritorSocket2.println("Todo listo, empezando partida");
            boolean turno1 = true;
            boolean turno2 = false;
            boolean fin = false;
            int bala = (int) (Math.random()*6) + 1;
            ArrayList<String> espacios = new ArrayList<>();
            for (int i = 0; i <= 5; i++) {
                espacios.add("[]");
                //System.out.println(espacios.get(i));
            }
            while (!fin) {
                while (turno1) {
                    for (int i = 0; i <= 5; i++) {
                        escritorSocket.print(espacios.get(i) + " ");
                        escritorSocket2.print(espacios.get(i) + " ");
                    }
                    escritorSocket.println();
                    escritorSocket2.println();
                    escritorSocket.println("Es tu turno, elige un número del 1 al 6");
                    escritorSocket2.println("Turno del jugador 1...");

                    var eleccionj1 = lectorSocket.readLine();

                    switch (eleccionj1) {
                        case "1":
                            if (espacios.get(0).equals("[X]")){
                                escritorSocket.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 1){
                                    escritorSocket.println("¡BOOM! ¡Has perdido!");
                                    escritorSocket2.println("¡Has ganado!");
                                    fin = true;
                                    turno2 = false;
                                    turno1 = false;
                                } else {
                                    espacios.set(0,"[X]");
                                    escritorSocket.println("Te salvaste, turno del jugador 2");
                                    escritorSocket2.println("El jugador 1 se ha salvado");
                                    turno2 = true;
                                    turno1 = false;
                                }
                            }
                            break;
                        case "2":
                            if (espacios.get(1).equals("[X]")){
                                escritorSocket.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 2){
                                    escritorSocket.println("¡BOOM! ¡Has perdido!");
                                    escritorSocket2.println("¡Has ganado!");
                                    fin = true;
                                    turno2 = false;
                                    turno1 = false;
                                } else {
                                    espacios.set(1,"[X]");
                                    escritorSocket.println("Te salvaste, turno del jugador 2");
                                    escritorSocket2.println("El jugador 1 se ha salvado");
                                    turno2 = true;
                                    turno1 = false;
                                }
                            }
                            break;
                        case "3":
                            if (espacios.get(2).equals("[X]")){
                                escritorSocket.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 3){
                                    escritorSocket.println("¡BOOM! ¡Has perdido!");
                                    escritorSocket2.println("¡Has ganado!");
                                    fin = true;
                                    turno2 = false;
                                    turno1 = false;
                                } else {
                                    espacios.set(2,"[X]");
                                    escritorSocket.println("Te salvaste, turno del jugador 2");
                                    escritorSocket2.println("El jugador 1 se ha salvado");
                                    turno2 = true;
                                    turno1 = false;
                                }
                            }
                            break;
                        case "4":
                            if (espacios.get(3).equals("[X]")){
                                escritorSocket.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 4){
                                    escritorSocket.println("¡BOOM! ¡Has perdido!");
                                    escritorSocket2.println("¡Has ganado!");
                                    fin = true;
                                    turno2 = false;
                                    turno1 = false;
                                } else {
                                    espacios.set(3,"[X]");
                                    escritorSocket.println("Te salvaste, turno del jugador 2");
                                    escritorSocket2.println("El jugador 1 se ha salvado");
                                    turno2 = true;
                                    turno1 = false;
                                }
                            }
                            break;
                        case "5":
                            if (espacios.get(4).equals("[X]")){
                                escritorSocket.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 5){
                                    escritorSocket.println("¡BOOM! ¡Has perdido!");
                                    escritorSocket2.println("¡Has ganado!");
                                    fin = true;
                                    turno2 = false;
                                    turno1 = false;
                                } else {
                                    espacios.set(4,"[X]");
                                    escritorSocket.println("Te salvaste, turno del jugador 2");
                                    escritorSocket2.println("El jugador 1 se ha salvado");
                                    turno2 = true;
                                    turno1 = false;
                                }
                            }
                            break;
                        case "6":
                            if (espacios.get(5).equals("[X]")){
                                escritorSocket.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 6){
                                    escritorSocket.println("¡BOOM! ¡Has perdido!");
                                    escritorSocket2.println("¡Has ganado!");
                                    fin = true;
                                    turno2 = false;
                                    turno1 = false;
                                } else {
                                    espacios.set(5,"[X]");
                                    escritorSocket.println("Te salvaste, turno del jugador 2");
                                    escritorSocket2.println("El jugador 1 se ha salvado");
                                    turno2 = true;
                                    turno1 = false;
                                }
                            }
                            break;
                    }
                }

                while (turno2) {
                    for (int i = 0; i <= 5; i++) {
                        escritorSocket.print(espacios.get(i) + " ");
                        escritorSocket2.print(espacios.get(i) + " ");
                    }
                    escritorSocket.println();
                    escritorSocket2.println();
                    escritorSocket.println("Turno del jugador 2...");
                    escritorSocket2.println("Es tu turno, elige un número del 1 al 6");

                    var eleccionj2 = lectorSocket2.readLine();

                    switch (eleccionj2) {
                        case "1":
                            if (espacios.get(0).equals("[X]")){
                                escritorSocket2.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 1){
                                    escritorSocket.println("¡Has ganado!");
                                    escritorSocket2.println("¡BOOM! ¡Has perdido!");
                                    fin = true;
                                    turno2=false;
                                } else {
                                    espacios.set(0,"[X]");
                                    escritorSocket.println("El jugador 2 se ha salvado");
                                    escritorSocket2.println("Te salvaste, turno del jugador 1");
                                    turno1 = true;
                                    turno2 = false;
                                }
                            }
                            break;
                        case "2":
                            if (espacios.get(1).equals("[X]")){
                                escritorSocket2.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 2){
                                    escritorSocket.println("¡Has ganado!");
                                    escritorSocket2.println("¡BOOM! ¡Has perdido!");
                                    fin = true;
                                    turno2=false;
                                } else {
                                    espacios.set(1,"[X]");
                                    escritorSocket.println("El jugador 2 se ha salvado");
                                    escritorSocket2.println("Te salvaste, turno del jugador 1");
                                    turno1 = true;
                                    turno2 = false;
                                }
                            }
                            break;
                        case "3":
                            if (espacios.get(2).equals("[X]")){
                                escritorSocket2.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 3){
                                    escritorSocket.println("¡Has ganado!");
                                    escritorSocket2.println("¡BOOM! ¡Has perdido!");
                                    fin = true;
                                    turno2=false;
                                } else {
                                    espacios.set(2,"[X]");
                                    escritorSocket.println("El jugador 2 se ha salvado");
                                    escritorSocket2.println("Te salvaste, turno del jugador 1");
                                    turno1 = true;
                                    turno2 = false;
                                }
                            }
                            break;
                        case "4":
                            if (espacios.get(3).equals("[X]")){
                                escritorSocket2.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 4){
                                    escritorSocket.println("¡Has ganado!");
                                    escritorSocket2.println("¡BOOM! ¡Has perdido!");
                                    fin = true;
                                    turno2=false;
                                } else {
                                    espacios.set(3,"[X]");
                                    escritorSocket.println("El jugador 2 se ha salvado");
                                    escritorSocket2.println("Te salvaste, turno del jugador 1");
                                    turno1 = true;
                                    turno2 = false;
                                }
                            }
                            break;
                        case "5":
                            if (espacios.get(4).equals("[X]")){
                                escritorSocket2.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 5){
                                    escritorSocket.println("¡Has ganado!");
                                    escritorSocket2.println("¡BOOM! ¡Has perdido!");
                                    fin = true;
                                    turno2=false;
                                } else {
                                    espacios.set(4,"[X]");
                                    escritorSocket.println("El jugador 2 se ha salvado");
                                    escritorSocket2.println("Te salvaste, turno del jugador 1");
                                    turno1 = true;
                                    turno2 = false;
                                }
                            }
                            break;
                        case "6":
                            if (espacios.get(5).equals("[X]")){
                                escritorSocket2.println("Esta casilla ya estaba disparada, prueba otra vez");
                            } else {
                                if (bala == 6){
                                    escritorSocket.println("¡Has ganado!");
                                    escritorSocket2.println("¡BOOM! ¡Has perdido!");
                                    fin = true;
                                    turno2=false;
                                } else {
                                    espacios.set(5,"[X]");
                                    escritorSocket.println("El jugador 2 se ha salvado");
                                    escritorSocket2.println("Te salvaste, turno del jugador 1");
                                    turno1 = true;
                                    turno2 = false;
                                }
                            }
                            break;
                    }
                }
            }
            escritorSocket.println("Fin de la partida");
            escritorSocket2.println("Fin de la partida");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
