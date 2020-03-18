/*Hoja de trabajo 7
 * Diccionario ingles - español
 * Mirka Monzon 18139
 * Main class
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean wantsToContinue = true;

        BinaryTree dictionary = null;
        ArrayList<String> sentence;

        while (wantsToContinue){

            System.out.println(menu());
            System.out.print("\nIngrese una opcion: ");
            Scanner input = new Scanner(System.in);
            String op = input.next();

            switch (op){
                case "1":
                    System.out.print("\n\nIngrese path del archivo diccionario: ");
                    Scanner input2 = new Scanner(System.in);
                    String path = input2.next();
                    dictionary = readWords(path);
                    System.out.println("\nPalabras disponibles(InOrder):\n");
                    System.out.println(BinaryTree.inOrder(dictionary));
                    break;
                case "2":
                    if (dictionary != null){
                        System.out.print("\n\nIngrese path del archivo oracion: ");
                        Scanner input3 = new Scanner(System.in);
                        String path2 = input3.next();
                        sentence = readSentence(path2);
                        sentence = translate(sentence, dictionary);
                        String translatedSentence = "";
                        for (String word: sentence) {
                            translatedSentence += " " + word;
                        }
                        System.out.println("\nOracion Traducida: " + translatedSentence);
                    } else {
                        System.out.println("\nERROR: NO se ha ingresado un diccionario.");
                    }
                    break;
                case "3":
                    wantsToContinue = false;
                    break;
                default:
                    System.out.println("\nLa opcion ingresada no es valida.");
                    break;
            }

        }
    }

    //menu
    public static String menu(){
        return "\n\tMenu\n\n" +
                "1. Agregar diccionario\n" +
                "2. Leer oracion\n" +
                "3. Salir\n\n";
    }

    //lee txt y asocia las palabras
    public static BinaryTree readWords(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        BinaryTree<Association> binaryTree = new BinaryTree();

        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split(", ");
            String englishWord = words[0].toLowerCase();
            String spanishWord = words[1].toLowerCase();
            Association association = new Association(englishWord, spanishWord);
            binaryTree.insert(association);
        }

        return binaryTree;

    }

    //lee txt con la oracion a traducir
    public static ArrayList readSentence(String path) throws IOException{

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<String> sentence = new ArrayList<>();

        while (scanner.hasNext()){
            String word = scanner.next();
            sentence.add(word);
        }

        return sentence;
    }

    //traduce la oracion
    public static ArrayList translate(ArrayList<String> sentence, BinaryTree dictionary){

        ArrayList<String> newSentece = new ArrayList();

        for (String word:sentence) {

            Association association = (Association) dictionary.search(word.toLowerCase());
            if (association != null){
                newSentece.add(association.getSpanishWord());
            } else {
                newSentece.add("*" + word + "*");
            }
        }

        return newSentece;

    }
}
