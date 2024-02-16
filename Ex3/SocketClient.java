package Ex3;

import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);
// .............................................................
System.out.print("Nom du serveur : ");
host = keyb.next();
System.out.print("Port du serveur : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le second paramètre n'est pas un entier.");
System.exit(-1);
}
// .............................................................
try {

    Personne adem=new Personne(15,"yassine");
// .............................................................
InetAddress adr = InetAddress.getByName(host);
// .............................................................
Socket socket = new Socket(adr, port);
// .............................................................
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// .............................................................
output.writeObject(adem);
// .............................................................
int id = (int) input.readObject();
System.out.println(" ID : " + id);
socket.close();
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
keyb.close();
}
}