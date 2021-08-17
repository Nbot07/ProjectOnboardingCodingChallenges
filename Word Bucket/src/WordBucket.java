import java.util.ArrayList;
import java.util.List;

public class WordBucket {
	
//	public static int getSize(ArrayList<String> arr) {
//		int size = 0;
//		for (String s: arr) {
//			size += s.length();
//		}
//		return size+arr.size()-1;
//	}
	public static void bucketize1(String s, int bucketSize) {
		//check if each word can fit in a bucket
		//iterate until space and mark
		//iterate until bucketSize marking spaces
		//go to last space before bucket filled
		
//		ArrayList<String> prevWords = new ArrayList<String>();
//		String out = "[";
		for (String word : s.split(" ")) {
			if (bucketSize < word.length()) {
				System.out.println("[]");
				return;
			}
//			if (getSize(prevWords) >= bucketSize) {
//				
//			}
			
		}
		
		System.out.print("[");
		int prevBucketEnd = 0;
		int mark = 0;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i) == ' '){
				if(i - prevBucketEnd >= bucketSize) {
					System.out.print(s.substring(prevBucketEnd, mark) + " "+ i + ", ");
					prevBucketEnd = mark;
				}
				mark = i;
			}
		}
		System.out.print(s.substring(prevBucketEnd));
		
		System.out.println("]");
	}
	
	public static void bucketize(String arg, int limit) {
        String[] words = arg.split(" ");
        List<String> preAnswer = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        int index = 0;
        for(String w : words){
            if(w.length() > limit){
                preAnswer.clear();
                break;
            }
            if(index == 0){
                temp.append(w);
                index += 1;
                continue;
            }
            if(index != 0 || index != words.length - 1){
                temp.append(" ");
            }
            if(temp.length() + w.length() > limit){
                preAnswer.add(temp.toString().trim());
                temp.delete(0, temp.length());
            }
            temp.append(w);
            if(index == words.length - 1){
                preAnswer.add(temp.toString().trim());
            }
            index += 1;
        }
        //String[] answer = preAnswer.toArray(new String[0]);
        System.out.println(preAnswer);
    }

	
	public static void main(String[] args) {
		bucketize("she sells sea shells by the sea", 10);
		bucketize("the mouse jumped over the cheese", 7);
		bucketize("fairy dust coated the air", 20);
		bucketize("a b c d e", 2);
		bucketize("she sells sea shells by the sea",2);
	}
	
}
