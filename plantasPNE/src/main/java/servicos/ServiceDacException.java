package servicos;

import dao.PersistenciaDacException;

public class ServiceDacException extends Exception {
	public ServiceDacException(String string, PersistenciaDacException e) {
		super();
	}

	public ServiceDacException(String string, Exception e) {
		// TODO Auto-generated constructor stub
	}

	public ServiceDacException(String string) {
		super(string);
	}
}
