/*
    Creado por Hermosa Programación - http://hermosaprogramacion.blogspot.com

    Artículo: Acceder a los Contactos de Android mediante el Contacts Provider

    Objetivos:
                - Comprender que es un Content Provider
                - Aprender como funciona un Content Resolver
                - Comprender como está estructurado el esquema ContactsContract
                - Consultar y Modificar datos de un contacto

 */

package com.example.azaa0.aplicacionpermisos;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import android.provider.ContactsContract.CommonDataKinds.Phone;


public class Main extends Activity {

    /*
    Código del mensaje de envío y
    Uri de contenido global
     */
    public static final int PICK_CONTACT_REQUEST = 1 ;
    private Uri contactUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    private void renderContact(Uri uri) {

        /*
        Obtener instancias de los Views
         */
        TextView contactName = (TextView)findViewById(R.id.contactName);
        TextView contactPhone = (TextView)findViewById(R.id.contactPhone);

        /*
        Setear valores
         */
        contactName.setText(getName(uri));
        contactPhone.setText(getPhone(uri));

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

    }

    private String getPhone(Uri uri) {
        /*
        Variables temporales para el id y el teléfono
         */
        String id = null;
        String phone = null;

        /************* PRIMERA CONSULTA ************/
        /*
        Obtener el _ID del contacto
         */
        Cursor contactCursor = getContentResolver().query(
                uri,
                new String[]{Contacts._ID},
                null,
                null,
                null);


        if (contactCursor.moveToFirst()) {
            id = contactCursor.getString(0);
        }
        contactCursor.close();

        /************* SEGUNDA CONSULTA ************/
        /*
        Sentencia WHERE para especificar que solo deseamos
        números de telefonía móvil
         */
        String selectionArgs =
                        Phone.CONTACT_ID + " = ? AND " +
                        Phone.TYPE+"= " +
                        Phone.TYPE_MOBILE;

        /*
        Obtener el número telefónico
         */
        Cursor phoneCursor = getContentResolver().query(
                Phone.CONTENT_URI,
                new String[] { Phone.NUMBER },
                selectionArgs,
                new String[] { id },
                null
        );
        if (phoneCursor.moveToFirst()) {
            phone = phoneCursor.getString(0);
        }
        phoneCursor.close();

        return phone;
    }

    private String getName(Uri uri) {

        /*
        Valor a retornar
         */
        String name = null;

         /*
        Obtener una instancia del Content Resolver
         */
        ContentResolver contentResolver = getContentResolver();

        /*
        Consultar el nombre del contacto
         */
        Cursor c = contentResolver.query(
                uri,
                new String[]{Contacts.DISPLAY_NAME},
                null,
                null,
                null);

        if(c.moveToFirst()){
            name = c.getString(0);
        }

        /*
        Cerramos el cursor
         */
        c.close();

        return name;
    }


}
