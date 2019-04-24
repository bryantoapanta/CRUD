
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class ModeloArrayList extends ModeloAbs
{
    private ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
    	lista.add(p);
      return false;    
    }
 
    public boolean borrarProducto ( int codigo ){
      
    	for( Producto a : lista ) {
    		if(a.codigo==codigo) { //busco que el codigo coincida
    			lista.remove(a); // si el codigo coincide, lo borre
    			return true;
    		}
    	}
      return false;
    }
    
    public Producto buscarProducto ( int codigo) {
    	for( Producto a : lista ) {
    		if(a.codigo==codigo) {
    			return a;
    		}
    	}
        return null;
    }
    
    public void listarProductos (){
    	for( Producto a : lista ) {
    		System.out.println(a.toString());
    	}

    }
    
    public boolean modificarProducto (Producto nuevo){
    	
       return false;
    }
    
    public void listarProductosBajoStock () {
    	
    	for( Producto a : lista ) {
    		if (a.getStock()<a.getStock_min()) { // si el stock es menor al stock minimo, entonces imprimo por pantalla
    			System.out.println(a.toString());
    		}
    	}
    	
    }  
    
}    
