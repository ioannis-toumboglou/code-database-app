package com.toumb.controller;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class SystemPath {
	public static String path() {
		// Define the path in which the code files are stored
		Path tempPath = FileSystems.getDefault().getPath("").toAbsolutePath();
    	String path = tempPath + "\\WebContent\\resources\\code-files\\";

    	return path;
     }

}