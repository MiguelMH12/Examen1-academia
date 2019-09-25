package com.everis.examenuno.ejerciciodos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ServicioArchivo extends Servicio{

	@Override
	public void exportar(List<String> cadenas) {
		// TODO Auto-generated method stub
		String ruta = "c:/temp/cadenas.txt";
		File archivo = new File(ruta);
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));
			for(String cadenasString: cadenas) {
				buffer.write(cadenasString);
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
