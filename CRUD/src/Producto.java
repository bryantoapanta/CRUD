
/**
 * Write a description of class Producto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Producto
{
    // instance variables - replace the example below with your own
    int codigo;    // Código del producto, se utiliza para buscar
    String nombre; // Nombre un texto
    int stock;    // existencia actuales
    int stock_min; // Número mínimo de existencias recomedadas
    float precio;  // Precio

    /**
     * Constructor for objects of class Producto
     */
    
    public Producto ( int codigo, String nombre, int stock, int stock_minimo, float precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock=stock;
        this.stock_min= stock_minimo;
        this.precio= precio;}

    
    public int getCodigo (){
        return codigo;
    }
    
    @Override
    public String toString(){
       return "Codigo: "+codigo +" ||  Nombre: "+ nombre +" ||  Stock: "+ stock+" ||  Stock minimo: "+ stock_min+" ||  Precio:"+precio;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setStock( int valor ){
        stock = valor;
    }
    
    public int getStock_min(){
        return stock_min;
    }
    
    public void setStock_min( int valor ){
        stock_min = valor;
    }
    
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio( float valor ){
        precio = valor;
    }
}
