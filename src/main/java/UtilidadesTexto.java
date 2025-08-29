import java.util.Scanner;

public class UtilidadesTexto {
    public static void main(){

    }

    public static void menu(){
        mostrarMenu();
        Scanner opcion = new Scanner(System.in);
        int seleccion = leerOpcion(opcion);
        ejecutarOpcion(seleccion,opcion);

    }
    public static void mostrarMenu(){
        System.out.println("1. Verificar si frase es Reves-Derecho");
        System.out.println("2.Contar vocales de una frase");
        System.out.println("3.Encriptar frase");
        System.out.println("4.Desencriptar una frase");
        System.out.println("5.Salir");
        System.out.println("Indique su seleccion: ");
    }

    public static int leerOpcion(Scanner opcion){;
        return opcion.nextInt();
    }

    public static void ejecutarOpcion(int opcion,Scanner lector){
        switch (opcion) {
            case 1 -> solicitarFrase(lector);
        }
    }

    public static String solicitarFrase(Scanner frase){
        System.out.println("Indique su frase: ");
        return frase.nextLine();
    }

    public static boolean verificarPalindromo(Scanner leer){
        String frase = solicitarFrase(leer);
        String fraseJunta = frase.replaceAll("\\s+","");
        String fraseInvertida = invertirFrase(frase);
        if (fraseJunta.equals(fraseInvertida)){
            return true;
        }else {
            return false;
        }
    }

    public static String invertirFrase(String fraseOriginal){
        String frase = fraseOriginal.replaceAll("\\s+","");
        StringBuilder inversion = new StringBuilder(frase);
        String fraseInvertida = inversion.reverse().toString();
        return fraseInvertida;
    }
}