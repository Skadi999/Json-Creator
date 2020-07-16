/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator.generators;


/**
 *
 * @author Вячеслав
 */
public class StairsGenerator extends FileGenerator {

    public StairsGenerator(String regName, String textureName, String modId, String directory) {
        super(regName, textureName, modId, directory);
    }
    
    @Override
    public void generate() {
        generateStairs();
        generateInnerStairs();
        generateOuterStairs();
        generateItemBlockStairs();
        generateBlockStateStairs();
        generateStairsRecipe();
        generateStairsLootTable();

    }

    //models > block > name_stairs.json
    private void generateStairs() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_stairs.json",
                "{\n"
                + "  \"parent\": \"block/stairs\",\n"
                + "  \"textures\": {\n"
                + "    \"bottom\": \"block/" + textureName + "\",\n"
                + "    \"top\": \"block/" + textureName + "\",\n"
                + "    \"side\": \"block/" + textureName + "\"\n"
                + "  }\n"
                + "}");
    }

    //models > block > name_inner_stairs.json
    private void generateInnerStairs() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_inner_stairs.json",
                "{\n"
                + "  \"parent\": \"block/inner_stairs\",\n"
                + "  \"textures\": {\n"
                + "    \"bottom\": \"block/" + textureName + "\",\n"
                + "    \"top\": \"block/" + textureName + "\",\n"
                + "    \"side\": \"block/" + textureName + "\"\n"
                + "  }\n"
                + "}");
    }

    //models > block > name_outer_stairs.json
    private void generateOuterStairs() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_outer_stairs.json",
                "{\n"
                + "  \"parent\": \"block/outer_stairs\",\n"
                + "  \"textures\": {\n"
                + "      \"bottom\": \"block/" + textureName + "\",\n"
                + "      \"top\": \"block/" + textureName + "\",\n"
                + "      \"side\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    //models > item > name_stairs.json
    private void generateItemBlockStairs() {
        generateFile(directory + "/assets/" + modId + "/models/item/" + regName + "_stairs.json",
                "{\n"
                + "  \"parent\": \"" + modId + ":block/" + regName + "_stairs\"\n"
                + "}");
    }

    //blockstates > name_stairs.json
    private void generateBlockStateStairs() {
        generateFile(directory + "/assets/" + modId + "/blockstates/" + regName + "_stairs.json",
                "{\n"
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
                + "}");
    }

    private void generateStairsRecipe() {
        generateFile(directory + "/data/" + modId + "/recipes/" + regName + "_stairs.json",
                "{\n"
                + "  \"type\": \"minecraft:crafting_shaped\",\n"
                + "  \"pattern\": [\n"
                + "    \"#  \",\n"
                + "    \"## \",\n"
                + "    \"###\"\n"
                + "  ],\n"
                + "  \"key\": {\n"
                + "    \"#\": {\n"
                + "      \"item\": \"minecraft:" + regName + "\"\n"
                + "    }\n"
                + "  },\n"
                + "  \"result\": {\n"
                + "    \"item\": \"" + modId + ":" + regName + "_stairs\",\n"
                + "    \"count\": 4\n"
                + "  }\n"
                + "}");
    }

    private void generateStairsLootTable() {
        generateFile(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_stairs.json",
                "{\n"
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
                + "}");
    }
}
