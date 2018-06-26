package actuadores;

interface Condicion<T> {
	boolean seCumple(T medicion);
}
