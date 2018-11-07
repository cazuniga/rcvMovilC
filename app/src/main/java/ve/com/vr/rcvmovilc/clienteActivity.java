package ve.com.vr.rcvmovilc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import ve.com.vr.rcvmovilc.datos.ClientesDB;
import ve.com.vr.rcvmovilc.model.Cliente;

public class clienteActivity extends AppCompatActivity {
    private ClientesDB db;
    Button btnOk;
    Button btnEl;
EditText edtRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        btnOk =   findViewById(R.id.btnOk);
        btnEl =   findViewById(R.id.btnEl);
        edtRes=   findViewById(R.id.edtRes) ;
        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CrearCliente();
                mostrarClientesLog();
            }
        });

        btnEl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                inicializarTBLCliente();
                mostrarClientesLog();
            }
        });

    }



private void inicializarTBLCliente(){
    db = new ClientesDB(this);
    db.deleteAllCliente();

}
    private void CrearCliente(){

        db = new ClientesDB(this);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Cliente cli01 = new Cliente(
                    1,
                    "N",
                    "V-15623819",
                    "CARLOS",
                    "ZUñIGA",
                    null,
                    "M",
                    format.parse("1981-09-28"),
                    "caz@correo.com",
                    "123",
                    "+584147914496",
                    "Mi casa 9",
                    "A"
            );

            db.insertCliente(cli01);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void mostrarClientesLog() {
        edtRes.setText("");
        List<Cliente> list = db.loadClientes();

        for(Cliente cl : list) {
            Log.i("CAZDB", cl.toString());
            edtRes.append(cl.toString() + "\n");
        }
    }

}
