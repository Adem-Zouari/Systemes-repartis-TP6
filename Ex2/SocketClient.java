package Ex2;

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

    voiture voit=new voiture("nissan", "qashqai");

// Résolution du nom d'hôte en une adresse IP InetAddress.

InetAddress adr = InetAddress.getByName(host);

// Création d'une socket et connexion au serveur.

Socket socket = new Socket(adr, port);

// Création des flux de sortie et d'entrée pour communiquer avec le serveur.

ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
int c=0;
System.out.print("Quantité du carburant à ajouté : ");
c=keyb.nextInt();

// Envoi de la voiture et quantité du carburant à ajouté au serveur.

output.writeObject(voit);
output.writeObject(c);

// Réception d'une voiture du serveur.

voit=(voiture) input.readObject();
System.out.println("Carburant="+voit.getCarburant());
socket.close();
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
keyb.close();
}
}
