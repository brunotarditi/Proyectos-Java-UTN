package test;

import datos.DetallesDao;
import datos.ProductoDao;
import modelo.Detalles;
import modelo.Producto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ProductoDao().getAllProducts();
        for (Producto p :productos) {
            System.out.println(p.getIdProducto());
            System.out.println(p.getNombre());
            System.out.println(p.getSaldoTotal());
        }
    }
}


