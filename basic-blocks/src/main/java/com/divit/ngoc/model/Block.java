package com.divit.ngoc.model;

import java.util.Date;

import com.divit.ngoc.util.BlockChainUtil;

public class Block {

	private String hash;
	private String previousHash;
	private String data;
	private long timeStamp;
	private int nonce = 0;

	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = BlockChainUtil.calculateHash(this);
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public int getNonce() {
		return nonce;
	}

	public String getData() {
		return data;
	}

	public void incrementNonce() {
		nonce++;
	}

}
