package mx.edu.utng.dloza.calculadoraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener,View.OnClickListener {
    Spinner cmbOpciones;
    EditText txtNum1;
    EditText txtNum2;
    EditText txtResultado;
    Button btnSumar;
    Button btnRestar;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnFactorial;
    Button btnLimpiar;
    int op; //calculadora seleccionada
    String[] opciones = {"CalculadoraNormal", "CalculadoraCientifica"};
    CalculadoraCientifica calculadoraCientifica;
    CalculadoraNormal calculadoraNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_app);

        //Relacionando los controles con la views
        cmbOpciones = (Spinner) findViewById(R.id.cmb_tipo_calculadora);
        txtNum1 = (EditText) findViewById(R.id.txt_num1);
        txtNum2 = (EditText) findViewById(R.id.txt_num2);
        txtResultado = (EditText) findViewById(R.id.txt_resultado);
        btnSumar = (Button) findViewById(R.id.btn_sumar);
        btnRestar = (Button) findViewById(R.id.btn_restar);
        btnMultiplicar = (Button) findViewById(R.id.btn_multiplicar);
        btnDividir = (Button) findViewById(R.id.btn_dividir);
        btnFactorial = (Button) findViewById(R.id.btn_factorial);
        btnLimpiar = (Button) findViewById(R.id.btn_limpiar);
        calculadoraNormal = new CalculadoraNormal();
        calculadoraCientifica = new CalculadoraCientifica();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, opciones);
        cmbOpciones.setAdapter(adapter);

        cmbOpciones.setOnItemSelectedListener(this);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                txtNum1.setText("");
                txtNum2.setText("");
                txtResultado.setText("0.0");
            }
        });

        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id) {
        op = (int) cmbOpciones.getSelectedItemId();
        switch (op) {
            case 0:
                btnFactorial.setVisibility(View.GONE);//no visible
                btnMultiplicar.setVisibility(View.VISIBLE);//visible
                btnDividir.setVisibility(View.VISIBLE);
                break;
            case 1:
                btnFactorial.setVisibility(View.VISIBLE);
                btnMultiplicar.setVisibility(View.GONE);
                btnDividir.setVisibility(View.GONE);
                //txtNum2.setVisibility(View.GONE);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        op=1;
    }

    @Override
    public void onClick(View view) {
        double num1;
        double num2;
        int num=0;
        double resultado=0.0;

        num1 = Double.parseDouble(txtNum1.getText().toString());
        num2 = Double.parseDouble(txtNum2.getText().toString());

        if (view.getId() == R.id.btn_sumar ) {
            resultado = calculadoraNormal.sumar(num1, num2);
            resultado = calculadoraCientifica.sumar(num1, num2);

        } else if (view.getId() == R.id.btn_restar) {
            resultado = calculadoraNormal.restar(num1, num2);
            resultado = calculadoraCientifica.restar(num1, num2);

        } else if (view.getId() == R.id.btn_multiplicar ) {
            resultado = calculadoraNormal.multiplicar(num1, num2);

        } else if (view.getId() == R.id.btn_dividir ) {
            resultado = calculadoraNormal.dividir(num1, num2);

        } else if (view.getId() == R.id.btn_factorial ) {
            num=Integer.parseInt(txtNum1.getText().toString());
            resultado = calculadoraCientifica.factorial(num);
        }
        txtResultado.setText("" + resultado);

    }
}

