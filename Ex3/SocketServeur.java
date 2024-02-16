package Ex3;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SocketServeur {
public static void main(String argv[]) {

//Création d'une map

Map<Integer, Personne> map = new HashMap<>();

// Création des personnes

Personne adem=new Personne(20,"adem");
Personne gauss=new Personne(63,"gauss");
Personne maxwell=new Personne(30,"maxwell");
Personne eisntein=new Personne(60,"eisntein");

//Insertion des personnes dans la map comme des exemples

map.put(0,adem);
map.put(1,gauss);
map.put(2,maxwell);
map.put(3,eisntein);

// Création d'un objet Scanner pour la saisie au clavier.

int port = 0;
Scanner keyb = new Scanner(System.in);
System.out.print("Port d'écoute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le paramètre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {
    while(true){

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

// Lecture d'une personne envoyée par le client.

Personne personne = (Personne) input.readObject();

// Recherche de l'id de la personne dans la map

int id=-1;
boolean found=false;
for(Map.Entry<Integer, Personne> entry : map.entrySet()) {
    
    if(entry!=null){
    id=entry.getKey();
    if((entry.getValue().Getage()==personne.Getage())&&(entry.getValue().Getnom().equals(personne.Getnom()))){
        output.writeObject(id);
        found=true;
        break;
    }
}
}

// L'ajout de la personne en cas ou la personne n'éxiste pas dans la map

if(!found){
    map.put(id+1,personne);
    output.writeObject(id+1);

}

// Affichage de l'adresse IP et du port du client

System.out.println(" ca vient de : " + socket.getInetAddress() +
":" + socket.getPort());

serverSocket.close();
    }
} catch (Exception e) {
System.err.println("Erreur : " + e);
}

keyb.close();
}
}