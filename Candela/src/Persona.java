
public class Persona {
	private String codigo;
	private String nombrepro;
	private String cantidad;
	private String precio;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String Codigo) {
		this.codigo = Codigo;
	}
	
	public String getNombrepro() {
		return nombrepro;
	}
	public void setNombrepro(String nombrepro) {
		this.nombrepro = nombrepro;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Codigo: " + codigo + "\nProducto: " + nombrepro + "\nCantidad: " + cantidad + "\nPrecio: "
				+ precio +"\n\n";
	}

}
