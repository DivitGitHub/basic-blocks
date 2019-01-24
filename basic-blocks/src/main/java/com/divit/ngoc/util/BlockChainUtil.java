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
			if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				return false;
			} else if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
				return false;
			} else if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
				// check if hash is solved
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
}