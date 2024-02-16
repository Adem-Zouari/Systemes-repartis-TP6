import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);

// Demande à l'utilisateur les détails du serveur.

System.out.print("Nom du serveur : ");
host = keyb.next();
System.out.print("Port du serveur : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le second paramètre n'est pas un entier.");
System.exit(-1);
}
try {

// Résolution du nom d'hôte en une adresse IP InetAddress

InetAddress adr = InetAddress.getByName(host);

// Création d'une socket et connexion au serveur.

Socket socket = new Socket(adr, port);

// Création des flux de sortie et d'entrée pour communiquer avec le serveur.

ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());

// Envoi de Hello au serveur.

output.writeObject(new String("Hello"));

// Réception d'une chaîne du serveur.

String chaine = (String) input.readObject();
System.out.println(" recu du serveur : " + chaine);
socket.close();
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
keyb.close();
}
}