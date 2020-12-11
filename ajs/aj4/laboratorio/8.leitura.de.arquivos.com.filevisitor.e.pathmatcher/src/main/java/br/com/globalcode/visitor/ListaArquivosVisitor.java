package br.com.globalcode.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ListaArquivosVisitor extends SimpleFileVisitor<Path> {

    private PathMatcher matcher;
    private List<Path> arquivos = new ArrayList<>();

    public ListaArquivosVisitor(PathMatcher matcher) {
        this.matcher = matcher;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    	boolean teste = matcher.matches(file); 
        if (teste) {
            arquivos.add(file);
            
        }
        System.out.println(file.getFileName() + " " + teste);
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getArquivos() {
        return arquivos;
    }
 }
