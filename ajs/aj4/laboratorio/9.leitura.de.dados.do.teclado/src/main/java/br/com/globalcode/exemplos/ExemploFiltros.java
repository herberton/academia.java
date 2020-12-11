package br.com.globalcode.exemplos;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.Console;
import java.util.Scanner;

public class ExemploFiltros {

    public static void main(String args[]) throws IOException {
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Digite o nome do diretório: ");
        String nomeDiretorio = scanner.nextLine();
        
        System.out.print("Digite a extensão do arquivo no diretório " + nomeDiretorio + ": ");
        String extensao = scanner.nextLine();
        
        Path diretorio = Paths.get(nomeDiretorio);
        if (Files.isDirectory(diretorio)) {
            // Gera uma lista de arquivos com a extensão desejada
            try (DirectoryStream<Path> arquivos
                    = Files.newDirectoryStream(diretorio, "*." + extensao)) {

                System.out.println("Lista de arquivos com a extensao :"
                        + extensao);
                for (Path arquivo : arquivos) {
                    System.out.println(arquivo.getFileName());
                }
            } //try-with-resources
        } else {
            System.out.println("Nao é um diretorio");
        }
    }
}