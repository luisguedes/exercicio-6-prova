import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

//import ChatUtil.ChatAula;

public class CadServer {

	public CadServer() throws RemoteException {
		try {
			LocateRegistry.createRegistry(8282);
			Naming.rebind("rmi://localhost:8282/dbcad", new CadProva());
			System.out.println("Rodando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException {
		new CadServer();
	}
}
