/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator.generators;

import java.io.IOException;

//WARNING: outdated. for MC version 1.12
public class BlockGenerator extends FileGenerator {

    public BlockGenerator(String regName, String textureName, String modId, String directory) {
        super(regName, textureName, modId, directory);
    }
    
    @Override
    public void generate(){
        this.writeBlock();
        this.writeBlockstate();
    }

    public void writeBlock() {
        generateFile(directory + "/models/block/" + regName + ".json",
                "{\n"
                + "    \"parent\": \"block/cube_all\",\n"
                + "    \"textures\": {\n"
                + "        \"all\": \"" + modId + ":blocks/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    public void writeBlockstate() {
        generateFile(directory + "/blockstates/" + regName + ".json",
                "{\n"
                + "    \"forge_marker\": 1,\n"
                + "    \"defaults\": {\n"
                + "        \"model\": \"" + modId + ":" + regName + "\"\n"
                + "    },\n"
                + "    \"variants\": {\n"
                + "        \"normal\": [{}],\n"
                + "        \"inventory\": [{}]\n"
                + "    }\n"
                + "}");
    }

}
