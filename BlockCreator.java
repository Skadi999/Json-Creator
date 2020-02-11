/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BlockCreator {

    private String regName;
    private String textureName;
    private String modId;
    private String directory;

    public BlockCreator(String regName, String textureName, String modId, String directory) {
        this.regName = regName;
        this.textureName = textureName;
        this.modId = modId;
        this.directory = directory;
    }

    public void create() throws IOException {
        this.writeBlock();
        this.writeBlockstate();
    }

    public void writeBlock() throws IOException {
        try {
            File f = new File(directory + "/models/block/" + regName + ".json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/cube_all\",\n"
                    + "    \"textures\": {\n"
                    + "        \"all\": \"" + modId + ":blocks/" + textureName + "\",\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCK file");
        }
    }

    public void writeBlockstate() throws IOException {
        try {
            File f = new File(directory + "/blockstates/" + regName + ".json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"forge_marker\": 1,\n"
                    + "    \"defaults\": {\n"
                    + "        \"model\": \"" + modId + ":" + regName + "\"\n"
                    + "    },\n"
                    + "    \"variants\": {\n"
                    + "        \"normal\": [{}],\n"
                    + "        \"inventory\": [{}]\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCK Blockstate file");
        }
    }

}
