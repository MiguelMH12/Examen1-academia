package com.everis.examenuno.ejerciciouno;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena ="Hola Mundo";
		analizarTexto(cadena);

	}
	
	public static void analizarTexto(String cadena) {
		System.out.println(cadena.length());
		String cadenaMayusculas = cadena.toUpperCase();
		System.out.println(cadenaMayusculas);
		
		Map<String, Long> ocurrencias = new HashMap<String, Long>();
		for(int i = 0; i < cadenaMayusculas.length(); i++) {  //Para cada elemento de la cadena
			if(null == ocurrencias.get(""+cadenaMayusculas.charAt(i))) {  //Si el mappeo en el caracter i está vacio 
				ocurrencias.put(""+cadenaMayusculas.charAt(i), 1L);  //agrega un nuevo caracter de la cadena como clave con el valor inicial 1 de tipo long
			}else {
				Long valor = ocurrencias.get(""+cadenaMayusculas.charAt(i));  //Si ya existe el caracter como clave 
				valor++;  //Lo incrementa
				ocurrencias.put(""+cadenaMayusculas.charAt(i), valor);  //Actualiza su valor incrementado
			}
		}
		
        Set<String> keys = ocurrencias.keySet();  //Obtenemos todas las claves-valor en el hash map
        Iterator<String> iterator = keys.iterator();  //Iterador que actua como cursor para recorrer todo el hashmap
        String key = null;  //Iniciamos  la clave en 0
        while(iterator.hasNext()) {  //Leemos todo el hash map ya almacenado con caracteres
            key = iterator.next();
            System.out.println(ocurrencias.get(key) + " letra " + key);

        }
	}

}
