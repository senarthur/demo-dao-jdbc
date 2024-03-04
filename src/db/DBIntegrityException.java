package db;

public class DBIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Pode ocorrer erro de referência. Ex: Se você tentar deletar um departamento
	// que está vinculado à um vendedor

	public DBIntegrityException(String msg) {
		super(msg);
	}
}
