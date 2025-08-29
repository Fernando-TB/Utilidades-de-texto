import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilidadesTexto {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        while (true) {
            mostrarMenu();
            Scanner opcion = new Scanner(System.in);
            int seleccion = leerOpcion(opcion);
            ejecutarOpcion(seleccion);
        }

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

    public static void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1 -> revesDerecho();
            case 2 -> cuantasVocales();
            case 3 -> encriptarTexto();
            case 4 -> desencriptarTexto();
            case 5 -> System.exit(0);
        }
    }

    public static String solicitarFrase(){
        System.out.println("Indique su frase: ");
        Scanner leer = new Scanner(System.in);
        String frase = leer.nextLine();
        return frase;

    }

    public static void revesDerecho() {
        if (verificarPalindromo()) {
            System.out.println("La frase es Reves-Derecho osea un palindromo.");
        }else{
            System.out.println("La frase no es Reves-Derecho.");
        }
    }

    public static boolean verificarPalindromo(){
        String frase = solicitarFrase();
        String fraseJunta = frase.replaceAll("\\s+","").toLowerCase();
        String fraseInvertida = invertirFrase(fraseJunta);
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

    public static void cuantasVocales(){
        String frase = solicitarFrase().toLowerCase().replaceAll("\\s+","");
        Character[] listaVocales = {'a','e','i','o','u'};
        List<Character> vocales = new ArrayList<>(List.of(listaVocales));
        int contador = 0;
        for (int i= 0 ; i < frase.length(); i++){
            char letra = frase.charAt(i);
            if (vocales.contains(letra)){
                contador++;
            }
        }
        System.out.println("La frase contiene " + contador + " vocales.");
    }

    public static void encriptarTexto(){
        String frase = solicitarFrase().toLowerCase().replaceAll("\\s+","");
        frase = frase
                .replace('a','@')
                .replace('e','&')
                .replace('i','!')
                .replace('o','*')
                .replace('u','#');
        System.out.println("Texto encriptado: "+ frase);
    }

    public static void desencriptarTexto(){
        String frase = solicitarFrase().toLowerCase().replaceAll("\\s+","");
        frase = frase
                .replace('@','a')
                .replace('&','e')
                .replace('!','i')
                .replace('*','o')
                .replace('#','u');
        System.out.println("Texto desencriptado: "+ frase);
    }
}