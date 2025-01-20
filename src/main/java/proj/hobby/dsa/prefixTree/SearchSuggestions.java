package proj.hobby.dsa.prefixTree;

import java.util.*;

/**
 * https://leetcode.com/problems/search-suggestions-system/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Search suggestions System
 *
 */
public class SearchSuggestions {

    private TrieNode root;
    private static final int MAX_SUGGESTIONS = 3;
    private static final int MAX_EDGE_SIZE = 26;

    public SearchSuggestions() {
        root =  new TrieNode();
    }

    /**
     *  Complexity:
     *   Time: O(N) -  N is length of Word
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            TrieNode next = node.children[index];
            if(next == null) {
                next = new TrieNode();
                node.children[index] = next;
            }
            node = next;
        }
        node.isWord = true;
    }

    /**
     * suggest products at a given TrieNode using dfs
     *
     * Complexity:
     *  Time: O(N) N is number of child TrieNodes of the given node (proportional to products)
     *  Space: O(1)
     *
     * @param node
     * @param sb
     * @param result
     */
    public void suggestedProducts(TrieNode node, StringBuilder sb, List<String> result) {
        if(result.size() == MAX_SUGGESTIONS) { // check to see if we reached MAX_SUGGESTIONS
            return;
        }
        if(node.isWord) result.add(sb.toString());// add current node's word
        for(int i =0 ; i < MAX_EDGE_SIZE; i++) {// traverse edges for words
            TrieNode temp = node.children[i];
            if(temp != null) {
                char c = (char) ('a'+i);
                sb.append(c);
                suggestedProducts(temp, sb, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    /**
     * Suggests at most three product names from products after each character of searchWord is typed.
     * Suggested products should have common prefix with searchWord. If there are more than three products
     * with a common prefix return the three lexicographically minimums products.
     *
     * Complexity:
     * Insertion:
     *  Time: O(N*L) N is number of Products and L is average length of product
     *
     * Search:
     *  Time: O(L*N) L is length of search Word and N is number of Products
     *  Space: O(L)
     *
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(String product : products) {
            insert(product);
        }
        TrieNode node = root;
        List<List<String>> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c: searchWord.toCharArray()) {
            List<String> result = new ArrayList<>();
            if(node != null) {
                int index = c - 'a';
                node = node.children[index];
                if(node != null) {
                    sb.append(c);
                    suggestedProducts(node, sb, result);
                }
            }
            results.add(result);
        }
        return results;
    }

    /**
     * TrieNode represents a Node in Trie data structure
     */
    class TrieNode {
        private boolean isWord;
        private TrieNode[] children;

        TrieNode(){
            children = new TrieNode[MAX_EDGE_SIZE];
        }
    }

    public static void main(String[] args) {
        SearchSuggestions sug = new SearchSuggestions();
        String[] products = Arrays.asList("mobile","mouse","moneypot","monitor","mousepad").toArray(new String[0]);
        List<List<String>> suggestions = sug.suggestedProducts(products, "mouse");
        System.out.println("Suggestions: "+suggestions);
        suggestions = sug.suggestedProducts(products, "mound");
        System.out.println("Suggestions: "+suggestions);
        suggestions = sug.suggestedProducts(products, "mat");
        System.out.println("Suggestions: "+suggestions);
        suggestions = sug.suggestedProducts(products, "cat");
        System.out.println("Suggestions: "+suggestions);

        products = Arrays.asList("bannana").toArray(new String[0]);
        suggestions = sug.suggestedProducts(products,"bannana");
        System.out.println("Suggestions: "+suggestions);

        products = Arrays.asList("").toArray(new String[0]);
        suggestions = sug.suggestedProducts(products,"kite");
        System.out.println("Suggestions: "+suggestions);

        products = Arrays.asList("ilpxatcgvfbmfunpljkodnbfaowi",
                "ilpsokmmniywxgbeqrpsaqeqn",
                "talrnwemajlqicbkxjyf",
                "sbqhbuvkvntmsutdpyavojqwinxofhvhecbtjjkwdkaazftxvgvicgio",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiameutvrtqwucjp",
                "l",
                "ilpxywtmdnlil",
                "rnjutrkyojwumoyrgzx",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyrhxnvfqsuymujmvkwctobnuvrusbqt",
                "ilpxatcgvfblxfvbnoxgmmpvqqvxqyuecwpbjtlzwmmcwspztjjxevjpxdnzcectypljpkjoilnvur",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdkwrfizkvef",
                "ffngjbmfkxtstjbzalnutfiybfy",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaipwtaovnfhuzu",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuamwsmzfbbtgnfsbujeotpndobpdg",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbl",
                "ilpxatcfeexjqxghbengdcvsljajqaxidzitqjfjpovxmijvofntfelqidcbekzecqodiralswkjqckrpz",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrklmagbqeadtwhndgodzgfejjcs",
                "hp",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxovkmfvxdiuceqbvczetytkfvcfykt",
                "ktihatqubvuvnszewdlcyfqclgwhwsrawtcpdvxwhmvaftzkrvu",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexgkoeppszhfbajvcxuaplxeobzyqe",
                "ilpxatcgvfblxfvbnoxgmmpvdxthphkvtcfhpevifbuzgcmxqjvtukbgeppeaufwgjbdfppxwszavitpctqthp",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqzxnhaplrwcgwjkr",
                "ilpxatcgvfkvqfnblpdvtesdandbeynurlcjwwrellxigbsfjccihrvfbsbtcscblctnzededcajrywkj",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypexgkrbzdzmsbimuycjfk",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirysflyamgemsnjibnfxbke",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetvkcqmhquleujnmi",
                "edmasudelavobnlbrj",
                "zgjrwqhoqvmaaasqmggcuahifrwwrfrtpvchkuvncpvugmizhpfiokijxwlssapntpecbdgwteqvfdzwu",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedopz",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwhchcgi",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdtdvk",
                "lnpadggtvd",
                "xbnfiostesudukxgghwolzawxqlovbnjweddrqcisujmuhsazvetxrsyqdaidrmfomwmanghqn",
                "zgmmrzerbzujlgomosxmgihordwpzvbnywczhosikslzlaqfyqnrjfbqzqwvihzojyzswbdxczknclmuyhdc",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamclkswqd",
                "gdqdyysurpvmakyesqoeipuvxlhnffgemhvswyvkbgatxuufhbuitjwnvvigwfweiordqdhtnzagjputzale",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnr",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaxcp",
                "ilpxatcgvfblxfvbnoxgmmkmnlolyewtuuosejmgconmcjep",
                "ilpxatcgvfblxfvbnoxgmmpvimowocjrj",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccbsqkdevdkizvlnrl",
                "wyeisnjhrhossmnpnexjqbkcsorccgawfgifsmwfdqqadgqdgpfoiagyxperbshwzbnoqqyjr",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcmsdqhbizk",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdqlhdjfflb",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxiedjqmul",
                "tzkwqsmwdhczbqnimbzgguyqvtywcyzkqhnkdtknumpuikfexldysotnndztwootn",
                "ilpxatcsfwrpusskcsmzunvejmfymcvs",
                "usoaljtodfybvquycywtnvivvdvbvymivvc",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiobdewutljgvugibawjskriuxeiwishfimbsinzt",
                "orrcvinutuqbzlaxrfhsbpjoonsjrubyrbbdghhqnwjz",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqncvydjmnouqktixtgjtvkmwciiuso",
                "jponpctybxuxtnigdqortyqjiobgdaehgybozbtvxalhyubibburfsjukhalynnkvjr",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofpsbqljapaqco",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaegtshdqrhtimpvnbymwrlmvghl",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxgcyqcrmwlrjlbnqqfuhypqgiurkyapxzrdsnbeifik",
                "ilpxatcgvfblxfvbnoxgmmiiubtvodpzwgdgoobsbbnlfjldpqydwejvfysrwhmhg",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqp",
                "dpwgvxdrbzlh",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpufytsqrkyhiehtjkgohchjkmxcx",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiiwstxiirty",
                "irjbjafrvdcpqanwt",
                "ilpxatcgvn",
                "ilpxatcgvfblxfvbnoxuherdhypducgxsuftiappkjfcqvorxizvdlgswfrqveuhlzitltnushzs",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrypwuijbjublekmxhchhnaxbhbgdaqifvdrfvheqiqcswrskd",
                "ilpxatcgvtqdvgovjgabbmkdicgymudbikvhihpxfmpanjyp",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamiuzrrvibhkwigjgrqfhn",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlym",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqismi",
                "jtbuygbbtdyasdtcuswpbquuhswfciyndfton",
                "ilpxxishsvmt",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvfgdtlfrwklzcwqmbmefnxwrtkpak",
                "ilpxatcgvfblxfvbnoxgmmpvimowoumiglwjrzletaydenogpldiblrwpyjeqjeow",
                "hlwga",
                "ilpxatcgvfblxfvbnjyryxxfayspcrqkvyopfzspzmmhhalwjvfhsgybgkzctlqtr",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofewrprmowynq",
                "qyuthohyzttitkgfrfybiuuvzzcqbddrbby",
                "uinnxgnuuptrxhbhplcdklstqbamsxwaeubppeutqlgngtgzycxpcqjabucoi",
                "ilpxatcgvfblxfvrpbuumlvymcimuothjdhlsgenxxcllwfibvvcavuiuesgdjhsgoxjzechjhwnprmut",
                "btrvkwzfdovyyycfxwmxhutvldkblvrsmeyktlwnmdmdepjnkrzkmnerxesvycbrpghnf",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycltcndobbsywuhxohkzostnacjyhj",
                "dijc",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdednjkkgwtekjv",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcwqxooniui",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyuhbnoibkpmygmul",
                "potullxiksrpnhngusckddvrtylgwztzxmmgvtrlbgwkgbgohsgbljroghmpwrwupszmkv",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoqpodgpsgmlj",
                "ryfoisftsawa",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqexqy",
                "fzvfyiqrwbserbdnnymmcaokpasfpijvbwdxnbctzekkgcudayqlnsclgcxkaeslihczwxphyqbdyxthpuprxjb",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpvoltdohcmslq",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdeyozknywbktmyzkm",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqlc",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypsan",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiarrqyflykjdwvnvicearpou",
                "yfilpbgdkfmphopolcvjbemkpqcqvcxdkkolpwgco",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztckwzvayxyzaqpm",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywb",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaisnakhppbhnofpnuns",
                "khdyqeswcmriitjysdj",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpnupiwbdseowsrurzjiscnitdqncuyzxvkuiskezqy",
                "ilpxatcgvfovxvhriwhgpadztzfcdfgnhktkhqhjiueszhzjpmxrzfgccxovsqxo",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnvncgupn",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetabyivtjxivaraiwg",
                "zvtcdlbjbnlnadytwqwrnbjomdlmmujvwpmazwbjwippucsujioeevltrrdfivkamxgjtrqckuflvpnbsbrhda",
                "apkqpncsbbiqstfxplizqbpriqywwjiwquzpfyhwyxfcucwcs",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetjoolenqclkstqazwb",
                "bjvozgbmtqdxyfirqwhebtijcwrebvdkxtxoahqsjtofybvh",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukfuxkg",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycqgxdkpnisqsfzlkmnpstbd",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrwh",
                "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkygsrgv"
                ).toArray(new String[0]);
        suggestions = sug.suggestedProducts(products,"ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywrywcjmtvaleckwduejlayguredkubbcqhtiafhcsmlgdmpcdouxdyxykmujehtpkjqfbrbyehjcnymgumqwbfouubonhzhvssjmpudpvjtdlurkbwyahtclafjaztcdxstgpsvhbbyndqhfkyycxnrvitcasubhnaeolgmmmedgzqtpjjhtlkwqcnjgwehbriwiklwniobbzhegbisgwccvstmdqyneolakaakrnzhmczxdoxhelbezsggbrzlzrrecyvzvrteofqopamraasigegtovcspphlpmsxsfkouohlwdvgrttzltyojunyvmlmhjjihubmkkbrvsbbdiejimobknxcwntoaqltofqopslhzobiuqhlxivctogflejhdlulda");
        System.out.println("Suggestions: "+suggestions);
    }
}
