import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("INPUT :  ");
            String name = reader.readLine();
            System.out.println("CaseChanger Service : " + service.CaseChanger(name));
            System.out.println("MinChar Service : " +service.MinChar(name));
            System.out.println("Reverse Service : " +service.Reverse(name));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
