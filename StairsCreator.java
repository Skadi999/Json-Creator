/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StairsCreator {

    private String regName;
    private String textureName;
    private String modId;
    private String directory;

    public StairsCreator(String regName, String textureName, String modId, String directory) {
        this.regName = regName;
        this.textureName = textureName;
        this.modId = modId;
        this.directory = directory;
    }

    public void create() throws IOException {
        this.writeStairs();
        this.writeInnerStairs();
        this.writeOuterStairs();
        this.writeItemBlockStairs();
        this.writeBlockStateStairs();

    }

    //models > block > name_stairs.json
    public void writeStairs() throws IOException {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"parent\": \"block/stairs\",\n"
                    + "  \"textures\": {\n"
                    + "    \"bottom\": \"block/" + textureName + "\",\n"
                    + "    \"top\": \"block/" + textureName + "\",\n"
                    + "    \"side\": \"block/" + textureName + "\"\n"
                    + "  }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to a STAIRS file");
        }
    }

    //models > block > name_inner_stairs.json
    public void writeInnerStairs() throws IOException {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_inner_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"parent\": \"block/inner_stairs\",\n"
                    + "  \"textures\": {\n"
                    + "    \"bottom\": \"block/" + textureName + "\",\n"
                    + "    \"top\": \"block/" + textureName + "\",\n"
                    + "    \"side\": \"block/" + textureName + "\"\n"
                    + "  }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to an INNER STAIRS file");
        }
    }

    //models > block > name_outer_stairs.json
    public void writeOuterStairs() throws IOException {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/block/" + regName + "_outer_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"parent\": \"block/outer_stairs\",\n"
                    + "  \"textures\": {\n"
                    + "      \"bottom\": \"block/" + textureName + "\",\n"
                    + "      \"top\": \"block/" + textureName + "\",\n"
                    + "      \"side\": \"block/" + textureName + "\"\n"
                    + "    }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to an OUTER STAIRS file");
        }
    }

    //models > item > name_stairs.json
    public void writeItemBlockStairs() throws IOException {
        try {
            File f = new File(directory + "/assets/" + modId + "/models/item/" + regName + "_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"parent\": \"" + modId + ":block/" + regName + "_stairs\"\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to an ITEM BLOCK STAIRS file");
        }
    }

    //blockstates > name_stairs.json
    public void writeBlockStateStairs() throws IOException {
        try {
            File f = new File(directory + "/assets/" + modId + "/blockstates/" + regName + "_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"variants\": {\n"
                    + "    \"facing=east,half=bottom,shape=straight\":  { \"model\": \"" + modId + ":block/" + regName + "_stairs\" },\n"
                    + "    \"facing=west,half=bottom,shape=straight\":  { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=south,half=bottom,shape=straight\": { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=north,half=bottom,shape=straight\": { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=east,half=bottom,shape=outer_right\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\" },\n"
                    + "    \"facing=west,half=bottom,shape=outer_right\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=south,half=bottom,shape=outer_right\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=north,half=bottom,shape=outer_right\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=east,half=bottom,shape=outer_left\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=west,half=bottom,shape=outer_left\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=south,half=bottom,shape=outer_left\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\" },\n"
                    + "    \"facing=north,half=bottom,shape=outer_left\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=east,half=bottom,shape=inner_right\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\" },\n"
                    + "    \"facing=west,half=bottom,shape=inner_right\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=south,half=bottom,shape=inner_right\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=north,half=bottom,shape=inner_right\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=east,half=bottom,shape=inner_left\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=west,half=bottom,shape=inner_left\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=south,half=bottom,shape=inner_left\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\" },\n"
                    + "    \"facing=north,half=bottom,shape=inner_left\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=east,half=top,shape=straight\":  { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"x\": 180, \"uvlock\": true },\n"
                    + "    \"facing=west,half=top,shape=straight\":  { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=south,half=top,shape=straight\": { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=north,half=top,shape=straight\": { \"model\": \"" + modId + ":block/" + regName + "_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=east,half=top,shape=outer_right\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"uvlock\": true },\n"
                    + "    \"facing=west,half=top,shape=outer_right\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=south,half=top,shape=outer_right\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=north,half=top,shape=outer_right\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=east,half=top,shape=outer_left\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=west,half=top,shape=outer_left\":  { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=south,half=top,shape=outer_left\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=north,half=top,shape=outer_left\": { \"model\": \"" + modId + ":block/" + regName + "_outer_stairs\", \"x\": 180, \"uvlock\": true },\n"
                    + "    \"facing=east,half=top,shape=inner_right\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"uvlock\": true },\n"
                    + "    \"facing=west,half=top,shape=inner_right\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=south,half=top,shape=inner_right\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=north,half=top,shape=inner_right\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=east,half=top,shape=inner_left\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
                    + "    \"facing=west,half=top,shape=inner_left\":  { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
                    + "    \"facing=south,half=top,shape=inner_left\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
                    + "    \"facing=north,half=top,shape=inner_left\": { \"model\": \"" + modId + ":block/" + regName + "_inner_stairs\", \"x\": 180, \"uvlock\": true }\n"
                    + "  }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException ioe) {
            System.out.println("exception found while creating or writing to an BLOCKSTATE STAIRS file");
        }
    }

    private void createStairsRecipe() {
        try {
            File f = new File(directory + "/data/" + modId + "/recipes/" + regName + "_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"type\": \"minecraft:crafting_shaped\",\n"
                    + "  \"pattern\": [\n"
                    + "    \"#  \",\n"
                    + "    \"## \",\n"
                    + "    \"###\"\n"
                    + "  ],\n"
                    + "  \"key\": {\n"
                    + "    \"#\": {\n"
                    + "      \"item\": \"minecraft:" + textureName + "\"\n"
                    + "    }\n"
                    + "  },\n"
                    + "  \"result\": {\n"
                    + "    \"item\": \"" + modId + ":" + regName + "_stairs\",\n"
                    + "    \"count\": 4\n"
                    + "  }\n"
                    + "}"
            );
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception found while creating a STAIRS RECIPE file");
        }
    }

    private void createStairsLootTable() {
        try {
            File f = new File(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_stairs.json");
            FileWriter fw = new FileWriter(f.getAbsolutePath());
            fw.write("{\n"
                    + "  \"type\": \"minecraft:block\",\n"
                    + "  \"pools\": [\n"
                    + "    {\n"
                    + "      \"rolls\": 1,\n"
                    + "      \"entries\": [\n"
                    + "        {\n"
                    + "          \"type\": \"minecraft:item\",\n"
                    + "          \"name\": \"" + modId + ":" + regName + "_stairs\"\n"
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
            System.out.println("Exception found while creating a STAIRS LOOT TABLE file");
        }
    }
}
