package com.divit.ngoc.util;

import java.util.List;

import com.divit.ngoc.model.Block;

public class BlockChainUtil {

	/**
	 * 
	 * Any changes to the blockchain's blocks will make it invalid.
	 * 
	 * @param blockchain
	 * @param currentBlock
	 * @param previousBlock
	 * @return
	 */
	public static Boolean isChainValid(List<Block> blockchain, int difficulty) {
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');

		for (int i = 1; i < blockchain.size(); i++) {
			Block currentBlock = blockchain.get(i);
			Block previousBlock = blockchain.get(i - 1);
			if (!currentBlock.getHash().equals(calculateHash(currentBlock))) {
				System.out.println("Block does not have correct hash");
				return false;
			} else if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
				System.out.println("Block does not have correct previous hash");
				return false;
			} else if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}

	public static String calculateHash(Block block) {
		String calculatedhash = StringUtil.applySha256(
			block.getPreviousHash() 
			+ Long.toString(block.getTimeStamp()) 
			+ Integer.toString(block.getNonce()) 
			+ block.getData());
		return calculatedhash;
	}

	public static void mineBlock(Block block, int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0');
		while (!block.getHash().substring(0, difficulty).equals(target)) {
			block.incrementNonce();
			block.setHash(calculateHash(block));
		}
		System.out.println("Block Mined! Block hash: " + block.getHash());
	}
}
