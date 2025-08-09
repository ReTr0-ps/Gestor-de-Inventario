package LogicaNegocio;

public interface IControlador<T> {

	 void agregar(T parametro);
	 
	 void eliminar(T parametro);
	 
	 void actualizar(T parametro, T parametro2);
	
}