🔗 HackerRank бодлого: Sherlock and Anagrams https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
🟡 Difficulty: Medium
📂 Директор: 7-sherlock-and-anagrams

Бодлогын утга
Өгөгдсөн тэмдэгтэн цуваанд агуулагдах бүх анихрам (anagram) хосуудыг олох.

Өөрөөр хэлбэл, s доторх бүх хэсгийн мөрүүдээс бие биенийхээ анихрам болох substring хосуудын тоог олно.

Жишээ оролт ба гаралт
Оролт	Гаралт
"abba"	4

Тайлбар
Анихрамууд: ["a", "a"], ["ab", "ba"], ["b", "b"], ["abb", "bba"]

Нийт 4 хос бий.

Шийдэл арга
Бүх боломжит substring-үүдийг олно.

Тухайн substring-үүдийг үсэгнүүдээр нь эрэмбэлж жигдхэн төлөвт оруулна.

Ижил төлөвтэй substring-үүдийн тоог тоолно.

Хэрвээ нэг төлөвийн substring-үүд n удаа гарвал тухайн төлөвөөс n*(n-1)/2 хос үүснэ.

Бүх төлөвийн хосуудыг нийлүүлнэ.

Кодны жишээ (Java)
java
Copy
Edit
public static int sherlockAndAnagrams(String s) {
    int count = 0;
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
            char[] sub = s.substring(i, j).toCharArray();
            Arrays.sort(sub);
            String key = new String(sub);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    for (int val : map.values()) {
        count += val * (val - 1) / 2;
    }

    return count;
}
