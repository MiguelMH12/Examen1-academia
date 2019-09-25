package com.everis.examenuno.ejerciciodos;

import java.util.ArrayList;

public class ServicioPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("Cadena 1 ");
		cadenas.add("Cadena 2 ");
		cadenas.add("Cadena 3 ");
		cadenas.add("Cadena 4 ");
		cadenas.add("Cadena 5 ");
		
		ServicioConsola servicioConsola = new ServicioConsola();
		ServicioArchivo servicioArchivo = new ServicioArchivo();
		servicioConsola.exportar(cadenas);
		servicioArchivo.exportar(cadenas);
	}
}
