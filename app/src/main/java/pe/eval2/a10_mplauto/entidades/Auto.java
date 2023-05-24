package pe.eval2.a10_mplauto.entidades;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Auto {

    private int id, modelo, marca, color;
    private String conductor, dato;
    private Bitmap imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
        try{
            byte[] bytecode= Base64.decode(dato, Base64.DEFAULT);
            imagen = BitmapFactory.decodeByteArray(bytecode,0,bytecode.length);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public Auto(int id, int modelo, int marca, int color, String conductor, String dato, Bitmap imagen) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.conductor = conductor;
        this.dato = dato;
        this.imagen = imagen;
    }

    public Auto() {
    }
}
