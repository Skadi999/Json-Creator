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
        createBlockstateHalf();
        createBlockstateDouble();
    }

    //models > block > name_slab_bottom.json
    public void createBlockBottom() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_slab_bottom.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/half_slab\",\n"
                    + "    \"textures\": {\n"
                    + "        \"bottom\": \"minecraft:blocks/" + textureName + "\",\n"
                    + "        \"top\": \"minecraft:blocks/" + textureName + "\",\n"
                    + "        \"side\": \"minecraft:blocks/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a SLAB-BOTTOM file");
        }
    }

    //models > block > name_slab_top.json
    public void createBlockTop() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_slab_top.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/upper_slab\",\n"
                    + "    \"textures\": {\n"
                    + "        \"bottom\": \"minecraft:blocks/" + textureName + "\",\n"
                    + "        \"top\": \"minecraft:blocks/" + textureName + "\",\n"
                    + "        \"side\": \"minecraft:blocks/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a SLAB-TOP file");
        }
    }

    //models > item > name_slab_half.json
    public void createItemBlock() {
        try {
            File f = new File(directory + "/models/item/" + regName + "_slab_half.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"" + modId + ":block/" + regName + "_slab_bottom\",\n"
                    + "    \"display\": {\n"
                    + "        \"thirdperson\": {\n"
                    + "            \"rotation\": [ 10, -45, 170 ],\n"
                    + "            \"translation\": [ 0, 1.5, -2.75 ],\n"
                    + "            \"scale\": [ 0.375, 0.375, 0.375 ]\n"
                    + "        }\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to an ITEM BLOCK SLAB file");
        }
    }

    //blockstates > name_slab_half.json
    public void createBlockstateHalf() {
        try {
            File f = new File(directory + "/blockstates/" + regName + "_slab_half.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"variants\": {\n"
                    + "        \"half=bottom\": { \"model\": \"" + modId + ":" + regName + "_slab_bottom\" },\n"
                    + "        \"half=top\": { \"model\": \"" + modId + ":" + regName + "_slab_top\" }\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCKSTATE SLAB HALF file");
        }
    }
    
    //blockstates > name_slab_double.json
    public void createBlockstateDouble() {
        try {
            File f = new File(directory + "/blockstates/" + regName + "_slab_double.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"variants\": {\n"
                    + "        \"half=top\": { \"model\": \"minecraft:" + regName + "\" },\n"
                    + "        \"half=bottom\": { \"model\": \"minecraft:" + regName + "\" }\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a BLOCKSTATE SLAB DOUBLE file");
        }
    }

}
