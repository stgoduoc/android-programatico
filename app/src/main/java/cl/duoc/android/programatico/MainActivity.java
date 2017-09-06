package cl.duoc.android.programatico;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Producto> productos = new ArrayList<>();

    private void crearProductos(){
        productos.add(new Producto(10000L, "Juguete de madera", 10990L));
        productos.add(new Producto(10001L, "Auto a control remoto", 19990L));
        productos.add(new Producto(10103L, "Guitarra a pilas", 14490L));
        productos.add(new Producto(10103L, "Planta artificial", 5490L));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, R.style.cabecera);
        TextView tvId = new TextView(contextThemeWrapper);
        tvId.setText("ID");
        TextView tvProducto = new TextView(contextThemeWrapper);
        tvProducto.setText("Producto");
        TextView tvPrecio = new TextView(contextThemeWrapper);
        tvPrecio.setText("Precio");

        TableLayout tableLayout = new TableLayout(this);
        TableRow tableRowCabecera = new TableRow(this);
        tableRowCabecera.addView(tvId);
        tableRowCabecera.addView(tvProducto);
        tableRowCabecera.addView(tvPrecio);
        tableLayout.addView(tableRowCabecera);


        crearProductos();
        ContextThemeWrapper contextThemeWrapperCelda = new ContextThemeWrapper(this, R.style.celda);
        ContextThemeWrapper contextThemeWrapperCebra = new ContextThemeWrapper(this, R.style.cebra);
        int i = 1;
        for(Producto p: productos) {
            TableRow fila = new TableRow(this);

            TextView tvId1 = new TextView(contextThemeWrapperCelda);
            TextView tvProducto1 = new TextView(contextThemeWrapperCelda);
            TextView tvPrecio1 = new TextView(contextThemeWrapperCelda);
            if(i%2 == 0) {
                tvId1 = new TextView(contextThemeWrapperCebra);
                tvProducto1 = new TextView(contextThemeWrapperCebra);
                tvPrecio1 = new TextView(contextThemeWrapperCebra);
            }

            tvId1.setText(p.getId()+"");
            tvProducto1.setText(p.getNombre());
            tvPrecio1.setText(NumberFormat.getInstance().format(p.getPrecio()));

            fila.addView(tvId1);
            fila.addView(tvProducto1);
            fila.addView(tvPrecio1);
            tableLayout.addView(fila);
            i++;
        }

        linearLayout.addView(tableLayout);

    }
}
