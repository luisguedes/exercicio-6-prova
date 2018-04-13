
package br.com.proj.test;

import br.com.proj.controller.CadDB;
import br.com.proj.model.Cad;
import junit.framework.TestCase;

public class Test extends TestCase {

	public void testInsert() {
		Cad chat = new Cad();
		chat.setNome("Teste");
		chat.setTipo("2345");
		//chat.setPorcentcacau(2345);
		
		assertEquals(new CadDB().insert(chat), true);
	}

	public void testUpdate() {
		Cad chat = new Cad();
		chat.setCodigo(2);
		chat.setNome("Luiz Gonzaga");
		chat.setTipo("9633");
		assertEquals(new CadDB().update(chat), true);
	}

	public void testDelete() {
		Cad chat = new Cad();
		chat.setCodigo(2);
		assertEquals(new CadDB().delete(chat), true);
	}

	public void testSelectTo() {
		assertNotNull(new CadDB().selectTo(1));
	}
	
	public void testSelectAll() {
		assertNotNull(new CadDB().selectAll());
	}

}
