import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }

    @Override
    public char MinChar(String ch) throws RemoteException {
        char min = 'z';
        int n=ch.length();
        for (int i=0; i<n-1; i++)
            if (ch.charAt(i) < min)
                min = ch.charAt(i);
      return  min;
    }

    @Override
    public StringBuffer CaseChanger(String str1) throws RemoteException {


        StringBuffer newStr=new StringBuffer(str1);

        for(int i = 0; i < str1.length(); i++) {

            if(Character.isLowerCase(str1.charAt(i))) {
                newStr.setCharAt(i, Character.toUpperCase(str1.charAt(i)));
            }
            else if(Character.isUpperCase(str1.charAt(i))) {
                newStr.setCharAt(i, Character.toLowerCase(str1.charAt(i)));
            }
        }
        return  newStr;
    }


    @Override
    public String Reverse(String ch1) throws RemoteException {

        String  nstr="";
        char ch;
        for (int i=0; i<ch1.length(); i++)
        {
            ch= ch1.charAt(i); //extracts each character
            nstr= ch+nstr; //adds each character in front of the existing string
        }
        return  nstr;
    }
}
