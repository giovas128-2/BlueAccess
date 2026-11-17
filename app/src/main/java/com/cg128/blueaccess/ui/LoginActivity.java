
package com.cg128.blueaccess.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cg128.blueaccess.R;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etCorreo, etPassword;
    private TextInputLayout layoutCorreo, layoutPassword;
    private MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DynamicColors.applyToActivityIfAvailable(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Conectar elementos del Login
        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);

        layoutCorreo = findViewById(R.id.layoutCorreo);
        layoutPassword = findViewById(R.id.layoutPassword);

        btnLogin = findViewById(R.id.btnLogin);

        TextView tvRegistro = findViewById(R.id.tvRegistro);
        TextView tvRecuperar = findViewById(R.id.tvRecuperar);

        // Iniciar sesión
        btnLogin.setOnClickListener(v -> validarLogin());

        // Abrir registro
        tvRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginActivity.this,
                    RegistroActivity.class
            );
            startActivity(intent);
        });

        // Recuperar contraseña
        tvRecuperar.setOnClickListener(v -> {
            mostrarRecuperacion();
        });
    }

    // VALIDACIONES DEL LOGIN
    private void validarLogin() {

        String correo = obtenerTexto(etCorreo).trim();
        String password = obtenerTexto(etPassword);

        layoutCorreo.setError(null);
        layoutPassword.setError(null);

        boolean valido = true;

        if (correo.isEmpty()) {
            layoutCorreo.setError(
                    "Ingresa tu correo electrónico"
            );
            valido = false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            layoutCorreo.setError(
                    "Ingresa un correo válido"
            );
            valido = false;
        }

        if (password.isEmpty()) {
            layoutPassword.setError(
                    "Ingresa tu contraseña"
            );
            valido = false;

        } else if (password.length() < 6) {
            layoutPassword.setError(
                    "La contraseña debe tener mínimo 6 caracteres"
            );
            valido = false;
        }

        if (valido) {
            Toast.makeText(
                    this,
                    "¡Bienvenido a BlueAccess!",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    // RECUPERAR CONTRASEÑA
    private void mostrarRecuperacion() {

        // Crear campo de correo Material 3
        TextInputLayout inputLayout =
                new TextInputLayout(this);

        inputLayout.setHint("Correo electrónico");

        inputLayout.setBoxBackgroundMode(
                TextInputLayout.BOX_BACKGROUND_OUTLINE
        );

        TextInputEditText inputCorreo =
                new TextInputEditText(inputLayout.getContext());

        inputCorreo.setInputType(
                android.text.InputType.TYPE_CLASS_TEXT |
                        android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        );

        inputCorreo.setSingleLine(true);

        inputLayout.addView(inputCorreo);

        // Espaciado del diálogo
        android.widget.LinearLayout contenedor =
                new android.widget.LinearLayout(this);

        contenedor.setOrientation(
                android.widget.LinearLayout.VERTICAL
        );

        int padding = (int) (
                24 * getResources().getDisplayMetrics().density
        );

        contenedor.setPadding(padding, 12, padding, 0);
        contenedor.addView(inputLayout);

        // Crear diálogo Material 3
        androidx.appcompat.app.AlertDialog dialogo =
                new MaterialAlertDialogBuilder(this)
                        .setTitle("Recuperar contraseña")
                        .setMessage(
                                "Ingresa tu correo electrónico para solicitar " +
                                        "la recuperación de tu contraseña."
                        )
                        .setView(contenedor)
                        .setNegativeButton(
                                "Cancelar",
                                (dialog, which) -> dialog.dismiss()
                        )
                        .setPositiveButton("Enviar", null)
                        .create();

        dialogo.setOnShowListener(dialog -> {

            dialogo.getButton(
                    androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE
            ).setOnClickListener(v -> {

                String correo = obtenerTexto(inputCorreo).trim();

                inputLayout.setError(null);

                if (correo.isEmpty()) {
                    inputLayout.setError(
                            "Ingresa tu correo electrónico"
                    );
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                    inputLayout.setError(
                            "Ingresa un correo válido"
                    );
                    return;
                }

                Toast.makeText(
                        this,
                        "Solicitud de recuperación simulada",
                        Toast.LENGTH_LONG
                ).show();

                dialogo.dismiss();
            });
        });

        dialogo.show();
    }

    // Obtener texto de un campo
    private String obtenerTexto(TextInputEditText campo) {
        return campo.getText() == null
                ? ""
                : campo.getText().toString();
    }
}
