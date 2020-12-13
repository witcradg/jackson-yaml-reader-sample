package io.witcraft.code_examples.yaml_reader;

import java.util.Arrays;

public class YamlDocument {

	private String name;
	private String description;
	private String birthdate; 
	private String[] targets;
	public String getName() {
		return name;
	}
	
	//Required by Jackson
	public YamlDocument() {}
	
	public YamlDocument(String name, String description, String birthdate, String[] targets) {
		super();
		this.name = name;
		this.description = description;
		this.birthdate = birthdate;
		this.targets = targets;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String[] getTargets() {
		return targets;
	}
	public void setTargets(String[] targets) {
		this.targets = targets;
	}
	@Override
	public String toString() {
		return "YamlDocument [name=" + name + ", description=" + description + ", birthdate=" + birthdate + ", targets="
				+ Arrays.toString(targets) + "]";
	}
}