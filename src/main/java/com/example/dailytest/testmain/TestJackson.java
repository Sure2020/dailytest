package com.example.dailytest.testmain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestJackson {
    public static void main(String[] args) throws JsonProcessingException {
        testJackson();
    }
    public static void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root1 = mapper.createObjectNode();

        root1.put("nodekey1", 1);
        root1.put("nodekey2", 2);

        System.out.println(root1.toString());

        //Create the root node
        ObjectNode root = mapper.createObjectNode();
        //Create a child node
        ObjectNode node1 = mapper.createObjectNode();
        node1.put("nodekey1", 1);
        node1.put("nodekey2", 2);
        //Bind the child nodes
        root.put("child", node1);
        //Array of nodes
        ArrayNode arrayNode = mapper.createArrayNode();
        arrayNode.add(node1);
        arrayNode.add(1);
        //Bind array node
        root.put("arraynode", arrayNode);

        System.out.println(mapper.toString());
        System.out.println(mapper.writeValueAsString(root));
        // 得到的输出信息
        // {"child":{"nodekey1":1,"nodekey2":2},"arraynode":[{"nodekey1":1,"nodekey2":2},1]}
    }

}
