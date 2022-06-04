import java.util.Arrays;
import java.util.Scanner;

public class Ventas {
    static String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre","Octubre","Noviembre","Diciembre"};
    public static double ventaAnualPromedio( int phone[] ){
        Double precio = 1500.00;
        Double montoAnual = 0.0;
        int cant =0;
        int i;

        for (i = 0; i < phone.length; i++){
            montoAnual = montoAnual + (phone[i]*precio);
            cant = cant + phone[i];
        }
//        System.out.println("total smartphone= "+ cant);
//        System.out.println("monto total smartphone= "+ montoAnual);
        montoAnual = montoAnual/12;
        return montoAnual;
    }

    public static String mesMayorVenta(int phone[] ){
        int i, index=0, cantMayor = 0 ;
        String mesMayor;

        for (i = 0; i < phone.length; i++){
            if (cantMayor < phone[i]){
                cantMayor = phone[i];
                index = i;
            }
        }
        mesMayor = mes[index];
        return  mesMayor;
    }

    public static String mesMenorVenta(int phone[] ){
        int i, index=0, cantMenor = 0 ;
        String mesMenor;

        for (i = 0; i < phone.length; i++){
            if (i == 0) {
                cantMenor = phone[i];
                continue;
            }
            if (cantMenor > phone[i]){
                cantMenor = phone[i];
                index = i;
            }
        }
        mesMenor = mes[index];
        return  mesMenor;
    }

    public static String ventaPorMes( int phone[] ) {
        Double precio = 1500.00;
        Double monto = 0.0;
        String cadena= "";
        int i;

        Double promedio = ventaAnualPromedio(phone);

        for (i = 0; i < phone.length; i++) {
            monto = phone[i] * precio;
            if(monto < promedio) {
                cadena = cadena + ", "+mes[i];
            }
        }
        return cadena;
    }

    public static void main(String[] args) {
        int cantidad, tamaño;
        int phone[] = {0,0,0,0,0,0,0,0,0,0,0,0};
        String mayorVenta, menorVenta, menosPromedio;

        Scanner sc = new Scanner(System.in);
        tamaño = mes.length;
        System.out.println(tamaño);
        int i = 0;

        System.out.println("*********************************************");
        System.out.println("************Venta de SmartPhones*************");
        System.out.println("*********************************************");
        System.out.println("Smartphones vendidos por mes");

        do{
            System.out.print(mes[i] +": ");
            cantidad = sc.nextInt();
            phone[i] = cantidad;
            i++;
        }while(i < mes.length);

        Double venta = ventaAnualPromedio(phone);
        mayorVenta = mesMayorVenta(phone);
        menorVenta = mesMenorVenta(phone);
        menosPromedio =ventaPorMes( phone);
        System.out.println("El promedio de la venta anual de Smartphones es: " + venta);
        System.out.println("El mes de mayor venta es: " + mayorVenta);
        System.out.println("El mes de menor venta es: " + menorVenta);
        System.out.println("Meses que no superan el promedio de ventas: " + menosPromedio);


    }

}
