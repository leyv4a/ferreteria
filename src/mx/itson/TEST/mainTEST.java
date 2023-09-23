/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.TEST;


import java.math.BigDecimal;
import java.util.List;
import mx.itson.domain.CarritoDeCompras;
import mx.itson.domain.Categoria;
import mx.itson.domain.DetalleCarrito;
import mx.itson.domain.Producto;
import mx.itson.persistence.ProductoDAO;
import mx.itson.services.CarritoService;
import mx.itson.services.ClienteService;
import mx.itson.services.DetalleCarritoService;
import mx.itson.services.ProductoService;

/**
 *
 * @author gabri
 */
public class mainTEST {
    public static void main(String[] args) throws Exception {
//        CarritoService cs = new CarritoService();
//        cs.crearCarritoDeCompras(1);
//        CarritoDeCompras cc = new CarritoDeCompras();
//        cc = cs.obtenerCarritoPorCliente(11);
//        
//     
//        ClienteService clienteServices = new ClienteService();
//        ProductoService productoServices = new ProductoService();
//        DetalleCarritoService Dc = new DetalleCarritoService();
//        DetalleCarrito carritod= new DetalleCarrito(cc.getCarritoID(), 3, 2);
//        Dc.agregarDetalleCarrito(carritod);
//        
            
        try {
//            DetalleCarrito dt = new DetalleCarrito();
//            dt.setCantidad(1);
//            dt.setCarritoid(1);
//            dt.setProductoid(2);
            
//            Dc.agregarDetalleCarrito(dt);
            //METODOS DE CLIENTE PROBADOS Y FUNCIONANDO
//            clienteServices.crearCliente("Gsabriel","gabriel@leyv4a.scom","12222222222");
//clienteServices.buscarClientePorEmail("gabriel@leyv4a.scom");
//clienteServices.modificarCliente("gabriel@leyv4a.scom", "5551123123", "Gabirle2");
//clienteServices.consultarSaldo("JJ@yahoo.com");
//clienteServices.autentificacion("JJ@yahooo.com", "password1");

    //METODOS DE PRODUCTO PROBANDOSE
//          Categoria categoriaPrueba = new Categoria(1, "Herramientas");
//          Producto productoPrueba = new Producto("Producto de Prueba", new BigDecimal("9.99"), "Descripcion de prueba", categoriaPrueba);
//          productoServices.crearProducto(productoPrueba);
//List<Producto> productos = productoServices.listarProductos();
//            for (Producto producto : productos) {
//                System.out.println("ID "+ producto.getProductoId() +" Nombre "+producto.getNombreProducto() + " Categoria " + producto.getCategoria().getNombreCategoria());
//            }
////FALTA PROBAR ACTUALIZAR Y ELIMINAR PERO PRIMERO HAY QUE HACER EL OBTENERPRODUCTOPORID
//Producto productoActulizar = productos.get(1);
//productoActulizar.setNombreProducto("ProductoNuevo");
//productoServices.modificarProducto(productoActulizar);

//int Eliminar = 4;
////productoServices.eliminarProducto(Eliminar);
//ProductoDAO pd = new ProductoDAO();
//pd.obtenerProductoPorID(Eliminar);
DetalleCarritoService dcs = new DetalleCarritoService();
DetalleCarrito dc = new DetalleCarrito(2, 2, 2, "Jose", BigDecimal.ONE);
dcs.listarDetallesPorCarritoId(1);

        } catch (Exception e) {
            throw e;
        }
    }
}
