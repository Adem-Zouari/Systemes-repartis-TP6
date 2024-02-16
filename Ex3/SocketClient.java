package Ex3;

import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);

// Création d'un objet Scanner pour la saisie au clavier.

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

// Création d'une personne
System.out.print("Nom : ");
String name=keyb.next();
System.out.print("Age : ");
int age=keyb.nextInt();
Personne adem=new Personne(age,name);
    
// Résolution du nom d'hôte en une adresse IP InetAddress

InetAddress adr = InetAddress.getByName(host);

// Création d'une socket et connexion au serveur.

Socket socket = new Socket(adr, port);

// Création des flux de sortie et d'entrée pour communiquer avec le serveur.

ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());

// Envoi d'une personne au serveur.

output.writeObject(adem);

// Réception de l'ID de la personne.

int id = (int) input.readObject();
System.out.println(" ID : " + id);
socket.close();
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
keyb.close();
}
}