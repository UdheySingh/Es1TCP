import java.io.*;
import java.net.*;

public class Client {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket socket;
    BufferedReader tastiera;
    String StringUser;
    String StringReply;
    DataInputStream in;
    DataOutputStream out;   

    protected Socket connetti() throws IOException
    {
        try{
            tastiera = new BufferedReader( new InputStreamReader(System.in));
            socket = new Socket(nomeServer, portaServer);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        }catch (UnknownHostException a){
            System.err.println("");
        }catch (Exception e){
            System.out.println("");
            System.exit(1);
        }
        System.out.println(InetAddress.getLocalHost());
        return socket;
    }
    public void comunica(){
        try{
            System.out.println("4 Inserisci stringa da modificare: "+'\n');
            StringUser = tastiera.readLine();
            System.out.println("5 Invio stringa al server e attendo...");
            out.writeBytes(StringUser+'\n');
            StringReply = in.readLine();
            System.out.println("... risposta dal server "+ '\n'+StringReply);
            System.out.println("9 CLI: terminata belaborazione chiusura connessione");
            socket.close();
        }catch (Exception e){
            System.exit(1);
        }
    }
    public static void main( String[] args ) throws IOException
    {
        client client1 = new client();
        client1.connetti();
        client1.comunica();
    }
}