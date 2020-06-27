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
public class WallGenerator extends FileGenerator {

    public WallGenerator(String regName, String textureName, String modId, String directory) {
        super(regName, textureName, modId, directory);
    }
    
    @Override
    public void generate() {
        generateWallPost();
        generateWallSide();
        generateWallInventory();
        generateWallBlockstate();
        generateWallItem();
        generateWallRecipe();
        generateWallLootTable();
    }

    private void generateWallPost() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_wall_post.json",
                "{\n"
                + "    \"parent\": \"block/template_wall_post\",\n"
                + "    \"textures\": {\n"
                + "        \"wall\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    private void generateWallSide() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_wall_side.json",
                "{\n"
                + "    \"parent\": \"block/template_wall_side\",\n"
                + "    \"textures\": {\n"
                + "        \"wall\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    private void generateWallInventory() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_wall_inventory.json",
                "{\n"
                + "    \"parent\": \"block/wall_inventory\",\n"
                + "    \"textures\": {\n"
                + "        \"wall\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    private void generateWallBlockstate() {
        generateFile(directory + "/assets/" + modId + "/blockstates/" + regName + "_wall.json",
                "{\n"
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
                + "}");
    }

    private void generateWallItem() {
        generateFile(directory + "/assets/" + modId + "/models/item/" + regName + "_wall.json",
                "{\n"
                + "  \"parent\": \"" + modId + ":block/" + regName + "_wall_inventory\"\n"
                + "}");
    }

    private void generateWallRecipe() {
        generateFile(directory + "/data/" + modId + "/recipes/" + regName + "_wall.json",
                "{\n"
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
                + "}");
    }

    private void generateWallLootTable() {
        generateFile(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_wall.json",
                "{\n"
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
                + "}");
    }
}
