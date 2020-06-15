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
public class FenceCreator {

    private String regName;
    private String textureName;
    private String modId;
    private String directory;

    public FenceCreator(String regName, String textureName, String modId, String directory) {
        this.regName = regName;
        this.textureName = textureName;
        this.modId = modId;
        this.directory = directory;
    }
    
    public void create() {
        createFencePost();
        createFenceSide();
        createFenceInventory();
        createFenceBlockstate();
        createFenceItem();
        createFenceRecipe();
        createFenceLootTable();
    }

    private void createFencePost() {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_fence_post.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/fence_post\",\n"
                    + "    \"textures\": {\n"
                    + "        \"texture\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a FENCE POST file");
        }
    }

    private void createFenceSide() {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_fence_side.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/fence_side\",\n"
                    + "    \"textures\": {\n"
                    + "        \"texture\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a FENCE SIDE file");
        }
    }

    private void createFenceInventory() {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_fence_inventory.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"parent\": \"block/fence_inventory\",\n"
                    + "    \"textures\": {\n"
                    + "        \"texture\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a FENCE INVENTORY file");
        }
    }

    private void createFenceBlockstate() {
        try {
            File f = new File(directory + "/assets/" + modId + "/blockstates/" + regName + "_fence.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "    \"multipart\": [\n"
                    + "        {   \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_fence_post\" }},\n"
                    + "        {   \"when\": { \"north\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_fence_side\", \"uvlock\": true }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"east\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_fence_side\", \"y\": 90, \"uvlock\": true }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"south\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_fence_side\", \"y\": 180, \"uvlock\": true }\n"
                    + "        },\n"
                    + "        {   \"when\": { \"west\": \"true\" },\n"
                    + "            \"apply\": { \"model\": \"" + modId + ":block/" + regName + "_fence_side\", \"y\": 270, \"uvlock\": true }\n"
                    + "        }\n"
                    + "    ]\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a FENCE BLOCKSTATES file");
        }
    }

    private void createFenceItem() {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/item/" + regName + "_fence.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"parent\": \"" + modId + ":block/" + regName + "_fence_inventory\"\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a FENCE ITEM file");
        }
    }

    private void createFenceRecipe() {
        try {
            File f = new File(directory + "/data/" + modId + "/recipes/" + regName + "_fence.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"type\": \"minecraft:crafting_shaped\",\n"
                    + "  \"group\": \"wooden_fence\",\n"
                    + "  \"pattern\": [\n"
                    + "    \"W#W\",\n"
                    + "    \"W#W\"\n"
                    + "  ],\n"
                    + "  \"key\": {\n"
                    + "    \"#\": {\n"
                    + "      \"item\": \"minecraft:stick\"\n"
                    + "    },\n"
                    + "    \"W\": {\n"
                    + "      \"item\": \"minecraft:" + regName + "\"\n"
                    + "    }\n"
                    + "  },\n"
                    + "  \"result\": {\n"
                    + "    \"item\": \"" + modId + ":" + regName + "_fence\",\n"
                    + "    \"count\": 3\n"
                    + "  }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a FENCE RECIPE file");
        }
    }

    private void createFenceLootTable() {
        try {
            File f = new File(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_fence.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"type\": \"minecraft:block\",\n"
                    + "  \"pools\": [\n"
                    + "    {\n"
                    + "      \"rolls\": 1,\n"
                    + "      \"entries\": [\n"
                    + "        {\n"
                    + "          \"type\": \"minecraft:item\",\n"
                    + "          \"name\": \"" + modId + ":" + regName + "_fence\"\n"
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
            System.out.println("Exception found while creating a FENCE LOOT TABLE file");
        }
    }
}
