package io.witcraft.code_examples.yaml_reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlSingleDocumentReaderDemo {
	public static void main(String[] args) {
		YamlDocument yamlDocument = readSingleDocumentFile();
		System.out.print(yamlDocument);
	}


	/**
	 * Read a single YAML file containing only one YAML document.
	 * 
	 * @return List<Command>
	 */
	private static YamlDocument readSingleDocumentFile() {
		YamlDocument yamlDocument = null;
		
    	//Jackson ObjectMapper and YAMLFactory
    	ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    	//findAndRegisterModules method so Jackson handles Date properly
    	mapper.findAndRegisterModules();

    	try {
    		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    		//one way
    		File file = new File(classLoader.getResource("mySingleDocumentFile.yaml").getFile());
    		yamlDocument = mapper.readValue(file, YamlDocument.class);

    		//or just get the file directly
    		//yamlDocument = mapper.readValue(new File("src/main/resources/mySingleDocumentFile.yaml"), YamlDocument.class);

		} catch (IOException e) {
	        System.out.println(e);
	        System.exit(1);
		}
		return yamlDocument;
	}
}
