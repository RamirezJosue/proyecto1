

package pe.edu.upeu;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MetodosJuegoTresEnRaya implements  IMetodosJuegoTresEnRaya{
    int tablero[][]=new int [3][3];
    
    @Override
     public void inicializarTablero(){
        for(int i=0;i<tablero.length;i++){
            for(int j=0; j<tablero[0].length; j++){
                tablero[i][j]=3;
                System.out.print("|"+tablero[i][j]);
                if(j==2){System.out.print("|");}                
            }
            System.out.println("");
        }
    } 
        @Override
     public String saludo(){
         return null;
     }
     @Override
     public void imprimirTableroResultado(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if(tablero[i][j]==0){System.out.print("|"+tablero[i][j]+"");}
                if(tablero[i][j]==1){System.out.print("|X");}
                if(tablero[i][j]==3){System.out.print("| ");}
            }
            System.out.println("|");
            System.out.println("");
        }
    }    
     
    public boolean comprobarGanador(int valor_jugador){
        if(tablero[0][0]==valor_jugador && tablero[0][1]==valor_jugador && 
            tablero[0][2]==valor_jugador){return true;}
        if(tablero[1][0]==valor_jugador && tablero[1][1]==valor_jugador && 
            tablero[1][2]==valor_jugador){return true;}
        if(tablero[2][0]==valor_jugador && tablero[2][1]==valor_jugador && 
            tablero[2][2]==valor_jugador){return true;}

        if(tablero[0][0]==valor_jugador && tablero[1][0]==valor_jugador && 
            tablero[2][0]==valor_jugador){return true;}
        if(tablero[0][1]==valor_jugador && tablero[1][1]==valor_jugador && 
            tablero[2][1]==valor_jugador){return true;}
        if(tablero[0][2]==valor_jugador && tablero[1][2]==valor_jugador && 
            tablero[2][2]==valor_jugador){return true;}
        
        if(tablero[0][0]==valor_jugador && tablero[1][1]==valor_jugador && 
            tablero[2][2]==valor_jugador){return true;}        
        if(tablero[2][0]==valor_jugador && tablero[1][1]==valor_jugador && 
            tablero[0][2]==valor_jugador){return true;}          
        return false;
    }
    @Override
    public void jugarTresEnRaya(){
        try {
            BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
            boolean finJuego=false;
            int valor_juego=0;            
            System.out.println("Como quieres jugar: X/0?");
            String simboloJuego=teclado.readLine().toUpperCase();
            if(simboloJuego.equals("X")){valor_juego=1;}
            if(simboloJuego.equals("0")){valor_juego=0;}
            
            if(simboloJuego.equals("X") || simboloJuego.equals("0")){            
                System.out.println("Comienza el Jugador "+simboloJuego);                
                while(finJuego==false){
                    imprimirTableroResultado();
                    if(valor_juego==0){System.out.println("Toca al Jugador 0:");}
                    if(valor_juego==1){System.out.println("Toca al Jugador X:");}
                    System.out.println("Introducir las coordenadas de la posicion (0,0):");
                    System.out.println("Ingrese la Fila:");
                    int fila=Integer.parseInt(teclado.readLine());
                    System.out.println("Ingrese la Columna:");
                    int columna=Integer.parseInt(teclado.readLine());
                    if(tablero[fila][columna]==3){
                    boolean ganador=comprobarGanador(valor_juego);
                    tablero[fila][columna]=valor_juego;//Agregar
                    if(ganador){
                        System.out.println("Ha ganado "+valor_juego);
                        finJuego=true;
                        inicializarTablero();
                    }else{
                        int estado_empate=0;
                        for(int i=0; i<tablero.length;i++){
                            for(int j=0;j<tablero[0].length; j++){
                                if(tablero[i][j]==0 || tablero[i][j]==1){
                                estado_empate=estado_empate+1;
                                }
                            }
                        }
                        
                        if(estado_empate==9){System.out.println("Se ha Empatado");finJuego=true; }
                        if(valor_juego==1){valor_juego=0;}
                        else {if(valor_juego==0){valor_juego=1;}}
                        
                        
                    }
                    }else{
                        System.out.println("No se puede jugar, ya esta usado");
                    }
                    
                }            
            }
        } catch (Exception e) {
        }        
    }
    
}
