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
public class FenceGenerator extends FileGenerator {

    public FenceGenerator(String regName, String textureName, String modId, String directory) {
        super(regName, textureName, modId, directory);
    }

    @Override
    public void generate() {
        generateFencePost();
        generateFenceSide();
        generateFenceInventory();
        generateFenceBlockstate();
        generateFenceItem();
        generateFenceRecipe();
        generateFenceLootTable();
    }

    private void generateFencePost() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_fence_post.json",
                "{\n"
                + "    \"parent\": \"block/fence_post\",\n"
                + "    \"textures\": {\n"
                + "        \"texture\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    private void generateFenceSide() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_fence_side.json",
                "{\n"
                + "    \"parent\": \"block/fence_side\",\n"
                + "    \"textures\": {\n"
                + "        \"texture\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    private void generateFenceInventory() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_fence_inventory.json",
                "{\n"
                + "    \"parent\": \"block/fence_inventory\",\n"
                + "    \"textures\": {\n"
                + "        \"texture\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    private void generateFenceBlockstate() {
        generateFile(directory + "/assets/" + modId + "/blockstates/" + regName + "_fence.json",
                "{\n"
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
                + "}");
    }

    private void generateFenceItem() {
        generateFile(directory + "/assets/" + modId + "/models/item/" + regName + "_fence.json",
                "{\n"
                + "  \"parent\": \"" + modId + ":block/" + regName + "_fence_inventory\"\n"
                + "}");
    }

    private void generateFenceRecipe() {
        generateFile(directory + "/data/" + modId + "/recipes/" + regName + "_fence.json",
                "{\n"
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
                + "}");
    }

    private void generateFenceLootTable() {
        generateFile(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_fence.json",
                "{\n"
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
                + "}");
    }
}
