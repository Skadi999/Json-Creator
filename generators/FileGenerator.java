/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Вячеслав
 */
public abstract class FileGenerator {

    String regName;
    String textureName;
    String modId;
    String directory;

    FileGenerator(String regName, String textureName, String modId, String directory) {
        this.regName = regName;
        this.textureName = textureName;
        this.modId = modId;
        this.directory = directory;
    }
    
    public void generate() {
        
    }

    void generateFile(String path, String text) {
        File f = new File(path);
        try (FileWriter fw = new FileWriter(f.getAbsolutePath())) {
            fw.write(text);
        } catch (IOException e) {
            System.out.println("Exception while writing to or creating\n" + path);
        }

    }
}
