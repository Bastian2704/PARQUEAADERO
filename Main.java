import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tarifa,caja,horaActual,numeroPuesto,opc,horaLlegada;
        boolean abierto;
        String placa;
        Scanner sc=new Scanner(System.in);
        Parqueadero parqueadero= new Parqueadero();
        System.out.println("Bienvenido al parqueadero");
do {
        System.out.println("Elija una opción");
        System.out.println("1.- Ingreso carro al parqueadero");
        System.out.println("2.- Salida de carro del parqueadero");
        System.out.println("3.- Informe ingresos del parqueadero");
        System.out.println("4.- Consultar cantidad de puestos disponibles");
        System.out.println("5.- Avanzar reloj del parqueadero");
        System.out.println("6.- Cambiar tarifa del parqueadero");
        System.out.println("7.- Tiempo promedio en Parqueadero");
        System.out.println("8.- ¿Hay carros con más de 8 horas?");
        System.out.println("9.- Carros con más de 3 horas parqueados");
        System.out.println("10.- ¿Existen carros con placa igual?");
        System.out.println("11.- Carros con placa PB y verificación de carros con más de 24 horas");
        System.out.println("12.- Desocupar parqueadero");
        System.out.println("13.- Salir de la aplicación");
        opc= Integer.parseInt(sc.next());
        switch (opc){
            case 1:{
                System.out.println("Ingrese la placa del carro que entra:");
                placa=sc.next();
                parqueadero.entrarCarro(placa);
                break;
            }
            case 2:{
                System.out.println("Ingrese la placa del carro que sale:");
                placa=sc.next();
                parqueadero.sacarCarro(placa);
                break;
            }
            case 3:{
                System.out.println("Ingresos");
                System.out.println("Hay $"+ parqueadero.darMontoCaja()+" en caja.");
                break;
            }
            case 4:{
                System.out.println("Puestos Disponibles");
                System.out.println("En este momento hay "+parqueadero.calcularPuestosLibres()+
                        " puestos libres");
                break;
            }
            case 5:{
                System.out.println("*Avanzar hora*");
                parqueadero.avanzarHora();
                break;
            }
            case 6:{
                System.out.println("Cambiar hora parqueadero");
                System.out.println("Ingrese la nueva tarifa del parqueadero:");
                tarifa=Integer.parseInt(sc.next());
                parqueadero.cambiarTarifa(tarifa);
            }
            case 7:{
                System.out.println("Hora Promedio");
                System.out.println("La horas promedio de carros en el parqueadero es: "+parqueadero.darTiempoPromedio());
            }
            case 8:{
                System.out.println("Carros con más de 8 horas");
                if (parqueadero.hayCarroMasDeOchoHoras()){
                    System.out.println("Hay carros con más de 8 horas");
                }else{
                    System.out.println("No hay carros con más de 8 horas");
                }
            }
            case 9: {
                System.out.println("Carros con más de 3 horas");
                ArrayList<Carro> carrosMasDeTresHoras = parqueadero.darCarrosMasDeTresHorasParqueados();
                System.out.println("Carros parqueados por más de tres horas:");
                for (Carro carro : carrosMasDeTresHoras) {
                    System.out.println("Placa: " + carro.darPlaca() + ", Tiempo en parqueadero: " + carro.darTiempoEnParqueadero(parqueadero.darHoraActual()) + " horas");
                }
            }
            case 10: {
                System.out.println("Carros Placa Igual");
                if (parqueadero.hayCarrosPlacaIgual()){
                    System.out.println("Existen carro/s con placas iguales");
                }else{
                    System.out.println("No existen carros con placas iguales");
                }
            }
            case 11: {
                parqueadero.metodo1();
            }
            case 12: {
                parqueadero.metodo2();
            }
            case 13: {
                System.out.println("SALIENDO DEL SISTEMA...");
            }

        }
}while (opc!=13);

    }
}