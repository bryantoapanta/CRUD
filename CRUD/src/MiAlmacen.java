import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

// Crear la clase Producto y completar los mÃ©todos

public class MiAlmacen {
	static private ModeloAbs almacen;// creo esta instancia para poder acceder a los metodos de modeloabs
	static Scanner sc;

	public static void main(String[] args) {
		almacen = new ModeloArrayList();
		sc = new Scanner(System.in);
		int opcion = 0;
		do {
			mostrarMenu();
			opcion = leerOpcion(1, 9);
			switch (opcion) {
			case 1:
				crear();
				break;
			case 2:
				consultar();
				break;
			case 3:
				borrar();
				break;
			case 4:
				modificarPrecio();
				break;
			case 5:
				comprar();
				break;
			case 6:
				vender();
				break;
			case 7:
				listar();
				break;
			case 8:
				listarPocoStock();
				break;
			}
			System.out.println("\n---------------------------- ");
			System.out.print("Pulse enter para continuar");
			sc.nextLine();
		} while (opcion != 9);
		sc.close();

	}

	private static void mostrarMenu() {
		System.out.println("\n\n    MENU");
		System.out.println("1. Nuevo producto ");
		System.out.println("2. Consulta producto ");
		System.out.println("3. Borrar producto ");
		System.out.println("4. Modificar precio ");
		System.out.println("5. Compra de productos ");
		System.out.println("6. Venta de productos ");
		System.out.println("7. Listado completo de productos ");
		System.out.println("8. Listado de productos con stock inferior al mÃ­nimo");
		System.out.println("9. Terminar ");
		System.out.print("Elige una opciÃ³n (1-9)");
	}

	// Lee un entero del System.in que este comprendido entre primero y ultimo
	private static int leerOpcion(int primero, int ultimo) {
		int valor = leerEntero();
		while (valor < primero || valor > ultimo) {
			valor = leerEntero();
		}
		return valor;
	}

	// Metodos Auxiliares leerFloat y LeerEntero,
	// Lee de la System.in con el scanner sc y controlan la excepcion de
	// NumberFormatException
	static private float leerFloat() {

		boolean error = false;
		float valor = 0;
		String cadena;
		do {
			error = false;
			try {
				// Intento leer directamente un entero
				cadena = sc.nextLine();
				valor = Float.parseFloat(cadena);

			} catch (NumberFormatException e) {
				System.out.println("Error en formato.");
				error = true;
			}
		} while (error);
		return valor;
	}

	// Leer codigo
	static private int leerEntero() {
		Scanner sc = new Scanner(System.in); // creo un sc para leer el numero introducido por teclado
		int opcion = sc.nextInt();
		return opcion; // devuelvo el numero escrito
	}

	// Leer producto
	static private String leerProducto() {
		Scanner sc = new Scanner(System.in); // creo un sc para leer el producto introducido por teclado
		String opcion = sc.nextLine();
		return opcion; // devuelvo el producto escrito
	}

	// Muestra los datos de un producto a partir de su codigo

	private static void consultar() {
		System.out.println("<CONSULTA>");
		System.out.print("Introduzca codigo:");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("PRODUCTO " + p);
		}

	}

	// Borrar un producto a partir de su codigo

	private static void borrar() {
		System.out.println("<ELIMINAR>");
		// IMPLEMENTAR
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			almacen.borrarProducto(codigo);
			System.out.println("PRODUCTO Borrado");
		}
	}

	// Cambia el precio de un producto a partir de su codigo
	private static void modificarPrecio() {
		System.out.println("<MODIFICAR PRECIO>");
		// IMPLEMENTAR
		System.out.println("<INTRODUZCA CODIGO>");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("INTRODUZCA PRECIO");
			Float precio= leerFloat();
			p.setPrecio(precio);
			System.out.println("PRODUCTO MODIFICADO");
		}
	}

	// Incrementa el stock
	private static void comprar() {
		System.out.println("<COMPRAR>");
		System.out.print("Introduzca codigo:");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("CANTIDAD A AÑADIR" );
			int valor= sc.nextInt();// cantidad que deseo añadir
			valor=valor+p.getStock();	// cantidad a añadir + cantidad existente
			p.setStock(valor);		// establezco el nuevo valor
			System.out.println("PRODUCTO AÑADIDO" );
		}
		
		// IMPLEMENTAR
	}

	// Decrementa el stock
	private static void vender() {
		System.out.println("<VENDER>");
		System.out.print("Introduzca codigo:");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("CANTIDAD A VENDER" );
			int valor= sc.nextInt();// cantidad que deseo añadir
			valor=p.getStock()-valor;	// cantidad a vender - cantidad existente
			p.setStock(valor);		// establezco el nuevo valor
			System.out.println("PRODUCTO AÑADIDO" );
		}

		// IMPLEMENTAR

	}

	// Listado de todos los productos
	private static void listar() {
		System.out.println("<LISTAR>");
		almacen.listarProductos();
	}

	// Listado de todos los productos con stock inferior a stock minimo
	private static void listarPocoStock() {
		System.out.println("<LISTAR STOCK BAJO MINIMOS>");
		almacen.listarProductosBajoStock();
	}

	// Solicita datos al usuario para dar de alta un nuevo producto
	// El codigo no se puede repetir
	private static void crear() {
		System.out.println("<NUEVO PRODUCTO>");
		String nuevo = leerProducto();// nuevo producto
		System.out.println("<CODIGO PRODUCTO>");
		int n = leerEntero();// codigo
		System.out.println("<PRECIO PRODUCTO>");
		float precio = leerFloat(); //sc.nextFloat();// codigo
		System.out.println("<STOCK PRODUCTO>");
		int stock = leerEntero();// codigo
		System.out.println("<STOCK MINIMO PRODUCTO>");
		int stockMin = leerEntero();// codigo

		Producto p = new Producto(n, nuevo, stock, stockMin, precio);
		almacen.insertarProducto(p);

	}

}
