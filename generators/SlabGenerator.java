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
public class SlabGenerator extends FileGenerator {

    public SlabGenerator(String regName, String textureName, String modId, String directory) {
        super(regName, textureName, modId, directory);
    }

    @Override
    public void generate() {
        generateBlockBottom();
        generateBlockTop();
        generateItemBlock();
        generateBlockstate();
        generateSlabRecipe();
        generateSlabLootTable();
    }

    //models > block > name_slab.json
    private void generateBlockBottom() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_slab.json",
                "{\n"
                + "    \"parent\": \"block/slab\",\n"
                + "    \"textures\": {\n"
                + "        \"bottom\": \"block/" + textureName + "\",\n"
                + "        \"top\": \"block/" + textureName + "\",\n"
                + "        \"side\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    //models > block > name_slab_top.json
    private void generateBlockTop() {
        generateFile(directory + "/assets/" + modId + "/models/block/" + regName + "_slab_top.json",
                "{\n"
                + "    \"parent\": \"block/slab_top\",\n"
                + "    \"textures\": {\n"
                + "        \"bottom\": \"block/" + textureName + "\",\n"
                + "        \"top\": \"block/" + textureName + "\",\n"
                + "        \"side\": \"block/" + textureName + "\"\n"
                + "    }\n"
                + "}");
    }

    //models > item > name_slab.json
    private void generateItemBlock() {
        generateFile(directory + "/assets/" + modId + "/models/item/" + regName + "_slab.json",
                "{\n"
                + "    \"parent\": \"" + modId + ":block/" + regName + "_slab\"\n"
                + "}");
    }

    //blockstates > name_slab.json
    private void generateBlockstate() {
        generateFile(directory + "/assets/" + modId + "/blockstates/" + regName + "_slab.json",
                "{\n"
                + "    \"variants\": {\n"
                + "        \"type=bottom\": { \"model\": \"" + modId + ":block/" + regName + "_slab\" },\n"
                + "        \"type=top\": { \"model\": \"" + modId + ":block/" + regName + "_slab_top\" },\n"
                + "        \"type=double\": { \"model\": \"block/" + regName + "\" }\n"
                + "    }\n"
                + "}");
    }

    private void generateSlabRecipe() {
        generateFile(directory + "/data/" + modId + "/recipes/" + regName + "_slab.json",
                "{\n"
                + "  \"type\": \"minecraft:crafting_shaped\",\n"
                + "  \"pattern\": [\n"
                + "    \"###\"\n"
                + "  ],\n"
                + "  \"key\": {\n"
                + "    \"#\": {\n"
                + "      \"item\": \"minecraft:" + regName + "\"\n"
                + "    }\n"
                + "  },\n"
                + "  \"result\": {\n"
                + "    \"item\": \"" + modId + ":" + regName + "_slab\",\n"
                + "    \"count\": 6\n"
                + "  }\n"
                + "}");
    }

    private void generateSlabLootTable() {
        generateFile(directory + "/data/" + modId + "/loot_tables/blocks/" + regName + "_slab.json",
                "{\n"
                + "  \"type\": \"minecraft:block\",\n"
                + "  \"pools\": [\n"
                + "    {\n"
                + "      \"rolls\": 1,\n"
                + "      \"entries\": [\n"
                + "        {\n"
                + "          \"type\": \"minecraft:item\",\n"
                + "          \"functions\": [\n"
                + "            {\n"
                + "              \"function\": \"minecraft:set_count\",\n"
                + "              \"conditions\": [\n"
                + "                {\n"
                + "                  \"condition\": \"minecraft:block_state_property\",\n"
                + "                  \"block\": \"" + modId + ":" + regName + "_slab\",\n"
                + "                  \"properties\": {\n"
                + "                    \"type\": \"double\"\n"
                + "                  }\n"
                + "                }\n"
                + "              ],\n"
                + "              \"count\": 2\n"
                + "            },\n"
                + "            {\n"
                + "              \"function\": \"minecraft:explosion_decay\"\n"
                + "            }\n"
                + "          ],\n"
                + "          \"name\": \"" + modId + ":" + regName + "_slab\"\n"
                + "        }\n"
                + "      ]\n"
                + "    }\n"
                + "  ]\n"
                + "}");
    }

}
