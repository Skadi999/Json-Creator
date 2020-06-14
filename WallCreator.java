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
        createWallRecipe();
        createWallLootTable();
    }

    private void createWallPost() {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_wall_post.json");
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
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_wall_side.json");
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
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_wall_inventory.json");
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
            File f = new File(directory + "/assets/" + modId + "/blockstates/" + regName + "_wall.json");
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
            File f = new File(directory + "/assets/" + modId + "/models/item/" + regName + "_wall.json");
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

    private void createWallRecipe() {
        try {
            File f = new File(directory + "/data/" + modId + "/recipes/" + regName + "_wall.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"type\": \"minecraft:crafting_shaped\",\n"
                    + "  \"pattern\": [\n"
                    + "    \"###\",\n"
                    + "    \"###\"\n"
                    + "  ],\n"
                    + "  \"key\": {\n"
                    + "    \"#\": {\n"
                    + "      \"item\": \"minecraft:" + textureName + "\"\n"
                    + "    }\n"
                    + "  },\n"
                    + "  \"result\": {\n"
                    + "    \"item\": \"" + modId + ":" + regName + "_wall\",\n"
                    + "    \"count\": 6\n"
                    + "  }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL RECIPE file");
        }
    }

    private void createWallLootTable() {
        try {
            File f = new File(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_wall.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"type\": \"minecraft:block\",\n"
                    + "  \"pools\": [\n"
                    + "    {\n"
                    + "      \"rolls\": 1,\n"
                    + "      \"entries\": [\n"
                    + "        {\n"
                    + "          \"type\": \"minecraft:item\",\n"
                    + "          \"name\": \"" + modId + ":" + regName + "_wall\"\n"
                    + "        }\n"
                    + "      ],\n"
                    + "      \"conditions\": [\n"
                    + "        {\n"
                    + "          \"condition\": \"minecraft:survives_explosion\"\n"
                    + "        }\n"
                    + "      ]\n"
                    + "    }\n"
                    + "  ]\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a WALL LOOT TABLE file");
        }
    }
}
