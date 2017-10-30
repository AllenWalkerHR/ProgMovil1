package net.ivanvega.manejofragmentosb;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActividadFragmentoHardcode extends AppCompatActivity implements c{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_hardcode);
    }


    @Override
    public void answer(String datos) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentoDos fragmentoDos = (FragmentoDos) fragmentManager.findFragmentById(R.id.fragmentDos);
        fragmentoDos.cambiarTexto(datos);

    }
}
