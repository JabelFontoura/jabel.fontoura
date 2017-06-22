package br.com.crescer.tema;

//@author Jabel
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtilsImpl implements FileUtils {
  
  private File file;
  
  @Override
  public boolean mk(String string) {
    try {
      file = new File(string);
      if(isFile(string)){
        return file.createNewFile();
      } else
        return file.mkdir();
    } catch (IOException ex) {
      Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
  
  @Override
  public boolean rm(String string) {
    if(isDirectory(string)) {
      try {
        throw new Exception("Arquivo inválido.");
      } catch (Exception ex) {
        Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        return false;
      }
    }
    return new File(string).delete();
  }
  
  @Override
  public String ls(String string) {
    if(isDirectory(string)){
      StringBuilder sb = new StringBuilder();
      for(File f : new File(string).listFiles())
        sb.append(f.getName() + " ");
      
      return sb.toString();
    } else
      return new File(string).getAbsolutePath();
  }
  
  @Override
  public boolean mv(String in, String out) {
    try {
      if(isDirectory(in)) {
        throw new Exception("Arquivo inválido.");
      }
      
      return new File(in).renameTo(new File(out));
      
    } catch (IOException ex) {
      Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
      Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }
  
  public boolean isFile(String string) {
    return string.contains(".");
  }
  
  public boolean isDirectory(String string) {
    return new File(string).isDirectory();
  }
  
  public boolean fileExist(String string) {
    return new File(string).exists();
  }
}
