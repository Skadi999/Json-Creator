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
public class WallCreator {

    private String regName;
    private String textureName;
    private String modId;
    private String directory;

    public WallCreator(String regName, String textureName, String modId, String directory) {
        this.regName = regName;
        this.textureName = textureName;
        this.modId = modId;
        this.directory = directory;
    }

    public void create() {
        createWallPost();
        createWallSide();
        createWallInventory();
        createWallBlockstate();
        createWallItem();
    }

    private void createWallPost() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_wall_post.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/template_wall_post\",\n"
                    + "    \"textures\": {\n"
                    + "        \"wall\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL_POST file");
        }
    }

    private void createWallSide() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_wall_side.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/template_wall_side\",\n"
                    + "    \"textures\": {\n"
                    + "        \"wall\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL_SIDE file");
        }
    }

    private void createWallInventory() {
        try {
            File f = new File(directory + "/models/block/" + regName + "_wall_inventory.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/wall_inventory\",\n"
                    + "    \"textures\": {\n"
                    + "        \"wall\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL_INVENTORY file");
        }
    }

    private void createWallBlockstate() {
        try {
            File f = new File(directory + "/blockstates/" + regName + "_wall.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"multipart\": [\n"
                    + "        {   \"when\": { \"up\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_wall_post\" }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"north\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_wall_side\", \"uvlock\": true }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"east\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_wall_side\", \"y\": 90, \"uvlock\": true }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"south\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_wall_side\", \"y\": 180, \"uvlock\": true }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"west\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_wall_side\", \"y\": 270, \"uvlock\": true }\n"
                    + "        }\n"
                    + "    ]\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL BLOCKSTATES file");
        }
    }

    private void createWallItem() {
        try {
            File f = new File(directory + "/models/item/" + regName + "_wall.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"parent\": \"" + modId + ":block/" + regName + "_wall_inventory\"\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL ITEM file");
        }
    }
}
