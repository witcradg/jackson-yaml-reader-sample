package io.witcraft.code_examples.yaml_reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

public class YamlMultiDocumentReaderDemo {

	public static void main(String[] args) {
		List<YamlDocument> documentList = readMultiDocumentFile();
		System.out.print(documentList);
	}

	/**
	 * Read a YAML files containing more than one YAML document
	 * 
	 * @return List<YamlDocument>
	 */
	private static List<YamlDocument> readMultiDocumentFile() {
		List<YamlDocument> documentList = null;
		try {
			YAMLFactory yaml = new YAMLFactory();
			ObjectMapper mapper = new ObjectMapper(yaml);

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			File file = new File(classLoader.getResource("myMultiDocumentFile.yaml").getFile());

			YAMLParser yamlParser = yaml.createParser(file);

			documentList = mapper.readValues(yamlParser, YamlDocument.class).readAll();
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		return documentList;
	}
}
