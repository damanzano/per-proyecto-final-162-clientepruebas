package programaciondmi.per.modelo.exceptions;

/**
 * Este excepción se lanza cuando se intenta crear una nota musical y no se pasan los
 * parámetros adecuados.
 * @author damanzano
 *
 */
public class MalaNotaMusicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MalaNotaMusicalException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MalaNotaMusicalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MalaNotaMusicalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MalaNotaMusicalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MalaNotaMusicalException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
