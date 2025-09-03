import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BlockChainSimulator {
    public static void main(String[] args) {
        // Genesis Block
        Block genesisBlock = new Block("0");
        genesisBlock.addTransaction(new Transaction("System", "Alice", 50));
        BlockChain.addBlock(genesisBlock);

        System.out.println("Mining block 1...");
        Block block1 = new Block(BlockChain.blockchain.get(BlockChain.blockchain.size()-1).hash);
        block1.addTransaction(new Transaction("Alice", "Bob", 10));
        block1.addTransaction(new Transaction("Bob", "Charlie", 5));
        BlockChain.addBlock(block1);

        System.out.println("Mining block 2...");
        Block block2 = new Block(BlockChain.blockchain.get(BlockChain.blockchain.size()-1).hash);
        block2.addTransaction(new Transaction("Charlie", "Alice", 2));
        block2.addTransaction(new Transaction("Alice", "David", 20));
        BlockChain.addBlock(block2);

        // Print blockchain as JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String blockchainJson = gson.toJson(BlockChain.blockchain);
        System.out.println("\nBlockchain:\n" + blockchainJson);

        // Verify chain validity
        System.out.println("\nBlockchain valid? " + BlockChain.isChainValid());
    }
}
