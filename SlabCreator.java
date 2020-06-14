/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Вячеслав
 */
public class SlabCreator {

    private String regName;
    private String textureName;
    private String modId;
    private String directory;

    public SlabCreator(String regName, String textureName, String modId, String directory) {
        this.regName = regName;
        this.textureName = textureName;
        this.modId = modId;
        this.directory = directory;
    }

    public void create() {
        createBlockBottom();
        createBlockTop();
        createItemBlock();
        createBlockstate();
    }

    //models > block > name_slab.json
    public void createBlockBottom() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_slab.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/slab\",\n"
                    + "    \"textures\": {\n"
                    + "        \"bottom\": \"block/" + textureName + "\",\n"
                    + "        \"top\": \"block/" + textureName + "\",\n"
                    + "        \"side\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCK SLAB file");
        }
    }

    //models > block > name_slab_top.json
    public void createBlockTop() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_slab_top.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/slab_top\",\n"
                    + "    \"textures\": {\n"
                    + "        \"bottom\": \"block/" + textureName + "\",\n"
                    + "        \"top\": \"block/" + textureName + "\",\n"
                    + "        \"side\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCK SLAB_TOP file");
        }
    }

    //models > item > name_slab.json
    public void createItemBlock() {
        try {
            File f = new File(directory + "/models/item/" + regName + "_slab.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"" + modId + ":block/" + regName + "_slab\"\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to an ITEM BLOCK SLAB file");
        }
    }

    //blockstates > name_slab.json
    public void createBlockstate() {
        try {
            File f = new File(directory + "/blockstates/" + regName + "_slab.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"variants\": {\n"
                    + "        \"type=bottom\": { \"model\": \"" + modId + ":block/" + regName + "_slab\" },\n"
                    + "        \"type=top\": { \"model\": \"" + modId + ":block/" + regName + "_slab_top\" },\n"
                    + "        \"type=double\": { \"model\": \"block/" + textureName + "\" }\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCKSTATE SLAB HALF file");
        }
    }
}
