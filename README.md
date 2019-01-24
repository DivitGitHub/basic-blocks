# BasicBlocks

This project shows the simple blockchain functionality. It creates a block with a digital signature (in this case our hash) and also stores the previous block hash. This also mines/validates existing blocks.

## What I've used
Java 11

Maven

Gson

## To start
Run the Application.java class

## Console after running
```
Mining block 1... 
Block Mined! Block hash: 00000bc84417f31f3935cec1bd7990ee6a709fc6aaefbd389c19dcd4861dcf37
Mining block 2... 
Block Mined! Block hash: 00000cb00fea8c785b4e13fdfb8534e2b1a52c1ad14189584e0871e0158e63cb
Mining block 3... 
Block Mined! Block hash: 0000001e1f78b4b6ffe72dafe5595f5f6fce731720caca0df5a7e2b392fdc274

Blockchain is Valid: true

The block chain: 
[
  {
    "hash": "00000bc84417f31f3935cec1bd7990ee6a709fc6aaefbd389c19dcd4861dcf37",
    "previousHash": "0",
    "data": "First block",
    "timeStamp": 1548372678401,
    "nonce": 494461
  },
  {
    "hash": "00000cb00fea8c785b4e13fdfb8534e2b1a52c1ad14189584e0871e0158e63cb",
    "previousHash": "00000bc84417f31f3935cec1bd7990ee6a709fc6aaefbd389c19dcd4861dcf37",
    "data": "Second block",
    "timeStamp": 1548372679221,
    "nonce": 214571
  },
  {
    "hash": "0000001e1f78b4b6ffe72dafe5595f5f6fce731720caca0df5a7e2b392fdc274",
    "previousHash": "00000cb00fea8c785b4e13fdfb8534e2b1a52c1ad14189584e0871e0158e63cb",
    "data": "Third block",
    "timeStamp": 1548372679563,
    "nonce": 898369
  }
]
```

### About
I created this project for fun and to allow me to explore the basic functionality of how blockchain works.
