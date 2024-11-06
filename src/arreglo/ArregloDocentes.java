package arreglo;
import java.util.ArrayList;

import clase.Docente;
public class ArregloDocentes {
	
	private ArrayList<Docente>doc;
	
	//creamos el constructor que cree el arraylist
	public ArregloDocentes(){
		doc = new ArrayList<Docente>(); //creando el arraylist
		
		//adicioando cuatro obejatos con add
		doc.add(new Docente(213, "Carlos", 20, 50.6));
		doc.add(new Docente(214, "Juan", 10, 80.2));
		doc.add(new Docente(215, "Maria", 30, 30.6));
		doc.add(new Docente(216, "Teresa", 60, 51.7));
			//agregar 3 objetos usando metodo adicionar
				adicionar(new Docente(217, "Pedro", 32, 15.60));
				adicionar(new Docente(218, "Luis", 21, 13.60));
				adicionar(new Docente(219, "Marcos", 32, 21.60));
	}
	
	//operacionesp publicas basicas
	
	//METODO ADICIONAR QUE RECIBE LA DirMem de un nuevo doente y lo adicione l ArrayList
		public void adicionar(Docente x){
			doc.add(x);
		}
	
	//METODO TAMANIO QUE RETORNE LA CNTIDAD DE OBJETOS DOCENTE REGISTRADOS HASTA ESE MOMENTO	
		public int tamanio(){
			return doc.size();
		}
		
	//METODO OBETENER QUE RECIBA UNA POSICION Y RETORNE LA DIRMEM DLE OBJETO DOCENTE RESPECTIVO	
		public Docente obtener(int i){
			return doc.get(i);
		}
		
		
	//opraciones complementarias
		
		public double sumarSueldos(){
			double suma =0;
			for (int i = 0; i < tamanio()-1; i++) 
				suma += obtener(i).sueldo();
			return suma;
		}
		
		
		public double calcularPromedio(){
			return sumarSueldos() / tamanio();
		}
		
		

		
}
