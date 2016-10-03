
package pe.edu.upeu;

public interface IMetodosJuegoTresEnRaya {
    public void inicializarTablero();
    public void imprimirTableroResultado();
    public void jugarTresEnRaya();
    public boolean comprobarGanador(int valor_jugador);
    
    public String saludo();
}
