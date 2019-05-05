package com.ntm.model;

public class DeviceWrapper {
	private String name;
	private String ipAddress;
	private String macAddress;

	public DeviceWrapper(String name, String ipAddress, String macAddress) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
		this.macAddress = macAddress;
	}
	
	public DeviceWrapper(String[] deviceProperty) {
		this.name = deviceProperty[0];
		this.ipAddress = deviceProperty[1];
		this.macAddress = deviceProperty[2];
		toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceWrapper [name=").append(name).append(", ipAddress=").append(ipAddress).append(", macAddress=").append(macAddress).append("]");
		return builder.toString();
	}

}
