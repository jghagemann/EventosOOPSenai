package src.senai;

import java.util.ArrayList;

public class MeuArrayList<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		String retorno = "MeuArrayList [";
		for (Object element : this) {
			retorno += "Elemento [ " + element + " ] ";
		}
		retorno += " ] ";
		return retorno;
	}

}
