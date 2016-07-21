/*
 * Copyright 2011-15 Fraunhofer ISE
 *
 * This file is part of jASN1.
 * For more information visit http://www.openmuc.org
 *
 * jASN1 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * jASN1 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with jASN1.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
/**
 Copyright 2006-2011 Abdulla Abdurakhmanov (abdulla@latestbit.com)
 Original sources are available at www.latestbit.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.openmuc.jasn1.compiler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.openmuc.jasn1.compiler.model.AsnModel;
import org.openmuc.jasn1.compiler.model.AsnModule;
import org.openmuc.jasn1.compiler.parser.ASNLexer;
import org.openmuc.jasn1.compiler.parser.ASNParser;

public class Compiler {

	public final static String VERSION = "1.5.0";

	private String outputBaseDir = "./";
	private String basePackageName = "";
	private boolean supportIndefiniteLength = false;
	private String[] inputFiles = null;

	private static void printUsage() {
		System.out.println(
				"SYNOPSIS\n\torg.openmuc.jasn1.compiler.Compiler [-o <output_base_dir>] [-p <package_base_name>] [-il] <asn1_file>...");
		System.out.println(
				"DESCRIPTION\n\tThe compiler reads the ASN.1 definitions from the given files and generates corresponding Java classes that can be used to conveniently encode/decode BER encoded data.");
		System.out.println("OPTIONS");
		System.out.println(
				"\t-o <output_base_dir>\n\t    The base directory for the generated Java classes. The class files will be saved in subfolders of the base directory corresponding to the name of the defined modules.\n");
		System.out.println(
				"\t-p <package_base_name>\n\t    The base package name. Added to this will be a name generated from the module name.\n");
		System.out.println("\t-il\n\t    Add support for decoding indefinite length in generated classes.\n");
		System.out.println("\t<asn1_file>\n\t    ASN.1 file defining one or more modules.\n");
	}

	public static void main(String args[]) throws Exception {

		Compiler compiler = new Compiler();
		compiler.compile(args);
	}

	private void compile(String args[]) throws Exception {

		if (!parseArgs(args)) {
			printUsage();
			System.exit(1);
		}

		System.out.println("Generated code will be saved in: " + outputBaseDir);
		if (supportIndefiniteLength == true) {
			System.out.println("Java classes will support decoding indefinite length.");
		}

		HashMap<String, AsnModule> modulesByName = new HashMap<>();

		for (String inputFile : inputFiles) {
			System.out.println("Parsing file: " + inputFile);
			AsnModel model = getJavaModelFromAsn1File(inputFile);
			modulesByName.putAll(model.modulesByName);
		}

		BerClassWriter classWriter = new BerClassWriter(modulesByName, outputBaseDir, basePackageName,
				supportIndefiniteLength);

		System.out.println("Generating Java classes...");

		classWriter.translate();
		System.out.println("done");
	}

	private AsnModel getJavaModelFromAsn1File(String inputFileName) throws Exception {
		InputStream stream = new FileInputStream(inputFileName);
		ASNLexer lexer = new ASNLexer(stream);
		ASNParser parser = new ASNParser(lexer);

		AsnModel model = new AsnModel();
		parser.module_definitions(model);

		return model;
	}

	private boolean parseArgs(String[] args) {
		if (args.length < 1) {
			return false;
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-o")) {
				i++;
				if (i == args.length) {
					return false;
				}
				outputBaseDir = args[i];
			}
			else if (args[i].equals("-p")) {
				i++;
				if (i == args.length) {
					return false;
				}
				basePackageName = args[i];
			}
			else if (args[i].equals("-il")) {
				supportIndefiniteLength = true;
			}
			else {
				inputFiles = new String[args.length - i];
				for (int j = 0; j < inputFiles.length; j++) {
					if (args[i].startsWith("-")) {
						return false;
					}
					inputFiles[j] = args[i++];
				}
			}
		}

		if (inputFiles == null) {
			return false;
		}
		return true;
	}

}
