import java.io.Serializable;

public class App implements Serializable {
	private String name; 
	private int appID;
	private String description;
	private String org;
	private String platform;
	private String version;
	private double price;
	private String link;
	
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
	 * Gets app description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets app description
	 * @param description Description of the app
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * gets app organization
	 * @return the org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * sets app organization
	 * @param org the org to set
	 */
	public void setOrg(String org) {
		this.org = org;
	}

	/**
	 * gets app platform
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * sets app platform
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * gets app version
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * sets app version
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * gets app price
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets app price
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * gets app link
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * sets app link
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Returns a string representation of an app
	 */
	public String toString() {
		return "App name: " + name + " , id: " + appID + " , Description: " + description +
				" , Organization: " + org + " , Platform: " + platform + " , Version: " + version +
				" , Link: " + link + " , Price: $" + price;
	}
	
	/**
	 * Overriden equals method 
	 * returns true if two apps have the same name and id
	 * false otherwise
	 */
	public boolean equals(Object obj) {
		if (obj instanceof App) {
			App other = (App) obj;
			return (name.equals(other.getName()) &&
					appID == other.getAppID() &&
					description.equals(other.getDescription())&&
					org.equals(other.getOrg())&&
					platform.equals(other.getPlatform())&&
					version.equals(other.getVersion())&&
					link.equals(other.getLink())&&
					price == other.getPrice());
		}
		return false;
	}
	
}
