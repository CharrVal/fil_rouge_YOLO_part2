package Exception;

import java.util.HashMap;

public class UtilisateurException extends Exception {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> erreurs;

	public UtilisateurException(String message, HashMap<String, String> erreurs) {
		super(message);
		this.erreurs = erreurs;
	}

	public HashMap<String, String> getErreurs() {
		return erreurs;
	}

}
