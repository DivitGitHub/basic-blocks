package com.divit.ngoc;

import java.util.ArrayList;
import java.util.List;

import com.divit.ngoc.model.Block;
import com.divit.ngoc.util.BlockChainUtil;
import com.google.gson.GsonBuilder;

public class Application {

	private static List<Block> blockchain = new ArrayList<>();
	private static int difficulty = 5;

	public static void main(String[] args) {
		blockchain.add(new Block("First block", "0"));
		System.out.println("Mining block 1... ");
		BlockChainUtil.mineBlock(blockchain.get(0), difficulty);
		
		blockchain.add(new Block("Second block", blockchain.get(0).getHash()));
		System.out.println("Mining block 2... ");
		BlockChainUtil.mineBlock(blockchain.get(1), difficulty);

		blockchain.add(new Block("Third block", blockchain.get(1).getHash()));
		System.out.println("Mining block 3... ");
		BlockChainUtil.mineBlock(blockchain.get(2), difficulty);

		System.out.println("\nBlockchain is Valid: " + BlockChainUtil.isChainValid(blockchain, difficulty));

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}
}
