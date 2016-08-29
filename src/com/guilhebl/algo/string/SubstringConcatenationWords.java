package com.guilhebl.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 */
public class SubstringConcatenationWords {
	
	public static void main(String[] args) {
		SubstringConcatenationWords s = new SubstringConcatenationWords();
		
//		String st1 = "barfoothefoobarman";
//		String[] sts = {"foo","bar"};		
//		printList(s.findSubstring(st1, sts));
//		System.out.println("\n");
		
//		String s2 = "wordgoodgoodgoodbestword";
//		String[] w2 = {"word","good","best","good"};
//		printList(s.findSubstring(s2, w2));
//		System.out.println("\n");
//		
//		String s2a = "a";
//		String[] w2a = {"a"};
//		printList(s.findSubstring(s2a, w2a));
//		System.out.println("\n");
//		
//		String s2b = "aaaaaaaa";
//		String[] w2b = {"aa","aa","aa"};
//		printList(s.findSubstring(s2b, w2b));
//		System.out.println("\n");
//		
//		String s2c = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//		String[] w2c = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
//		printList(s.findSubstring(s2c, w2c));
//		System.out.println("\n ************** \n");
//		
//		String s3 = "amxbtipvhwzyytfnekijzdvutiweyhcyvbbqjqosonrmiwcoikxjpsfiacpbltbjudbfvpxkfqypoaeykbibwpkyrbzfubqqgrvbhunonmdbmhazlkahbmftnfajiqbohwpqtdegpkjdtlcevfnxttsjausikuytsnklsqtjcdnworcmyslsndbpzvzjrxekmqxfhrqlwfjkxowxgjptmsilqhwhebtsrtxakqoivxsulrsrajmpewcufbbjexexqbaarokplejzxbsanfprdtljwoualyybcydvonkzsuapxtpkagddcomydhbqfbsjzvfplpodlrujkkvkszpupcvulwlsxdcyahnlydqkulvexqqprgmhkhdvdopatrawanhzqajnletkwmzoslxeuazxrozkiziimqhfqqudwnntzojtcgzwiywzpvmzxuhjmrqejmjgaybbnkxrqwpaxlaojongkwrxnkdxwnfylgaaqztivjiuwkihaxnluhkjrninanoovoonpixmtghpsrzvrmgnvqwmfhcguqusgkfvsdhnlqdfkcabqiooamagteoqwiieupzpsjcfbhlllnmcwcswpseizsyvcgaxwbmqmoyqwlbjyqnwsfvhyzqzsowuxyrvafnouleswibxyptswoauqsviiscfqwcsbqhxbnravvxvksoghodziahqslyljaflsokwccwzxtvjnjrwzwvhxczrqxezakmsyxoabkcyfxjtiaphznqyppphnwhngtheswhtijtqiclqfcxepnchctorpvgxroejmlfwwymebzwgctmtiqcmlrebokahaetmryjnwxtzzphdktwulzhxsnaizaqafjowhxmfxhfwzmzlixgtwnqqcszbtrbaaqyjpkomuvktijgqhmlfbeydwzfrqirsaqbqcreynptxaapjmarogptdoawgjoyjgzbksgjhxcexcthpwyfcpahfbelmujvckzmcfvkcyqbckktikamzbweecpqwanakmmnrizvipxmbjglugytjwanyrdwsrwcdirxsqucitpldvxxdxqntscrkgnczjgctybmqwqarfmucjriikvbczsofhqeszjlxkzpiqqavewapoixafyeeqtkzlqrkzchmczwupypvvrklzhlefrlxkxwwnpgprqdvpbpgchbxynkyuxeborazoyxendvgvackbtsdavczimzclffaxfbndyrqdozzoblqwgvxbyykmzoyguafbbtfbmxgbwhpzthwbdvcdtopudnazngaqbfrnfaqdhidcpbdswgvrunnzapyqvziygcmlcerjmuocxrwvzuowhbvjqubovkmbmapofgzrcnvbhswgokcvnagfwitr";
//		String[] w3 = {"odlrujkkvkszpupcvulw","ybcydvonkzsuapxtpkag","lsxdcyahnlydqkulvexq","bjyqnwsfvhyzqzsowuxy","hzqajnletk"};
//	 	printList(s.findSubstring(s3, w3));

//		String s3b = "mississippi";
//		String[] w3b = {"is"};
		
//		String s4 = "mississippi";
//		String[] w4 = {"si","is"};		
//	 	printList(s.findSubstring(s4, w4));

		Long initTime = System.currentTimeMillis();

//		String s5 = "lxiceyvyuodxgsszjyqhoqbmoaevrooclwgrxdrrsvqynixyiqfxijjwjnradgfqelidpzujwmhjxhhfzpehypehfxkifrbkelnvmkejyosvxcdwrhdpxjyejkmodpyiaofnamyyaqwxuzvliychkdltnahtpibsyihyufyuxutsvofepklbnxuczdvqnyiljrldwmawgtoekvizfvauuwxtzuknvuaemohkajgidwmpswqzsqumotipnsekofoatynthtdmqqbkmrjejftxybpovtalypmtpzowuslmimwwgidppwpqzeguxgfyxttmuijraudkicgomjgbhxrgbxcaekabfuoceztgvyqdayumkaorxhaafcclofoubeyffrlardgsdagncwhbehdllhycmmynrwswnfzekfyohhbldkojrtufashphfcabxyqezwpgxfpegahtqrklnrmiadrfhrieralrzaxwhncnpliievtsmhcnktusmfydfjwgluesjgiyuqgylasajunupjodomjwyfcjzjeirojlepksrcsbzhxqsluhzdfxkjjmsnukbfxhxhzomtrncodvbzebejapujbpwxbzdyhaiiquciheymzcmffsofhlpkanibnnbwnjefdipmpqbospuxhkervtbxhjawycsnlytrhifwagmsvirfvwwsrxqajswhuqvirqbaygybpktmvnrslnkencfyvdfrucbnscntlluaxpmsegkrvxwibdgwgoqcsrpnwcghpcjntxhadurzrpjsssrzghdaavnwxvdpzoctmjtpdmqwcapwuixapbcrwqovltkniogwybldpeatgrqazpcqsehowxmiryxbndxngkqxqqrwhjwiyayrfghbfvlyuizjnywvlmtbfmymxwvxxvqedafjvthrbjarhwmslhwqvwessbqrxivaidjewtvzcyqlwfghmcxiyccsdukcdhdlkorghnilnyxjdfrshqahuebazlccvfpfwhofwwrjwqsavjsecunwyowzazdxgteecskyqbhntbponhupdhldvkdxjgurbzwdtgbmjkzcmqszxmqcvbfsliqwrmqunmyjubvfowhambblprnkuucifueyjwswisheucjiaskotnzieoualxiqtpoclibwbiaxnmhnercagdkkufmfevxzmncxvdtynwvaicoovsqbxbntiaaoxxnjmpgiucgiaeikgyyesrfquvjcvmsujfdwxlgrpmbpsmzzkaffrkxlfipcuhweobclnifcwguputqftvmmhjzprotmxssmtuxieencnhthcjoygakojkfbaypyqhmmdjwjojlbqfkvqztzzdpjpumsubsnkezpnvydhlgzqrujsnirtzaktoeprwcdadsqbsvieehwxefptpgoojzjxdzrcbucfpsihoqluzkrfpgzhmnxxohxuiowlkyqztajjqwdsguxyayfooemcnjwvzuhjvzloauxsqckxw";
//		String[] w5 = { "gbmjkzcmqszxmqcvbfsliqw", "obclnifcwguputqftvmmhjz", "iaxnmhnercagdkkufmfevxz",
//				"oygakojkfbaypyqhmmdjwjo", "kuucifueyjwswisheucjias", "ponhupdhldvkdxjgurbzwdt",
//				"fptpgoojzjxdzrcbucfpsih", "kotnzieoualxiqtpoclibwb", "lkyqztajjqwdsguxyayfooe",
//				"ghmcxiyccsdukcdhdlkorgh", "yesrfquvjcvmsujfdwxlgrp", "wyowzazdxgteecskyqbhntb",
//				"mbpsmzzkaffrkxlfipcuhwe", "oqluzkrfpgzhmnxxohxuiow", "mncxvdtynwvaicoovsqbxbn",
//				"ktoeprwcdadsqbsvieehwxe", "protmxssmtuxieencnhthcj", "dafjvthrbjarhwmslhwqvwe",
//				"kezpnvydhlgzqrujsnirtza", "rmqunmyjubvfowhambblprn", "izjnywvlmtbfmymxwvxxvqe",
//				"nilnyxjdfrshqahuebazlcc", "tiaaoxxnjmpgiucgiaeikgy", "ssbqrxivaidjewtvzcyqlwf",
//				"vfpfwhofwwrjwqsavjsecun", "jlbqfkvqztzzdpjpumsubsn" };
//		

//		String s5 = "peeqlxgobnhansuuviwgxykugyeflcaahhqueyihorhdjdyhlunksyfbyjijllluueoycyhspowztugeqvqltvmtgwcshqobufbwdirtynurjaxzxoktlymsvrmehagbfhzjsqesfykoajoxzaqlzddwupadpgexqdikwmcbmosmyglxgckhhnddeegummterbonnrrzfjnfpyfxcpfjfkojowddiyhazwnmngnupaagzfebwlnbvdlmaqpipwkosadhgqcwrccshivdtihrmsdoisyzojojjtqpjsncwsufaslwasnokseukduamklxdcmmwcrvunawflugdhwpzbklggosqzpvddhchaxdoxatjuboeaefdqrjwfbogsjkxsmftlijiictfgilgoqjghseovsxndhkxvpsgabqkempkwasktbsctwroqqdvxnsuflcfmursghecjwmezghscyiuolpnbijivnphhgcopgqbfffelmzqmhkcvcrymaihnxqxdslvbdwgidkwqloctahqcyqozyxovqlaiyxlctrmxeippwtkxacbzusasrqphesqcpdelxrkbbbsaufzvjaweuyymoqtsklvbpbmmuypyzjywqxtczpgwngkdydwirtkiwywrznpawpwpoprpgzltfvxgbvouoackbadanucljzcxqtpxsasayribowvezzpabucopebadeawzpvurnuphcqvanazorbpndfcihdnnfjmueglucdbgvyhlaizrkpfpujxdolqtwfpbndvqgywdwfoxqqqcfxrbjrhxeztaeibulyktwizvqnugdmkkmbovsvswulzbwavjbhfzpeuhrqpxfzjrbxmvueursvuqvpzyyeypiuxclmbqmkjpkvmgbixtdrjbilbipzyawxejjfbxrkodfdkgnjctbnwlyxuqzuqvrwecbfcupqyuvicjtecwsaisxeiwaatrwxtzcvutospjcsuvyyssyclwivuiwobunwusuqlikbtovoltodmnhzlrufzsvanjzjbtboblrwzmmkibqwqzvbrriskevzpuksnlgqwamxobjwcbuubrvsjdmvjhuybesopbgnbtmpuvoyxkuacpunugieocerixgzymobhaqdxgdwrxwtoqgjxonnsrecqmbqzrririoqqrnhrjafaiozydmsxqundxeeovohfcywwnfpwguyqlxroljlegbjffpwcddkidggqlvptrnmcndtyogewhneocatifdsllabyvssoggtvlmvbuaycneqselcjowuzwyyrqshyaatlormjrmlgqdawpcifyefwefnxxxvxxrkoiyxbnkjfpkcgokmpqtlvybsxynuxggl";
//		String[] w5 = { "vbpbmmuypyzjywqxtczpgw", "ngkdydwirtkiwywrznpawp", "evzpuksnlgqwamxobjwcbu",
//				"oblrwzmmkibqwqzvbrrisk", "dvqgywdwfoxqqqcfxrbjrh", "zcvutospjcsuvyyssyclwi", "qqrnhrjafaiozydmsxqund",
//				"qgjxonnsrecqmbqzrririo", "pkvmgbixtdrjbilbipzyaw", "laizrkpfpujxdolqtwfpbn", "ubrvsjdmvjhuybesopbgnb",
//				"zpvurnuphcqvanazorbpnd", "lyxuqzuqvrwecbfcupqyuv", "tmpuvoyxkuacpunugieoce", "xejjfbxrkodfdkgnjctbnw",
//				"wpoprpgzltfvxgbvouoack", "ibowvezzpabucopebadeaw", "zpeuhrqpxfzjrbxmvueurs", "badanucljzcxqtpxsasayr",
//				"rixgzymobhaqdxgdwrxwto", "todmnhzlrufzsvanjzjbtb", "fcihdnnfjmueglucdbgvyh", "icjtecwsaisxeiwaatrwxt",
//				"vuiwobunwusuqlikbtovol", "bbsaufzvjaweuyymoqtskl", "xeztaeibulyktwizvqnugd", "vuqvpzyyeypiuxclmbqmkj",
//				"mkkmbovsvswulzbwavjbhf" };
		
		
//		String s5 = "ejwwmybnorgshugzmoxopwuvshlcwasclobxmckcvtxfndeztdqiakfusswqsovdfwatanwxgtctyjvsmlcoxijrahivwfybbbudosawnfpmomgczirzscqvlaqhfqkithlhbodptvdhjljltckogcjsdbbktotnxgwyuapnxuwgfirbmdrvgapldsvwgqjfxggtixjhshnzphcemtzsvodygbxpriwqockyavfscvtsewyqpxlnnqnvrkmjtjbjllilinflkbfoxdhocsbpirmcbznuioevcojkdqvoraeqdlhffkwqbjsdkfxstdpxryixrdligpzldgtiqryuasxmxwgtcwsvwasngdwovxzafuixmjrobqbbnhwpdokcpfpxinlfmkfrfqrtzkhabidqszhxorzfypcjcnopzwigmbznmjnpttflsmjifknezrneedvgzfmnhoavxqksjreddpmibbodtbhzfehgluuukupjmbbvshzxyniaowdjamlfssndojyyephstlonsplrettspwepipwcjmfyvfybxiuqtkdlzqedjxxbvdsfurhedneauccrkyjfiptjfxmpxlssrkyldfriuvjranikluqtjjcoiqffdxaukagphzycvjtvwdhhxzagkevvuccxccuoccdkbboymjtimdrmerspxpktsmrwrlkvpnhqrvpdekmtpdfuxzjwpvqjjhfaupylefbvbsbhdncsshmrhxoyuejenqgjheulkxjnqkwvzznriclrbzryfaeuqkfxrbldyusoeoldpbwadhrgijeplijcvqbormrqglgmzsprtmryvkeevlthvflsvognbxfjilwkdndyzwwxgdbeqwlldyezmkopktzugxgkklimhhjqkmuaifnodtpredhqygmedtqpezboimeuyyujfjxkdmbjpizpqltvgknnlodtbhnbhjkmuhwxvzgmkhbcvvadhnssbvneecglnqxhavhvxpkjxlluilzpysjcnwguyofnhfvhaceztoiscumkhociglkvispihvyoatxcxbeqsmluixgsliatukrecgoldmzfhwkgaqzsckonjuhxdhqztjfxstjvikdrhpyjfxbjjryslfpqoiphrwfjqqhaamrjbrsiovrxmqsyxhqmritjeauwqbwtpqcqhvyyssvfknfhxvtodpzipueixdbntdfcaeatyyainfpkclbgaaqrwwzwbcjwiqzkwzfuxfclmsxpdyvfbnwxjytnaejivivriamhgqsskqhnqeurttrfrmstrbeokzhuzvbfmwywohmgogyhzpmsdemugqkspsmoppwbnwabdmiruibwznqcuczculujfiavzwynsyqxmarjkshjhxobandwyzggjibjgzyaaqxorqxbkenscbveqbaociwmqxxyzvyblypeongzrttvwqzmrccwkzidyfbxcaypyquodcpwxkstbthuvjqgialhfmgjohzoxvdaxuywfqrgmyahhtpqtazbphmfoluliznftodyguesshcacrsvutylalqrykehjuofisdookjhrljvedsywrlyccpaowjaqyfaqioesxnlkwgpbznzszyudpwrlgrdgwdyhucztsneqttsuirmjriohhgunzatyfrfzvgvptbgpwajgtysligupoqeoqxoyqtzozufvvlktnvahvsseymtpeyfvxttqosgpplkmxwgmsgtpantazppgnubmpwcdqkvhwfuvcahwibniohiqyywnuzzmxeppokxksrfwrpuzqhjgqryorwboxdauhrkxehiwaputeouwxdfoudcoagcxjcuqvenznxxnprgvhasffxtzaxpcfrcovwgrcwqptoekhmgpoywtxruxokcubekzcrqengviwbtgnzvdzrwwkqvacxwgdhffyvjldgvchoiwnfzoyvkiogisdfyjmfomcazigukqlumyzmnzjzhzfpslwsukykwckvktswjdqxdrlsqvsxwxpqkljeyjpulbswwmuhplfueqnvnhukgjarxlxvwmriqjgmxawmndhsvwnjdjvjtxcsjapfogpesxtpypenunfpjuyoevzztctecilqqbxkaqcyhiobvtqgqruumvvhxolbyzsqcrdchhdqprtkkjsccowrjtyjjmkhleanvfpemuublnnyzfabtxsestncfalqenfcswgerbfcqsapzdtscnzugmwlmidtxkvqhbuaecevwhmwkfqmvpgbefpqpsjmdecmixmmbsjxzwvjdmxydechlraajjmoqpcyoqmrjwoiumuzatydzcnktnkeyztoqvogodxxznhvzduzxudwwqhpftwdspuimioanlzobhjakgajafgzxpqckmhdbbnqmcszpuoqbztnftzgahhxwxbgkilnmzfydyxusnnvngksbjabqjaohdvrniezhmxmkxhemwbbclwdxwgngicplzgajmaryzfkyoqlkrmmfirchzrphveuwmvgaxzbwenvteifxuuefnimnadwxhruvoavlzyhfmeasmgrjawongccgfbgoualiaivbhcgvjjnxpggrewglalthmzvgziobrjeanlvyukwlscexbkibvdjhdgnepdiimmkcxhattwglbkicvsfswocbvphmtpwhcgjbnmxgidtlqcnnwtfujhvgzdussqbwynylzvtjapvqtidpdjkpshvrmqlhindhabubyokzdfrwqvnvgzkyhistydagsgnujiviyijdnabfxqbdqnexvwsvzvcsbrmkbkuzsdehghndyqjodnnblfwmaygdstotfkvxozgwhtbhlkvrzismnozqpfthajafuxekzlgigjpsukjvsdihrjzgovnreqwapdkoqswyclqyvbvpedzyoyedvuuamscbxnqnfmmjyehvidnoimmxmtcinwkbqmcobubjjpshucechrqrffqsyscnqoohcsxenypyqhfklloudgmklcejvgynwouzhtfwuuukdbwpmkjrqxeeaipxrokncholathupdetgaktmvmftqjvzyssocftjwemroghrncynmtchhhcaqxbqpthuaafwgrouaxonzocljeuslzsdwvuoodipdpnlhdihaywzmymxdjrqikughquwtenyucjdgrmipiidiwclhuepgyynoslhzahtdqwliktzsddaahohbszhqxxgripqlwlomjbwtuynydoakejmwkvojuwbfltqjfgxqhwkduzbxpdhtpvrzrfjndmsqfizmqxdxtpbpoemekvxzrrakwjxcxqsdasptruqmjtbaapgmkfnbwnlvzlxwdpzfjryanrmzmpzoefapmnsjdgecrdywsabctaegttffigupnwgakylngrrxurtotxqmzxvsqazajvrwsxyeyjteakeudzjxwbjvagnsjntskmocmpgkybqbnwvrwgoskzqkgffpsyhfmxhymqinrbohxlytsmoeleqrjvievpjipsgdkrqeuglrsjnmvdsihicsgkybcjltcswolpsfxdypmlbjotuxewskisnmczfgreuevnjssjifvlqlhkllifxrxkdbjlhcpegmtrelbosyajljvwwedtxbdccpnmreqaqjrxwulpunagwxesbilalrdniqbzxrbpcvmzpyqklsskpwctgqtrjwhrpisocwderqfiqxsdpkphjsapkvhvsqojyixaechvuoemmyqdlfkuzmlliugckuljfkljoshjhlvvlnywvjswvekfyqhjnsusefdtakejxbejrchoncklguqgnyrcslwztbstmycjziuskegagtlonducdogwbevugppsptdqbajmepmmizaycwcgmjeopbivsyphtvxvvgjbyxpgwpganjiaumojpyhhywosrmnouwpstgbrvhtlqcnmqbygbfnabesvshjmdbhyhirfrkqkmfwdgujhzyjdcbyuijjnkqluaczrnrbbwaeeupnwqzbsazplkyaxqorqsshhlljjlpphhedxdepgfgrqerpuhgmaawhnhqwsgnznrfmxjbdrkwjopylxezxgvetcvrwdewsxdeumhzfrvoilmvksuhyqltuimrnsphqslmgvmmojawwptghonigbdclqtbikiacwpjrbxhmzejozpypfixglatdvuogdoizdtsgsztsfcihtgwyqugeuahpuvvzmgarbsyuutmbxuisdfrvbxzxzhmuektssuktoknkfbmcwwubbnwenybmfqglaceuyqnoadzfenjcjfdlvcpiatuhjdujhaffqsvqvuxchgerokejovrqonxxstibunikiedfyahijobxyhimebctobsjudkqstbcxgixgrhpfiofpwruzvpqyjzvollheoldutddnksutjakhtghpxxnjykxjwgqmsvhnykclexepxqxqzghwfxfdhfmflesfabvanxlrurjtigkjotftqnwyskffpxlragrnfffawqtgyfpmzxfpkdpenxlewyxxgrkmwrmshhzfnorolyfxbvdrspxqnxnuoygkruczddgssygfymdcjgvdxutlrhffhnpyjuxmxefrelxezcgikdliyhvpocvvpkvagvmezrxffujeysplvavtjqjxsgujqsjznxforctwzecxyrkwufpdxadrgzczrnyelfschnagucguuqqqwitviynrypsrdswqxqsegulcwrwsjnihxedfcqychqumiscfkwmqqxunqrfbgqjdwmkyelbldxympctbzfupeocwhkypchuyvhybsbmvymjppfrqmlfrbkpjwpyyytytawuuyjrwxboogfessmltwdcssdqtwomymjskujjtmxiueopwacrwfuqazitvyhvlspvoaeipdsjhgyfjbxhityisidnhlksfznubucqxwaheamndjxmcxwufajmnveuwuoyosqnoqwvtjkwuhkzghvmjhawcfszbhzrbpgsidnbmxxihihnrfbamcyojqpkzodbejtmmipahojoysepzhpljpaugrghgjimtdahnpivdtlcnptnxjyiaafislqavamqgmxtdfoiaakorebqpbbpegawrqymqkewycsdjglkiwaacdqterkixkgraedtqirqmjtvsfhadhafktyrmkzmvidxmisfskvevpcnujqxrqedleuyowkjgphsxzzqlvujkwwgiodbfjesnbsbzcnftuzrvzjjudsgcqmmfpnmyrenuxotbbyvxyovzxgtcyzgqnsvcfhczoptnfnojnlinbfmylhdlijcvcxzjhdixuckaralemvsnbgooorayceuedtomzyjtctvtwgyiesxhynvogxnjdjphcftbefxgasawzagfugmuthjahylkhatlgpnkuksuesrduxkodwjzgubpsmzzmvkskzeglxaqrrvmrgcwcnvkhwzbibaxwnriowoavosminabvfxastkcrkdclgzjvqrjofjjvbyfragofeoazzeqljuypthkmywaffmcjkickqqsuhsviyovhitxeajqahshpejaqtcdkuvgdpclnsguabtgbfwdmrmbvydorfrbcokfdmtsgboidkpgpnmdeyhawkqqshtwxdbarwuxykgduxjlkxppwyruihkcqgynjcpbylayvgdqfpbqmshksyfbhrfxxemhgbkgmkhjtkzyzdqmxxwqvdtevyducpdksntgyaqtkrrkwiyuhukfadjvdnrievszilfinxbyrvknfihmetreydbcstkwoexwsfhfekfvfplmxszcosgovisnbemrjlndqwkvhqsofdbdychmupcsxvhazvrihhnxfyumonbvqeyoghccxfuwacxzxqkezxefxarnnujgyjugrzjoefmghjfhcrnbrtgouaehwnnxwkdplodpuqxdbemfwahptpfppjzowoltyqijfoabgzejerpatwponuefgdtcrgxswiddygeeflpjeelzccnsztxfyqhqyhkuppapvgvdtkmxraytcolbhkiiasaazkvqzvfxbaaxkoudovxrjkusxdazxaawmvoostlvvnsfbpjqkijvudpriqrfsrdfortimgdhtypunakzituezjyhbrpuksbamuiycngvlvpyvczfxvlwhjgicvempfobbwadkiavdswyuxdttoqaaykctprkwfmyeodowglzyjzuhencufcwdobydslazxadnftllhmjslfbrtdlahkgwlebdpdeofidldoymakfnpgekmsltcrrnxvspywfggjrmxryybdltmsfykstmlnzjitaipfoyohkmzimcozxardydxtpjgquoluzbznzqvlewtqyhryjldjoadgjlyfckzbnbootlzxhupieggntjxilcqxnocpyesnhjbauaxcvmkzusmodlyonoldequfunsbwudquaurogsiyhydswsimflrvfwruouskxjfzfynmrymyyqsvkajpnanvyepnzixyteyafnmwnbwmtojdpsucthxtopgpxgnsmnsrdhpskledapiricvdmtwaifrhnebzuttzckroywranbrvgmashxurelyrrbslxnmzyeowchwpjplrdnjlkfcoqdhheavbnhdlltjpahflwscafnnsspikuqszqpcdyfrkaabdigogatgiitadlinfyhgowjuvqlhrniuvrketfmboibttkgakohbmsvhigqztbvrsgxlnjndrqwmcdnntwofojpyrhamivfcdcotodwhvtuyyjlthbaxmrvfzxrhvzkydartfqbalxyjilepmemawjfxhzecyqcdswxxmaaxxyifmouauibstgpcfwgfmjlfhketkeshfcorqirmssfnbuqiqwqfhbmol";
//		String[] w5 = { "toiscumkhociglkvispihvyoatxcx", "ndojyyephstlonsplrettspwepipw",
//				"yzfkyoqlkrmmfirchzrphveuwmvga", "mxxihihnrfbamcyojqpkzodbejtmm", "fenjcjfdlvcpiatuhjdujhaffqsvq",
//				"ehghndyqjodnnblfwmaygdstotfkv", "heoldutddnksutjakhtghpxxnjykx", "cvrwdewsxdeumhzfrvoilmvksuhyq",
//				"ftqjvzyssocftjwemroghrncynmtc", "idiwclhuepgyynoslhzahtdqwlikt", "eurttrfrmstrbeokzhuzvbfmwywoh",
//				"jxlluilzpysjcnwguyofnhfvhacez", "uskegagtlonducdogwbevugppsptd", "xmcxwufajmnveuwuoyosqnoqwvtjk",
//				"wolpsfxdypmlbjotuxewskisnmczf", "fjryanrmzmpzoefapmnsjdgecrdyw", "jgmxawmndhsvwnjdjvjtxcsjapfog",
//				"wuhkzghvmjhawcfszbhzrbpgsidnb", "yelbldxympctbzfupeocwhkypchuy", "vzduzxudwwqhpftwdspuimioanlzo",
//				"bdpdeofidldoymakfnpgekmsltcrr", "fmyeodowglzyjzuhencufcwdobyds", "dhtypunakzituezjyhbrpuksbamui",
//				"bdmiruibwznqcuczculujfiavzwyn", "eudzjxwbjvagnsjntskmocmpgkybq", "tuynydoakejmwkvojuwbfltqjfgxq",
//				"psrdswqxqsegulcwrwsjnihxedfcq", "cokfdmtsgboidkpgpnmdeyhawkqqs", "fujhvgzdussqbwynylzvtjapvqtid",
//				"rqeuglrsjnmvdsihicsgkybcjltcs", "vhybsbmvymjppfrqmlfrbkpjwpyyy", "aukagphzycvjtvwdhhxzagkevvucc",
//				"hwkduzbxpdhtpvrzrfjndmsqfizmq", "ywnuzzmxeppokxksrfwrpuzqhjgqr", "qbajmepmmizaycwcgmjeopbivsyph",
//				"uamscbxnqnfmmjyehvidnoimmxmtc", "nxvspywfggjrmxryybdltmsfykstm", "amrjbrsiovrxmqsyxhqmritjeauwq",
//				"yorwboxdauhrkxehiwaputeouwxdf", "qkewycsdjglkiwaacdqterkixkgra", "ycngvlvpyvczfxvlwhjgicvempfob",
//				"jgphsxzzqlvujkwwgiodbfjesnbsb", "mkxhemwbbclwdxwgngicplzgajmar", "mryvkeevlthvflsvognbxfjilwkdn",
//				"mezrxffujeysplvavtjqjxsgujqsj", "rtotxqmzxvsqazajvrwsxyeyjteak", "sabctaegttffigupnwgakylngrrxu",
//				"xccuoccdkbboymjtimdrmerspxpkt", "xusnnvngksbjabqjaohdvrniezhmx", "oyuejenqgjheulkxjnqkwvzznricl",
//				"mxszcosgovisnbemrjlndqwkvhqso", "wsgnznrfmxjbdrkwjopylxezxgvet", "dxmisfskvevpcnujqxrqedleuyowk",
//				"dhrgijeplijcvqbormrqglgmzsprt", "vuxchgerokejovrqonxxstibuniki", "lumyzmnzjzhzfpslwsukykwckvkts",
//				"inwkbqmcobubjjpshucechrqrffqs", "ywtxruxokcubekzcrqengviwbtgnz", "ccpnmreqaqjrxwulpunagwxesbila",
//				"pesxtpypenunfpjuyoevzztctecil", "sygfymdcjgvdxutlrhffhnpyjuxmx", "uisdfrvbxzxzhmuektssuktoknkfb",
//				"cejvgynwouzhtfwuuukdbwpmkjrqx", "oudcoagcxjcuqvenznxxnprgvhasf", "sxnlkwgpbznzszyudpwrlgrdgwdyh",
//				"qqbxkaqcyhiobvtqgqruumvvhxolb", "mkhleanvfpemuublnnyzfabtxsest", "bibaxwnriowoavosminabvfxastkc",
//				"bcxgixgrhpfiofpwruzvpqyjzvoll", "lzccnsztxfyqhqyhkuppapvgvdtkm", "pdjkpshvrmqlhindhabubyokzdfrw",
//				"qbbnhwpdokcpfpxinlfmkfrfqrtzk", "rnyelfschnagucguuqqqwitviynry", "qtrjwhrpisocwderqfiqxsdpkphjs",
//				"vxttqosgpplkmxwgmsgtpantazppg", "tyisidnhlksfznubucqxwaheamndj", "kgaqzsckonjuhxdhqztjfxstjvikd",
//				"jeuslzsdwvuoodipdpnlhdihaywzm", "vdzrwwkqvacxwgdhffyvjldgvchoi", "cftbefxgasawzagfugmuthjahylkh",
//				"xraytcolbhkiiasaazkvqzvfxbaax", "oyqtzozufvvlktnvahvsseymtpeyf", "rnnujgyjugrzjoefmghjfhcrnbrtg",
//				"rfzvgvptbgpwajgtysligupoqeoqx", "igbdclqtbikiacwpjrbxhmzejozpy", "dyzwwxgdbeqwlldyezmkopktzugxg",
//				"hmetreydbcstkwoexwsfhfekfvfpl", "zcnftuzrvzjjudsgcqmmfpnmyrenu", "zzmvkskzeglxaqrrvmrgcwcnvkhwz",
//				"vjswvekfyqhjnsusefdtakejxbejr", "rwwzwbcjwiqzkwzfuxfclmsxpdyvf", "fdbdychmupcsxvhazvrihhnxfyumo",
//				"vdtevyducpdksntgyaqtkrrkwiyuh", "nbvqeyoghccxfuwacxzxqkezxefxa", "vpgbefpqpsjmdecmixmmbsjxzwvjd",
//				"jwgqmsvhnykclexepxqxqzghwfxfd", "olyfxbvdrspxqnxnuoygkruczddgs", "qgmxtdfoiaakorebqpbbpegawrqym",
//				"liaivbhcgvjjnxpggrewglalthmzv", "choncklguqgnyrcslwztbstmycjzi", "fpkdpenxlewyxxgrkmwrmshhzfnor",
//				"hhhcaqxbqpthuaafwgrouaxonzocl", "ipahojoysepzhpljpaugrghgjimtd", "wosrmnouwpstgbrvhtlqcnmqbygbf",
//				"nwyskffpxlragrnfffawqtgyfpmzx", "bcvvadhnssbvneecglnqxhavhvxpk", "hoavxqksjreddpmibbodtbhzfehgl",
//				"lazxadnftllhmjslfbrtdlahkgwle", "uuukupjmbbvshzxyniaowdjamlfss", "tpqtazbphmfoluliznftodyguessh",
//				"ychqumiscfkwmqqxunqrfbgqjdwmk", "rkdclgzjvqrjofjjvbyfragofeoaz", "pphhedxdepgfgrqerpuhgmaawhnhq",
//				"cacrsvutylalqrykehjuofisdookj", "kyldfriuvjranikluqtjjcoiqffdx", "bnwvrwgoskzqkgffpsyhfmxhymqin",
//				"uzmlliugckuljfkljoshjhlvvlnyw", "abfxqbdqnexvwsvzvcsbrmkbkuzsd", "xotbbyvxyovzxgtcyzgqnsvcfhczo",
//				"bwtpqcqhvyyssvfknfhxvtodpzipu", "nsfbpjqkijvudpriqrfsrdfortimg", "tgwyqugeuahpuvvzmgarbsyuutmbx",
//				"upnwqzbsazplkyaxqorqsshhlljjl", "edfyahijobxyhimebctobsjudkqst", "ialhfmgjohzoxvdaxuywfqrgmyahh",
//				"jlhcpegmtrelbosyajljvwwedtxbd", "tpfppjzowoltyqijfoabgzejerpat", "mgogyhzpmsdemugqkspsmoppwbnwa",
//				"nubmpwcdqkvhwfuvcahwibniohiqy", "ukfadjvdnrievszilfinxbyrvknfi", "dgnepdiimmkcxhattwglbkicvsfsw",
//				"syqxmarjkshjhxobandwyzggjibjg", "bnwxjytnaejivivriamhgqsskqhnq", "hzyjdcbyuijjnkqluaczrnrbbwaee",
//				"yscnqoohcsxenypyqhfklloudgmkl", "habidqszhxorzfypcjcnopzwigmbz", "wjdqxdrlsqvsxwxpqkljeyjpulbsw",
//				"tytawuuyjrwxboogfessmltwdcssd", "pfixglatdvuogdoizdtsgsztsfcih", "apkvhvsqojyixaechvuoemmyqdlfk",
//				"ouaehwnnxwkdplodpuqxdbemfwahp", "ixuckaralemvsnbgooorayceuedto", "ymxdjrqikughquwtenyucjdgrmipi",
//				"smrwrlkvpnhqrvpdekmtpdfuxzjwp", "bhjakgajafgzxpqckmhdbbnqmcszp", "beqsmluixgsliatukrecgoldmzfhw",
//				"greuevnjssjifvlqlhkllifxrxkdb", "yzsqcrdchhdqprtkkjsccowrjtyjj", "sviyovhitxeajqahshpejaqtcdkuv",
//				"qtwomymjskujjtmxiueopwacrwfuq", "mzyjtctvtwgyiesxhynvogxnjdjph", "dyfbxcaypyquodcpwxkstbthuvjqg",
//				"hfmflesfabvanxlrurjtigkjotftq", "mxydechlraajjmoqpcyoqmrjwoium", "nabesvshjmdbhyhirfrkqkmfwdguj",
//				"bhrfxxemhgbkgmkhjtkzyzdqmxxwq", "gziobrjeanlvyukwlscexbkibvdjh", "mcwwubbnwenybmfqglaceuyqnoadz",
//				"xyzvyblypeongzrttvwqzmrccwkzi", "ncfalqenfcswgerbfcqsapzdtscnz", "dtqpezboimeuyyujfjxkdmbjpizpq",
//				"wmuhplfueqnvnhukgjarxlxvwmriq", "qwapdkoqswyclqyvbvpedzyoyedvu", "uoqbztnftzgahhxwxbgkilnmzfydy",
//				"zsddaahohbszhqxxgripqlwlomjbw", "bwadkiavdswyuxdttoqaaykctprkw", "eixdbntdfcaeatyyainfpkclbgaaq",
//				"nmjnpttflsmjifknezrneedvgzfmn", "avlzyhfmeasmgrjawongccgfbgoua", "kklimhhjqkmuaifnodtpredhqygme",
//				"xzbwenvteifxuuefnimnadwxhruvo", "ugmwlmidtxkvqhbuaecevwhmwkfqm", "rhpyjfxbjjryslfpqoiphrwfjqqha",
//				"eeaipxrokncholathupdetgaktmvm", "ltuimrnsphqslmgvmmojawwptghon", "azitvyhvlspvoaeipdsjhgyfjbxhi",
//				"efrelxezcgikdliyhvpocvvpkvagv", "znxforctwzecxyrkwufpdxadrgzcz", "kcqgynjcpbylayvgdqfpbqmshksyf",
//				"hrljvedsywrlyccpaowjaqyfaqioe", "cjmfyvfybxiuqtkdlzqedjxxbvdsf", "zeqljuypthkmywaffmcjkickqqsuh",
//				"wnfzoyvkiogisdfyjmfomcazigukq", "zyaaqxorqxbkenscbveqbaociwmqx", "ahnpivdtlcnptnxjyiaafislqavam",
//				"edtqirqmjtvsfhadhafktyrmkzmvi", "wponuefgdtcrgxswiddygeeflpjee", "xozgwhtbhlkvrzismnozqpfthajaf",
//				"ptnfnojnlinbfmylhdlijcvcxzjhd", "uxekzlgigjpsukjvsdihrjzgovnre", "rbohxlytsmoeleqrjvievpjipsgdk",
//				"fxtzaxpcfrcovwgrcwqptoekhmgpo", "tvxvvgjbyxpgwpganjiaumojpyhhy", "vqjjhfaupylefbvbsbhdncsshmrhx",
//				"urhedneauccrkyjfiptjfxmpxlssr", "ltvgknnlodtbhnbhjkmuhwxvzgmkh", "ucztsneqttsuirmjriohhgunzatyf",
//				"rbzryfaeuqkfxrbldyusoeoldpbwa", "atlgpnkuksuesrduxkodwjzgubpsm", "lrdniqbzxrbpcvmzpyqklsskpwctg",
//				"qvnvgzkyhistydagsgnujiviyijdn", "uzatydzcnktnkeyztoqvogodxxznh", "ocbvphmtpwhcgjbnmxgidtlqcnnwt",
//				"koudovxrjkusxdazxaawmvoostlvv", "ptruqmjtbaapgmkfnbwnlvzlxwdpz", "xdxtpbpoemekvxzrrakwjxcxqsdas",
//				"gdpclnsguabtgbfwdmrmbvydorfrb", "htwxdbarwuxykgduxjlkxppwyruih" };
//		
//		printList(s.findSubstring(s5, w5));
//		
//		Long endTime = System.currentTimeMillis();
//		System.out.println("\n\nFinal Time: " + (endTime - initTime) + "ms \n\n");
//		
//
		
		String s6 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
		String[] w6 = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
		printList(s.findSubstring(s6, w6));
	}
	
	
    private static void printList(List<Integer> findSubstring) {
    	for (Integer integer : findSubstring) {
			System.out.print(integer + " ");
		}
	}


	public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null) return null;        
    	Map<String, Integer> mapCount = new HashMap<>();
    	
    	for (int i = 0; i < words.length; i++) {
			mapCount.put(words[i], mapCount.containsKey(words[i]) ? mapCount.get(words[i]) + 1 : 1);
		}
        
    	int len = s.length();
    	int wordLen = words[0].length();    	
    	int limit = len - (wordLen * words.length);
    	boolean changed = false;
    	//Map<String, Integer> mapResults = new HashMap<>(mapCount); // stores the results found for a word e.g "xyz" starting on index i 
    	Map<String, Integer> mapCopy = new HashMap<>(mapCount);
    	List<Integer> r = new ArrayList<>();
    	
		for (int i = 0; i <= limit; i++) {
//			if (changed) {
				mapCopy = new HashMap<>(mapCount);
//			}
//			int cntFound = 0;
			
			for (int j = 0; j < words.length; j++) {
				//String sub = s.substring(i + cntFound * wordLen, i + cntFound * wordLen + wordLen);
				String sub = s.substring(i + j*wordLen, i + j*wordLen+ wordLen);
				if (mapCopy.containsKey(sub)) {
					int countElem = mapCopy.get(sub);
					if (countElem == 1) {
						mapCopy.remove(sub);
					} else {
						mapCopy.put(sub, countElem - 1);
					}
//					changed = true;
//					cntFound++;
					if (mapCopy.isEmpty()) {
						r.add(i);			
						break;
					}												
				} else {
					break;
				}				
			}			
		}    	    	    	
    	return r;
    }

	public List<Integer> findSubstringA(String s, String[] words) {
        if (s == null || words == null) return null;        
    	Set<Integer> idxs = new HashSet<>();
    	int len = s.length();
    	int wordLen = words[0].length();
    	int lastIdxFound = 0;
    	int startFrom = 0;
    	
    	int limit = len - (wordLen * words.length);
    	
		for (int j = 0; j < words.length; j++) {
			startFrom = 0;
			lastIdxFound = Integer.MAX_VALUE;
			while(lastIdxFound != -1 && lastIdxFound + wordLen <= len) {
				int idx = s.indexOf(words[j], startFrom);				
				if (idx >= 0 && idx != lastIdxFound && !idxs.contains(idx)) {
				//if (idx >= 0 && idx + wordLen <= len && idx != lastIdxFound) {
						//&& s.substring(idx, idx + wordLen).equals(words[j])) {
					if (isDictionaryPresent(s, idx, words, j)) {
						idxs.add(idx);
					}
				}													
				lastIdxFound = idx;
				if (idx + wordLen > limit) lastIdxFound = -1;  				
				startFrom = idx + 1;
			}
		}    	    	    	
    	return buildListFromSet(idxs);
    }

	public static List<Integer> findSubstring2(String S, String[] L) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (S == null || L == null || L.length == 0) return res;
	    int len = L[0].length(); // length of each word
	    
	    Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
	    for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
	    
	    for (int i = 0; i <= S.length() - len * L.length; i++) {
	        Map<String, Integer> copy = new HashMap<String, Integer>(map);
	        for (int j = 0; j < L.length; j++) { // checkc if match
	            String str = S.substring(i + j*len, i + j*len + len); // next word
	            if (copy.containsKey(str)) { // is in remaining words
	                int count = copy.get(str);
	                if (count == 1) copy.remove(str);
	                else copy.put(str, count - 1);
	                if (copy.isEmpty()) { // matches
	                    res.add(i);
	                    break;
	                }
	            } else break; // not in L
	        }
	    }
	    return res;
	}
	private boolean isDictionaryPresent(String s, int idx, String[] words, int j) {
		if (words.length == 1) return true;
		int wordLen = words[j].length();
		int startIndex = idx + wordLen;
		boolean found = false;
	
		for (int i = 0; i < words.length; i++) {
			Set<Integer> idxs = new HashSet<>();
			idxs.add(j);

			if (i != j) {
				found = matchWords(idxs, s, words, startIndex);
				if (found) return true;
			}
		}		
		return found;
	}

	private boolean matchWords(Set<Integer> idxs, String s, String[] words, int startFrom) {
		boolean found = false;
		if (idxs.size() == words.length) {
			//results.add(buildListFromSet(idxs));
			found = true;
		} else if (startFrom + words[0].length() <= s.length()) {
			for(int i = 0; i < words.length; i++) {
				if (!idxs.contains(i) && s.substring(startFrom, startFrom + words[i].length()).equals(words[i])) {
					idxs.add(i);					
					found = matchWords(idxs, s, words, startFrom + words[i].length());
					if (found) return true;					
					idxs.remove(i);
				}
			}
		}
		return found;
	}

//	private void matchWords(List<List<Integer>> results, Set<Integer> idxs, String s, String[] words, int startFrom) {
//		if (idxs.size() == words.length) {
//			//results.add(buildListFromSet(idxs));
//			results.add(buildListFromSet(idxs));
//		} else if (startFrom + words[0].length() <= s.length()) {
//			for(int i = 0; i < words.length; i++) {
//				if (!idxs.contains(i) && s.substring(startFrom, startFrom + words[i].length()).equals(words[i])) {
//					idxs.add(i);
//					matchWords(results, idxs, s, words, startFrom + words[i].length());
//					idxs.remove(i);
//				}
//			}
//		}
//	}

	private List<Integer> buildListFromSet(Set<Integer> idxs) {		
		List<Integer> l = new ArrayList<>();
		for (Integer integer : idxs) {
			l.add(integer);
		}
		
		return l;
	}

    
}
