package com.androneef.pdfcreation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama,tempatLahir, tanggalLahir, alamat;
    Button createPDF;
    String nama1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama =(EditText) findViewById(R.id.edtNama);
        tempatLahir =(EditText) findViewById(R.id.edtTempatLahir);
        tanggalLahir =(EditText) findViewById(R.id.edtTanggalLahir);
        alamat =(EditText) findViewById(R.id.edtAlamat);
        createPDF =(Button) findViewById(R.id.button);

        createPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buatPDF();
            }
        });

    }
    public void buatPDF(){
        String filename= "pdfbaru";
        String filecontent = "content";
        ToPDF pdf = new ToPDF();
        pdf.nm=nama.getText().toString();
        pdf.tmpt=tempatLahir.getText().toString();
        pdf.tgl=tanggalLahir.getText().toString();
        pdf.almt=alamat.getText().toString();
        if(pdf.create(filename,filecontent)){
            Toast.makeText(getApplicationContext(), filename + " PDF CREATED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"CREATION FAILED", Toast.LENGTH_SHORT).show();
        }

    }
}
