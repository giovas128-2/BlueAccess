package com.cg128.blueaccess.ui;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cg128.blueaccess.R;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.button.MaterialButton;

public class RegistroActivity extends AppCompatActivity {

    private TextInputEditText etNombre, etCorreo;
    private TextInputEditText etPassword, etConfirmar;

    private TextInputLayout layoutNombre, layoutCorreo;
    private TextInputLayout layoutPassword, layoutConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DynamicColors.applyToActivityIfAvailable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = findViewById(R.id.etNombreRegistro);
        etCorreo = findViewById(R.id.etCorreoRegistro);
        etPassword = findViewById(R.id.etPasswordRegistro);
        etConfirmar = findViewById(R.id.etConfirmarRegistro);

        layoutNombre = findViewById(R.id.layoutNombreRegistro);
        layoutCorreo = findViewById(R.id.layoutCorreoRegistro);
        layoutPassword = findViewById(R.id.layoutPasswordRegistro);
        layoutConfirmar = findViewById(R.id.layoutConfirmarRegistro);

        MaterialButton btnCrear = findViewById(R.id.btnCrearCuenta);
        MaterialButton btnVolver = findViewById(R.id.btnVolverLogin);

        btnCrear.setOnClickListener(v -> validarRegistro());
        btnVolver.setOnClickListener(v -> finish());
    }

    private void validarRegistro() {

        String nombre = obtenerTexto(etNombre).trim();
        String correo = obtenerTexto(etCorreo).trim();
        String password = obtenerTexto(etPassword);
        String confirmar = obtenerTexto(etConfirmar);

        layoutNombre.setError(null);
        layoutCorreo.setError(null);
        layoutPassword.setError(null);
        layoutConfirmar.setError(null);

        boolean valido = true;

        if (nombre.isEmpty()) {
            layoutNombre.setError("Ingresa tu nombre");
            valido = false;
        }

        if (correo.isEmpty()) {
            layoutCorreo.setError("Ingresa tu correo");
            valido = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            layoutCorreo.setError("Correo electrónico inválido");
            valido = false;
        }

        if (password.length() < 6) {
            layoutPassword.setError("Mínimo 6 caracteres");
            valido = false;
        }

        if (!password.equals(confirmar)) {
            layoutConfirmar.setError("Las contraseñas no coinciden");
            valido = false;
        }

        if (valido) {
            Toast.makeText(
                    this,
                    "Registro de demostración completado",
                    Toast.LENGTH_LONG
            ).show();

            finish();
        }
    }

    private String obtenerTexto(TextInputEditText campo) {
        return campo.getText() == null
                ? ""
                : campo.getText().toString();
    }
}
