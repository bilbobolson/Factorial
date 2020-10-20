package com.ajsb.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input ;
    private Button boton ;
    private TextView resultado ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main) ;

        // Obtenemos una referencia a cada uno de los elementos de la interfaz
        input     = findViewById(R.id.input) ;
        boton     = findViewById(R.id.boton) ;
        resultado = findViewById(R.id.resultado) ;

        //
        boton.setOnClickListener((v) ->
        {
            // Capturar el valor introducido por el usuario
            Integer valor = Integer.parseInt(input.getText().toString()) ;

            // Mostramos el resultado en pantalla
            resultado.setText(factorial(valor)) ;
            Log.i("FACTORIALR:", factorialR(valor).toString()) ;

        }) ;
    }

    /**
     * Calcula el factorial de un número
     * Método iterativo
     * @param num
     * @return
     */
    private String factorial(Integer num)
    {
        // n! = n·(n-1)·(n-2)· ... · 1
        Integer f = 1 ;
        for ( ; num > 1; num--) f = f * num ;
        return f.toString() ;
    }

    /**
     * Calcular el factorial de un número
     * Método recursivo
     * La recursividad consiste en que un método se invoca a sí mismo para resolver una versión
     * más pequeña del problema original. Distinguimos entre:
     *
     * - Caso base: aquel que tiene una solución directa.
     * - Caso general: necesita de la recursividad para llegar a una solución.
     *
     *  ¿Cuándo usamos la recursividad? Siempre que no exista una solución iterativa sencilla.
     *
     * @param num
     * @return
     */
    private Integer factorialR(Integer num)
    {
        // n! = n·(n-1)!

        // 0! = 1    ---> 100 uds en memoria = 600 uds
        // 1! = 1·0! ---> 100 uds en memoria = 500 uds
        // 2! = 2·1! ---> 100 uds en memoria = 400 uds
        // 3! = 3·2! ---> 100 uds en memoria = 300 uds
        // 4! = 4·3! ---> 100 uds en memoria = 200 uds
        // 5! = 5·4! ---> 100 uds en memoria

        if (num==0) return 1 ;
        return num*factorialR(num-1) ;
    }
}