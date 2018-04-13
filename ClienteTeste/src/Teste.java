import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {

		String nome = "";
		String cpf = "";
		// nome = JOptionPane.showInputDialog("Entre com seu nome. (Entre com 0 para
		// sair)");
		try {

			while (cpf != null) {
				nome = JOptionPane.showInputDialog(
						"Qual o nome do veterinario que deve ser cadastrado?. (Botão cancelar para os cadastros!)");
				cpf = JOptionPane.showInputDialog("Qual é o CPF do veterinario " + nome + " ?");
				Icad objCad = (Icad) Naming.lookup("rmi://localhost:8282/dbcad");
				Message msg = new Message(nome, cpf);
				objCad.sendMessage(msg);
				System.out.println(returnMessage(objCad.retrieveMessage()));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String returnMessage(List<Message> lst) {

		String valor = "";
		for (Message message : lst) {
			valor += message.getUsuario() + ": " + message.getMensagem() + "\n";
		}
		return valor;
	}
}