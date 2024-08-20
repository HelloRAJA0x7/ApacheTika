package com.nt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

/*
 * 1.MetaData Type--> PASS
 * 2.Formatted Text Type--> PASS
 * 3.Plain Text Type
 * 4.Main Content Type
 * 5.Structured Text Type
 * 6.Recursive JSON Type
 */

public class TikaTest 
{
	public static void main(String[] args) 
	{
		try 
		{
			File file = new File("D:\\Sample_Pdf_File.pdf");
			InputStream inputStream = new FileInputStream(file);
			
			Tika tika = new Tika();
			String fileContent = tika.parseToString(file);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("enter the type : ");
			int type = sc.nextInt();
			
			switch(type)
			{
				case 1: // MetaData Type!
					Metadata metaData = new Metadata();
					AutoDetectParser autoDetectParser = new AutoDetectParser();
					BodyContentHandler bodyContentHandler = new BodyContentHandler();
					ParseContext parseContext = new ParseContext();
					
					autoDetectParser.parse(inputStream, bodyContentHandler, metaData, parseContext);
					System.err.println("PDF MetaData Text Type!");
					
					for(String data : metaData.names()) {
						System.out.println(data);
					}
				break;
				case 2: //Formatted Text Type!
					System.out.println("PDF Formatted Text Type!");
					System.err.println(fileContent);
				break;
				case 3: //Plain Text Type!
					
					
			}
			sc.close();
			inputStream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}