package edu.neumont.csc180.rosado.jose;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class PDFGenerator {

	static void createPDFFile(Account acc, String uri) {
		String folderName = "PDF_Files";
		boolean folderExists = new File(folderName).mkdir();
		if(folderExists) {
			System.out.println("PDF Folder Created");
		}
		
		String fileName = acc.getFirstName() + "_" + acc.getLastName();
		
		try (OutputStream os = new FileOutputStream(folderName + "/" + fileName + ".pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri(uri);
            builder.toStream(os);
            builder.run();
		} catch (Exception e) {
			System.out.println("Something broke...");
			e.printStackTrace();
		}
	}
}
