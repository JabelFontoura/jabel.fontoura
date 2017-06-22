package br.com.crescer.tema;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterUtilsImpl implements WriterUtils {

  private File file;

  @Override
  public void write(String stringFile, String conteudo) {
      file = new File(stringFile);
    try {
      if(!stringFile.contains(".txt")) throw new Exception("Este não é um arquivo .txt");
      else if(!Files.exists(file.toPath())) throw new Exception("Arquivo não encontrado.");
      
      final Writer writer = new FileWriter(stringFile);
      final BufferedWriter bufferReader = new BufferedWriter(writer);
      
      bufferReader.append(conteudo);
      
      bufferReader.flush();
    } catch (Exception ex) {
      Logger.getLogger(WriterUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}