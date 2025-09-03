import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BlockChainSimulator {
    public static void main(String[] args) {
        BlockChain.blockchain.add(new Block("Genesis Block", "0"));

        System.out.println("Mining block 1...");
        BlockChain.addBlock(new Block("First transaction", BlockChain.blockchain.get(BlockChain.blockchain.size() - 1).hash));

        System.out.println("Mining block 2...");
        BlockChain.addBlock(new Block("Second transaction", BlockChain.blockchain.get(BlockChain.blockchain.size() - 1).hash));

        System.out.println("Mining block 3...");
        BlockChain.addBlock(new Block("Third transaction", BlockChain.blockchain.get(BlockChain.blockchain.size() - 1).hash));

        // Print blockchain as JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String blockchainJson = gson.toJson(BlockChain.blockchain);
        System.out.println("\nBlockchain:\n" + blockchainJson);

        // Verify chain validity
        System.out.println("\nBlockchain valid? " + BlockChain.isChainValid());
    }
}
