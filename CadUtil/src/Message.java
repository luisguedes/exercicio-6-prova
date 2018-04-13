import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.proj.controller.CadDB;
import br.com.proj.model.Cad;

public class Message implements Serializable {

	private static final long seriatVersionUID = -2723363051271966964L;

	private String user;
	private String message;

	private static List<Message> lstMessage = new ArrayList<Message>();

	public Message(String user, String message) {
		this.user = user;
		this.message = message;
	}

	public String getUsuario() {
		return user;
	}

	public void setUsuario(String user) {
		this.user = user;
	}

	public String getMensagem() {
		return message;
	}

	public void setMensagem(String message) {
		this.message = message;
	}

	public static List<Message> getLstMessage() {
		return lstMessage;
	}

	public static void setLstMessage(Message msg) {
		lstMessage.add(msg);
		Cad addmsgbd = new Cad();
		addmsgbd.setNome(msg.getUsuario());
		addmsgbd.setTipo(msg.getMensagem());
		new CadDB().insert(addmsgbd);
		if (addmsgbd.getMensagem().equals("!CriarLog")) {
			CriarLogChat();
	}
	}
	public static void CriarLogChat() {
		FileWriter arq;
		try {
			String path = "C:\\ChatLog\\";
			(new File(path)).mkdir();
			
			arq = new FileWriter(path+"ChatLog.txt");
			PrintWriter gravar = new PrintWriter (arq);
			List<Cad> lstChat = new CadDB().selectAll();
			
			for(Cad chat: lstChat) {
				gravar.println(chat.toString());
			}
			arq.close();
		}catch (IOException e) {
			e.getMessage();
		}
	}
	
}

