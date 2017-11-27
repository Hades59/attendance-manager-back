package dev.attendancemanager.entite;

/**
 * @author Florent Callaou
 * Departement of the user 
 * @see User
 */
public enum Departement {
	
	DSI("DSI"),
	DSI_DEV("DSI/DEV"),
	DSI_INDUS("DSI/INDUS"),
	DSI_INDUS_LINUX("DSI/INDUS/Linux"),
	DSI_INDUS_WINDOWS("DSI/INDUS/Windows"),
	DSI_DEV_PHP("DSI/DEV/PHP"),
	DSI_DEV_JAVA1("DSI/DEV/Java1"),
	DSI_DEV_JAVA2("DSI/DEV/Java2"),
	DSI_INDUS_SOLARIS("DSI/INDUS/Solaris");
	
	/** name : String */
	private String name;

	/**
	 * Constructor
	 * @param name
	 */
	private Departement(String name) {
		this.name = name;
	}

	/** Getter for name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
