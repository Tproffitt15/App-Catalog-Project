import java.io.Serializable;

public class App implements Serializable {
	private String name; 
	private int appID;
	
	/**
	 * Gets name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets name
	 * @param name name of application
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets app ID number
	 * @return name
	 */
	public int getAppID() {
		return appID;
	}
	
	/**
	 * sets app ID
	 * @param id ID number of application
	 */
	public void setAppID(int id) {
		this.appID = id;
	}

	/**
	 * Returns a string representation of an app
	 */
	public String toString() {
		return "App name: " + name + " , id: " + appID;
	}
	
	/**
	 * Overriden equals method 
	 * returns true if two apps have the same name and id
	 * false otherwise
	 */
	public boolean equals(Object obj) {
		if (obj instanceof App) {
			App other = (App) obj;
			return (name.equals(other.getName()));
		}
		return false;
	}
	
}
