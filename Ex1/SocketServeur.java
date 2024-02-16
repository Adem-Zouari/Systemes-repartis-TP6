import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);
// .............................................................
System.out.print("Port d'écoute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le paramètre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {
// .............................................................
ServerSocket serverSocket = new ServerSocket(port);
System.out.println("Le serveur est en attente...");
// ..........................................................

Socket socket = serverSocket.accept();
System.out.println("Un client est connecté");
// ..........................................................
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// ..........................................................
String chaine = (String) input.readObject();
System.out.println(" recu : " + chaine);
// ..........................................................
System.out.println(" ca vient de : " + socket.getInetAddress() +
":" + socket.getPort());
// ..........................................................
output.writeObject(new String("bien recu"));
serverSocket.close();
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
keyb.close();
}
}