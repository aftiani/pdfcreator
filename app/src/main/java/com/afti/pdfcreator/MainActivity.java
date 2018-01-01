package com.afti.pdfcreator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama,tempatlahir,tanggallahir,alamat;
    Button createPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText)findViewById(R.id.edtNama);
        tempatlahir = (EditText)findViewById(R.id.edtTempatLahir);
        tanggallahir = (EditText)findViewById(R.id.edtTanggalLahir);
        alamat = (EditText)findViewById(R.id.edtAlamat);
        createPDF = (Button)findViewById(R.id.btnCreate);

        createPDF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buatPDF();
            }
        });
    }

    public void buatPDF(){
        String filename = "pdfbaru";
        String filecontent = "Content";
        ToPDF pdf = new ToPDF();
        pdf.nm = nama.getText().toString();
        pdf.tmpt = tempatlahir.getText().toString();
        pdf.tgl = tanggallahir.getText().toString();
        pdf.alamat =alamat.getText().toString();
        if (pdf.create(filename, filecontent)){
            Toast.makeText(getApplicationContext(),filename + " PDF CREATED ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"CREATION FAILED",Toast.LENGTH_SHORT).show();
        }
    }
}
