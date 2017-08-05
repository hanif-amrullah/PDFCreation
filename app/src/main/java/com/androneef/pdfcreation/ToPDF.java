package com.androneef.pdfcreation;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Andronif on 29/07/2017.
 */

public class ToPDF {
    String nm,tmpt,tgl,almt;
    public Boolean create(String fname, String fcontent) {
        try{
            String fpath = "/sdcard/" + fname + ".pdf"; // mau nyimpan di internal apa eksternal + nama file + tipe file
            File file = new File(fpath); // buat file baru

            // jiak file tidak ada buatr file baru
            if(!file.exists()){
                file.createNewFile();
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile()));
            // buka dokument dulu sebelum operasi (nulis)
            document.open();

            document.add(new Paragraph("Nama : " + nm));
            document.add(new Paragraph("Tempat : " + tmpt));
            document.add(new Paragraph("Tanggal : " + tgl));
            document.add(new Paragraph("alamat : " + almt));

            document.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
