package com.afti.pdfcreator;

import android.provider.DocumentsContract;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User id on 29 Jul 2017.
 */

public class ToPDF {
    MainActivity ma = new MainActivity();
    String nm,tmpt,tgl,alamat;
    public Boolean create(String fname, String fcontent) {
        try {
            String fpath = "/sdcard/" + fname + ".pdf";
            File file = new File(fpath);

            if (!file.exists()) {
                file.createNewFile();
            }

            // Font bfBold12 = new Font (Font.FontFamily.TIMES_ROMAN,12,FONT.BOLD,new Based();
            //Font bf12 = new Font (Font.FontFamily.TIMES_ROMAN,12);
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile()));
            document.open();
            document.add(new Paragraph("Ini Header!!!"));
            document.add(new Paragraph("TEST"));
            document.add(new Paragraph("Nama: "+nm));
            document.add(new Paragraph("Tempat Lahir : "+tmpt));
            document.add(new Paragraph("Tanggal Lahir : "+tgl));
            document.add(new Paragraph("Alamat: "+alamat));


            document.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }catch (DocumentException e){
            e.printStackTrace();
            return false;
        }
    }
}