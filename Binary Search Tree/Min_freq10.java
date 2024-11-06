import java.io.*;

public class Min_freq10 {

  public class bst_String {

    class Node {
      String key;
      Integer value;
      Node left;
      Node right;

      Node(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
      }
    }

    Node root;

    bst_String()
    {
      this.root = null;
    }

    public Integer get(String key) {
      return get(root, key);
    }

    private Integer get(Node x, String key) {
      if (x == null)
        return null;

      int c = key.compareTo(x.key);
      if (c == 0)
        return x.value;
      else if (c < 0)
        return get(x.left, key);
      else
        return get(x.right, key);
    }

    public void put(String key, Integer value) {
      root = put(root, key, value);
    }

    private Node put(Node x, String key, Integer value) {
      if (x == null)
        return new Node(key, value);

      int c = key.compareTo(x.key);
      if (c == 0)
        x.value = value;
      else if (c < 0)
        x.left = put(x.left, key, value);
      else
        x.right = put(x.right, key, value);

      return x;
    }
  }

  public static void main(String[] args) throws IOException {

    // https://introcs.cs.princeton.edu/java/data/leipzig/leipzig1m.txt
    FileReader fileReader = new FileReader("leipzig1m.txt");
    BufferedReader br = new BufferedReader(fileReader);
    Integer maxCount = 0;
    String hFreqWord = "";
    Min_freq10 main = new Min_freq10();
    bst_String bst = main.new bst_String();

    while (br.ready()) {
      String line = br.readLine();
      String[] words = line.split(" ");

      for (String word : words) {
        if (word.length() < 10)
          continue;

        Integer count = bst.get(word);
        if (count != null) {
          bst.put(word, count + 1);
          if (count + 1 > maxCount) {
            maxCount = count + 1;
            hFreqWord = word;
          }
        } else {
          bst.put(word, 1);
        }
      }
    }
    System.out.println(hFreqWord + " " + maxCount);
    br.close();
  }
}
