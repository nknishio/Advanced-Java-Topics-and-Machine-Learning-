import java.util.*;
/**
 * Code for Chapter 11 Exercises (except Exercise 20: Vocabulary, which is in Vocabulary.java)
 * Completed 09/12/2025
 */

public class Main {
    // Returns a list of all prime numbers up to the given maximum
// using the Sieve of Eratosthenes algorithm.
    public static LinkedList<Integer> sieve2(int max) {
        LinkedList<Integer> primes = new LinkedList<Integer>();

        // add all numbers from 2 to max to a list
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(2);
        for (int i = 3; i <= max; i+=2) {
            numbers.add(i);
        }
        while (!numbers.isEmpty()) {
            // remove a prime number from the front of the list
            int front = numbers.remove(0);
            Iterator<Integer> itr = numbers.iterator();

            if(front*front==max) {
                while (itr.hasNext()) {
                    primes.add(itr.next());
                    itr.remove();
                }
            }else {
                primes.add(front);
            }

            // remove all multiples of this prime number

            while (itr.hasNext()) {
                int current = itr.next();
                if (current % front == 0) {
                    itr.remove();
                }
            }
        }

        return primes;
    }

    public List<Integer> alternate(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new LinkedList<Integer>();
        int i1 = 0, i2 = 0;
        boolean turn = true;
        while(i1<a.size() || i2<b.size()) {
            if(i1 < a.size() && turn){
                ans.add(a.get(i1));
                i1++;
            }else if(i2<b.size() && !turn) {
                ans.add(b.get(i2));
                i2++;
            }
            turn = !turn;
        }
        return ans;
    }
    public void removeInRange(List<Integer> list, int element, int s, int e) {
        if(s>e) return;
        List<Integer> temp = new LinkedList<Integer>();
        for(int i = 0; i<s; ++i) {
            temp.add(list.get(i));
        }
        for(int i = s; i<e; ++i) {
            if(list.get(i)!=element) {
                temp.add(list.get(i));
            }
        }
        for(int i = e; i < list.size();++i) {
            temp.add(list.get(i));
        }
        list.clear();
        list.addAll(temp);

    }
    public void partition(List<Integer> list, int k) {
        List<Integer> less = new LinkedList<Integer>();
        List<Integer> great = new LinkedList<Integer>();
        for(int i = 0; i<list.size();++i) {
            if(list.get(i)<k) {
                less.add(list.get(i));
            }
            else {
                great.add(list.get(i));
            }
        }
        less.addAll(great);
        list.clear();
        list.addAll(less);
    }
    public void sortAndRemoveDuplicates(List<Integer> list) {
        // Collections.sort(list);
        Set<Integer> set = new TreeSet<Integer>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
    }
    public int countUnique(List<Integer> list) {
        Set<Integer> s = new TreeSet<Integer>();
        for(int i =0; i<list.size();++i) {
            s.add(list.get(i));
        }
        return s.size();
    }
    public int countCommon(List<Integer> l1, List<Integer> l2) {
        Set<Integer> s = new TreeSet<Integer>();
        for(int i = 0; i < l1.size(); ++i) {
            if(l2.contains(l1.get(i))) {
                s.add(l1.get(i));
            }
        }
        return s.size();
    }
    public int maxLength(Set<String> s) {
        int maxLength = 0;
        for(String x : s ) {
            if(x.length()>maxLength) {
                maxLength = x.length();
            }
        }
        return maxLength;
    }
    public boolean hasOdd(Set<Integer> s) {
        for(int x : s) {
            if(x%2==1) return true;
        }
        return false;
    }
    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().length() % 2 == 0) {
                it.remove();
            }
        }
    }
    public Set<Integer> symmetricSetDifference(Set<Integer> a, Set<Integer> b) {
        Set<Integer> ans = new TreeSet<Integer>();
        for(int x : a) {
            if(!b.contains(x)) {
                ans.add(x);
            }
        }
        for(int x : b) {
            if(!a.contains(x)) {
                ans.add(x);
            }
        }
        return ans;
    }

    public boolean contains3(List<String> list) {
        Map<String, Integer> str_cnt = new HashMap<String, Integer>();
        for (String s : list) {
            str_cnt.put(s, str_cnt.getOrDefault(s, 0) + 1);
        }
        for (String s : str_cnt.keySet()) {
            if (str_cnt.get(s) >= 3) {
                return true;
            }
        }
        return false;
    }
    public boolean isUnique(Map<String,String> map) {
        Set<String> x =new HashSet<String>(map.values());
        return x.size()== map.keySet().size();
    }

    public Map<String, Integer> intersect(HashMap<String,Integer> a, HashMap<String,Integer> b) {
        Map<String, Integer> ans = new HashMap<String, Integer>();
        for(String key : a.keySet()) {
            if(b.containsKey(key) && b.get(key).equals(a.get(key))) {
                ans.put(key,a.get(key));
            }
        }
        return ans;
    }
    public boolean is1to1(Map<String, String> map) {
        Set<String> s = new HashSet<String>(map.values());
        return s.size() == map.keySet().size();
    }
    public int maxOccurrences(List<Integer> list) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for(int x : list) {
            cnt.put(x, cnt.getOrDefault(x,0)+1);
        }
        int ans = 0;
        for(int key : cnt.keySet()) {
            if(cnt.get(key)>ans) {
                ans = cnt.get(key);
            }
        }
        return ans;
    }

    public boolean subMap(Map<String,String> a, Map<String, String> b) {
        for(String key : a.keySet()) {
            if(!b.containsKey(key) || b.get(key)!=a.get(key)) return false;
        }
        return true;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> ans = new HashMap<String, Integer>();
        for(int key : map.keySet()) {
            ans.put(map.get(key),key);
        }
        return ans;
    }
    public int rarest(Map<String,Integer> map) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for(String key : map.keySet()) {
            cnt.put(map.get(key), cnt.getOrDefault(map.get(key),0)+1);
        }
        int ans = -1;
        int mn = Integer.MAX_VALUE;
        for(int key : cnt.keySet()) {
            if(cnt.get(key)<mn) {
                mn = cnt.get(key);
                ans = key;
            }else if(cnt.get(key)==mn && key<ans) {
                mn = cnt.get(key);
                ans = key;
            }
        }
        return ans;
    }
    
    public Map<String, Integer> pairCounts(List<String> ls) {
        Map<String, Integer> ans = new HashMap<String, Integer>();
        for (String str : ls) {
            for (int j = 0; j < str.length() - 1; ++j) {
                String pair = str.substring(j, j + 2);
                ans.put(pair, ans.getOrDefault(pair, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}