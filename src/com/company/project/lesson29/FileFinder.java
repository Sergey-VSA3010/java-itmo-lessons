package com.company.project.lesson29;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;
// Задачи для ForkJoinPool
//Future
//ForkJoinTask
//

public class FileFinder extends RecursiveTask<File> {
    private File file;
    private File directory;

    public FileFinder(File file, File directory) {
        if (file == null)
            throw new IllegalArgumentException("file is null");
        this.file = file;
        if(directory != null || !directory.isDirectory())
            throw new IllegalArgumentException("error in directory");
        this.directory = directory;
    }

    @Override
    protected File compute() {
        File[] subFiles = directory.listFiles();
        CopyOnWriteArrayList<FileFinder> fileFinders = new CopyOnWriteArrayList<>();
        if (subFiles !=null) {
            for (File subFile : subFiles) {
                if (subFile.isDirectory()){
                    FileFinder subFinder = new FileFinder(file,subFile);
                    subFinder.fork();
                }else {
                    if (file.getName().equals(subFile.getName())){
                        return subFile.getAbsoluteFile();
                    }
                }
            }
        }
        for (FileFinder fileFinder : fileFinders){
            File found = fileFinder.join();
            if (found != null && found.getName().equals(file.getName())){
                return found.getAbsoluteFile();
            }
        }
        return null;
    }
}
