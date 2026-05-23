package com.wipro.ass.entity;

public class Provider {
	private String providerId , provideName,specialty ;
	public Provider(String providerID,String providerName,String specialty) {
		this.provideName=providerName;
		this.providerId=providerID;
		this.specialty=specialty;
	}
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProvideName() {
		return provideName;
	}

	public void setProvideName(String provideName) {
		this.provideName = provideName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
}
