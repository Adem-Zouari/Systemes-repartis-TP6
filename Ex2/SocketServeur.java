package Ex2;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);

// Création d'un objet Scanner pour la saisie au clavier.

System.out.print("Port d'écoute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le paramètre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {

//  Création d'une socket serveur qui écoute sur le port spécifié.

ServerSocket serverSocket = new ServerSocket(port);
System.out.println("Le serveur est en attente...");

// Attente de la connexion d'un client.

Socket socket = serverSocket.accept();
System.out.println("Un client est connecté");

// Création des flux de sortie et d'entrée pour communiquer avec le client.

ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());

// Lecture de la voiture et la quantité du carburant à ajouté envoyée par le client.

voiture voit = (voiture) input.readObject();
int c=(int) input.readObject();

// Remplissage du carburant

voit.setCarburant(c);

// Affichage de l'adresse IP et du port du client

System.out.println(" ca vient de : " + socket.getInetAddress() +
":" + socket.getPort());

// Envoi de la voiture au client.

output.writeObject(voit);

serverSocket.close();
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
keyb.close();
}
}